package com.fpmislata.banco.dominio;

import java.io.Serializable;

public class SucursalBancaria implements Serializable{

    int idSucursalBancaria;
    String nombreSucursalBancaria;
    String direccionSucursalBancaria;
    EntidadBancaria entidadBancaria;
    
    public SucursalBancaria() {
    }

    public SucursalBancaria(int idSucursalBancaria, String nombreSucursalBancaria, String direccionSucursalBancaria, EntidadBancaria EntidadBancaria) {
        this.idSucursalBancaria = idSucursalBancaria;
        this.nombreSucursalBancaria = nombreSucursalBancaria;
        this.direccionSucursalBancaria = direccionSucursalBancaria;
        this.entidadBancaria = EntidadBancaria;
    }
    

    public EntidadBancaria getEntidadBancaria() {
        return entidadBancaria;
    }

    public void setEntidadBancaria(EntidadBancaria EntidadBancaria) {
        this.entidadBancaria = EntidadBancaria;
    }

    public int getIdSucursalBancaria() {
        return idSucursalBancaria;
    }

    public void setIdSucursalBancaria(int idSucursalBancaria) {
        this.idSucursalBancaria = idSucursalBancaria;
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


}
