package com.fpmislata.banco.dominio;

public class MovimientoBancario {
    int idMovimientoBancario;
    int idCuentaBancariaOrigen;
    int idCuentaBancariaDestino;
    double cantidadMovimientoBancario;
    String conceptoMovimientoBancario;

    public int getIdMovimientoBancario() {
        return idMovimientoBancario;
    }

    public void setIdMovimientoBancario(int idMovimientoBancario) {
        this.idMovimientoBancario = idMovimientoBancario;
    }

    public int getIdCuentaBancariaOrigen() {
        return idCuentaBancariaOrigen;
    }

    public void setIdCuentaBancariaOrigen(int idCuentaBancariaOrigen) {
        this.idCuentaBancariaOrigen = idCuentaBancariaOrigen;
    }

    public int getIdCuentaBancariaDestino() {
        return idCuentaBancariaDestino;
    }

    public void setIdCuentaBancariaDestino(int idCuentaBancariaDestino) {
        this.idCuentaBancariaDestino = idCuentaBancariaDestino;
    }

    public double getCantidadMovimientoBancario() {
        return cantidadMovimientoBancario;
    }

    public void setCantidadMovimientoBancario(double cantidadMovimientoBancario) {
        this.cantidadMovimientoBancario = cantidadMovimientoBancario;
    }

    public String getConceptoMovimientoBancario() {
        return conceptoMovimientoBancario;
    }

    public void setConceptoMovimientoBancario(String conceptoMovimientoBancario) {
        this.conceptoMovimientoBancario = conceptoMovimientoBancario;
    }

}
