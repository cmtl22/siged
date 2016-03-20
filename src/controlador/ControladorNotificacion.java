package controlador;

import java.util.Map;
import javax.swing.JOptionPane;
import modelo.Notificacion;
import modelo.Usuario;

public class ControladorNotificacion {

    // <editor-fold defaultstate="collapsed" desc="Declaracion de variables">    
    private String camposObligatorios;
    private String camposInvalidos;
    private boolean bandera;
    private String[] respuesta;
    // </editor-fold >    

    // <editor-fold defaultstate="collapsed" desc="Metodos">    
    public ControladorNotificacion() {
        this.bandera = false;
        this.respuesta = new String[3];
    }

    public boolean crearActualizar(Map datos) {
        camposObligatorios = validarCamposObligatorios(datos);
        if (camposObligatorios.equals("")) {
            Notificacion notificacion = new Notificacion();
            notificacion.setAccion((String) datos.get("accion"));
            notificacion.setId((String) datos.get("id"));
            notificacion.setReferencia((String) datos.get("referencia"));
            notificacion.setDescripcion((String) datos.get("descripcion"));
            notificacion.setTipo((String) datos.get("tipo"));

            respuesta = notificacion.crearActualizar(notificacion);

            controladorMensaje.getInstance().getMsgGuardar(respuesta[1]);
            bandera = controladorVariablesSesion.getInstance().validarRespuestaDB(respuesta[2]);
        } else {
            controladorMensaje.getInstance().getMsgCamposObligatorios(camposObligatorios);
        }
        return bandera;
    }

    public void eliminar(Map datos) {

        Notificacion notificacion = new Notificacion();
        notificacion.setId((String) datos.get("id"));
        controladorMensaje.getInstance().getMsgEliminar(notificacion.eliminar(notificacion));

    }
    
    public void quitar(Map datos) {

        Notificacion notificacion = new Notificacion();
        notificacion.setId((String) datos.get("id"));
        controladorMensaje.getInstance().getMsgEliminar(notificacion.eliminar(notificacion));

    }

    public String validarCamposObligatorios(Map datos) {
        camposObligatorios = "";

        return camposObligatorios;
    }

    // </editor-fold>    
}
