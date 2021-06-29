package com.emergentes.dao;

import com.emergentes.modelo.Estudiantes;
import java.util.List;

public interface EstudiantesDAO {
    public void insert_estudiante(Estudiantes estudiantes) throws Exception;
    public void update_estudiante(Estudiantes estudiantes) throws Exception;
    public void delete_estudiante(int cod) throws Exception;
    public Estudiantes getId_estudiante(int cod) throws Exception;
    public List<Estudiantes> getAll_estudiante_area(String area) throws Exception;
    
    public double estudiantes_totales()throws Exception;    
    public double estudiantes_totales_areas(String area)throws Exception; 
}
