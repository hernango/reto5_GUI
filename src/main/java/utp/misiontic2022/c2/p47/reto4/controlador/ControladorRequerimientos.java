package utp.misiontic2022.c2.p47.reto4.controlador;

import java.sql.SQLException;
import java.util.ArrayList;

import utp.misiontic2022.c2.p47.reto4.modelo.dao.ConsolidadorSalarioLideresDAO;
import utp.misiontic2022.c2.p47.reto4.modelo.dao.LiderDAO;
import utp.misiontic2022.c2.p47.reto4.modelo.vo.ConsolidadorLideresCiudadResidencia;
import utp.misiontic2022.c2.p47.reto4.modelo.vo.Lider;



public class ControladorRequerimientos {
    // Su código
    
    public ArrayList<Lider> consultarRequerimiento1() throws SQLException {
        LiderDAO daoLider = new LiderDAO();
        return daoLider.consultarPorSegundoApellido("Ortiz");
    }

    public ArrayList<Lider> consultarRequerimiento2() throws SQLException {
        LiderDAO daoLider = new LiderDAO();

        return daoLider.consultarNombreModificado();
    }

    public ArrayList<ConsolidadorLideresCiudadResidencia> consultarRequerimiento3() throws SQLException {
        ConsolidadorSalarioLideresDAO dao= new ConsolidadorSalarioLideresDAO();
        return dao.consultarSalariosConsolidadoCiudades();
        
    }
}
