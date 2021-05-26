
package com.emergentes.DAO;

import com.emergentes.utiles.ConexionBD;
import com.energentes.modelo.Usuarios;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UsuariosDAOimpl extends ConexionBD implements UsuariosDAO {

    @Override
    public Usuarios Validar(String usuario, String correo, String clave) throws Exception {
        Usuarios usu = new Usuarios();
        try{
        String sql = "SELECT * FROM usuarios WHERE usuario = ? and correo = ? and clave = ?";
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setString(1, usuario);
        ps.setString(2, correo);
        ps.setString(3, clave);
 
        ResultSet rs = ps.executeQuery();
        
        if (rs.next()) {
            usu.setId(rs.getInt("id"));
            usu.setUsuario(rs.getString("usuario"));
            usu.setCorreo(rs.getString("correo"));
            usu.setClave(rs.getString("clave"));
        }
        rs.close();
        ps.close();
        }catch(Exception ex){
            System.out.println("ERROR AL CONECTAR: "+ex.getMessage());
        }finally{
            this.desconectar();
        }
        return usu;
    }
    
     
    
}
