package controlador;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import modelo.Persona;

public class ControladorPersona {

    //<editor-fold defaultstate="collapsed" desc="Declaración de Variables">
    private String camposObligatorios;
    private String camposInvalidos;
    boolean bandera;
    private String[] respuesta;
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Métodos">
    public ControladorPersona() {
        this.bandera = false;
        this.respuesta = new String[3];
    }

    public boolean crearActualizar(Map datosPersona) {

        camposObligatorios = validarCamposObligatorios(datosPersona);
        camposInvalidos = validarInformacion(datosPersona);
        if (camposObligatorios.equals("") && camposInvalidos.equals("")) {

            Persona persona = new Persona();
            persona.setAccion((String) datosPersona.get("accion"));
            persona.setId((String) datosPersona.get("id"));
            persona.setTipoIdentificacion((String) datosPersona.get("tipoIdentificacion"));
            persona.setIdCarreraEmpresa((String) datosPersona.get("idCarreraEmpresa"));
            persona.setNumeroIdentificacion((String) datosPersona.get("numeroIdentificacion"));
            persona.setNombres((String) datosPersona.get("nombres"));
            persona.setApellidos((String) datosPersona.get("apellidos"));
            persona.setFechaNacimiento((String) datosPersona.get("fechaNacimiento"));
            persona.setDireccion((String) datosPersona.get("direccion"));
            persona.setTelefonoFijo((String) datosPersona.get("telefonoFijo"));
            persona.setTelefonoCelular((String) datosPersona.get("telefonoCelular"));
            persona.setCorreo((String) datosPersona.get("correo"));
            persona.setTipo((String) datosPersona.get("tipo"));
            persona.setFormacionAcademica((String) datosPersona.get("formacionAcademica"));
            persona.setInformacionAdicional((String) datosPersona.get("informacionAdicional"));
            persona.setTipoGeneral((String) datosPersona.get("tipoGeneral"));
            persona.setGenero((String) datosPersona.get("genero"));

            respuesta = persona.crearActualizar(persona);

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

        Persona persona = new Persona();
        persona.setId((String) datos.get("id"));
        controladorMensaje.getInstance().getMsgEliminar(persona.eliminar(persona));

    }

    public String validarCamposObligatorios(Map datosPersona) {
        camposObligatorios = "";

        if (datosPersona.get("idCarreraEmpresa").equals("-1")) {
            camposObligatorios += "Seleccione una Empresa\n";
        }
        if (datosPersona.get("nombres").equals("")) {
            camposObligatorios += "Ingrese los Nombres\n";
        }
        if (datosPersona.get("apellidos").equals("")) {
            camposObligatorios += "Ingrese los Apellidos\n";
        }
        if (datosPersona.get("tipoIdentificacion").equals("-1")) {
            camposObligatorios += "Seleccione el Tipo de Identificación\n";
        }
        if (datosPersona.get("numeroIdentificacion").equals("")) {
            camposObligatorios += "Ingrese el Número de identificación\n";
        }
        if (datosPersona.get("telefonoFijo").equals("")) {
            camposObligatorios += "Ingrese el Teléfono Fijo\n";
        }
        if (datosPersona.get("telefonoCelular").equals("")) {
            camposObligatorios += "Ingrese el Teléfono Móvil\n";
        }
        if (datosPersona.get("correo").equals("")) {
            camposObligatorios += "Ingrese el Correo Electrónico\n";
        }
        if (datosPersona.get("fechaNacimiento").equals("2016-03-02")) {
            camposObligatorios += "Seleccione la Fecha de Nacimiento\n";
        }
        if (datosPersona.get("direccion").equals("")) {
            camposObligatorios += "Ingrese la Dirección\n";
        }
        if (datosPersona.get("formacionAcademica").equals("")) {
            camposObligatorios += "Ingrese los Datos de Formación Académica\n";
        }

        return camposObligatorios;
    }

    private String validarInformacion(Map datosPersona) {

        camposInvalidos = "";
        if (!validarCedula((String) datosPersona.get("numeroIdentificacion")) && datosPersona.get("tipoIdentificacion").equals("CED")) {
            camposInvalidos += "No es un Formato de Cédula Aceptado\n";

        }
        if (!validarEmail((String) datosPersona.get("correo"))) {
            camposInvalidos += "No es un formato de Correo Electrónico Aceptado\n";

        }
        if (!validarRuc((String) datosPersona.get("numeroIdentificacion")) && datosPersona.get("tipoIdentificacion").equals("RUC")) {
            camposInvalidos += "No es un Formato de RUC Aceptado\n";

        }
        if (!validarFechaNacimiento((String) datosPersona.get("fechaNacimiento"))) {
            camposInvalidos += "La fecha de nacimiento debe ser menor\n";

        }
        return camposInvalidos;
    }

    private boolean validarFechaNacimiento(String strFechaNacimiento) {
        try {
            Calendar calFechaActual = new GregorianCalendar();
            Calendar calFechaNacimiento = new GregorianCalendar();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            calFechaNacimiento.setTime(sdf.parse(strFechaNacimiento));
            calFechaActual.add(Calendar.YEAR, -16);
            return calFechaActual.after(calFechaNacimiento);

        } catch (ParseException ex) {
            Logger.getLogger(ControladorPersona.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean validarCedula(String num_identificacion) {
        boolean cedulaCorrecta;
        try {
            String cedula = "";
            if (num_identificacion.length() == 10) {
                cedula = num_identificacion;
            } else {
                for (int x = 0; x < num_identificacion.length() - 3; x++) {
                    cedula = cedula + num_identificacion.charAt(x);
                }
            }

            if (num_identificacion.length() == 10) // ConstantesApp.LongitudCedula
            {
                int tercerDigito = Integer.parseInt(cedula.substring(2, 3));
                if (tercerDigito < 6) {
                    // Coeficientes de validación cédula
                    // El decimo digito se lo considera dígito verificador
                    int[] coefValCedula = {2, 1, 2, 1, 2, 1, 2, 1, 2};
                    int verificador = Integer.parseInt(cedula.substring(9, 10));
                    int suma = 0;
                    int digito = 0;
                    for (int i = 0; i < (cedula.length() - 1); i++) {
                        digito = Integer.parseInt(cedula.substring(i, i + 1)) * coefValCedula[i];
                        suma += ((digito % 10) + (digito / 10));
                    }

                    if ((suma % 10 == 0) && (suma % 10 == verificador)) {
                        cedulaCorrecta = true;
                    } else if ((10 - (suma % 10)) == verificador) {
                        cedulaCorrecta = true;
                    } else {
                        cedulaCorrecta = false;
                    }
                } else {
                    cedulaCorrecta = false;
                }
            } else {
                cedulaCorrecta = false;
            }
        } catch (NumberFormatException nfe) {
            cedulaCorrecta = false;
        } catch (Exception err) {
            System.out.println("Una excepcion ocurrio en el proceso de validadcion");
            cedulaCorrecta = false;
        }

        if (!cedulaCorrecta) {
            System.out.println("La Cédula ingresada es Incorrecta");
        }
        return cedulaCorrecta;
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

    public boolean validarRuc(String ruc) {
        boolean rucCorrecto;
        try {
            String Ruc = "";
            String finalRUC = ruc.substring(10, 13);
            if (ruc.length() == 10) {
                Ruc = ruc;
            } else {
                for (int x = 0; x < ruc.length() - 3; x++) {
                    Ruc = Ruc + ruc.charAt(x);
                }
            }

            if (ruc.length() == 13 && finalRUC.equals("001")) // ConstantesApp.LongitudCedula
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

//</editor-fold>
}
