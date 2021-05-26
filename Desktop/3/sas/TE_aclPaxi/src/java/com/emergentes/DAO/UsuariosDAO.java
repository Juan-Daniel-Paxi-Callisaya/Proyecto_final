
package com.emergentes.DAO;

import com.energentes.modelo.Usuarios;

public interface UsuariosDAO {
    
    public Usuarios Validar(String usuario,String correo, String clave) throws Exception;
    
}
