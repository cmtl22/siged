package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SeguimientoReunion {

    private String _id;
    private String _idPeriodo;
    private String _idTutorEmpresarial;
    private String _participante;
    private String _fechaReunion;
    private String _motivo;
    private String _observacion;

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

    public String getIdTutorEmpresarial() {
        return _idTutorEmpresarial;
    }

    public void setIdTutorEmpresarial(String _idTutorEmpresarial) {
        this._idTutorEmpresarial = _idTutorEmpresarial;
    }

    public String getParticipante() {
        return _participante;
    }

    public void setParticipante(String _participante) {
        this._participante = _participante;
    }

    public String getFechaReunion() {
        return _fechaReunion;
    }

    public void setFechaReunion(String _fechaReunion) {
        this._fechaReunion = _fechaReunion;
    }

    public String getMotivo() {
        return _motivo;
    }

    public void setMotivo(String _motivo) {
        this._motivo = _motivo;
    }

    public String getObservacion() {
        return _observacion;
    }

    public void setObservacion(String _observacion) {
        this._observacion = _observacion;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }
    // </editor-fold>

    public String[] crearActualizar(SeguimientoReunion datos) {

        try {
            this._sql = "select *from sp_siged_seguimiento_reunion_crear_actualizar(?, ?, ?, ?, ?, ?, ?, ?);";
            sentencia = Conexion.getConexion().prepareStatement(this._sql);
            sentencia.setString(1, datos.getAccion());
            sentencia.setInt(2, Integer.parseInt(datos.getId()));
            sentencia.setInt(3, Integer.parseInt(datos.getIdPeriodo()));
            sentencia.setInt(4, Integer.parseInt(datos.getIdTutorEmpresarial()));
            sentencia.setString(5, datos.getParticipante());
            sentencia.setString(6, datos.getFechaReunion());
            sentencia.setString(7, datos.getMotivo());
            sentencia.setString(8, datos.getObservacion());

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

    public String eliminar(SeguimientoReunion datos) {
        try {
            this._sql = "select *from sp_siged_eliminar('reunion_seguimiento',?);";
            sentencia = Conexion.getConexion().prepareStatement(this._sql);
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

}
