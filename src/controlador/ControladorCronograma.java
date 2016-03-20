package controlador;

import java.sql.ResultSet;
import java.util.Map;
import modelo.Cronograma;

public class ControladorCronograma {

    private ResultSet resultado;
    String camposObligatorios;
    String camposInvalidos;
    boolean bandera;
    String[] respuesta;
    
    /**
     *
     * @param datos
     * @param datosArchivos
     * @param tamanioArchivos
     */
    public boolean crearActualizar(Map datos) {
        camposObligatorios = validarCamposObligatorios(datos);
        if (camposObligatorios.equals("")) {

            Cronograma cronograma = new Cronograma();
            cronograma.setAccion((String) datos.get("accion"));
            cronograma.setId((String) datos.get("id"));
            cronograma.setIdPeriodo((String) datos.get("idPeriodo"));
            cronograma.setTarea((String) datos.get("tarea"));
            cronograma.setFechaInicio((String) datos.get("fechaInicio"));
            cronograma.setFechaFin((String) datos.get("fechaFin"));

            respuesta = cronograma.crearActualizar(cronograma);
            controladorMensaje.getInstance().getMsgGuardar(respuesta[1]);
            bandera = controladorVariablesSesion.getInstance().validarRespuestaDB(respuesta[2]);


        } else {
            controladorMensaje.getInstance().getMsgCamposObligatorios(camposObligatorios);
        }
         return bandera;

    }

    public void eliminar(Map datos) {

        Cronograma cronograma = new Cronograma();
        cronograma.setId((String) datos.get("id"));
        controladorMensaje.getInstance().getMsgEliminar(cronograma.eliminar(cronograma));

    }

    public String validarCamposObligatorios(Map datos) {
       camposObligatorios = "";
        if (datos.get("id").equals("")) {
            camposObligatorios += "\nFalta el id";

        }
        if (datos.get("idPeriodo").equals("-1")) {
            camposObligatorios += "\nSeleccione el período";

        }
        if (datos.get("tarea").equals("-1")) {
            camposObligatorios += "\nIngrese la tarea";

        }
        if (datos.get("fechaInicio").equals("")) {
            camposObligatorios += "\nSeleccione la fecha de inicio";

        }
        if (datos.get("fechaFin").equals("")) {
            camposObligatorios += "\nSeleccione la fecha de finalización";

        }
       
        return camposObligatorios;
    }

}
