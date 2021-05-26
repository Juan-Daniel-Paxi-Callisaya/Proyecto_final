<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    
    <body style="text-align: center">
        <table border="8">
            <tr>
                <th>TECNOLOGIA DE EMERGENTES</th>
            </tr>
            <tr>
                <th>Ingenierio: Lic.Mario Torrez</th>
            </tr>
            <tr>
                <th>Nombre: Juan Daniel Paxi Callisaya</th>            
            </tr>
        </table>
        <h1>LOGIN</h1>

        <form action="MainController" method="post">
            <p>Usuario:  </p>
            <input type="text" placeholder="Nombre de Usuario" name="usuario" required>
            <p>Correo:  </p>
            <input type="text" placeholder="correo" name="correo" required>
            <p>Clave:  </p>
            
            <input type="password" placeholder="clave" name="clave" required>
            <br>
            <input type="submit" value="Ingresar">
        </form>

    </body>
</html>
