package controlador;

import java.sql.ResultSet;
import java.util.Map;
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
        if (camposObligatorios.equals("")) {

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
            controladorMensaje.getInstance().getMsgCamposObligatorios(camposObligatorios);
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

}
