/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.sql.ResultSet;
import java.util.Map;
import modelo.Ubicacion;

public class ControladorUbicacion {

    //<editor-fold defaultstate="collapsed" desc="Declaración de Variables">
    ResultSet resultado;
    String camposObligatorios;
    String camposInvalidos;
    boolean bandera;
    String[] respuesta;
    String[] referenciaSplit = new String[1];
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Métodos">
    public ControladorUbicacion() {
        this.bandera = false;
        this.respuesta = new String[3];
    }
    
    public boolean crearActualizar(Map datos) {
        camposObligatorios = validarCamposObligatorios(datos);
        
        if (camposObligatorios.equals("")) {
            if (camposInvalidos.equals("")) {
                Ubicacion usuario = new Ubicacion();
                usuario.setAccion((String) datos.get("accion"));
                usuario.setId((String) datos.get("id"));
                usuario.setPais((String) datos.get("pais"));
                usuario.setProvincia((String) datos.get("provincia"));
                usuario.setCanton((String) datos.get("canton"));
                usuario.setCiudad((String) datos.get("ciudad"));
                usuario.setSector((String) datos.get("sector"));
                usuario.setReferencia((String) datos.get("referencia"));
                usuario.setCallePrincipal((String) datos.get("callePrincipal"));
                usuario.setCalleInterseccion((String) datos.get("calleInterseccion"));
                usuario.setNumero((String) datos.get("numero"));
                
                respuesta = usuario.crearActualizar(usuario);
                
                controladorMensaje.getInstance().getMsgGuardar(respuesta[1]);
                return bandera = controladorVariablesSesion.getInstance().validarRespuestaDB(respuesta[2]);
            } else {
                controladorMensaje.getInstance().getMsgCamposInvalidos(camposInvalidos);
            }
        } else {
            controladorMensaje.getInstance().getMsgCamposObligatorios(camposObligatorios);
        }
        return bandera;
    }
    
    public void eliminar(Map datos) {
        
        Ubicacion ubicacion = new Ubicacion();
        ubicacion.setId((String) datos.get("id"));
        controladorMensaje.getInstance().getMsgEliminar(ubicacion.eliminar(ubicacion));
        
    }
    
    public String validarCamposObligatorios(Map datos) {
        camposObligatorios = "";
        
        return camposObligatorios;
    }
//</editor-fold>
    
}
