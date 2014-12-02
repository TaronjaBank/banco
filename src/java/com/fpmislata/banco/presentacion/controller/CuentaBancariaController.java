package com.fpmislata.banco.presentacion.controller;

import com.fpmislata.banco.dominio.CuentaBancaria;
import com.fpmislata.banco.persistencia.dao.CuentaBancariaDAO;
import com.fpmislata.banco.common.json.JsonTransformer;
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
@RequestMapping("/CuentaBancaria")
public class CuentaBancariaController {
    
    @Autowired
    CuentaBancariaDAO cuentaBancariaDAO;
    
    @Autowired
    JsonTransformer jsonTransformer;

    @RequestMapping(
            value = {"/{idCuentaBancaria}"},
            method = RequestMethod.GET)
    public void get(
            HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse,
            @PathVariable("idCuentaBancaria") int idCuentaBancaria) {
        try {
            CuentaBancaria cuentaBancaria = cuentaBancariaDAO.get(idCuentaBancaria);
            String jsonSalida = jsonTransformer.toJson(cuentaBancaria);
            httpServletResponse.getWriter().println(jsonSalida);
            httpServletResponse.setStatus(HttpServletResponse.SC_OK);
            httpServletResponse.setContentType("application/json; char=UTF-8");
        } catch (IOException ex) {
            httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(
            method = RequestMethod.POST)
    public void insert(
            HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse,
            @RequestBody String jsonEntrada){
        try {
            CuentaBancaria cuentaBancariaEntrada = (CuentaBancaria) jsonTransformer.fromJson(jsonEntrada, CuentaBancaria.class);
            CuentaBancaria cuentaBancariaSalida = cuentaBancariaDAO.insert(cuentaBancariaEntrada);
            String jsonSalida = jsonTransformer.toJson(cuentaBancariaSalida);
            httpServletResponse.getWriter().println(jsonSalida);
            httpServletResponse.setStatus(HttpServletResponse.SC_OK);
        } catch (IOException ex) {
            httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(
            value = {"/{idCuentaBancaria}"},
            method = RequestMethod.PUT,
            consumes = "application/json",
            produces = "application/json")
    public void update(
            HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse,
            @RequestBody String jsonEntrada,
            @PathVariable("idCuentaBancaria") int idCuentaBancaria){
        try {
            CuentaBancaria cuentaBancaria=(CuentaBancaria) jsonTransformer.fromJson(jsonEntrada, CuentaBancaria.class);
            cuentaBancaria = cuentaBancariaDAO.update(cuentaBancaria);
            String jsonSalida = jsonTransformer.toJson(cuentaBancaria);
            httpServletResponse.getWriter().println(jsonSalida);
            httpServletResponse.setStatus(HttpServletResponse.SC_OK);
            httpServletResponse.setContentType("application/json; char=UTF-8");
        } catch (IOException ex) {
            httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(
            value = {"{idCuentaBancaria}"},
            method = RequestMethod.DELETE)
    public void delete(
            HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse,
            @PathVariable("idCuentaBancaria") int idCuentaBancaria){
        cuentaBancariaDAO.delete(idCuentaBancaria);
        httpServletResponse.setStatus(HttpServletResponse.SC_NO_CONTENT);
    }

    @RequestMapping(
            method = RequestMethod.GET)
    public void findAll(
            HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse){
        try {
            String jsonSalida = jsonTransformer.toJson(cuentaBancariaDAO.findAll());
            httpServletResponse.getWriter().println(jsonSalida);
            httpServletResponse.setStatus(HttpServletResponse.SC_OK);
            httpServletResponse.setContentType("application/json; char=UTF-8");
        } catch (IOException ex) {
            httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }
}