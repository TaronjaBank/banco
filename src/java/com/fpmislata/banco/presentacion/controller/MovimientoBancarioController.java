package com.fpmislata.banco.presentacion.controller;

import com.fpmislata.banco.dominio.MovimientoBancario;
import com.fpmislata.banco.persistencia.dao.MovimientoBancarioDAO;
import com.fpmislata.banco.common.json.JsonTransformer;
import com.fpmislata.banco.persistencia.impl.jdbc.connectionFactory.ConnectionFactory;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/MovimientoBancario")
public class MovimientoBancarioController {

    MovimientoBancario movimientoBancario;

    @Autowired
    MovimientoBancarioDAO movimientoBancarioDAO;

    @Autowired
    JsonTransformer jsonTransformer;

    @Autowired
    ConnectionFactory connectionFactory;

    @RequestMapping(
            value = {"/{idMovimientoBancario}"},
            method = RequestMethod.GET)
    public void get(
            HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse,
            @PathVariable("idMovimientoBancario") int idMovimientoBancario) {
        try {
            movimientoBancario = movimientoBancarioDAO.get(idMovimientoBancario);
            String jsonSalida = jsonTransformer.toJson(movimientoBancario);
            httpServletResponse.getWriter().println(jsonSalida);

            httpServletResponse.setStatus(HttpServletResponse.SC_OK);
        } catch (IOException ex) {
            httpServletResponse.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
    }

    @RequestMapping(
            value = {"/"},
            method = RequestMethod.POST)
    public void insert(
            HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse,
            @RequestBody String jsonEntrada) {
        try {
            movimientoBancario = (MovimientoBancario) jsonTransformer.fromJson(jsonEntrada, MovimientoBancario.class);
            MovimientoBancario movimientoBancarioSalida = movimientoBancarioDAO.insert(movimientoBancario);
            String jsonSalida = jsonTransformer.toJson(movimientoBancarioSalida);
            httpServletResponse.getWriter().println(jsonSalida);

            httpServletResponse.setStatus(HttpServletResponse.SC_OK);
        } catch (IOException ex) {
            httpServletResponse.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
    }

    @RequestMapping(
            value = {"/{idMovimientoBancario}"},
            method = RequestMethod.PUT,
            consumes = "application/json",
            produces = "application/json"
    )
    public void update(
            HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse,
            @PathVariable("idMovimientoBancario") int idMovimientoBancario,
            @RequestBody String jsonEntrada) {
        try {
            movimientoBancario = (MovimientoBancario) jsonTransformer.fromJson(jsonEntrada, MovimientoBancario.class);
            movimientoBancario = movimientoBancarioDAO.update(movimientoBancario);
            String jsonSalida = jsonTransformer.toJson(movimientoBancario);
            httpServletResponse.getWriter().println(jsonSalida);

            httpServletResponse.setContentType("application/json; char=UTF-8");
            httpServletResponse.setStatus(HttpServletResponse.SC_OK);
        } catch (IOException ex) {
            httpServletResponse.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
    }

    @RequestMapping(
            value = {"/{idMovimientoBancario}"},
            method = RequestMethod.DELETE)
    public void delete(
            HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse,
            @PathVariable("idMovimientoBancario") int idMovimientoBancario) {
        movimientoBancarioDAO.delete(idMovimientoBancario);
        httpServletResponse.setStatus(HttpServletResponse.SC_NO_CONTENT);
    }

    @RequestMapping(
            value = {""},
            method = RequestMethod.GET)
    public void findAll(
            HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse) {
        try {
            String jsonSalida = jsonTransformer.toJson(movimientoBancarioDAO.findAll());
            httpServletResponse.getWriter().println(jsonSalida);

            httpServletResponse.setStatus(HttpServletResponse.SC_OK);
        } catch (IOException ex) {
            httpServletResponse.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
    }
}