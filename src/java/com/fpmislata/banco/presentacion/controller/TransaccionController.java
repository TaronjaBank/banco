/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.presentacion.controller;

import com.fpmislata.banco.common.json.JsonTransformer;
import com.fpmislata.banco.dominio.CuentaBancaria;
import com.fpmislata.banco.dominio.EntidadBancaria;
import com.fpmislata.banco.dominio.PasarelaPago;
import com.fpmislata.banco.dominio.Transaccion;
import com.fpmislata.banco.persistencia.dao.CuentaBancariaDAO;
import com.fpmislata.banco.persistencia.dao.MovimientoBancarioDAO;
import com.fpmislata.banco.persistencia.dao.BussinessException;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
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
public class TransaccionController {

    @Autowired
    MovimientoBancarioDAO movimientoBancarioDAO;

    @Autowired
    JsonTransformer jsonTransformer;

    @Autowired
    CuentaBancariaDAO cuentaBancariaDAO;

    @RequestMapping(
            method = RequestMethod.POST)
    public void generarTransaccion(HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse,
            @RequestBody String jsonEntrada) {
        try {
            Transaccion transaccion = (Transaccion) jsonTransformer.fromJson(jsonEntrada, Transaccion.class);
            CuentaBancaria cuentaBancariaOrigen =cuentaBancariaDAO.getFromNumeroCuenta(transaccion.getNumeroCuentaOrigen());
            CuentaBancaria cuentaBancariaDestino =cuentaBancariaDAO.getFromNumeroCuenta(transaccion.getNumeroCuentaDestino());
            if(cuentaBancariaDestino.getCliente().getApiKey().equals(transaccion.getApiKey())){
				PasarelaPago pasarelaPago=new PasarelaPago(transaccion);
				movimientoBancarioDAO.insert(pasarelaPago.getMovimientoBancarioDEBE(cuentaBancariaOrigen));
				movimientoBancarioDAO.insert(pasarelaPago.getMovimientoBancarioHABER(cuentaBancariaDestino));
				httpServletResponse.getWriter().println("Se ha realizado el pago");
				httpServletResponse.setStatus(HttpServletResponse.SC_OK);
            }else{
                throw new BussinessException("ApiKey","La apiKey no es Correcta");
            }
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
