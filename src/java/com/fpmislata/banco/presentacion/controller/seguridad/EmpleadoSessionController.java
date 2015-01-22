package com.fpmislata.banco.presentacion.controller.seguridad;

import com.fpmislata.banco.common.json.JsonTransformer;
import com.fpmislata.banco.dominio.Credencial;
import com.fpmislata.banco.dominio.Empleado;
import com.fpmislata.banco.persistencia.dao.EmpleadoDAO;
import com.fpmislata.banco.servicio.seguridad.EmpleadoAuthentication;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/Session/Empleado")
public class EmpleadoSessionController {

    @Autowired
    JsonTransformer jsonTransformer;
    @Autowired
    EmpleadoDAO empleadoDAO;
    @Autowired
    EmpleadoAuthentication empleadoAuthentication;

    @RequestMapping(method = RequestMethod.GET)
    public void get(
            HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse) throws IOException {
        try {
            String loginEmpleado;
            String jsonSalida;
            Empleado empleado;

            HttpSession httpSession = httpServletRequest.getSession(true);

            if (httpSession != null) {
                loginEmpleado= (String)httpSession.getAttribute("loginEmpleado");
                
                empleado=empleadoDAO.getFromLogin(loginEmpleado);
                if (empleado == null) {
                     httpServletResponse.setStatus(HttpServletResponse.SC_NO_CONTENT);
                }
                else{
                jsonSalida = jsonTransformer.toJson(empleado);
                httpServletResponse.getWriter().println(jsonSalida);
                httpServletResponse.setContentType("application/json; char=UTF-8");
                httpServletResponse.setStatus(HttpServletResponse.SC_OK);
                }
            } else {
                httpServletResponse.setStatus(HttpServletResponse.SC_NO_CONTENT);
            }

        } catch (IOException ex) {
            httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    public void logIn(
            HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse,
            @RequestBody String jsonEntrada) throws IOException {

        String jsonSalida;
        Credencial credencial;
        Empleado empleado;
        HttpSession httpSession;
        try {
            credencial = (Credencial) jsonTransformer.fromJson(jsonEntrada, Credencial.class);
            System.out.println("password: " + credencial.getPassword());
            empleado = empleadoAuthentication.authenticate(credencial);

            if (empleado != null) {
                httpSession = httpServletRequest.getSession(true);
                httpSession.setAttribute("loginEmpleado", empleado.getLoginEmpleado());

                jsonSalida = jsonTransformer.toJson(empleado);
                httpServletResponse.getWriter().println(jsonSalida);
                httpServletResponse.setContentType("application/json; char=UTF-8");
                httpServletResponse.setStatus(HttpServletResponse.SC_OK);
            } else {
                httpServletResponse.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            }

        } catch (IOException ex) {
            httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public void logOut(
            HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse) throws IOException {
        
        HttpSession httpSession = httpServletRequest.getSession(true);
        httpSession.setAttribute("loginEmpleado", null);

        httpServletResponse.setStatus(HttpServletResponse.SC_NO_CONTENT);

    }

}
