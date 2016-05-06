package controlador;

import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.Carrera;

public class ControladorCarrera {

    private ResultSet resultado;
    String camposObligatorios;
    String camposInvalidos;
    boolean bandera;
    String[] respuesta;

    public ControladorCarrera() {
        this.bandera = false;
        this.respuesta = new String[3];
    }

    public boolean crearActualizar(Map datos) {
        camposObligatorios = validarCamposObligatorios(datos);
        camposInvalidos = validarInformacion(datos);
        if (camposObligatorios.equals("") && camposInvalidos.equals("")) {

            Carrera carrera = new Carrera();
            carrera.setAccion((String) datos.get("accion"));
            carrera.setId((String) datos.get("id"));
            carrera.setIdInstituto((String) datos.get("idInstituto"));
            carrera.setIdPersona((String) datos.get("idPersona"));
            carrera.setNombre((String) datos.get("nombre"));
            carrera.setDescripcion((String) datos.get("descripcion"));
            carrera.setFecha((String) datos.get("fecha"));
            carrera.setNumeroResolucion((String) datos.get("numeroResolucion"));

            respuesta = carrera.crearActualizar(carrera);
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

        Carrera carrera = new Carrera();
        carrera.setId((String) datos.get("id"));
        controladorMensaje.getInstance().getMsgEliminar(carrera.eliminar(carrera));

    }

    public String validarCamposObligatorios(Map datos) {
        camposObligatorios = "";
        if (datos.get("id").equals("")) {
            camposObligatorios += "\nFalta el id";

        }
        if (datos.get("idInstituto").equals("-1")) {
            camposObligatorios += "\nSeleccione un instituto";

        }
        if (datos.get("idPersona").equals("-1")) {
            camposObligatorios += "\nSeleccione un coordinador";

        }
        if (datos.get("nombre").equals("")) {
            camposObligatorios += "\nIngrese el nombre de la carrera";

        }
        if (datos.get("descripcion").equals("")) {
            camposObligatorios += "\nIngrese la descripción de la carrera";

        }
        if (datos.get("fecha").equals("2016-04-05")) {
            camposObligatorios += "\nSeleccione una fecha";

        }
        if (datos.get("numeroResolucion").equals("")) {
            camposObligatorios += "\nIngrese el número de resolución";

        }

        return camposObligatorios;
    }

    private String validarInformacion(Map datos) {

        camposInvalidos = "";
        if (!(validarFecha((String) datos.get("fecha")))) {
            camposInvalidos += "La fecha de aprobación debe ser menor\n";
        }

        return camposInvalidos;
    }

    private boolean validarFecha(String strFecha) {
        try {
            Calendar calFechaActual = new GregorianCalendar();
            Calendar calFecha = new GregorianCalendar();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            calFecha.setTime(sdf.parse(strFecha));

            return calFechaActual.after(calFecha);

        } catch (ParseException ex) {
            Logger.getLogger(ControladorPersona.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

}
