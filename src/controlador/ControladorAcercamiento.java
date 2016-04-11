package controlador;

import java.sql.ResultSet;
import java.util.Map;
import modelo.Acercamiento;

public class ControladorAcercamiento {

    private ResultSet resultado;
    String camposObligatorios;
    String camposInvalidos;
    boolean bandera;
    String[] respuesta;

    public ControladorAcercamiento() {
        this.bandera = false;
        this.respuesta = new String[3];
    }

    public boolean crearActualizar(Map datos) {
        camposObligatorios = validarCamposObligatorios(datos);
        if (camposObligatorios.equals("")) {

            Acercamiento acercamiento = new Acercamiento();//instanaciar la clase que esta en el modelo 
            acercamiento.setAccion((String) datos.get("accion"));
            acercamiento.setId((String) datos.get("id"));
            acercamiento.setIdEmpresaSucursal((String) datos.get("idEmpresaSucursal"));
            acercamiento.setFecha((String) datos.get("fecha"));
            acercamiento.setObservaciones((String) datos.get("observaciones"));
            acercamiento.setIdEstadoAcercamiento((String) datos.get("estadoAcercamiento"));

            respuesta = acercamiento.crearActualizar(acercamiento);

            controladorMensaje.getInstance().getMsgGuardar(respuesta[1]);
            bandera = controladorVariablesSesion.getInstance().validarRespuestaDB(respuesta[2]);

        } else {
            controladorMensaje.getInstance().getMsgCamposObligatorios(camposObligatorios);
        }
        return bandera;

    }

    public void eliminar(Map datos) {

        Acercamiento acercamiento = new Acercamiento();
        acercamiento.setId((String) datos.get("id"));
        controladorMensaje.getInstance().getMsgEliminar(acercamiento.eliminar(acercamiento));

    }

    public String validarCamposObligatorios(Map datos) {
        camposObligatorios = "";
        if (datos.get("id").equals("")) {
            camposObligatorios += "\nFalta el id";

        }
        if (datos.get("idEmpresaSucursal").equals("-1")) {
            camposObligatorios += "\nSeleccione una empresa";

        }
        if (datos.get("fecha").equals("")) {
            camposObligatorios += "\nSeleccione una fecha";

        }
        if (datos.get("estadoAcercamiento").equals("-1")) {
            camposObligatorios += "\nSeleccione un estado";

        }

        return camposObligatorios;
    }

}
