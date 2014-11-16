package com.fpmislata.banco.dominio;

public class SucursalBancaria {
    int idSucursalBancaria;
    String nombreSucursalBancaria;
    String direccionSucursalBancaria;
    int idEntidadBancaria;

    public SucursalBancaria() {
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

    public int getIdEntidadBancaria() {
        return idEntidadBancaria;
    }

    public void setIdEntidadBancaria(int idEntidadBancaria) {
        this.idEntidadBancaria = idEntidadBancaria;
    }
    
}
