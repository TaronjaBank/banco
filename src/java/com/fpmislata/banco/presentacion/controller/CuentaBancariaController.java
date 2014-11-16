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

    CuentaBancaria cuentaBancaria;
    
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
            cuentaBancaria = cuentaBancariaDAO.get(idCuentaBancaria);
            String jsonSalida = jsonTransformer.toJson(cuentaBancaria);
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
            @RequestBody String jsonEntrada){
        try {
            cuentaBancaria = (CuentaBancaria) jsonTransformer.fromJson(jsonEntrada, CuentaBancaria.class);
            CuentaBancaria cuentaBancariaSalida = cuentaBancariaDAO.insert(cuentaBancaria);
            String jsonSalida = jsonTransformer.toJson(cuentaBancariaSalida);
            httpServletResponse.getWriter().println(jsonSalida);
            
            httpServletResponse.setStatus(HttpServletResponse.SC_OK);
        } catch (IOException ex) {
            httpServletResponse.setStatus(HttpServletResponse.SC_BAD_REQUEST);
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
            cuentaBancaria=(CuentaBancaria) jsonTransformer.fromJson(jsonEntrada, CuentaBancaria.class);
            cuentaBancaria = cuentaBancariaDAO.update(cuentaBancaria);
            String jsonSalida = jsonTransformer.toJson(cuentaBancaria);
            httpServletResponse.getWriter().println(jsonSalida);
            
            httpServletResponse.setContentType("application/json; char=UTF-8");
            httpServletResponse.setStatus(HttpServletResponse.SC_OK);
        } catch (IOException ex) {
            httpServletResponse.setStatus(HttpServletResponse.SC_BAD_REQUEST);
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
            value = {""},
            method = RequestMethod.GET)
    public void findAll(
            HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse){
        try {
            String jsonSalida = jsonTransformer.toJson(cuentaBancariaDAO.findAll());
            httpServletResponse.getWriter().println(jsonSalida);
            
            httpServletResponse.setStatus(HttpServletResponse.SC_OK);
        } catch (IOException ex) {
            httpServletResponse.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
    }
}