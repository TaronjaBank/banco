/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.dominio;

import javax.validation.constraints.Pattern;
import org.hibernate.validator.constraints.NotBlank;

public class Transaccion {
    
  @NotBlank
  @Pattern(regexp="\\d{4}-\\d{4}-\\d{4}")
  private String numeroCuentaOrigen;
  
  @NotBlank
  @Pattern(regexp="\\d{4}-\\d{4}-\\d{4}")
  private String numeroCuentaDestino;
  
  private double importe;
  
  @NotBlank
  private String concepto;
  
    public Transaccion() {
    }

    public Transaccion(String numeroCuentaOrigen, String numeroCuentaDestino, double importe, String concepto) {
        this.numeroCuentaOrigen = numeroCuentaOrigen;
        this.numeroCuentaDestino = numeroCuentaDestino;
        this.importe = importe;
        this.concepto = concepto;
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

    public String getNumeroCuentaOrigen() {
        return numeroCuentaOrigen;
    }

    public void setNumeroCuentaOrigen(String numeroCuentaOrigen) {
        this.numeroCuentaOrigen = numeroCuentaOrigen;
    }

    public String getNumeroCuentaDestino() {
        return numeroCuentaDestino;
    }

    public void setNumeroCuentaDestino(String numeroCuentaDestino) {
        this.numeroCuentaDestino = numeroCuentaDestino;
    }

   
    
  
}
