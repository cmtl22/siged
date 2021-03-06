/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Convenio;


public class ControladorConvenio {
    
   // <editor-fold defaultstate="collapsed" desc="Declaración de Variables"> 
    private ResultSet resultado;
    private String camposObligatorios;
    private String camposInvalidos;
    private boolean bandera;
    private String[] respuesta;
    private String[] referenciaSplit = new String[1];
    // </editor-fold>
   
   // <editor-fold defaultstate="collapsed" desc="Metodos"> 
    
    public ControladorConvenio() {
        this.bandera = false;
        this.respuesta = new String[3];
    }
    
    public boolean crearActualizar(Map datosConvenio) {
        
        camposObligatorios = validarCamposObligatorios(datosConvenio);
        camposInvalidos = validarInformacion(datosConvenio);
        if (camposObligatorios.equals("") && camposInvalidos.equals("")) {
       
        Convenio convenio = new Convenio(); 

        convenio.setAccion((String) datosConvenio.get("accion"));
        convenio.setId((String) datosConvenio.get("id"));
        convenio.setIdViabilidad((String) datosConvenio.get("idViabilidad"));
        convenio.setNumero((String) datosConvenio.get("numeroConvenio"));
        convenio.setFechaFin((String) datosConvenio.get("fechaFin"));
        convenio.setFechaSuscripcion((String) datosConvenio.get("fechaSuscripcion"));
        convenio.setObservaciones((String) datosConvenio.get("observaciones"));
        convenio.setAdmEmpresaPrincipal((String) datosConvenio.get("admEmpresaPrincipal"));
        convenio.setAdmEmpresaSuplente((String) datosConvenio.get("admEmpresaSuplente"));
        convenio.setAdmInstitutoPrincipal((String) datosConvenio.get("admInstitutoPrincipal"));
        convenio.setAdmInstitutoSuplente((String) datosConvenio.get("admInstitutoSuplente"));

        respuesta = convenio.crearActualizar(convenio);

        controladorMensaje.getInstance().getMsgGuardar(respuesta[1]);
        return bandera = controladorVariablesSesion.getInstance().validarRespuestaDB(respuesta[2]);
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

        Convenio convenio = new Convenio();
        convenio.setId((String) datos.get("id"));
        controladorMensaje.getInstance().getMsgEliminar(convenio.eliminar(convenio));

    }

    public String validarCamposObligatorios(Map datosConvenio) {
        camposObligatorios = "";
        if (datosConvenio.get("idViabilidad").equals("-1")) {
            camposObligatorios += "Seleccione la Viabilidad\n";
        }
        if (datosConvenio.get("numeroConvenio").equals("")) {
            camposObligatorios += "Ingrese el Número del convenio\n";
        }
        if (datosConvenio.get("fechaFin").equals("")) {
            camposObligatorios += "Seleccione la Fecha de Finalización del Convenio\n";
        }
        if (datosConvenio.get("fechaSuscripcion").equals("")) {
            camposObligatorios += "Seleccione la Fecha de Susucripción del Convenio\n";
        }
        if (datosConvenio.get("admEmpresaPrincipal").equals("")) {
            camposObligatorios += "Ingrese el Administrador Principal por la Empresa\n";
        }
        if (datosConvenio.get("admEmpresaSuplente").equals("")) {
            camposObligatorios += "Ingrese el Administrador Suplente por la Empresa\n";
        }
        if (datosConvenio.get("admInstitutoPrincipal").equals("")) {
            camposObligatorios += "Ingrese el Administrador Principal por el Instituto\n";
        }
        if (datosConvenio.get("admInstitutoSuplente").equals("")) {
            camposObligatorios += "Ingrese el Administrador Suplente por el Instituto\n";
        }
        
        return camposObligatorios;
    }
    private String validarInformacion(Map datos) {

        camposInvalidos = "";
        if (validarFechas((String) datos.get("fechaSuscripcion"), (String) datos.get("fechaFin")) < 0) {
            camposInvalidos += "Fechas incorrectas\n";

        }
        return camposInvalidos;
    }

    private int validarFechas(String strFechaSuscripcion, String strFechaFin) {
        try {
            Calendar calFechaSuscripcion = new GregorianCalendar();
            Calendar calFechaFin = new GregorianCalendar();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

            calFechaSuscripcion.setTime(sdf.parse(strFechaSuscripcion));
            calFechaFin.setTime(sdf.parse(strFechaFin));

            return calFechaFin.compareTo(calFechaSuscripcion);

        } catch (ParseException ex) {
            Logger.getLogger(ControladorPersona.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 1;
    }
    // </editor-fold>
    
}
