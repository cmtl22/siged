package controlador;

import java.io.File;
import java.io.FileInputStream;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class controladorVariablesSesion {

    private final FileNameExtensionFilter filtroArchivosXLS = new FileNameExtensionFilter("XLSX Documents (*.xlsx)", "xlsx");
    private JFileChooser jcArchivo;
    private FileInputStream archivo;

    private static controladorVariablesSesion instancia;
    private boolean estadoFormulario;
    private static final String DATOS_DISPONIBLES = "disponibles";
    private static final String DATOS_ELIMINADOS = "eliminados";
    private static final String DATOS_TODOS = "todos";
    private static final String DATOS_FILTRAR = "filtroIndividual";
    private static final String DATOS = "datos";
    private static final String PATH_APLICATION = new File("").getAbsolutePath();
    private static final String PATTERN_STRING = "[A-Za-z]";
    private static final String PATTERN_NUMERIC = "[0-9]";
    private String codigoUsuario;
    private String nombreUsuario;
    private String perfilUsuario;
    private String correoUsuario;
    private String nombresPersona;

    private String[] datosTabla;
    private String[] nombresComlumnas;
    private String datosTemporalesConsulta;
    private String[] datosConsulta;

    private boolean bandera;
    private static final int limiteVentanas = 2;
    private int contadorVentanas;

    private controladorVariablesSesion() {
        contadorVentanas = 0;
    }

    public static controladorVariablesSesion getInstance() {
        if (instancia == null) {
            instancia = new controladorVariablesSesion();
        }
        return instancia;
    }

    public String getCorreoUsuario() {
        return correoUsuario;
    }

// <editor-fold defaultstate="collapsed" desc="Getters and Setters">
    public String getNombresPersona() {
        return nombresPersona;
    }

    public void setNombresPersona(String nombresPersona) {
        this.nombresPersona = nombresPersona;
    }

    public void setCorreoUsuario(String correoUsuario) {
        this.correoUsuario = correoUsuario;
    }

    public String[] getDatosTabla() {
        return datosTabla;
    }

    public void setDatosTabla(String[] datosTabla) {
        this.datosTabla = datosTabla;
    }

    public boolean isEstadoFormulario() {
        return estadoFormulario;
    }

    public void setEstadoFormulario(boolean estadoFormulario) {
        this.estadoFormulario = estadoFormulario;
    }

    public String getCodigoUsuario() {
        return codigoUsuario;
    }

    public void setCodigoUsuario(String codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getPerfilUsuario() {
        return perfilUsuario;
    }

    public void setPerfilUsuario(String perfilUsuario) {
        this.perfilUsuario = perfilUsuario;
    }

    public String[] getNombresComlumnas() {
        return nombresComlumnas;
    }

    public void setNombresComlumnas(String[] nombresComlumnas) {
        this.nombresComlumnas = nombresComlumnas;
    }

    public String getDatosTemporalesConsulta() {
        return datosTemporalesConsulta;
    }

    public void setDatosTemporalesConsulta(String datosTemporalesConsulta) {
        this.datosTemporalesConsulta = datosTemporalesConsulta;
    }

    public boolean isBandera() {
        return bandera;
    }

    public void setBandera(boolean bandera) {
        this.bandera = bandera;
    }

    // </editor-fold>                        
// <editor-fold defaultstate="collapsed" desc="Metodos">  
    public boolean validarRespuestaDB(String respuesta) {
        bandera = false;
        switch (respuesta) {
            case "1":
                bandera = true;
                break;
            case "23505"://unique_violation
                bandera = false;
                break;
            case "23503"://foreign_key_violation
                bandera = false;
                break;
            case "23502"://not_null_violation
                bandera = false;
                break;

            default:
                bandera = false;
        }
        return bandera;
    }

    public String getDatos() {
        return DATOS;
    }

    public String getDisponibles() {
        return DATOS_DISPONIBLES;
    }

    public String getEliminados() {
        return DATOS_ELIMINADOS;
    }

    public String getTodos() {
        return DATOS_TODOS;
    }

    public String getFiltrar() {
        return DATOS_FILTRAR;
    }

    public String getPathAplication() {
        return PATH_APLICATION;
    }

    public int getContadorVentanas() {
        return contadorVentanas;
    }

    public void setContadorVentanas(int contadorVentanas) {
        this.contadorVentanas = this.contadorVentanas + contadorVentanas;
    }

    public int getLimiteVentanas() {
        return limiteVentanas;
    }

    public String[] getDatosConsulta() {
        return datosConsulta;
    }

    public void setDatosConsulta(String[] datosConsulta) {
        this.datosConsulta = datosConsulta;
    }

    public int eliminar(String id) {
        int estadoEliminar = 1;
        try {
            if (id.equals("")) {
                JOptionPane.showMessageDialog(null, "Debe elejir antes de eliminar!!!", "Eliminar", JOptionPane.WARNING_MESSAGE);
            } else {
                int seleccion = JOptionPane.showOptionDialog(
                        null,
                        "¿Está Seguro de eliminar?",
                        "Eliminar",
                        JOptionPane.YES_NO_CANCEL_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null, // null para icono por defecto.
                        new Object[]{"Si", "No"}, // null para YES, NO y CANCEL
                        "opcion 1");
                return seleccion;

            }
        } catch (Exception ex) {
            // estadoCerrarVentana=1;
        }

        return estadoEliminar;
    }

    public int guardarCambios() {
        int estadoEliminar = 1;
        try {

            int seleccion = JOptionPane.showOptionDialog(
                    null,
                    "¿Desea Guardar los cambios?",
                    "Guardar",
                    JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null, // null para icono por defecto.
                    new Object[]{"Si", "No"}, // null para YES, NO y CANCEL
                    "opcion 1");
            return seleccion;

        } catch (Exception ex) {
            // estadoCerrarVentana=1;
        }

        return estadoEliminar;
    }

    public static String validarLetrasConEspacios(String cadena) {
        String aux = "";
        if (!cadena.matches("[A-Za-z\\s]*")) {

            char cad[];
            cad = cadena.toCharArray();
            for (int i = 0; i < cadena.length(); i++) {
                int ascci = (int) cad[i];
                if (!((ascci >= 65 && ascci <= 90) || (ascci >= 97 && ascci <= 122) || (ascci == 32))) {

                    aux = cadena.substring(0, i);
                    //  aux += cadena.substring(i + 1, cadena.length());
                    cadena = aux;
                }

            }
        }
        return cadena;
    }

    public static String validarLetrasSinEspacios(String cadena) {
        if (!cadena.matches("[A-Za-z]*")) {
            char cad[];
            cad = cadena.toCharArray();

            for (int i = 0; i < cadena.length(); i++) {
                int ascci = (int) cad[i];
                if (!((ascci >= 65 && ascci <= 90) || (ascci >= 97 && ascci <= 122))) {

                    cadena = cadena.substring(0, i);
                }

            }
        }
        return cadena;
    }

    public static String validarNumerosConEspacios(String cadena) {
        if (!cadena.matches("[0-9\\s]*")) {
            char cad[];
            cad = cadena.toCharArray();

            for (int i = 0; i < cadena.length(); i++) {
                int ascci = (int) cad[i];
                if (!((ascci >= 48 && ascci <= 57) || (ascci == 32))) {

                    cadena = cadena.substring(0, i);
                }

            }
        }
        return cadena;
    }

    public static String validarNumerosSinEspacios(String cadena) {
        if (!cadena.matches("[0-9]*")) {
            char cad[];
            cad = cadena.toCharArray();

            for (int i = 0; i < cadena.length(); i++) {
                int ascci = (int) cad[i];
                if (!((ascci >= 48 && ascci <= 57))) {

                    cadena = cadena.substring(0, i);
                }

            }
        }
        return cadena;
    }

    public String[] obtenerRuta() {
        String[] archivoXLSX = new String[2];
        JFileChooser file = new JFileChooser();
        file.setFileFilter(filtroArchivosXLS);
        int estado = file.showSaveDialog(file);
        if (estado == JFileChooser.APPROVE_OPTION) {
            File archivo = file.getSelectedFile();

            archivoXLSX[0] = archivo.getPath();
            archivoXLSX[1] = archivo.getName();
        }
        return archivoXLSX;
    }
// </editor-fold> 
}
