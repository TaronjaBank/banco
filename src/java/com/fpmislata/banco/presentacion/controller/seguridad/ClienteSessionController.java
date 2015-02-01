package com.fpmislata.banco.presentacion.controller.seguridad;

import com.fpmislata.banco.common.json.JsonTransformer;
import com.fpmislata.banco.dominio.Cliente;
import com.fpmislata.banco.dominio.Credencial;
import com.fpmislata.banco.persistencia.dao.ClienteDAO;
import com.fpmislata.banco.servicio.seguridad.ClienteAuthentication;
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
@RequestMapping("/Session/Cliente")
public class ClienteSessionController {

    @Autowired
    ClienteDAO clienteDAO;
    @Autowired
    JsonTransformer jsonTransformer;
    @Autowired
    ClienteAuthentication clienteAuthentication;

    @RequestMapping(method = RequestMethod.GET)
    public void get(
            HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse) {

        try {
            HttpSession httpSession = httpServletRequest.getSession(true);

            if (httpSession != null) {
                String loginCliente = (String) httpSession.getAttribute("loginCliente");
                Cliente cliente = clienteDAO.getFromLogin(loginCliente);
                if (cliente == null) {
                    httpServletResponse.setStatus(HttpServletResponse.SC_NO_CONTENT);
                } else {
                    String jsonSalida = jsonTransformer.toJson(cliente);
                    httpServletResponse.getWriter().println(jsonSalida);
                    httpServletResponse.setStatus(HttpServletResponse.SC_OK);
                    httpServletResponse.setContentType("application/json; char=UTF-8");
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
            @RequestBody String jsonEntrada) {

        try {
            Credencial credencial = (Credencial) jsonTransformer.fromJson(jsonEntrada, Credencial.class);
            Cliente cliente = clienteAuthentication.authenticate(credencial);
            if (cliente != null) {
                HttpSession httpSession = httpServletRequest.getSession(true);
                httpSession.setAttribute("loginCLiente", cliente.getLoginCliente());

                String jsonSalida = jsonTransformer.toJson(cliente);
                httpServletResponse.getWriter().println(jsonSalida);
                httpServletResponse.setStatus(HttpServletResponse.SC_OK);
                httpServletResponse.setContentType("application/json; char=UTF-8");
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
        httpSession.setAttribute("loginCliente", null);
        httpServletResponse.setStatus(HttpServletResponse.SC_NO_CONTENT);

    }

}
