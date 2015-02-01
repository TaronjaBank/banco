package com.fpmislata.banco.dominio;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class EntidadBancaria implements Serializable{

    int idEntidadBancaria;
    String codigoEntidadBancaria;
    String nombreEntidadBancaria;
    Date fechaCreacionEntidadBancaria;
    @JsonIgnore
    private Set<SucursalBancaria> sucursalesBancarias;

    public EntidadBancaria() {
    }

    public EntidadBancaria(int idEntidadBancaria, String codigoEntidadBancaria, String nombreEntidadBancaria, Date fechaCreacionEntidadBancaria) {
        this.idEntidadBancaria = idEntidadBancaria;
        this.codigoEntidadBancaria = codigoEntidadBancaria;
        this.nombreEntidadBancaria = nombreEntidadBancaria;
        this.fechaCreacionEntidadBancaria = fechaCreacionEntidadBancaria;
    }
    
    public int getIdEntidadBancaria() {
        return idEntidadBancaria;
    }

    public void setIdEntidadBancaria(int idEntidadBancaria) {
        this.idEntidadBancaria = idEntidadBancaria;
    }

    public String getCodigoEntidadBancaria() {
        return codigoEntidadBancaria;
    }

    public void setCodigoEntidadBancaria(String codigoEntidadBancaria) {
        this.codigoEntidadBancaria = codigoEntidadBancaria;
    }

    public String getNombreEntidadBancaria() {
        return nombreEntidadBancaria;
    }

    public void setNombreEntidadBancaria(String nombreEntidadBancaria) {
        this.nombreEntidadBancaria = nombreEntidadBancaria;
    }

    public Date getFechaCreacionEntidadBancaria() {
        return fechaCreacionEntidadBancaria;
    }

    public void setFechaCreacionEntidadBancaria(Date fechaCreacionEntidadBancaria) {
        this.fechaCreacionEntidadBancaria = fechaCreacionEntidadBancaria;
    }
    
    public Set<SucursalBancaria> getSucursalesBancarias() {
        return sucursalesBancarias;
    }

    public void setSucursalesBancarias(Set<SucursalBancaria> sucursalesBancarias) {
        this.sucursalesBancarias = sucursalesBancarias;
    }

}
