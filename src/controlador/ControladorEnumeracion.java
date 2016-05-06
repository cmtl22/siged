package controlador;

import java.sql.ResultSet;
import java.util.Map;
import modelo.Enumeracion;

public class ControladorEnumeracion {

    ResultSet resultado;
    String camposObligatorios;
    String camposInvalidos;
    boolean bandera;

    String[] respuesta;

    public ControladorEnumeracion() {
        this.bandera = false;
        this.respuesta = new String[3];
    }

    /**
     *
     * @param datos
     */
    public boolean crearActualizar(Map datos) {
        camposObligatorios = validarCamposObligatorios(datos);
        if (camposObligatorios.equals("")) {
            Enumeracion enumeracion = new Enumeracion();
            enumeracion.setAccion((String) datos.get("accion"));
            enumeracion.setId((String) datos.get("id"));
            enumeracion.setNombre((String) datos.get("nombre"));
            enumeracion.setTipo((String) datos.get("tipo"));
            enumeracion.setCodigo((String) datos.get("codigo"));
            enumeracion.setDescripcion((String) datos.get("descripcion"));

            respuesta = enumeracion.crearActualizar(enumeracion);

            controladorMensaje.getInstance().getMsgGuardar(respuesta[1]);
            bandera = controladorVariablesSesion.getInstance().validarRespuestaDB(respuesta[2]);

        } else {
            controladorMensaje.getInstance().getMsgCamposObligatorios(camposObligatorios);
        }
        return bandera;
    }

    public void eliminar(Map datos) {

        Enumeracion enumeracion = new Enumeracion();
        enumeracion.setId((String) datos.get("id"));
        controladorMensaje.getInstance().getMsgEliminar(enumeracion.eliminar(enumeracion));

    }

    public String validarCamposObligatorios(Map datos) {
        camposObligatorios = "";
        if (datos.get("nombre").equals("")) {
            camposObligatorios += "Nombre\n";
        }
        if (datos.get("codigo").equals("")) {
            camposObligatorios += "Valor\n";
        }

        return camposObligatorios;
    }
}
