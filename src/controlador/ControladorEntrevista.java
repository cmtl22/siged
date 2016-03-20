package controlador;

import java.sql.ResultSet;
import java.util.Map;
import modelo.Entrevista;

public class ControladorEntrevista {

    ResultSet resultado;
    String camposObligatorios;
    String camposInvalidos;
    boolean bandera;
    String[] respuesta;

    public ControladorEntrevista() {
        this.bandera = false;
        this.respuesta = new String[3];
    }

    public boolean crearActualizar(Map datos) {
        camposObligatorios = validarCamposObligatorios(datos);
        camposInvalidos = validarDatos(datos);
        if (camposObligatorios.equals("")) {
            if (camposInvalidos.equals("")) {
                Entrevista entrevista = new Entrevista();
                entrevista.setAccion((String) datos.get("accion"));
                entrevista.setId((String) datos.get("id"));
                entrevista.setIdEmpresaSucursal((String) datos.get("idEmpresaSucursal"));
                entrevista.setIdEstudiante((String) datos.get("idEstudiante"));
                entrevista.setIdPeriodo((String) datos.get("idPeriodo"));
                entrevista.setIdEstado((String) datos.get("idEstadoEntrevista"));
                entrevista.setIdNivel((String) datos.get("idNivel"));
                entrevista.setObservaciones((String) datos.get("observaciones"));
                entrevista.setFecha((String) datos.get("fecha"));

                respuesta = entrevista.crearActualizar(entrevista);

                controladorMensaje.getInstance().getMsgGuardar(respuesta[1]);
                bandera = controladorVariablesSesion.getInstance().validarRespuestaDB(respuesta[2]);
            } else {
                controladorMensaje.getInstance().getMsgCamposInvalidos(camposInvalidos);
            }
        } else {
            controladorMensaje.getInstance().getMsgCamposObligatorios(camposObligatorios);
        }
        return bandera;
    }

    public void eliminar(Map datos) {

        Entrevista entrevista = new Entrevista();
        entrevista.setId((String) datos.get("id"));
        controladorMensaje.getInstance().getMsgEliminar(entrevista.eliminar(entrevista));

    }

    public String validarCamposObligatorios(Map datos) {
        camposObligatorios = "";

        return camposObligatorios;
    }

    public String validarDatos(Map datos) {
        camposObligatorios = "";
        if (datos.get("id").equals("")) {
            camposObligatorios += "\nFalta el id";

        }
        if (datos.get("idEmpresaSucursal").equals("-1")) {
            camposObligatorios += "\nSeleccione una empresa";

        }
        if (datos.get("idEstudiante").equals("-1")) {
            camposObligatorios += "\nSeleccione un estudiante";

        }
        if (datos.get("idPeriodo").equals("-1")) {
            camposObligatorios += "\nSeleccione un período";

        }
        if (datos.get("idEstadoEntrevista").equals("-1")) {
            camposObligatorios += "\nSeleccione un estado";
            
        }
        if (datos.get("fecha").equals("")) {
            camposObligatorios += "\nSeleccione una fecha";

        }
        if (datos.get("idNivel").equals("-1")) {
            camposObligatorios += "\nSeleccione un nivel";

        }
        

        return camposObligatorios;
    }

}
