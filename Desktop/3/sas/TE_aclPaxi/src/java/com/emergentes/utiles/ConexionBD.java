        
package com.emergentes.utiles;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {
    static String driver = "com.mysql.jdbc.Driver";
    static String url ="jdbc:mysql://localhost:3306/bd_aclsalazar";
    static String usuario="root";
    static String password="";
    
    protected Connection conn= null;
    public ConexionBD(){
        try{
            Class.forName(driver);
            conn= DriverManager.getConnection(url, usuario, password);
            if(conn!= null){
                System.out.println("conexion exitosa");
            }
        }catch(ClassNotFoundException e){
            System.out.println("error en driver" + e.getMessage());
        } catch(SQLException e){
            System.out.println("error en driver" + e.getMessage());
        }
    }
    
    public Connection conectar(){
        return conn;
    }
    public void desconectar(){
        try{
            conn.close();
        }catch(SQLException e){
            System.out.println("error en driver" + e.getMessage());
        }
    }
}