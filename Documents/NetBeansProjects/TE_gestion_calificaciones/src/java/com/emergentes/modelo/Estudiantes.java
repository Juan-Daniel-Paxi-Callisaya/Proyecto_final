package com.emergentes.modelo;

import java.sql.Date;

public class Estudiantes extends Usuarios {
    private int cod_estudiante;
    private String area;
    private String descripcion;
    private double monto;
    private Date fecha;
    private int usuario; 
    
    public int getCod_estudiante() {
        return cod_estudiante;
    }

    public void setCod_estudiante(int cod_estudiante) {
        this.cod_estudiante = cod_estudiante;
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
