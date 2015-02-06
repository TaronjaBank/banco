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
    
    public MovimientoBancario getMovimientoBancarioDEBE(){
        MovimientoBancario movimientoBancarioDEBE=new MovimientoBancario();
       
            movimientoBancarioDEBE.setConceptoMovimientoBancario(this.transaccion.getConcepto());
            movimientoBancarioDEBE.setCuentaBancaria(this.transaccion.getCuentaOrigen());
            movimientoBancarioDEBE.setTipoMovimiento(TipoMovimiento.DEBE);
            movimientoBancarioDEBE.setCantidadMovimientoBancario(this.transaccion.getImporte());
            
        
        return movimientoBancarioDEBE;
    }
     
    public MovimientoBancario getMovimientoBancarioHABER(){
        MovimientoBancario movimientoBancarioHABER=new MovimientoBancario();
       
            movimientoBancarioHABER.setConceptoMovimientoBancario(this.transaccion.getConcepto());
            movimientoBancarioHABER.setCuentaBancaria(this.transaccion.getCuentaDestino());
            movimientoBancarioHABER.setTipoMovimiento(TipoMovimiento.HABER);
            movimientoBancarioHABER.setCantidadMovimientoBancario(this.transaccion.getImporte());
            
        
        return movimientoBancarioHABER;
    } 
}
