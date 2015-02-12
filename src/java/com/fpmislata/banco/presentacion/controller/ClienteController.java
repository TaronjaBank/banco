package com.fpmislata.banco.presentacion.controller;

import com.fpmislata.banco.common.json.JsonTransformer;
import com.fpmislata.banco.dominio.Cliente;
import com.fpmislata.banco.dominio.CuentaBancaria;
import com.fpmislata.banco.persistencia.dao.ClienteDAO;
import java.io.IOException;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/Cliente")
public class ClienteController {

    @Autowired
    ClienteDAO clienteDAO;
    @Autowired
    JsonTransformer jsonTransformer;

    @RequestMapping(
            value = "/{idCliente}",
            method = RequestMethod.GET)
    public void get(
            HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse,
            @PathVariable("idCliente") int idCliente) {
        try {
            Cliente cliente = clienteDAO.get(idCliente);
            String jsonSalida = jsonTransformer.toJson(cliente);
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
            @RequestBody String jsonEntrada) {
        try {
            Cliente clienteEntrada = (Cliente) jsonTransformer.fromJson(jsonEntrada, Cliente.class);
            Cliente clienteSalida = clienteDAO.insert(clienteEntrada);
            String jsonSalida = jsonTransformer.toJson(clienteSalida);
            httpServletResponse.getWriter().println(jsonSalida);
            httpServletResponse.setStatus(HttpServletResponse.SC_OK);
        } catch (IOException ex) {
            httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(
            value = "/{idCliente}",
            method = RequestMethod.PUT,
            consumes = "application/json",
            produces = "application/json")
    public void update(
            HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse,
            @PathVariable("idCliente") int idCliente,
            @RequestBody String jsonEntrada) {
        try {
            Cliente cliente = (Cliente) jsonTransformer.fromJson(jsonEntrada, Cliente.class);
            cliente = clienteDAO.update(cliente);
            String jsonSalida = jsonTransformer.toJson(cliente);
            httpServletResponse.getWriter().println(jsonSalida);
            httpServletResponse.setStatus(HttpServletResponse.SC_OK);
            httpServletResponse.setContentType("application/json; char=UTF-8");
        } catch (IOException ex) {
            httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(
            value = "/{idCliente}",
            method = RequestMethod.DELETE)
    public void delete(
            HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse,
            @PathVariable("idCliente") int idCliente) {
        clienteDAO.delete(idCliente);
        httpServletResponse.setStatus(HttpServletResponse.SC_NO_CONTENT);
    }

    @RequestMapping(
            method = RequestMethod.GET)
    public void finAll(
            HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse) {
        try {
            String jsonSalida = jsonTransformer.toJson(clienteDAO.findAll());
            httpServletResponse.getWriter().println(jsonSalida);
            httpServletResponse.setStatus(HttpServletResponse.SC_OK);
            httpServletResponse.setContentType("application/json; char=UTF-8");
        } catch (IOException ex) {
            httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(
            value = "/{idCliente}/CuentaBancaria",
            method = RequestMethod.GET)
    public void finAllCuentasByCliente(
            HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse,
            @PathVariable("idCliente") int idCliente) {
        {
            try {
                Cliente cliente = clienteDAO.get(idCliente);
                Set<CuentaBancaria> cuentasBancarias = cliente.getCuentasBancarias();
                String jsonSalida = jsonTransformer.toJson(cuentasBancarias);
                httpServletResponse.getWriter().println(jsonSalida);
                httpServletResponse.setStatus(HttpServletResponse.SC_OK);
                httpServletResponse.setContentType("application/json; char=UTF-8");
            } catch (IOException ex) {
                httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            }
        }
    }

}
