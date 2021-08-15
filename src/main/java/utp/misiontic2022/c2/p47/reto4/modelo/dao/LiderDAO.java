package utp.misiontic2022.c2.p47.reto4.modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import utp.misiontic2022.c2.p47.reto4.modelo.vo.Lider;
import utp.misiontic2022.c2.p47.reto4.util.JDBCUtilities;

public class LiderDAO {
    public ArrayList<Lider> consultarPorSegundoApellido(String segundoApellido) throws SQLException {
        ArrayList<Lider> listaLideres= new ArrayList<Lider>();
        Connection conexion=JDBCUtilities.getConnection();
        
        String sqlConsulta= "select Nombre, Primer_Apellido, Segundo_Apellido, Salario"
        + " from Lider" 
        +" where Segundo_Apellido = ?";
       
       PreparedStatement stmt=conexion.prepareStatement(sqlConsulta);
       stmt.setString(1, segundoApellido);
        ResultSet resultadoConsulta=stmt.executeQuery();
        while(resultadoConsulta.next()){
            Lider lider= new Lider();
            lider.setNombre(resultadoConsulta.getString("Nombre"));
            lider.setPrimerApellido(resultadoConsulta.getString("Primer_Apellido"));
            lider.setSegundoApellido(resultadoConsulta.getString("Segundo_Apellido"));
            lider.setSalario(resultadoConsulta.getInt("Salario"));
            listaLideres.add(lider);
        }
        stmt.close();
        conexion.close();
        return listaLideres;
    }

    //******************************************************** */

    public ArrayList<Lider> consultarNombreModificado() throws SQLException {
        ArrayList<Lider> listaLideres= new ArrayList<Lider>();
        Connection conexion=JDBCUtilities.getConnection();
        
        String sqlConsulta= "select LOWER(SUBSTR(Nombre,1,1)) || UPPER(SUBSTR(Nombre,2,LENGTH(Nombre)))"
        +" as nombre_modificado from Lider";
        
       Statement stmt=conexion.createStatement();
       ResultSet resultadoConsulta=stmt.executeQuery(sqlConsulta);
        while(resultadoConsulta.next()){
            Lider lider= new Lider();
            lider.setNombre(resultadoConsulta.getString("nombre_modificado"));
            listaLideres.add(lider);
        }
        stmt.close();
        conexion.close();
        return listaLideres;
    }
}