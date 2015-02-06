/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.dominio;

public class Transaccion {
  private CuentaBancaria CuentaOrigen;
  private CuentaBancaria CuentaDestino;
  private double importe;
  private String concepto;
  
    public Transaccion() {
    }

    public Transaccion(CuentaBancaria CuentaOrigen, CuentaBancaria CuentaDestino, double importe, String concepto) {
        this.CuentaOrigen = CuentaOrigen;
        this.CuentaDestino = CuentaDestino;
        this.importe = importe;
        this.concepto = concepto;
    }

   

    public CuentaBancaria getCuentaOrigen() {
        return CuentaOrigen;
    }

    public void setCuentaOrigen(CuentaBancaria CuentaOrigen) {
        this.CuentaOrigen = CuentaOrigen;
    }

    public CuentaBancaria getCuentaDestino() {
        return CuentaDestino;
    }

    public void setCuentaDestino(CuentaBancaria CuentaDestino) {
        this.CuentaDestino = CuentaDestino;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

   
    
  
}
