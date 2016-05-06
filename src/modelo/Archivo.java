package modelo;

import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Archivo {

    // <editor-fold defaultstate="collapsed" desc="Declaracion de variables">
    private String _id;
    private int[] _idArchivos;
    private String _referencia;
    private String _descripcion;
    private String[] _descripcionVarios;
    private String[] _nombresArchivos;
    private String _ruta;
    private InputStream _archivo;
    private int _tamanioArchivo;
    private String _tipo;

    private String accion;
    private String sql;
    private PreparedStatement sentencia;
    private ResultSet resultadoQuery;
    private final String respuesta[] = new String[3];
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Getters and Setters">

    public String getId() {
        return _id;
    }

    public void setId(String _id) {
        this._id = _id;
    }

    public String getReferencia() {
        return _referencia;
    }

    public void setReferencia(String _referencia) {
        this._referencia = _referencia;
    }

    public String getDescripcion() {
        return _descripcion;
    }

    public void setDescripcion(String _descripcion) {
        this._descripcion = _descripcion;
    }

    public String getRuta() {
        return _ruta;
    }

    public void setRuta(String _ruta) {
        this._ruta = _ruta;
    }

    public InputStream getArchivo() {
        return _archivo;
    }

    public void setArchivo(InputStream _archivo) {
        this._archivo = _archivo;
    }

    public int getTamanioArchivo() {
        return _tamanioArchivo;
    }

    public void setTamanioArchivo(int _tamanioArchivo) {
        this._tamanioArchivo = _tamanioArchivo;
    }

    public String getTipo() {
        return _tipo;
    }

    public void setTipo(String _tipo) {
        this._tipo = _tipo;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    public String[] getDescripcionVarios() {
        return _descripcionVarios;
    }

    public void setDescripcionVarios(String[] _descripcionVarios) {
        this._descripcionVarios = _descripcionVarios;
    }

    public int[] getIdArchivos() {
        return _idArchivos;
    }

    public void setIdArchivos(int[] _idArchivos) {
        this._idArchivos = _idArchivos;
    }

    public String[] getNombresArchivos() {
        return _nombresArchivos;
    }

    public void setNombresArchivos(String[] _nombresArchivos) {
        this._nombresArchivos = _nombresArchivos;
    }

// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Métodos">
    public String[] crearActualizar(Archivo datos) {
        try {
            sql = "select *from sp_siged_documento_anexos_crear_actualizar(?, ?, ?, ?, ?, ?,?);";
            sentencia = Conexion.getConexion().prepareStatement(sql);
            sentencia.setString(1, datos.getAccion());
            sentencia.setInt(2, Integer.parseInt(datos.getId()));
            sentencia.setInt(3, Integer.parseInt(datos.getReferencia()));
            sentencia.setString(4, datos.getDescripcion());
            sentencia.setString(5, datos.getRuta());
            sentencia.setBinaryStream(6, datos.getArchivo(), datos.getTamanioArchivo());
            sentencia.setString(7, datos.getTipo());
            System.out.println(sentencia);
            resultadoQuery = sentencia.executeQuery();
            resultadoQuery.next();
            respuesta[0] = resultadoQuery.getString(1);
            respuesta[1] = resultadoQuery.getString(2);
            respuesta[2] = resultadoQuery.getString(3);

            sentencia.close();
            return respuesta;

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

    public String[] modificarDescripcionArchivos(Archivo datos) {
        try {
            PostgreSQLInt4Array idArchivos = new PostgreSQLInt4Array(datos.getIdArchivos());
            PostgreSQLTextArray nombresArchivos = new PostgreSQLTextArray(datos.getNombresArchivos());
            PostgreSQLTextArray descripcionArchivos = new PostgreSQLTextArray(datos.getDescripcionVarios());
            sql = "select *from sp_siged_modificar_descripcion_anexos(?, ?,?);";
            sentencia = Conexion.getConexion().prepareStatement(sql);

            sentencia.setArray(1, idArchivos);
            sentencia.setArray(2, nombresArchivos);
            sentencia.setArray(3, descripcionArchivos);

            System.out.println(sentencia);
            resultadoQuery = sentencia.executeQuery();
            resultadoQuery.next();

            respuesta[0] = resultadoQuery.getString(1);
            respuesta[1] = resultadoQuery.getString(2);
            respuesta[2] = resultadoQuery.getString(3);
            sentencia.close();
            return respuesta;

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

    public String eliminar(Archivo datos) {
        try {
            sql = "select *from sp_siged_documento_anexos_eliminar(?);";
            sentencia = Conexion.getConexion().prepareStatement(sql);
            sentencia.setInt(1, Integer.parseInt(datos.getId()));
            System.out.println(sentencia);
            resultadoQuery = sentencia.executeQuery();
            resultadoQuery.next();
            respuesta[0] = resultadoQuery.getString(1);
            respuesta[1] = resultadoQuery.getString(2);
            respuesta[2] = resultadoQuery.getString(3);
            sentencia.close();
            return respuesta[1];
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }
    // </editor-fold>
}
