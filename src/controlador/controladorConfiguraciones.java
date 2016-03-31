package controlador;

import java.io.File;
import java.util.Calendar;
import java.util.Map;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import modelo.Configuraciones;

public class controladorConfiguraciones {

    private JFileChooser RealizarBackupMySQL = new JFileChooser();

    private static controladorConfiguraciones instancia;
    private boolean estadoFormulario;
    private static final String DATOS_DISPONIBLES = "disponibles";
    private static final String DATOS_ELIMINADOS = "eliminados";
    private static final String DATOS_TODOS = "todos";
    private static final String DATOS_FILTRAR = "filtroIndividual";
    private static final String DATOS = "datos";
    private static final String PATH_APLICATION = new File("").getAbsolutePath();
    private String camposObligatorios;
    private String codigoUsuario;
    private String nombreUsuario;
    private String perfilUsuario;

    private String[] datosTabla;
    private String[] nombresComlumnas;
    private String datosTemporalesConsulta;
    private String[] datosConsulta;

    private boolean bandera;
    private static final int limiteVentanas = 2;
    private static final int limiteIntentosLogin = 3;
    private int contadorVentanas;
    private int contadorIntentosLogin;
    String[] respuesta;

    private controladorConfiguraciones() {
        contadorVentanas = 0;
        contadorIntentosLogin = limiteIntentosLogin;
        this.bandera = false;
        this.respuesta = new String[3];
    }

    public static controladorConfiguraciones getInstance() {
        if (instancia == null) {
            instancia = new controladorConfiguraciones();
        }
        return instancia;
    }

// <editor-fold defaultstate="collapsed" desc="Getters and Setters">                          
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
    public void generarBackup() {
        int resp;
        Calendar c = Calendar.getInstance();
        String fecha = String.valueOf(c.get(Calendar.DATE));
        fecha = fecha + String.valueOf(c.get(Calendar.MONTH));
        fecha = fecha + String.valueOf(c.get(Calendar.YEAR));
        resp = RealizarBackupMySQL.showSaveDialog(null);//JFileChooser de nombre RealizarBackupMySQL
        if (resp == JFileChooser.APPROVE_OPTION) {//Si el usuario presiona aceptar; se genera el Backup
            try {

                File backupFile = new File(String.valueOf(RealizarBackupMySQL.getSelectedFile().getParent())
                        + "\\"
                        + "backup_"
                        + RealizarBackupMySQL.getSelectedFile().getName()
                        + "_"
                        + fecha
                        + ".sql");

                String userDataBase = "postgres";
                String passwordDataBase = "root";
                String dataBase = "siged_pruebas";
                String comandos = "cmd /c pg_dump -U  " + userDataBase + " " + dataBase + " > " + backupFile.getAbsoluteFile().toString();
                System.out.println(comandos);
                Runtime.getRuntime().exec(comandos);

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error no se genero el archivo por el siguiente motivo:" + e.getMessage(), "Verificar", JOptionPane.ERROR_MESSAGE);
            }
            JOptionPane.showMessageDialog(null, "Backup generado correctamente", "Generado", JOptionPane.INFORMATION_MESSAGE);
        } else if (resp == JFileChooser.CANCEL_OPTION) {
            JOptionPane.showMessageDialog(null, "Ha sido cancelada la generacion del Backup", "Cancelado", JOptionPane.WARNING_MESSAGE);
        }
    }

    public boolean crearActualizar(Map datos) {
        camposObligatorios = validarCamposObligatorios(datos);
        if (camposObligatorios.equals("")) {
            Configuraciones configuraciones = new Configuraciones();
            configuraciones.setAccion((String) datos.get("accion"));
            configuraciones.setId((String) datos.get("id"));
            configuraciones.setNombre((String) datos.get("nombre"));
            configuraciones.setValor((String) datos.get("valor"));

            respuesta = configuraciones.crearActualizar(configuraciones);

            controladorMensaje.getInstance().getMsgGuardar(respuesta[1]);
            bandera = controladorVariablesSesion.getInstance().validarRespuestaDB(respuesta[2]);

        } else {
            controladorMensaje.getInstance().getMsgCamposObligatorios(camposObligatorios);
        }
        return bandera;
    }

    public void eliminar(Map datos) {

        Configuraciones configuraciones = new Configuraciones();
        configuraciones.setId((String) datos.get("id"));
        controladorMensaje.getInstance().getMsgEliminar(configuraciones.eliminar(configuraciones));

    }

    public String validarCamposObligatorios(Map datos) {
        camposObligatorios = "";
        if (datos.get("nombre").equals("")) {
            camposObligatorios += "Nombre\n";
        }
        if (datos.get("valor").equals("")) {
            camposObligatorios += "Valor\n";
        }

        return camposObligatorios;
    }

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

    public int getContadorIntentosLogin() {
        return contadorIntentosLogin;
    }

    public void setContadorIntentosLogin(int contadorIntentosLogin) {
        this.contadorIntentosLogin = contadorIntentosLogin;
    }

    public int getLimiteVentanas() {
        return limiteVentanas;
    }

    public int getLimiteIntentosLogin() {
        return limiteIntentosLogin;
    }

    public String[] getDatosConsulta() {
        return datosConsulta;
    }

    public void setDatosConsulta(String[] datosConsulta) {
        this.datosConsulta = datosConsulta;
    }
// </editor-fold> 
}
