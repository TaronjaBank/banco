/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.dominio;

/**
 *
 * @author Marti
 */
public class PasarelaPago {
     Transaccion transaccion;

    public PasarelaPago(Transaccion transaccion) {
        this.transaccion = transaccion;
    }
    
    public MovimientoBancario getMovimientoBancarioDEBE(CuentaBancaria cuentaBancariaOrigen){
        MovimientoBancario movimientoBancarioDEBE=new MovimientoBancario();
       
            movimientoBancarioDEBE.setConceptoMovimientoBancario(this.transaccion.getConcepto());
            movimientoBancarioDEBE.setCuentaBancaria(cuentaBancariaOrigen);
            movimientoBancarioDEBE.setTipoMovimiento(TipoMovimiento.DEBE);
            movimientoBancarioDEBE.setCantidadMovimientoBancario(this.transaccion.getImporte());
            
        
        return movimientoBancarioDEBE;
    }
     
    public MovimientoBancario getMovimientoBancarioHABER(CuentaBancaria cuentaBancariaDestino){
        MovimientoBancario movimientoBancarioHABER=new MovimientoBancario();
       
            movimientoBancarioHABER.setConceptoMovimientoBancario(this.transaccion.getConcepto());
            movimientoBancarioHABER.setCuentaBancaria(cuentaBancariaDestino);
            movimientoBancarioHABER.setTipoMovimiento(TipoMovimiento.HABER);
            movimientoBancarioHABER.setCantidadMovimientoBancario(this.transaccion.getImporte());
            
        
        return movimientoBancarioHABER;
    } 
}
