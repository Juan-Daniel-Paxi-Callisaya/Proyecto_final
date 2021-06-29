package com.emergentes.dao;

import com.emergentes.modelo.Estudiantes;
import com.emergentes.utiles.conexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EstudiantesDAOimpl extends conexionDB implements EstudiantesDAO{

    @Override
    public void insert_estudiante(Estudiantes estudiantes) throws Exception {
        try {
            this.conectar();
            String sql = "insert into estudiantes (area, descripcion, monto, fecha, usuario) values (?, ?, ?, ?, ?)";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, estudiantes.getArea());
            ps.setString(2, estudiantes.getDescripcion());
            ps.setDouble(3, estudiantes.getMonto());
            ps.setDate(4, estudiantes.getFecha());
            ps.setInt(5, estudiantes.getCod_usuario());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally{
            this.desconectar();
        }        
    }

    @Override
    public void update_estudiante(Estudiantes estudiantes) throws Exception {
    try {
            this.conectar();
            String sql = "update estudiantes set descripcion = ?, monto = ?, fecha = ? where cod_estudiante = ?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, estudiantes.getDescripcion());
            ps.setDouble(2, estudiantes.getMonto());
            ps.setDate(3, estudiantes.getFecha());
            ps.setInt(4, estudiantes.getCod_estudiante());
            ps.executeUpdate();
            
        } catch (Exception e) {
            throw e;
        } finally{
            this.desconectar();
        }        
    }

    @Override
    public void delete_estudiante(int cod) throws Exception {
        try {
            this.conectar();
            String sql = "delete from estudiantes where cod_estudiante = ?";
            PreparedStatement ps= this.conn.prepareStatement(sql);
            ps.setInt(1, cod);
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally{
            this.desconectar();
        }          
    }

    @Override
    public Estudiantes getId_estudiante(int cod) throws Exception {
        Estudiantes gasto = new Estudiantes();
        try {
            this.conectar();            
            String sql = "select * from estudiantes where cod_estudiante = ?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, cod);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                gasto.setCod_estudiante(rs.getInt("cod_estudiante"));
                gasto.setArea(rs.getString("area"));
                gasto.setDescripcion(rs.getString("descripcion"));
                gasto.setMonto(rs.getInt("monto"));
                gasto.setFecha(rs.getDate("fecha"));                
            }            
        } catch (Exception e) {
            throw e;
        } finally{
            this.desconectar();
        }
        return gasto;          
    }

    @Override
    public List<Estudiantes> getAll_estudiante_area(String area) throws Exception {
        List<Estudiantes> lista = null;
        try {
            this.conectar();
            String sql = "select * from estudiantes where area = ?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, area);
            ResultSet rs = ps.executeQuery();
            lista = new ArrayList<Estudiantes>();
            while (rs.next()) {                
                Estudiantes estudiante = new Estudiantes();                
                estudiante.setCod_estudiante(rs.getInt("cod_estudiante"));
                estudiante.setArea(rs.getString("area"));
                estudiante.setDescripcion(rs.getString("descripcion"));
                estudiante.setMonto(rs.getDouble("monto"));
                estudiante.setFecha(rs.getDate("fecha"));            
                lista.add(estudiante);
            }            
        } catch (Exception e) {
            throw e;
        }finally{
            this.desconectar();
        }
        return lista;                 
    }

    @Override
    public double estudiantes_totales() throws Exception {
        double docente_total=0.0;
        try {
            this.conectar();
            Statement st = conn.createStatement();
            String sql = "select SUM(monto) as monto from estudiantes";            
            ResultSet rs = st.executeQuery(sql);            
            while (rs.next()) {
                docente_total = rs.getDouble("monto");
            }            
        } catch (Exception e) {
            throw e;
        } finally{
            this.desconectar();
        }
        return docente_total;         
    }

    @Override
    public double estudiantes_totales_areas(String area) throws Exception {
        double estudiante_total=0.0;
        System.out.println("EL AREA EN ESTUDIANTES :"+area);
        try {
            this.conectar();
            Statement st = conn.createStatement();
            String sql = "select SUM(monto) as monto from estudiantes where area = ?";            
            PreparedStatement ps= this.conn.prepareStatement(sql);
            //ps.setString(1, area); 
            ps.setString(1, area);
            ResultSet rs = ps.executeQuery();            
            while (rs.next()) {
                estudiante_total = rs.getDouble("monto");
                System.out.println("EL monto:"+estudiante_total);
            }            
        } catch (Exception e) {
            throw e;
        } finally{
            this.desconectar();
        }
        return estudiante_total;                        
    }
}
