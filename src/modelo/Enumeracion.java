package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Enumeracion {

    private String _id;
    private String _nombre;
    private String _tipo;
    private String _codigo;
    private String _descripcion;

    private String accion;
    private boolean bandera;
    private String sql;
    private PreparedStatement sentencia;
    private ResultSet resultadoQuery;
    String[] respuesta = new String[3];

    ;

    public String getId() {
        return _id;
    }

    public void setId(String _id) {
        this._id = _id;
    }

    public String getNombre() {
        return _nombre;
    }

    public void setNombre(String _nombre) {
        this._nombre = _nombre;
    }

    public String getTipo() {
        return _tipo;
    }

    public void setTipo(String _tipo) {
        this._tipo = _tipo;
    }

    public String getCodigo() {
        return _codigo;
    }

    public void setCodigo(String _codigo) {
        this._codigo = _codigo;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    public boolean isBandera() {
        return bandera;
    }

    public void setBandera(boolean bandera) {
        this.bandera = bandera;
    }

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }

    public PreparedStatement getSentencia() {
        return sentencia;
    }

    public void setSentencia(PreparedStatement sentencia) {
        this.sentencia = sentencia;
    }

    public ResultSet getResultadoQuery() {
        return resultadoQuery;
    }

    public void setResultadoQuery(ResultSet resultadoQuery) {
        this.resultadoQuery = resultadoQuery;
    }

    public String[] getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String[] respuesta) {
        this.respuesta = respuesta;
    }

    public String getDescripcion() {
        return _descripcion;
    }

    public void setDescripcion(String _descripcion) {
        this._descripcion = _descripcion;
    }

    public String[] crearActualizar(Enumeracion datos) {

        try {
            sql = "select *from sp_siged_enumeracion_crear_actualizar(?, ?, ?, ?, ?,?);";
            sentencia = Conexion.getConexion().prepareStatement(sql);
            sentencia.setString(1, datos.getAccion());
            sentencia.setInt(2, Integer.parseInt(datos.getId()));
            sentencia.setString(3, datos.getNombre());
            sentencia.setString(4, datos.getTipo());
            sentencia.setString(5, datos.getCodigo());
            sentencia.setString(6, datos.getDescripcion());

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

    public String eliminar(Enumeracion datos) {
        try {
            sql = "select sp_siged_eliminar('enumeracion',?);";
            sentencia = Conexion.getConexion().prepareStatement(sql);
            sentencia.setInt(1, Integer.parseInt(datos.getId()));
            resultadoQuery = sentencia.executeQuery();
            resultadoQuery.next();
            respuesta[1] = resultadoQuery.getString(1);
            sentencia.close();
            return respuesta[1];
        } catch (SQLException ex) {
            return null;
        }
    }

}
