package com.fpmislata.banco.dominio;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fpmislata.banco.common.utilidades;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotNull;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Empleado {

    int idEmpleado;
    
    @NotNull
    String dniEmpleado;
    
    @NotNull
    String nombreEmpleado;
    
    @NotNull
    String apellido1Empleado;
    
    @NotNull
    String apellido2Empleado;
    
    @NotNull
    SucursalBancaria sucursalBancaria;
    
    @NotNull
    String loginEmpleado;
    
    @NotNull
    String passwordEmpleado;

    
    @AssertTrue(message = "El DNI no es correcto")
    private boolean isDNIValido() {
        this.dniEmpleado=this.dniEmpleado.toUpperCase();
        return utilidades.comprobarDNI(this.dniEmpleado);
    }
    public Empleado() {
    }

    public Empleado(int idEmpleado, String dniEmpleado, String nombreEmpleado, String apellido1Empleado, String apellido2Empleado, SucursalBancaria sucursalBancaria, String loginEmpleado, String passwordEmpleado) {
        this.idEmpleado = idEmpleado;
        this.dniEmpleado = dniEmpleado;
        this.nombreEmpleado = nombreEmpleado;
        this.apellido1Empleado = apellido1Empleado;
        this.apellido2Empleado = apellido2Empleado;
        this.sucursalBancaria = sucursalBancaria;
        this.loginEmpleado = loginEmpleado;
        this.passwordEmpleado = passwordEmpleado;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getDniEmpleado() {
        return dniEmpleado;
    }

    public void setDniEmpleado(String dniEmpleado) {
        this.dniEmpleado = dniEmpleado;
    }

    public String getNombreEmpleado() {
        return nombreEmpleado;
    }

    public void setNombreEmpleado(String nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }

    public String getApellido1Empleado() {
        return apellido1Empleado;
    }

    public void setApellido1Empleado(String apellido1Empleado) {
        this.apellido1Empleado = apellido1Empleado;
    }

    public String getApellido2Empleado() {
        return apellido2Empleado;
    }

    public void setApellido2Empleado(String apellido2Empleado) {
        this.apellido2Empleado = apellido2Empleado;
    }

    public String getLoginEmpleado() {
        return loginEmpleado;
    }

    public void setLoginEmpleado(String loginEmpleado) {
        this.loginEmpleado = loginEmpleado;
    }

    public String getPasswordEmpleado() {
        return passwordEmpleado;
    }

    public void setPasswordEmpleado(String passwordEmpleado) {
        this.passwordEmpleado = passwordEmpleado;
    }

    public SucursalBancaria getSucursalBancaria() {
        return sucursalBancaria;
    }

    public void setSucursalBancaria(SucursalBancaria sucursalBancaria) {
        this.sucursalBancaria = sucursalBancaria;
    }

}
