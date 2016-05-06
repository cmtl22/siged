package controlador;

import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
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
     * @return
     */
    public boolean crearActualizar(Map datos) {
        camposObligatorios = validarCamposObligatorios(datos);
        camposInvalidos = validarInformacion(datos);
        if (camposObligatorios.equals("") && camposInvalidos.equals("")) {

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
            if (!camposObligatorios.equals("")) {
                controladorMensaje.getInstance().getMsgCamposObligatorios(camposObligatorios);
            }
            if (!camposInvalidos.equals("")) {
                controladorMensaje.getInstance().getMsgCamposInvalidos(camposInvalidos);
            }
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

    private String validarInformacion(Map datosPersona) {

        camposInvalidos = "";
        if (validarFechas((String) datosPersona.get("fechaInicio"), (String) datosPersona.get("fechaFin")) < 0) {
            camposInvalidos += "Fechas incorrectas\n";

        }
        return camposInvalidos;
    }

    private int validarFechas(String strFechaInicio, String strFechaFin) {
        try {
            Calendar calFechaInicio = new GregorianCalendar();
            Calendar calFechaFin = new GregorianCalendar();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

            calFechaInicio.setTime(sdf.parse(strFechaInicio));
            calFechaFin.setTime(sdf.parse(strFechaFin));

            return calFechaFin.compareTo(calFechaInicio);

        } catch (ParseException ex) {
            Logger.getLogger(ControladorPersona.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 1;
    }
}
