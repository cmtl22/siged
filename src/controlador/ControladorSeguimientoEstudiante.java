package controlador;

import java.sql.ResultSet;
import java.util.Map;
import modelo.SeguimientoEstudiante;

public class ControladorSeguimientoEstudiante {

    private ResultSet resultado;
    String camposObligatorios;
    String camposInvalidos;
    boolean bandera;
    String[] respuesta;

    public boolean crearActualizar(Map datos, Object[] datosArchivos, int[] tamanioArchivos) {
        camposObligatorios = validarCamposObligatorios(datos);
        if (camposObligatorios.equals("")) {

            SeguimientoEstudiante seguimientoEstudiante = new SeguimientoEstudiante();
            seguimientoEstudiante.setAccion((String) datos.get("accion"));
            seguimientoEstudiante.setId((String) datos.get("id"));
            seguimientoEstudiante.setIdPeriodo((String) datos.get("idPeriodo"));
            seguimientoEstudiante.setIdEstudiante((String) datos.get("idEstudiante"));
            seguimientoEstudiante.setIdTutorEmpresarial((String) datos.get("idTutorEmpresarial"));
            seguimientoEstudiante.setIdTutorAcademico((String) datos.get("idTutorAcademico"));
            seguimientoEstudiante.setIdEmpresaSucursal((String) datos.get("idEmpresaSucursal"));
            seguimientoEstudiante.setIdNivel((String) datos.get("idNivel"));
            seguimientoEstudiante.setNotaInstituto((String) datos.get("notaInstituto"));
            seguimientoEstudiante.setNotaEmpresa((String) datos.get("notaEmpresa"));

            respuesta = seguimientoEstudiante.crearActualizar(seguimientoEstudiante);

            controladorMensaje.getInstance().getMsgGuardar(respuesta[1]);
            bandera = controladorVariablesSesion.getInstance().validarRespuestaDB(respuesta[2]);
        } else {
            controladorMensaje.getInstance().getMsgCamposObligatorios(camposObligatorios);
        }
        return bandera;
    }

    public void eliminar(Map datos) {

        SeguimientoEstudiante seguimientoEstudiante = new SeguimientoEstudiante();
        seguimientoEstudiante.setId((String) datos.get("id"));
        controladorMensaje.getInstance().getMsgEliminar(seguimientoEstudiante.eliminar(seguimientoEstudiante));

    }

    public String validarCamposObligatorios(Map datos) {
         camposObligatorios = "";
        if (datos.get("id").equals("")) {
            camposObligatorios += "\nFalta el id";

        }
        if (datos.get("idPeriodo").equals("-1")) {
            camposObligatorios += "\nSeleccione el período";

        }
        if (datos.get("idEstudiante").equals("-1")) {
            camposObligatorios += "\nSeleccione el estudiante";

        }
        if (datos.get("idTutorEmpresarial").equals("-1")) {
            camposObligatorios += "\nSeleccione el tutor empresarial";

        }
        if (datos.get("idTutorAcademico").equals("-1")) {
            camposObligatorios += "\nSeleccione el tutor académico";

        }
        if (datos.get("idEmpresaSucursal").equals("-1")) {
            camposObligatorios += "\nSeleccione una empresa";

        }
        if (datos.get("idNivel").equals("-1")) {
            camposObligatorios += "\nSeleccione un nivel";

        }
        if (datos.get("notaInstituto").equals("")) {
            camposObligatorios += "\nIngrese la nota del instituto";

        }
        if (datos.get("notaEmpresa").equals("")) {
            camposObligatorios += "\nIngrese la nota de la empresa";

        }
        return camposObligatorios;
    }

}
