package com.emergentes.modelo;

import java.sql.Date;

public class Docentes extends Usuarios {
    private int cod_docente;
    private String area;
    private String descripcion;
    private double monto;
    private Date fecha;
    private int usuario;

    public int getCod_docente() {
        return cod_docente;
    }

    public void setCod_docente(int cod_docente) {
        this.cod_docente = cod_docente;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getUsuario() {
        return usuario;
    }

    public void setUsuario(int usuario) {
        this.usuario = usuario;
    }
}
