package com.fpmislata.banco.dominio;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.Set;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class CuentaBancaria {

    int idCuentaBancaria;
    int numeroCuentaBancaria;
    int idCliente;
    private SucursalBancaria sucursalBancaria;
    @JsonIgnore
    private Set<MovimientoBancario> movimientosBancarios;

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

    public Set<MovimientoBancario> getMovimientosBancarios() {
        return movimientosBancarios;
    }

    public void setMovimientosBancarios(Set<MovimientoBancario> movimientosBancarios) {
        this.movimientosBancarios = movimientosBancarios;
    }

}
