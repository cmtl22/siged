package controlador;

import java.sql.ResultSet;
import java.util.Map;
import modelo.Asignatura;

public class ControladorAsignatura {

    private ResultSet resultado;
    String camposObligatorios;
    String camposInvalidos;
    boolean bandera;
    String[] respuesta;

    public ControladorAsignatura() {
        this.bandera = false;
        this.respuesta = new String[3];
    }

    public boolean crearActualizar(Map datos) {
        camposObligatorios = validarCamposObligatorios(datos);
        if (camposObligatorios.equals("")) {
            Asignatura asignatura = new Asignatura();//instanaciar la clase que esta en el modelo 
            asignatura.setAccion((String) datos.get("accion"));
            asignatura.setId((String) datos.get("id"));
            asignatura.setIdCarrera((String) datos.get("idCarrera"));
            asignatura.setNombre((String) datos.get("nombre"));
            asignatura.setResultadoAprendizaje((String) datos.get("resultadoAprendizaje"));
            asignatura.setEquipamiento((String) datos.get("equipamiento"));
            asignatura.setSimilitud((String) datos.get("similitud"));

            respuesta = asignatura.crearActualizar(asignatura);
            controladorMensaje.getInstance().getMsgGuardar(respuesta[1]);
            bandera = controladorVariablesSesion.getInstance().validarRespuestaDB(respuesta[2]);

        } else {
            controladorMensaje.getInstance().getMsgCamposObligatorios(camposObligatorios);
        }
        return bandera;
    }

    public void eliminar(Map datos) {

        Asignatura asignatura = new Asignatura();
        asignatura.setId((String) datos.get("id"));
        controladorMensaje.getInstance().getMsgEliminar(asignatura.eliminar(asignatura));

    }

    public String validarCamposObligatorios(Map datos) {
         camposObligatorios = "";
        if (datos.get("id").equals("")) {
            camposObligatorios += "\nFalta el id";

        }
        if (datos.get("idCarrera").equals("-1")) {
            camposObligatorios += "\nSeleccione una carrera";

        }
        if (datos.get("nombre").equals("")) {
            camposObligatorios += "\nIngrese el nombre de la asignatura";

        }
        if (datos.get("resultadoAprendizaje").equals("")) {
            camposObligatorios += "\nIngrese el resultado del aprendizaje";

        }
        if (datos.get("equipamiento").equals("")) {
            camposObligatorios += "\nSeleccione el equipamiento";

        }
        if (datos.get("similitud").equals("")) {
            camposObligatorios += "\nSeleccione la similitud";

        }
                
        return camposObligatorios;
    }

}