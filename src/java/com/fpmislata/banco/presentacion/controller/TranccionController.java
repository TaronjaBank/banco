/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.presentacion.controller;

import com.fpmislata.banco.dominio.EntidadBancaria;
import com.fpmislata.banco.dominio.Transaccion;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Marti
 */

@Controller// Para que java entienda que esto es un controlador.
@RequestMapping("/Transaccion")
public class TranccionController {
    
    @RequestMapping(
            method = RequestMethod.POST)
    public void generarTransaccion(HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse,
            @RequestBody String jsonEntrada) {
        try {
            //recojer los dos numeros de cuenta y hacer el get de ellas para obtenet los objetos cuenta a traves de su dao.
            //crear la transaccion con los numeros de cuenta. y el concepto y el inporte.
            //generar los dos movimientos bancarios 
            //insertarlos a traves de su dao en la tabla correspondiente
            httpServletResponse.getWriter().println();
            httpServletResponse.setStatus(HttpServletResponse.SC_OK);
        } catch (IOException ex) {
            httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }
}
