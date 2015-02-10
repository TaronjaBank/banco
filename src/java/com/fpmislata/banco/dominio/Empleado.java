package com.fpmislata.banco.dominio;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fpmislata.banco.common.Validaciones;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotBlank;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Empleado {

    int idEmpleado;
    
    @NotBlank
    @Pattern(regexp = "(\\d{8})([a-zA-Z]{1})")
    String dniEmpleado;
    
    @NotBlank
    @Size(min = 0, max = 50)        
    String nombreEmpleado;
    
    @NotBlank
    @Size(min = 0, max = 50)
    String apellido1Empleado;
    
    @NotBlank
    @Size(min = 0, max = 50)
    String apellido2Empleado;
    
    @NotNull
    SucursalBancaria sucursalBancaria;
    
    @NotBlank
    @Size(min = 0, max = 50)
    String loginEmpleado;
    
    @NotBlank
    @Size(min = 0, max = 50)
    String passwordEmpleado;

    
    @AssertTrue(message = "El DNI no es correcto")
    private boolean isDNIValido() {
        boolean valido;
        if (this.dniEmpleado != null) {
            this.dniEmpleado = this.dniEmpleado.toUpperCase();
            valido = Validaciones.comprobarDNI(this.dniEmpleado);
        } else {
            valido = false;
        }
        return valido;
    }
    
    @AssertTrue(message = "El campo login no puede contener espacios en blanco")
    private boolean isLoginValido() {
        return Validaciones.espaciosEnBlanco(this.loginEmpleado);
    }
    
    @AssertTrue(message = "El campo password no puede contener espacios en blanco")
    private boolean isPasswordValido() {
        return Validaciones.espaciosEnBlanco(this.passwordEmpleado);
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
