package controlador;

import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Periodo;

public class ControladorPeriodo {

    String camposObligatorios;
    String camposInvalidos;
    boolean bandera;
    String[] respuesta;

    public boolean abrirPeriodo(Map datos) {
        camposObligatorios = validarCamposObligatorios(datos);
        if (camposObligatorios.equals("")) {
            Periodo periodo = new Periodo();
            periodo.setId((String) datos.get("id"));

            respuesta = periodo.abrirPeriodo(periodo);
            controladorMensaje.getInstance().getMsgGuardar(respuesta[1]);
        } else {
            controladorMensaje.getInstance().getMsgCamposObligatorios(camposObligatorios);
        }
        return bandera = controladorVariablesSesion.getInstance().validarRespuestaDB(respuesta[2]);

    }

    public boolean crearActualizar(Map datos) {
        camposObligatorios = validarCamposObligatorios(datos);
        camposInvalidos = validarInformacion(datos);
        if (camposObligatorios.equals("") && camposInvalidos.equals("")) {
            Periodo periodo = new Periodo();
            periodo.setAccion((String) datos.get("accion"));
            System.out.println((String) datos.get("accion"));
            periodo.setId((String) datos.get("id"));
            System.out.println("" + (String) datos.get("id"));
            periodo.setNombre((String) datos.get("nombre"));
            periodo.setFechaInicio((String) datos.get("fechaInicio"));
            periodo.setFechaFin((String) datos.get("fechaFin"));

            respuesta = periodo.crearActualizar(periodo);

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

        Periodo periodo = new Periodo();
        periodo.setId((String) datos.get("id"));
        controladorMensaje.getInstance().getMsgEliminar(periodo.eliminar(periodo));

    }

    public String validarCamposObligatorios(Map datos) {
        camposObligatorios = "";
        if (datos.get("id").equals("")) {
            camposObligatorios += "\nFalta el id";

        }
        if (datos.get("nombre").equals("")) {
            camposObligatorios += "\nIngrese el período";

        }
        if (datos.get("fechaInicio").equals("")) {
            camposObligatorios += "\nSeleccione una fecha de inicio";

        }
        if (datos.get("fechaFin").equals("-1")) {
            camposObligatorios += "\nSeleccione una fecha de finalización";

        }

        return camposObligatorios;
    }

    private String validarInformacion(Map datos) {

        camposInvalidos = "";
        if (validarFechas((String) datos.get("fechaInicio"), (String) datos.get("fechaFin")) < 0) {
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
