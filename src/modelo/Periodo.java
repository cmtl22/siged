package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Periodo {

    private String _id;
    private String _nombre;
    private String _fechaInicio;
    private String _fechaFin;

    private String accion;
    private boolean bandera;
    private String sql;
    private PreparedStatement sentencia;
    private ResultSet resultadoQuery;
    private final String respuesta[] = new String[3];

    // <editor-fold defaultstate="collapsed" desc="Getters and Setters">
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

    public String getFechaInicio() {
        return _fechaInicio;
    }

    public void setFechaInicio(String _fechaInicio) {
        this._fechaInicio = _fechaInicio;
    }

    public String getFechaFin() {
        return _fechaFin;
    }

    public void setFechaFin(String _fechaFin) {
        this._fechaFin = _fechaFin;
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
    // </editor-fold>

    public String[] crearActualizar(Periodo datos) {

        try {
            sql = "select *from sp_siged_periodo_crear_actualizar(?, ?, ?, ?, ?);";
            sentencia = Conexion.getConexion().prepareStatement(sql);
            sentencia.setString(1, datos.getAccion());
            sentencia.setInt(2, Integer.parseInt(datos.getId()));
            sentencia.setString(3, datos.getNombre());
            sentencia.setString(4, datos.getFechaInicio());
            sentencia.setString(5, datos.getFechaFin());

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

    public String eliminar(Periodo datos) {
        try {
            sql = "select *from sp_siged_eliminar('periodo',?);";
            sentencia = Conexion.getConexion().prepareStatement(sql);
            sentencia.setInt(1, Integer.parseInt(datos.getId()));
            resultadoQuery = sentencia.executeQuery();
            resultadoQuery.next();
            respuesta[0] = resultadoQuery.getString(1);
            respuesta[1] = resultadoQuery.getString(2);
            respuesta[2] = resultadoQuery.getString(3);
            sentencia.close();
            return respuesta[1];
        } catch (SQLException ex) {
            return null;
        }
    }
    
    public String[] abrirPeriodo(Periodo datos) {
        try {
            sql = "select *from sp_siged_periodo_abrir(?);";
            sentencia = Conexion.getConexion().prepareStatement(sql);
            sentencia.setInt(1, Integer.parseInt(datos.getId()));
            resultadoQuery = sentencia.executeQuery();
            resultadoQuery.next();
            respuesta[0] = resultadoQuery.getString(1);
            respuesta[1] = resultadoQuery.getString(2);
            respuesta[2] = resultadoQuery.getString(3);
            sentencia.close();
            return respuesta;
        } catch (SQLException ex) {
            return null;
        }
    }

}
