package controlador;

import java.util.Map;
import modelo.Viabilidad;

public class ControladorViabilidad {

    //<editor-fold defaultstate="collapsed" desc="Declaración de Varaiables">
    private String camposObligatorios;
    private String camposInvalidos;
    private boolean bandera;
    private String[] respuesta;
    private String[] referenciaSplit = new String[1];
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Métodos">
    public ControladorViabilidad() {
        this.bandera = false;
        this.respuesta = new String[3];
    }

    public boolean crearActualizar(Map datosViabilidad) {
        camposObligatorios = validarCamposObligatorios(datosViabilidad);
        if (camposObligatorios.equals("")) {

            Viabilidad viabilidad = new Viabilidad();
            viabilidad.setAccion((String) datosViabilidad.get("accion"));

            viabilidad.setId((String) datosViabilidad.get("id"));
            viabilidad.setEmprId((String) datosViabilidad.get("idEmpresa"));
            viabilidad.setNumeroInforme((String) datosViabilidad.get("numeroDeInforme"));
            viabilidad.setFechaInforme((String) datosViabilidad.get("fechaInforme"));
            viabilidad.setAsunto((String) datosViabilidad.get("asunto"));
            viabilidad.setConstatación((String) datosViabilidad.get("constatacion"));
            viabilidad.setDeudaSri((String) datosViabilidad.get("deudaSRI"));
            viabilidad.setDeudaIess((String) datosViabilidad.get("deudaIESS"));
            viabilidad.setDeudaSercop((String) datosViabilidad.get("deudaSERCOP"));
            viabilidad.setDeudaSupIntendencia((String) datosViabilidad.get("deudaSupIntendencia"));
            viabilidad.setObservacionesDeudas((String) datosViabilidad.get("observacionesDeudas"));
            viabilidad.setRecomendaciones((String) datosViabilidad.get("recomendaciones"));
            viabilidad.setFechaPrimerAcerc((String) datosViabilidad.get("fechaPrimerAcercamiento"));
            viabilidad.setDocuAcercamiento((String) datosViabilidad.get("documentAcercamiento"));
            viabilidad.setObservacionesInforme((String) datosViabilidad.get("observacionesInforme"));
            viabilidad.setNumEstudiantes((String) datosViabilidad.get("numeroEstudiantes"));
            viabilidad.setCantidadTutores((String) datosViabilidad.get("numeroTutores"));
            viabilidad.setPlazo((String) datosViabilidad.get("plazo"));
            viabilidad.setRenuevaConvenio((String) datosViabilidad.get("renuevaConvenio"));
            viabilidad.setObservacionesRenovacion((String) datosViabilidad.get("observacionesRenovacion"));
            viabilidad.setAdministradorInst((String) datosViabilidad.get("administradorInstiituto"));
            viabilidad.setAdministradorEmpr((String) datosViabilidad.get("administradorEmpresa"));
            viabilidad.setProcesoDesignacion((String) datosViabilidad.get("procesoDesignacion"));
            viabilidad.setUniformes((String) datosViabilidad.get("uniformes"));
            viabilidad.setEquipoProteccion((String) datosViabilidad.get("equipoProteccion"));
            viabilidad.setNormasSeguridad((String) datosViabilidad.get("normasSeguridad"));
            viabilidad.setObservacionesCondiciones((String) datosViabilidad.get("observacionesCondiciones"));
            viabilidad.setCompensacion((String) datosViabilidad.get("compensacion"));
            viabilidad.setCompensacionTipo((String) datosViabilidad.get("compensacionTipo"));
            viabilidad.setCompensacionCondiciones((String) datosViabilidad.get("compensacionCondiciones"));
            viabilidad.setElaborado((String) datosViabilidad.get("elaborado"));
            viabilidad.setRevisado((String) datosViabilidad.get("revisado"));
            viabilidad.setAprobado((String) datosViabilidad.get("aprobado"));
            viabilidad.setEstadoTramite((String) datosViabilidad.get("estadoTramite"));
            viabilidad.setIdCarrera((String) datosViabilidad.get("idCarrera"));

            respuesta = viabilidad.crearActualizar(viabilidad);

            controladorMensaje.getInstance().getMsgGuardar(respuesta[1]);
            return bandera = controladorVariablesSesion.getInstance().validarRespuestaDB(respuesta[2]);

        } else {
            controladorMensaje.getInstance().getMsgCamposObligatorios(camposObligatorios);
        }
        return bandera;
    }

    public void eliminar(Map datos) {

        Viabilidad viabilidad = new Viabilidad();
        viabilidad.setId((String) datos.get("id"));
        System.out.println("" + (String) datos.get("id"));
        controladorMensaje.getInstance().getMsgEliminar(viabilidad.eliminar(viabilidad));

    }

    public String validarCamposObligatorios(Map datosViabilidad) {
        camposObligatorios = "";
        if (datosViabilidad.get("idEmpresaSucursal").equals("-1") || datosViabilidad.get("fechaPrimerAcercamiento").equals("")) {
            camposObligatorios += "Seleccione una Empresa\n";
        }
        if (datosViabilidad.get("numeroDeInforme").equals("") || datosViabilidad.get("asunto").equals("")) {
            camposObligatorios += "Seleccione el Instituto que Entrará en el Convenio\n";
        }
        if (datosViabilidad.get("documentAcercamiento").equals("")) {
            camposObligatorios += "Ingrese los Documentos de Respaldo del Acercamiento\n";
        }
        if (datosViabilidad.get("administradorInstiituto").equals("")) {
            camposObligatorios += "Seleccione el Cargo del Administrador del Instituto\n";
        }
        if (datosViabilidad.get("administradorEmpresa").equals("")) {
            camposObligatorios += "Seleccione el Cargo del Administrador por Parte de la Empresa\n";
        }
        if (datosViabilidad.get("procesoDesignacion").equals("")) {
            camposObligatorios += "Ingrese el Proceso de Designación\n";
        }
        if (datosViabilidad.get("compensacionTipo").equals("")) {
            camposObligatorios += "Ingrese el Tipo de Compensación que Recibirá el Estudiante\n";
        }
        if (datosViabilidad.get("compensacionCondiciones").equals("")) {
            camposObligatorios += "Ingrese las Condiciones Acerca de  la Compensación del Estudiante\n";
        }
        if (datosViabilidad.get("elaborado").equals("")) {
            camposObligatorios += "Ingrese el Nombre de la Persona que Elaboró el Informe\n";
        }
        if (datosViabilidad.get("revisado").equals("")) {
            camposObligatorios += "Ingrese el Nombre de la Persona que Revisó el Informe\n";
        }
        if (datosViabilidad.get("aprobado").equals("")) {
            camposObligatorios += "Ingrese el Nombre de la Persona que Aprobó el Informe\n";
        }
        if (datosViabilidad.get("estadoTramite").equals("")) {
            camposObligatorios += "Seleccione el Estado en el que se Encuentra el Presente Informe  \n";
        }
        if (datosViabilidad.get("idCarrera").equals("")) {
            camposObligatorios += "idEmpresa\n";
        }

        return camposObligatorios;
    }
//</editor-fold>

}
