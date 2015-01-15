package com.fpmislata.banco.dominio;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

public class EntidadBancaria implements Serializable{

    int idEntidadBancaria;
    String codigoEntidadBancaria;
    String nombreEntidadBancaria;
    Date fechaCreacionEntidadBancaria;
    private List<SucursalBancaria> sucursalesBancarias;

    public List<SucursalBancaria> getSucursalesBancarias() {
        return sucursalesBancarias;
    }

    public void setSucursalesBancarias(List<SucursalBancaria> SucursalesBancarias) {
        this.sucursalesBancarias = SucursalesBancarias;
    }

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

}
