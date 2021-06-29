package com.emergentes.dao;

import com.emergentes.modelo.Docentes;
import com.emergentes.utiles.conexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DocentesDAOimpl extends conexionDB implements DocentesDAO{

    @Override
    public void insert_docente(Docentes docentes) throws Exception {
        try {
            this.conectar();
            String sql = "insert into docentes (area, descripcion, monto, fecha, usuario) values (?, ?, ?, ?, ?)";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, docentes.getArea());
            ps.setString(2, docentes.getDescripcion());
            ps.setDouble(3, docentes.getMonto());
            ps.setDate(4, docentes.getFecha());
            ps.setInt(5, docentes.getCod_usuario());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;            
        } finally{
            this.desconectar();
        }        
    }

    @Override
    public void update_docente(Docentes docentes) throws Exception {
    try {
            this.conectar();
            String sql = "update docentes set descripcion = ?, monto = ?, fecha = ? where cod_docente = ?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, docentes.getDescripcion());
            ps.setDouble(2, docentes.getMonto());
            ps.setDate(3, docentes.getFecha());
            ps.setInt(4, docentes.getCod_docente());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally{
            this.desconectar();
        }        
    }

    @Override
    public void delete_docente(int cod) throws Exception {
        try {
            this.conectar();
            String sql = "delete from docentes where cod_docente = ?";
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
    public Docentes getId_docente(int cod) throws Exception {
           Docentes docente = new Docentes();
        try {
            this.conectar();            
            String sql = "select * from docentes where cod_docente = ?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, cod);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                docente.setCod_docente(rs.getInt("cod_docente"));
                docente.setArea(rs.getString("area"));
                docente.setDescripcion(rs.getString("descripcion"));
                docente.setMonto(rs.getInt("monto"));
                docente.setFecha(rs.getDate("fecha"));                
            }            
        } catch (Exception e) {
            throw e;
        } finally{
            this.desconectar();
        }
        return docente;          
    }

    @Override
    public List<Docentes> getAll_docente_area(String area) throws Exception {
        List<Docentes> lista = null;
        try {
            this.conectar();
            String sql = "select * from docentes where area = ?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, area);
            ResultSet rs = ps.executeQuery();
            lista = new ArrayList<Docentes>();
            while (rs.next()) {                
                Docentes docente = new Docentes();                
                docente.setCod_docente(rs.getInt("cod_docente"));
                docente.setArea(rs.getString("area"));
                docente.setDescripcion(rs.getString("descripcion"));
                docente.setMonto(rs.getDouble("monto"));
                docente.setFecha(rs.getDate("fecha"));            
                lista.add(docente);
            }
            
        } catch (Exception e) {
            throw e;
        }finally{
            this.desconectar();
        }
        return lista;         
    }

    @Override
    public double docentes_totales() throws Exception {
        double docente_total=0.0;
        try {
            this.conectar();
            Statement st = conn.createStatement();
            String sql = "select SUM(monto) as monto from docentes";            
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
    public double docentes_totales_areas(String area) throws Exception {
        double docente_total=0.0;
        System.out.println("EL AREA EN DOCENTES :"+area);
        try {
            this.conectar();            
            String sql = "select SUM(monto) as monto from docentes where area = ?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, area);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {                
                docente_total = rs.getDouble("monto");
                System.out.println("EL monto:"+docente_total);
            }            
        } catch (Exception e) {
            System.out.println("ERROR EN LA CONSULTA");
            throw e;
        } finally{
            this.desconectar();
        }
        return docente_total;                  
    }
}
