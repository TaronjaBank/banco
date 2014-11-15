package com.fpmislata.banco.presentacion.controller;

import com.fpmislata.banco.dominio.SucursalBancaria;
import com.fpmislata.banco.persistencia.dao.SucursalBancariaDAO;
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
@RequestMapping("/SucursalBancaria")
public class SucursalBancariaController {

    SucursalBancaria sucursalBancaria;

    @Autowired
    SucursalBancariaDAO sucursalBancariaDAO;
    
    @Autowired
    JsonTransformer jsonTransformer;
    
    
    @RequestMapping(
            value = {"/{idSucursalBancaria}"},
            method = RequestMethod.GET)
    public void get(HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse,
            @PathVariable("idSucursalBancaria") int idSucursalBancaria) {
        
        try {
            sucursalBancaria = sucursalBancariaDAO.get(idSucursalBancaria);
            String jsonSalida = jsonTransformer.toJson(sucursalBancaria);
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
            sucursalBancaria = (SucursalBancaria) jsonTransformer.fromJson(jsonEntrada, SucursalBancaria.class);
            SucursalBancaria sucursalBancariaSalida = sucursalBancariaDAO.insert(sucursalBancaria);
            String jsonSalida = jsonTransformer.toJson(sucursalBancariaSalida);
            httpServletResponse.getWriter().println(jsonSalida);
            
            httpServletResponse.setStatus(HttpServletResponse.SC_OK);
        } catch (IOException ex) {
            httpServletResponse.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
    }

    @RequestMapping(
            value = {"/{idSucursalBancaria}"},
            method = RequestMethod.PUT,
            consumes = "application/json",
            produces = "application/json")
    public void update(
            HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse,
            @PathVariable("idSucursalBancaria") int idSucursalBancaria,
            @RequestBody String jsonEntrada) {

        try {
            sucursalBancaria = (SucursalBancaria) jsonTransformer.fromJson(jsonEntrada, SucursalBancaria.class);
            sucursalBancaria = sucursalBancariaDAO.update(sucursalBancaria);
            String jsonSalida = jsonTransformer.toJson(sucursalBancaria);
            httpServletResponse.getWriter().println(jsonSalida);
            
            httpServletResponse.setContentType("application/json; char=UTF-8");
            httpServletResponse.setStatus(HttpServletResponse.SC_OK);
        } catch (IOException ex){
            httpServletResponse.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
    }

    @RequestMapping(
            value = {"/{idSucursalBancaria}"},
            method = RequestMethod.DELETE)
    public void delete(
            HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse,
            @PathVariable("idSucursalBancaria") int idSucursalBancaria) {
        
        sucursalBancariaDAO.delete(idSucursalBancaria);
        httpServletResponse.setStatus(HttpServletResponse.SC_NO_CONTENT);
    }

    @RequestMapping(
            value = {""},
            method = RequestMethod.GET)
    public void findAll(HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse) {
        try {
            httpServletResponse.getWriter().println(jsonTransformer.toJson(sucursalBancariaDAO.findAll()));
            httpServletResponse.setStatus(HttpServletResponse.SC_OK);
        } catch (IOException ex) {
            httpServletResponse.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
    }
}
