package controlador;

import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.SeguimientoEstudiante;

public class ControladorSeguimientoEstudiante {

    private ResultSet resultado;
    String camposObligatorios;
    String camposInvalidos;
    boolean bandera;
    String[] respuesta;

    public boolean crearActualizar(Map datos, Object[] datosArchivos, int[] tamanioArchivos) {
        camposObligatorios = validarCamposObligatorios(datos);
        camposInvalidos = validarInformacion(datos);
        if (camposObligatorios.equals("") && camposInvalidos.equals("")) {

            SeguimientoEstudiante seguimientoEstudiante = new SeguimientoEstudiante();
            seguimientoEstudiante.setAccion((String) datos.get("accion"));
            seguimientoEstudiante.setId((String) datos.get("id"));
            seguimientoEstudiante.setIdPeriodo((String) datos.get("idPeriodo"));
            seguimientoEstudiante.setFechaInicio((String) datos.get("fechaInicio"));
            seguimientoEstudiante.setFechaFin((String) datos.get("fechaFin"));
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

        if (datos.get("fechaInicio").equals("")) {
            camposObligatorios += "\nSeleccione una fecha";
        }

        if (datos.get("fechaFin").equals("")) {
            camposObligatorios += "\nSeleccione una fecha";
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
