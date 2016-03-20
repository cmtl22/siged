
package controlador;

import java.sql.ResultSet;
import java.util.Map;
import modelo.Sucursal;
import modelo.Ubicacion;



public class ControladorSucursal {
    
    //<editor-fold defaultstate="collapsed" desc="Declaración de Variables">
    ResultSet resultado;
    String camposObligatorios;
    String camposInvalidos;
    boolean bandera;
    String[] respuesta;
    String[] referenciaSplit = new String[1];
//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Métodos">
    public ControladorSucursal() {
        this.bandera = false;
        this.respuesta = new String[3];
    }
    
    /**
     *
     * @param datos
     * @return
     */
    public boolean crearActualizar(Map datos) {
        camposObligatorios = validarCamposObligatorios(datos);
        
        if (camposObligatorios.equals("")) {
            //if (camposInvalidos.equals("")) {
            
            Sucursal sucursal = new Sucursal();
            Ubicacion ubic = new Ubicacion();
            
            sucursal.setAccion((String) datos.get("accion"));
            sucursal.setId((String) datos.get("id"));
            sucursal.setIdEmpresa((String) datos.get("idEmpresa"));
            sucursal.setIdUbicacion((String) datos.get("idUbicacion"));
            sucursal.setNombre((String) datos.get("nombreSucursal"));
            sucursal.setTipo((String) datos.get("idTipo"));
            ubic.setId("idUbicacion");
            ubic.setPais((String) datos.get("pais"));
            ubic.setProvincia((String) datos.get("provincia"));
            ubic.setCanton((String) datos.get("canton"));
            ubic.setCiudad((String) datos.get("ciudad"));
            ubic.setSector((String) datos.get("sector"));
            ubic.setReferencia((String) datos.get("referencia"));
            ubic.setCallePrincipal((String) datos.get("callePrincipal"));
            ubic.setCalleInterseccion((String) datos.get("calleInteresecion"));
            ubic.setNumero((String) datos.get("numero"));
            
            
            respuesta = sucursal.crearActualizar(sucursal, ubic);
            
            controladorMensaje.getInstance().getMsgGuardar(respuesta[1]);
            return bandera = controladorVariablesSesion.getInstance().validarRespuestaDB(respuesta[2]);
            //} else {
            //  controladorMensaje.getInstance().getMsgCamposInvalidos(camposInvalidos);
            // }
        } else {
            controladorMensaje.getInstance().getMsgCamposObligatorios(camposObligatorios);
        }
        return bandera;
    }
    
    public void eliminar(Map datos) {
        
        Sucursal sucursal = new Sucursal()  ;
        sucursal.setId((String) datos.get("id"));
        controladorMensaje.getInstance().getMsgEliminar(sucursal.eliminar(sucursal));
        
    }
    
    public String validarCamposObligatorios(Map datos) {
        camposObligatorios = "";
        if (datos.get("idEmpresa").equals("-1")) {
            camposObligatorios += "Seleccione la Empresa Matriz\n";
        }
        if (datos.get("nombreSucursal").equals("")) {
            camposObligatorios += "Ingrese el Nombre de la Sucursal\n";
        }
        if (datos.get("pais").equals("")) {
            camposObligatorios += "Ingrese un País\n";
        }
        if (datos.get("provincia").equals("")) {
            camposObligatorios += "Ingrese una Provincia\n";
        }
        if (datos.get("canton").equals("")) {
            camposObligatorios += "Ingrese un Cantón\n";
        }
        if (datos.get("ciudad").equals("")) {
            camposObligatorios += "Ingrese una Ciudad\n";
        }
        if (datos.get("sector").equals("")) {
            camposObligatorios += "Ingrese un Sector\n";
        }
        if (datos.get("referencia").equals("")) {
            camposObligatorios += "Ingrese un Lugar de Referencia\n";
        }
        if (datos.get("callePrincipal").equals("")) {
            camposObligatorios += "Ingrese la Calle Principal en Donde se Encuentra Ubicada las Sucursal\n";
        }
        if (datos.get("calleInteresecion").equals("")) {
            camposObligatorios += "Ingrese la Intersección en Donde se Encuentra Ubicada las Sucursal\n";
        }
        if (datos.get("numero").equals("")) {
            camposObligatorios += "Ingrese el Número del Edificio\n";
        }
        if (datos.get("idTipo").equals("-1")) {
            camposObligatorios += "Seleccione Matriz o Sucursal\n";
        }
        
        return camposObligatorios;
    }
//</editor-fold>
    

}