package controlador;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import modelo.Archivo;

public class controladorArchivo {

    private String[] respuesta;
    private boolean bandera;
    private final FileNameExtensionFilter filtroArchivosPDF = new FileNameExtensionFilter("PDF Documents (*.pdf)", "pdf");

    private JFileChooser jcArchivo;
    private String[] rutasArchivos;
    private String[] nombresArchivos;
    private FileInputStream[] archivos;
    private int[] tamanioArchivos;

    public String[] getNombresArchivos() {
        return nombresArchivos;
    }

    public void setNombresArchivos(String[] nombresArchivos) {
        this.nombresArchivos = nombresArchivos;
    }

    public void crearActualizar(Map datos, Object[] datosArchivos, int[] tamanioArchivos, String[] nombArchivos) {
        Archivo archivo = new Archivo();
        archivo.setAccion((String) datos.get("accion"));
        archivo.setId((String) datos.get("id"));
        archivo.setReferencia((String) datos.get("referencia"));
        archivo.setDescripcion((String) datos.get("descripcion"));

        archivo.setTipo((String) datos.get("tipo"));

        for (int i = 0; i < datosArchivos.length; i++) {
            archivo.setArchivo((InputStream) datosArchivos[i]);
            archivo.setRuta(nombArchivos[i]);
            archivo.setTamanioArchivo(tamanioArchivos[i]);
            respuesta = archivo.crearActualizar(archivo);
        }

        controladorMensaje.getInstance().getMsgGuardar(respuesta[1]);
        bandera = controladorVariablesSesion.getInstance().validarRespuestaDB(respuesta[2]);
    }

    public boolean modificarDescripcionAnexos(int[] idArchivos, String[] nombresArchivos, String[] descripcionArchivos) {
        Archivo archivo = new Archivo();
        archivo.setIdArchivos(idArchivos);
        archivo.setNombresArchivos(nombresArchivos);
        archivo.setDescripcionVarios(descripcionArchivos);
        respuesta = archivo.modificarDescripcionArchivos(archivo);
        controladorMensaje.getInstance().getMsgGuardar(respuesta[1]);
        bandera = controladorVariablesSesion.getInstance().validarRespuestaDB(respuesta[2]);
        return true;
    }

    public void eliminar(Map datos) {

        Archivo archivo = new Archivo();
        archivo.setId((String) datos.get("id"));
        controladorMensaje.getInstance().getMsgEliminar(archivo.eliminar(archivo));

    }

    public void descargarArchivo(String[] criterioBusqueda, String extension) {
        try {
            controladorConsulta consulta = new controladorConsulta();

            ResultSet rs = consulta.consultarDatos("documento_anexos", controladorVariablesSesion.getInstance().getFiltrar(), criterioBusqueda);
            JFileChooser file = new JFileChooser();
            file.setFileFilter(filtroArchivosPDF);// crea un flitro para que se puedan seleccionar solo  PDF
            int estado = file.showSaveDialog(file);
            if (estado == JFileChooser.APPROVE_OPTION) {
                File archivo = file.getSelectedFile();
                OutputStream out = new FileOutputStream(archivo.getPath() + "." + extension);
                byte[] fileBytes = null;

                while (rs.next()) {

                    fileBytes = rs.getBytes("docu_archivo");

                }

                out.write(fileBytes);
                out.close();
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Su archivo no se ha guardado", "Advertencia", JOptionPane.WARNING_MESSAGE);
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Su archivo no se ha guardado", "Advertencia", JOptionPane.WARNING_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Su archivo no se ha guardado", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }

    public FileInputStream[] cargarArchivos() {
        archivos = null;
        jcArchivo = new JFileChooser();
        jcArchivo.setFileSelectionMode(JFileChooser.FILES_ONLY);//solo archivos y no carpetas
        jcArchivo.setFileFilter(filtroArchivosPDF);// crea un flitro para que se puedan seleccionar solo  PDF

        if (!jcArchivo.isMultiSelectionEnabled()) {
            jcArchivo.setMultiSelectionEnabled(true);//habilita  la selección multiple de archivos
        }

        int estado = jcArchivo.showOpenDialog(null); //abre la ventana de dialogo para escojer los archivos
        if (estado == JFileChooser.APPROVE_OPTION) { //verifica si es presiono en aceptar o abrir caso contrario no entra en el if
            try {

                archivos = new FileInputStream[jcArchivo.getSelectedFiles().length];
                tamanioArchivos = new int[jcArchivo.getSelectedFiles().length];
                nombresArchivos = new String[jcArchivo.getSelectedFiles().length];
                rutasArchivos = new String[jcArchivo.getSelectedFiles().length];
                for (int i = 0; i < jcArchivo.getSelectedFiles().length; i++) {
                    archivos[i] = new FileInputStream(jcArchivo.getSelectedFiles()[i]);
                    tamanioArchivos[i] = (int) jcArchivo.getSelectedFiles()[i].length();
                    nombresArchivos[i] = jcArchivo.getSelectedFiles()[i].getName();
                    rutasArchivos[i] = jcArchivo.getSelectedFiles()[i].getAbsolutePath();
                }

            } catch (FileNotFoundException ex) {
                Logger.getLogger(controladorArchivo.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return archivos;
    }

    public int[] getTamanioArchivos() {
        return tamanioArchivos;
    }



}
