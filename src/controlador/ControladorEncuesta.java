package controlador;

import java.sql.ResultSet;
import java.util.Map;
import modelo.Encuesta;

public class ControladorEncuesta {

    ResultSet resultado;
    String camposObligatorios;
    String camposInvalidos;
    boolean bandera;
    String[] respuesta;

    public ControladorEncuesta() {
        this.bandera = false;
        this.respuesta = new String[3];
    }

    public boolean crearActualizar(Map datos) {
        camposObligatorios = validarCamposObligatorios(datos);
         if (camposObligatorios.equals("")) {
            
                Encuesta encuesta = new Encuesta();
                encuesta.setAccion((String) datos.get("accion"));
                encuesta.setId((String) datos.get("id"));
                encuesta.setIdPeriodo((String) datos.get("idPeriodo"));
                encuesta.setObservaciones((String) datos.get("observaciones"));

                respuesta = encuesta.crearActualizar(encuesta);
            controladorMensaje.getInstance().getMsgGuardar(respuesta[1]);
            bandera = controladorVariablesSesion.getInstance().validarRespuestaDB(respuesta[2]);

        } else {
            controladorMensaje.getInstance().getMsgCamposObligatorios(camposObligatorios);
        }
        return bandera;
    }

    public void eliminar(Map datos) {

        Encuesta encuesta = new Encuesta();
        encuesta.setId((String) datos.get("id"));
        controladorMensaje.getInstance().getMsgEliminar(encuesta.eliminar(encuesta));

    }

    public String validarCamposObligatorios(Map datos) {
        camposObligatorios = "";
        if (datos.get("id").equals("")) {
            camposObligatorios += "\nFalta el id";

        }
        if (datos.get("idPeriodo").equals("-1")) {
            camposObligatorios += "\nSeleccione un período";

        }
        if (datos.get("observaciones").equals("")) {
            camposObligatorios += "\nIngrese una observación";

        }
        
        return camposObligatorios;
    }

}

