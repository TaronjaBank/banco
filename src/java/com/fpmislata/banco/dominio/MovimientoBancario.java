package com.fpmislata.banco.dominio;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotBlank;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class MovimientoBancario {

    int idMovimientoBancario;
    
    @NotBlank
    String conceptoMovimientoBancario;
    
    @NotNull
    Double cantidadMovimientoBancario;
    
    @NotNull
    TipoMovimiento tipoMovimiento;
    
    @NotNull
    CuentaBancaria cuentaBancaria;
    
    public MovimientoBancario() {
    }

    public MovimientoBancario(int idMovimientoBancario, String conceptoMovimientoBancario, double cantidadMovimientoBancario, TipoMovimiento tipoMovimiento, CuentaBancaria cuentaBancaria) {
        this.idMovimientoBancario = idMovimientoBancario;
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

    public String getConceptoMovimientoBancario() {
        return conceptoMovimientoBancario;
    }

    public void setConceptoMovimientoBancario(String conceptoMovimientoBancario) {
        this.conceptoMovimientoBancario = conceptoMovimientoBancario;
    }

    public Double getCantidadMovimientoBancario() {
        return cantidadMovimientoBancario;
    }

    public void setCantidadMovimientoBancario(Double cantidadMovimientoBancario) {
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
