package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Cronograma {

    private String _id;
    private String _idPeriodo;
    private String _tarea;
    private String _fechaInicio;
    private String _fechaFin;

    private String accion;
    private boolean bandera;
    private String _sql;
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

    public String getIdPeriodo() {
        return _idPeriodo;
    }

    public void setIdPeriodo(String _idPeriodo) {
        this._idPeriodo = _idPeriodo;
    }

    public String getTarea() {
        return _tarea;
    }

    public void setTarea(String _tarea) {
        this._tarea = _tarea;
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
   // </editor-fold>
    
    public String[] crearActualizar(Cronograma datos) {

        try {
            this._sql = "select *from sp_siged_cronograma_crear_actualizar(?, ?, ?, ?, ?, ?);";
            sentencia = Conexion.getConexion().prepareStatement(this._sql);
            sentencia.setString(1, datos.getAccion());
            sentencia.setInt(2, Integer.parseInt(datos.getId()));
            sentencia.setInt(3, Integer.parseInt(datos.getIdPeriodo()));
            sentencia.setString(4, datos.getTarea());
            sentencia.setString(5, datos.getFechaInicio());
            sentencia.setString(6, datos.getFechaFin());

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

    public String eliminar(Cronograma datos) {
        try {
            this._sql = "select *from sp_siged_eliminar('cronograma',?);";
            sentencia = Conexion.getConexion().prepareStatement(this._sql);
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
            return null;
        }
    }

}
