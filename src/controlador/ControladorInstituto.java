package controlador;

import java.sql.ResultSet;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import modelo.Instituto;

public class ControladorInstituto {

    private ResultSet resultado;
    String camposObligatorios;
    String camposInvalidos;
    boolean bandera;
    String[] respuesta;

    public boolean crearActualizar(Map datos) {
        camposObligatorios = validarCamposObligatorios(datos);
        camposInvalidos=validarInformacion(datos);
        if (camposObligatorios.equals("")&&camposInvalidos.equals("")){

            Instituto instituto = new Instituto();
            instituto.setAccion((String) datos.get("accion"));
            instituto.setId((String) datos.get("id"));
            instituto.setIdPersona( String.valueOf(datos.get("idPersona")));
            instituto.setNombre((String) datos.get("nombre"));
            instituto.setDireccion((String) datos.get("direccion"));
            instituto.setTelefono((String) datos.get("telefono"));
            instituto.setCorreo((String) datos.get("correo"));
            instituto.setSiglas((String) datos.get("siglas"));
            instituto.setCoordinacionZonal((String) datos.get("coordinacionZonal"));
            instituto.setFechaCreacion((String) datos.get("fechaCreacion"));
            instituto.setCreacionResolucion((String) datos.get("creacionResolucion"));

            respuesta = instituto.crearActualizar(instituto);

            controladorMensaje.getInstance().getMsgGuardar(respuesta[1]);
            bandera = controladorVariablesSesion.getInstance().validarRespuestaDB(respuesta[2]);
        } else {
           if (!camposObligatorios.equals(""))  
            controladorMensaje.getInstance().getMsgCamposObligatorios(camposObligatorios);
           if (!camposInvalidos.equals(""))  
            controladorMensaje.getInstance().getMsgCamposInvalidos(camposInvalidos);
        }   
            
       return bandera;

    }

    public void eliminar(Map datos) {

        Instituto instituto = new Instituto();
        instituto.setId((String) datos.get("id"));
        System.out.println("id que viene de la vista" + datos.get("id"));
        controladorMensaje.getInstance().getMsgEliminar(instituto.eliminar(instituto));

    }

    public String validarCamposObligatorios(Map datos) {
        camposObligatorios = "";
        if (datos.get("id").equals("")) {
            camposObligatorios += "\nFalta el id";

        }
        if (datos.get("nombre").equals("")) {
            camposObligatorios += "\nIngrese el nombre del instituto";

        }
         if (datos.get("idPersona").equals("-1")) {
            camposObligatorios += "\nIngrese el nombre del rector";

        }
        if (datos.get("coordinacionZonal").equals("")) {
            camposObligatorios += "\nIngrese la coordinación zonal";

        }
        if (datos.get("direccion").equals("")) {
            camposObligatorios += "\nIngrese la dirección";

        }
        if (datos.get("creacionResolucion").equals("")) {
            camposObligatorios += "\nIngrese la creaciön de la resolución";

        }
        if (datos.get("correo").equals("")) {
            camposObligatorios += "\nIngrese el correo del instituto";

        }
        if (datos.get("siglas").equals("")) {
            camposObligatorios += "\nIngrese las siglas del instituto";

        }

        return camposObligatorios;
    }

    private String validarInformacion(Map datos) {

        camposInvalidos = "";
        if (!validarEmail((String) datos.get("correo"))) {
            camposInvalidos += "Correo Electrónico\n";

        }
        return camposInvalidos;
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
}
