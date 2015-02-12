package com.fpmislata.banco.dominio;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.Set;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotBlank;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class SucursalBancaria implements Serializable {

    
    int idSucursalBancaria;
    
    @NotBlank
    @Size(min=4, max=4)
    String codigoSucursalBancaria;
    
    @NotBlank
    @Size(min=0,max=50)
    String nombreSucursalBancaria;
    
    @NotBlank
    @Size(min=0,max=50)
    String direccionSucursalBancaria;
    
    @NotNull
    @Valid
    EntidadBancaria entidadBancaria;
    
    
    @JsonIgnore
    Set<CuentaBancaria> cuentasBancarias;
    @JsonIgnore
    Set<Empleado> empleados;

    public SucursalBancaria() {
    }

    public SucursalBancaria(int idSucursalBancaria, String codigoSucursalBancaria, String nombreSucursalBancaria, String direccionSucursalBancaria, EntidadBancaria entidadBancaria) {
        this.idSucursalBancaria = idSucursalBancaria;
        this.codigoSucursalBancaria = codigoSucursalBancaria;
        this.nombreSucursalBancaria = nombreSucursalBancaria;
        this.direccionSucursalBancaria = direccionSucursalBancaria;
        this.entidadBancaria = entidadBancaria;
    }

    public int getIdSucursalBancaria() {
        return idSucursalBancaria;
    }

    public void setIdSucursalBancaria(int idSucursalBancaria) {
        this.idSucursalBancaria = idSucursalBancaria;
    }

    public String getCodigoSucursalBancaria() {
        return codigoSucursalBancaria;
    }

    public void setCodigoSucursalBancaria(String codigoSucursalBancaria) {
        this.codigoSucursalBancaria = codigoSucursalBancaria;
    }

    public String getNombreSucursalBancaria() {
        return nombreSucursalBancaria;
    }

    public void setNombreSucursalBancaria(String nombreSucursalBancaria) {
        this.nombreSucursalBancaria = nombreSucursalBancaria;
    }

    public String getDireccionSucursalBancaria() {
        return direccionSucursalBancaria;
    }

    public void setDireccionSucursalBancaria(String direccionSucursalBancaria) {
        this.direccionSucursalBancaria = direccionSucursalBancaria;
    }

    public EntidadBancaria getEntidadBancaria() {
        return entidadBancaria;
    }

    public void setEntidadBancaria(EntidadBancaria EntidadBancaria) {
        this.entidadBancaria = EntidadBancaria;
    }

    public Set<CuentaBancaria> getCuentasBancarias() {
        return cuentasBancarias;
    }

    public void setCuentasBancarias(Set<CuentaBancaria> cuentasBancarias) {
        this.cuentasBancarias = cuentasBancarias;
    }

    public Set<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(Set<Empleado> empleados) {
        this.empleados = empleados;
    }

}
