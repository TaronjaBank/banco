package com.fpmislata.banco.presentacion.controller;

import com.fpmislata.banco.common.json.JsonTransformer;
import com.fpmislata.banco.dominio.EntidadBancaria;
import com.fpmislata.banco.persistencia.dao.EntidadBancariaDAO;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller// Para que java entienda que esto es un controlador.
@RequestMapping("/EntidadBancaria")
public class EntidadBancariaController {

    EntidadBancaria entidadBancaria;

    @Autowired
    EntidadBancariaDAO entidadBancariaDAO;

    @Autowired
    JsonTransformer jsonTransformer;

    @RequestMapping(
            value = "/{idEntidadBancaria}",
            method = RequestMethod.GET)
    public void get(
            HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse,
            @PathVariable("idEntidadBancaria") int idEntidadBancaria) {
        try {
            entidadBancaria = entidadBancariaDAO.get(idEntidadBancaria);
            String jsonSalida = jsonTransformer.toJson(entidadBancaria);
            httpServletResponse.getWriter().println(jsonSalida);

            httpServletResponse.setStatus(HttpServletResponse.SC_OK);
        } catch (IOException ex) {
            httpServletResponse.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
    }

    @RequestMapping(
            value = "/",
            method = RequestMethod.POST)
    public void insert(HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse,
            @RequestBody String jsonEntrada) {
        try {
            entidadBancaria = (EntidadBancaria) jsonTransformer.fromJson(jsonEntrada, EntidadBancaria.class);
            EntidadBancaria entidadBancariaSalida = entidadBancariaDAO.insert(entidadBancaria);
            String jsonSalida = jsonTransformer.toJson(entidadBancariaSalida);
            httpServletResponse.getWriter().println(jsonSalida);

            httpServletResponse.setStatus(HttpServletResponse.SC_OK);
        } catch (IOException ex) {
            httpServletResponse.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
    }

    @RequestMapping(
            value = {"/{idEntidadBancaria}"},
            method = RequestMethod.PUT,
            consumes = "application/json",
            produces = "application/json"
    )
    public void update(
            HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse,
            @PathVariable("idEntidadBancaria") int idEntidadBancaria,
            @RequestBody String jsonEntrada) {
        try {
            entidadBancaria = (EntidadBancaria) jsonTransformer.fromJson(jsonEntrada, EntidadBancaria.class);
            entidadBancaria = entidadBancariaDAO.update(entidadBancaria);
            String jsonSalida = jsonTransformer.toJson(entidadBancaria);
            httpServletResponse.getWriter().println(jsonSalida);

            httpServletResponse.setContentType("application/json; char=UTF-8");
            httpServletResponse.setStatus(HttpServletResponse.SC_OK);
        } catch (IOException ex) {
            httpServletResponse.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
    }

    @RequestMapping(
            value = "/{idEntidadBancaria}",
            method = RequestMethod.DELETE)
    public void delete(
            HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse,
            @PathVariable("idEntidadBancaria") int idEntidadBancaria) {
        entidadBancariaDAO.delete(idEntidadBancaria);
        httpServletResponse.setStatus(HttpServletResponse.SC_NO_CONTENT);
    }

    @RequestMapping(
            value = "",
            method = RequestMethod.GET)
    public void findAll(
            HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse) {
        try {
            String jsonSalida = jsonTransformer.toJson(entidadBancariaDAO.findAll());
            httpServletResponse.getWriter().println(jsonSalida);

            httpServletResponse.setStatus(HttpServletResponse.SC_OK);
        } catch (IOException ex) {
            httpServletResponse.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
    }
}