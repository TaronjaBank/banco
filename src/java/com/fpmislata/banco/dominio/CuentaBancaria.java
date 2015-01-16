package com.fpmislata.banco.dominio;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class CuentaBancaria {

    int idCuentaBancaria;
    int numeroCuentaBancaria;
    int idCliente;
    private SucursalBancaria sucursalBancaria;

    public CuentaBancaria() {
    }
    
    public CuentaBancaria(int idCuentaBancaria, int numeroCuentaBancaria, int idEntidadBancaria, int idCliente, SucursalBancaria sucursalBancaria) {
        this.idCuentaBancaria = idCuentaBancaria;
        this.numeroCuentaBancaria = numeroCuentaBancaria;
        
        this.idCliente = idCliente;
        this.sucursalBancaria = sucursalBancaria;
    }
    
    public int getIdCuentaBancaria() {
        return idCuentaBancaria;
    }

    public void setIdCuentaBancaria(int idCuentaBancaria) {
        this.idCuentaBancaria = idCuentaBancaria;
    }

    public int getNumeroCuentaBancaria() {
        return numeroCuentaBancaria;
    }

    public void setNumeroCuentaBancaria(int numeroCuentaBancaria) {
        this.numeroCuentaBancaria = numeroCuentaBancaria;
    }


    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public SucursalBancaria getSucursalBancaria() {
        return sucursalBancaria;
    }

    public void setSucursalBancaria(SucursalBancaria sucursalBancaria) {
        this.sucursalBancaria = sucursalBancaria;
    }

}
