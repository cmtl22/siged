/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.sql.ResultSet;
import java.util.Map;
import modelo.EscenarioViabilidad;

/**
 *
 * @author Usuario
 */
public class ControladorEscenarioViabilidad {

    //<editor-fold defaultstate="collapsed" desc="Declaración de Variables">
    private ResultSet resultado;
    private String camposObligatorios;
    private String camposInvalidos;
    private boolean bandera;
    private String[] respuesta;
    private String[] referenciaSplit = new String[1];
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Métodos">
    public ControladorEscenarioViabilidad() {
        this.bandera = false;
        this.respuesta = new String[3];
    }
    
    public boolean crearActualizar(Map datosEscenarioViabilidad) {
        camposObligatorios = validarCamposObligatorios(datosEscenarioViabilidad);
        if (camposObligatorios.equals("")) {
            /*if (validarInformacion(datosViabilidad).equals("")) {*/
            EscenarioViabilidad escViabilidad = new EscenarioViabilidad();
            escViabilidad.setAccion((String) datosEscenarioViabilidad.get("accion"));
            
            escViabilidad.setId((String) datosEscenarioViabilidad.get("id"));
            escViabilidad.setIdViabilidad((String) datosEscenarioViabilidad.get("idViabilidad"));
            escViabilidad.setTipo((String) datosEscenarioViabilidad.get("tipo"));
            escViabilidad.setNumeroEstudiantes((String) datosEscenarioViabilidad.get("numeroEstudiantes"));
            escViabilidad.setObservaciones((String) datosEscenarioViabilidad.get("observaciones"));
            escViabilidad.setActividades((String) datosEscenarioViabilidad.get("actividades"));
            escViabilidad.setEquipamiento((String) datosEscenarioViabilidad.get("equipamiento"));
            
            respuesta = escViabilidad.crearActualizar(escViabilidad);
            
            controladorMensaje.getInstance().getMsgGuardar(respuesta[1]);
            return bandera = controladorVariablesSesion.getInstance().validarRespuestaDB(respuesta[2]);
            /*} else {
            controladorMensaje.getInstance().getMsgCamposInvalidos(camposInvalidos);
            }*/
        } else {
            controladorMensaje.getInstance().getMsgCamposObligatorios(camposObligatorios);
        }
        return bandera;
    }
    
    public void eliminar(Map datos) {
        
        EscenarioViabilidad escViabilidad = new EscenarioViabilidad();
        escViabilidad.setId((String) datos.get("id"));
        controladorMensaje.getInstance().getMsgEliminar(escViabilidad.eliminar(escViabilidad));
        
    }
    
    public String validarCamposObligatorios(Map datosEscenariosViabilidad) {
        camposObligatorios = "";
        
        if (datosEscenariosViabilidad.get("idViabilidad").equals("-1")) {
            camposObligatorios += "Seleccione el Informe de Viabilidad\n";
        }
        if (datosEscenariosViabilidad.get("tipo").equals("-1")) {
            camposObligatorios += "Seleccione el Tipo\n";
        }
        if (datosEscenariosViabilidad.get("numeroEstudiantes").equals("")) {
            camposObligatorios += "Ingrese el Número de Estudiantes\n";
        }
        if (datosEscenariosViabilidad.get("actividades").equals("")) {
            camposObligatorios += "Ingrese una Descripción de las Actividades que se Realizan en éste Escenario\n";
        }
        if (datosEscenariosViabilidad.get("equipamiento").equals("")) {
            camposObligatorios += "Ingrese la Descripción del Equipamiento que se Proveera al Estudiante\n";
        }
        
        return camposObligatorios;
    }
//</editor-fold>
}
