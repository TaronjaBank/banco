package com.fpmislata.banco.dominio;

import java.util.Date;

public class EntidadBancaria {
    int idEntidadBancaria;
    String codigoEntidadBancaria;
    String nombreEntidadBancaria;
    Date fechaCreacionEntidadBancaria;

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
