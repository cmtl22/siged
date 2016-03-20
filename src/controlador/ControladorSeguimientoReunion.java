package controlador;

import java.sql.ResultSet;
import java.util.Map;
import modelo.SeguimientoReunion;

public class ControladorSeguimientoReunion {

    private ResultSet resultado;
    String camposObligatorios;
    String camposInvalidos;
    boolean bandera;
    String[] respuesta;

    public boolean crearActualizar(Map datos, Object[] datosArchivos, int[] tamanioArchivos) {
        camposObligatorios = validarCamposObligatorios(datos);
        if (camposObligatorios.equals("")) {

            SeguimientoReunion seguimientoReunion = new SeguimientoReunion();
            seguimientoReunion.setAccion((String) datos.get("accion"));
            seguimientoReunion.setId((String) datos.get("id"));
            seguimientoReunion.setIdPeriodo((String) datos.get("idPeriodo"));
            seguimientoReunion.setIdTutorEmpresarial((String) datos.get("idTutorEmpresarial"));
            seguimientoReunion.setParticipante((String) datos.get("participante"));
            seguimientoReunion.setFechaReunion((String) datos.get("fechaReunion"));
            seguimientoReunion.setMotivo((String) datos.get("motivoReunion"));
            seguimientoReunion.setObservacion((String) datos.get("observaciones"));

            respuesta = seguimientoReunion.crearActualizar(seguimientoReunion);

            controladorMensaje.getInstance().getMsgGuardar(respuesta[1]);
            bandera = controladorVariablesSesion.getInstance().validarRespuestaDB(respuesta[2]);
        } else {
            controladorMensaje.getInstance().getMsgCamposObligatorios(camposObligatorios);
        }
        return bandera;
    }

    public void eliminar(Map datos) {

        SeguimientoReunion seguimientoReunion = new SeguimientoReunion();
        seguimientoReunion.setId((String) datos.get("id"));
        controladorMensaje.getInstance().getMsgEliminar(seguimientoReunion.eliminar(seguimientoReunion));

    }

    public String validarCamposObligatorios(Map datos) {
       camposObligatorios = "";
        if (datos.get("id").equals("")) {
            camposObligatorios += "\nFalta el id";

        }
        if (datos.get("idPeriodo").equals("-1")) {
            camposObligatorios += "\nSeleccione un período";

        }
        if (datos.get("idTutorEmpresarial").equals("-1")) {
            camposObligatorios += "\nSeleccione un tutor empresarial";

        }
        if (datos.get("participante").equals("")) {
            camposObligatorios += "\nIngrese el nombre del participante";

        }
        if (datos.get("fechaReunion").equals("")) {
            camposObligatorios += "\nSeleccione una fecha";

        }
        if (datos.get("motivoReunion").equals("")) {
            camposObligatorios += "\nIngrese el motivo de la reunión";

        }

        return camposObligatorios;
    }

}
