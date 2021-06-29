package com.emergentes.dao;

import com.emergentes.modelo.Docentes;
import java.sql.Date;
import java.util.List;

public interface DocentesDAO {
    public void insert_docente(Docentes docentes) throws Exception;
    public void update_docente(Docentes docentes) throws Exception;
    public void delete_docente(int cod) throws Exception;
    public Docentes getId_docente(int cod) throws Exception;
    public List<Docentes> getAll_docente_area(String area) throws Exception;    
    public double docentes_totales()throws Exception;    
    public double docentes_totales_areas(String area)throws Exception; 
}
