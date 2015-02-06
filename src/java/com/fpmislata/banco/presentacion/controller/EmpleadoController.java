package com.fpmislata.banco.presentacion.controller;

import com.fpmislata.banco.common.json.JsonTransformer;
import com.fpmislata.banco.dominio.Empleado;
import com.fpmislata.banco.persistencia.dao.EmpleadoDAO;
import com.fpmislata.banco.persistencia.dao.impl.hibernate.common.BussinessException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/Empleado")
public class EmpleadoController {
    @Autowired
    EmpleadoDAO empleadoDAO;
    @Autowired
    JsonTransformer jsonTransformer;
    
    @RequestMapping(
            value = "/{idEmpleado}",
            method = RequestMethod.GET)
    public void get(
            HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse,
            @PathVariable("idEmpleado") int idEmpleado) {
        try {
            Empleado empleado = empleadoDAO.get(idEmpleado);
            String jsonSalida = jsonTransformer.toJson(empleado);
            httpServletResponse.getWriter().println(jsonSalida);
            httpServletResponse.setStatus(HttpServletResponse.SC_OK);
            httpServletResponse.setContentType("application/json; char=UTF-8");
        } catch (IOException ex) {
            httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        } catch (BussinessException bussinessException) {
            try {
                String jsonSalida = jsonTransformer.toJson(bussinessException.getBussinessMessageList());
                httpServletResponse.getWriter().println(jsonSalida);
                httpServletResponse.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            } catch (IOException ex) {
                httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            }
        }
    }

    @RequestMapping(
            method = RequestMethod.POST)
    public void insert(HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse,
            @RequestBody String jsonEntrada) {
        try {
            Empleado empleadoEntrada = (Empleado) jsonTransformer.fromJson(jsonEntrada, Empleado.class);
            Empleado empleadoSalida = empleadoDAO.insert(empleadoEntrada);
            String jsonSalida = jsonTransformer.toJson(empleadoSalida);
            httpServletResponse.getWriter().println(jsonSalida);
            httpServletResponse.setStatus(HttpServletResponse.SC_OK);
        } catch (IOException ex) {
            httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        } catch (BussinessException bussinessException) {
            try {
                String jsonSalida = jsonTransformer.toJson(bussinessException.getBussinessMessageList());
                httpServletResponse.getWriter().println(jsonSalida);
                httpServletResponse.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            } catch (IOException ex) {
                httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            }
        }
    }

    @RequestMapping(
            value = {"/{idEmpleado}"},
            method = RequestMethod.PUT,
            consumes = "application/json",
            produces = "application/json"
    )
    public void update(
            HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse,
            @PathVariable("idEmpleado") int idEmpleado,
            @RequestBody String jsonEntrada) {
        try {
            Empleado empleado = (Empleado) jsonTransformer.fromJson(jsonEntrada, Empleado.class);
            empleado = empleadoDAO.update(empleado);
            String jsonSalida = jsonTransformer.toJson(empleado);
            httpServletResponse.getWriter().println(jsonSalida);
            httpServletResponse.setStatus(HttpServletResponse.SC_OK);
            httpServletResponse.setContentType("application/json; char=UTF-8");
        } catch (IOException ex) {
            httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        } catch (BussinessException bussinessException) {
            try {
                String jsonSalida = jsonTransformer.toJson(bussinessException.getBussinessMessageList());
                httpServletResponse.getWriter().println(jsonSalida);
                httpServletResponse.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            } catch (IOException ex) {
                httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            }
        }
    }

    @RequestMapping(
            value = "/{idEmpleado}",
            method = RequestMethod.DELETE)
    public void delete(
            HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse,
            @PathVariable("idEmpleado") int idEmpleado) {
        try {
            empleadoDAO.delete(idEmpleado);
            httpServletResponse.setStatus(HttpServletResponse.SC_NO_CONTENT);
        } catch (BussinessException bussinessException) {
            try {
                String jsonSalida = jsonTransformer.toJson(bussinessException.getBussinessMessageList());
                httpServletResponse.getWriter().println(jsonSalida);
                httpServletResponse.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            } catch (IOException ex) {
                httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            }
        }
    }

    @RequestMapping(
            method = RequestMethod.GET)
    public void findAll(
            HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse) {
        try {
            String jsonSalida = jsonTransformer.toJson(empleadoDAO.findAll());
            httpServletResponse.getWriter().println(jsonSalida);
            httpServletResponse.setStatus(HttpServletResponse.SC_OK);
            httpServletResponse.setContentType("application/json; char=UTF-8");
        } catch (IOException ex) {
            httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        } catch (BussinessException bussinessException) {
            try {
                String jsonSalida = jsonTransformer.toJson(bussinessException.getBussinessMessageList());
                httpServletResponse.getWriter().println(jsonSalida);
                httpServletResponse.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            } catch (IOException ex) {
                httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            }
        }
    }
}