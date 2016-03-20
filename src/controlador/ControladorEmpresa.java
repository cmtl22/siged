package controlador;

import java.sql.ResultSet;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import modelo.Empresa;

public class ControladorEmpresa {

    //<editor-fold defaultstate="collapsed" desc="Declaración de Variables">
    private ResultSet resultado;
    private String camposObligatorios;
    private String camposInvalidos;
    private boolean bandera;
    private String[] respuesta;
    private String[] referenciaSplit = new String[1];
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Métodos">
    public ControladorEmpresa() {
        this.bandera = false;
        this.respuesta = new String[3];
    }
    
    public boolean crearActualizar(Map datosEmpresa) {
        
        camposObligatorios = validarCamposObligatorios(datosEmpresa);
        camposInvalidos = validarInformacion(datosEmpresa);
        
        if (camposObligatorios.equals("") && camposInvalidos.equals("")) {
            Empresa empresa = new Empresa();
            empresa.setAccion((String) datosEmpresa.get("accion"));
            empresa.setId((String) datosEmpresa.get("id"));
            empresa.setRuc((String) datosEmpresa.get("ruc"));
            empresa.setNombreComercial((String) datosEmpresa.get("nombreComercial"));
            empresa.setRazonSocial((String) datosEmpresa.get("razonSocial"));
            empresa.setTipo((String) datosEmpresa.get("tipo"));
            empresa.setActividadEconomica((String) datosEmpresa.get("actividadEconomica"));
            empresa.setTelefono((String) datosEmpresa.get("telefono"));
            empresa.setCorreo((String) datosEmpresa.get("correo"));
            
            respuesta = empresa.crearActualizar(empresa);
            
            controladorMensaje.getInstance().getMsgGuardar(respuesta[1]);
            return bandera = controladorVariablesSesion.getInstance().validarRespuestaDB(respuesta[2]);
        } else {
            
            if (!camposObligatorios.equals("")) controladorMensaje.getInstance().getMsgCamposObligatorios(camposObligatorios);
            if (!camposInvalidos.equals("")) controladorMensaje.getInstance().getMsgCamposInvalidos(camposInvalidos);
        }
        return bandera;
        
    }
    
    public void eliminar(Map datos) {
        
        Empresa empresa = new Empresa();
        empresa.setId((String) datos.get("id"));
        controladorMensaje.getInstance().getMsgEliminar(empresa.eliminar(empresa));
        
    }
    
    public String validarCamposObligatorios(Map datosPersona) {
        camposObligatorios = "";
        if (datosPersona.get("ruc").equals("")) {
            camposObligatorios += "Ingrese el Ruc\n";
        }
        if (datosPersona.get("nombreComercial").equals("")) {
            camposObligatorios += "Ingrese el Nombre Comercial\n";
        }
        if (datosPersona.get("razonSocial").equals("")) {
            camposObligatorios += "Ingrese la Razón Social\n";
        }
        if (datosPersona.get("tipo").equals("-1")) {
            camposObligatorios += "Seleccione el Tipo de Empresa\n";
        }
        if (datosPersona.get("actividadEconomica").equals("")) {
            camposObligatorios += "Ingrese la Actividad Económina\n";
        }
        return camposObligatorios;
    }
    
    private String validarInformacion(Map datosEmpresa) {
        
        camposInvalidos = "";
        if (!validarRuc((String) datosEmpresa.get("ruc"))) {
            camposInvalidos += "Ingrese un Ruc Válido\n";            
        }
        
        if (!validarEmail((String) datosEmpresa.get("correo"))) {
            camposInvalidos += "No es un formato de Correo Electrónico Aceptado\n";
            
        }
        
        return camposInvalidos;
    }
    
    public boolean validarRuc(String ruc) {
        boolean rucCorrecto;
        try {
            String Ruc = "";
            if (ruc.length() == 10) {
                Ruc = ruc;
            } else {
                for (int x = 0; x < ruc.length() - 3; x++) {
                    Ruc = Ruc + ruc.charAt(x);
                }
            }
            
            if (Ruc.length() == 10) // ConstantesApp.LongitudCedula
            {
                int tercerDigito = Integer.parseInt(Ruc.substring(2, 3));
                if (tercerDigito < 6) {
                    // Coeficientes de validación cédula
                    // El decimo digito se lo considera dígito verificador
                    int[] coefValCedula = {2, 1, 2, 1, 2, 1, 2, 1, 2};
                    int verificador = Integer.parseInt(Ruc.substring(9, 10));
                    int suma = 0;
                    int digito = 0;
                    for (int i = 0; i < (Ruc.length() - 1); i++) {
                        digito = Integer.parseInt(Ruc.substring(i, i + 1)) * coefValCedula[i];
                        suma += ((digito % 10) + (digito / 10));
                    }
                    
                    if ((suma % 10 == 0) && (suma % 10 == verificador)) {
                        rucCorrecto = true;
                    } else if ((10 - (suma % 10)) == verificador) {
                        rucCorrecto = true;
                    } else {
                        rucCorrecto = false;
                    }
                } else {
                    rucCorrecto = false;
                }
            } else {
                rucCorrecto = false;
            }
        } catch (NumberFormatException nfe) {
            rucCorrecto = false;
        } catch (Exception err) {
            System.out.println("Una excepcion ocurrio en el proceso de validadcion");
            rucCorrecto = false;
        }
        
        if (!rucCorrecto) {
            System.out.println("La Cédula ingresada es Incorrecta");
        }
        return rucCorrecto;
    }
    
    private static final String PATTERN_EMAIL = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    
    public boolean validarEmail(String email) {
        
        // Compiles the given regular expression into a pattern.
        Pattern pattern = Pattern.compile(PATTERN_EMAIL);
        
        // Match the given input against this pattern
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
        
    }
//</editor-fold>
}
