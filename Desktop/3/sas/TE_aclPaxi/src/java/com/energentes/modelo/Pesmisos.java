
package com.energentes.modelo;

public class Pesmisos {
    
    private int id;
    private int id_usuario;
    private int id_rol;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public int getId_rol() {
        return id_rol;
    }

    public void setId_rol(int id_rol) {
        this.id_rol = id_rol;
    }

    @Override
    public String toString() {
        return "Pesmisos{" + "id=" + id + ", id_usuario=" + id_usuario + ", id_rol=" + id_rol + '}';
    }
    
}