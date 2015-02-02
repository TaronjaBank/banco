package com.fpmislata.banco.dominio;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class MovimientoBancario {

    int idMovimientoBancario;
    int idCuentaBancariaDestino;
    String conceptoMovimientoBancario;
    double cantidadMovimientoBancario;
    TipoMovimiento tipoMovimiento;
    CuentaBancaria cuentaBancaria;
    
    public MovimientoBancario() {
    }

    public MovimientoBancario(int idMovimientoBancario, int idCuentaBancariaDestino, String conceptoMovimientoBancario, double cantidadMovimientoBancario, TipoMovimiento tipoMovimiento, CuentaBancaria cuentaBancaria) {
        this.idMovimientoBancario = idMovimientoBancario;
        this.idCuentaBancariaDestino = idCuentaBancariaDestino;
        this.conceptoMovimientoBancario = conceptoMovimientoBancario;
        this.cantidadMovimientoBancario = cantidadMovimientoBancario;
        this.tipoMovimiento = tipoMovimiento;
        this.cuentaBancaria = cuentaBancaria;
    }

    public int getIdMovimientoBancario() {
        return idMovimientoBancario;
    }

    public void setIdMovimientoBancario(int idMovimientoBancario) {
        this.idMovimientoBancario = idMovimientoBancario;
    }

    public int getIdCuentaBancariaDestino() {
        return idCuentaBancariaDestino;
    }

    public void setIdCuentaBancariaDestino(int idCuentaBancariaDestino) {
        this.idCuentaBancariaDestino = idCuentaBancariaDestino;
    }

    public String getConceptoMovimientoBancario() {
        return conceptoMovimientoBancario;
    }

    public void setConceptoMovimientoBancario(String conceptoMovimientoBancario) {
        this.conceptoMovimientoBancario = conceptoMovimientoBancario;
    }

    public double getCantidadMovimientoBancario() {
        return cantidadMovimientoBancario;
    }

    public void setCantidadMovimientoBancario(double cantidadMovimientoBancario) {
        this.cantidadMovimientoBancario = cantidadMovimientoBancario;
    }

    public TipoMovimiento getTipoMovimiento() {
        return tipoMovimiento;
    }

    public void setTipoMovimiento(TipoMovimiento tipoMovimiento) {
        this.tipoMovimiento = tipoMovimiento;
    }

    public CuentaBancaria getCuentaBancaria() {
        return cuentaBancaria;
    }

    public void setCuentaBancaria(CuentaBancaria cuentaBancaria) {
        this.cuentaBancaria = cuentaBancaria;
    }

    

}
