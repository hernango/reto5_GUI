package utp.misiontic2022.c2.p47.reto4.modelo.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import utp.misiontic2022.c2.p47.reto4.modelo.vo.ConsolidadorLideresCiudadResidencia;
import utp.misiontic2022.c2.p47.reto4.util.JDBCUtilities;

public class ConsolidadorSalarioLideresDAO {

    public ArrayList<ConsolidadorLideresCiudadResidencia> consultarSalariosConsolidadoCiudades() throws SQLException {
        
            ArrayList<ConsolidadorLideresCiudadResidencia> listaSalariosConsolidados = new ArrayList<ConsolidadorLideresCiudadResidencia>();
            Connection conexion=JDBCUtilities.getConnection();
            
            String sqlConsulta= "select ciudad_residencia, sum(Salario) as suma from Lider"
            +" group by ciudad_residencia";
           Statement stmt=conexion.createStatement();
           ResultSet resultadoConsulta=stmt.executeQuery(sqlConsulta);
            while(resultadoConsulta.next()){
                ConsolidadorLideresCiudadResidencia consolidadoLideresCiudades= new ConsolidadorLideresCiudadResidencia();
                consolidadoLideresCiudades.setCiudadResidencia(resultadoConsulta.getString("ciudad_residencia"));
                consolidadoLideresCiudades.setSalarios(resultadoConsulta.getLong("suma"));
                listaSalariosConsolidados.add(consolidadoLideresCiudades);
            }
            stmt.close();
            conexion.close();
            return listaSalariosConsolidados;
        }
    }
