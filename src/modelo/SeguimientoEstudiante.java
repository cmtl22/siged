package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SeguimientoEstudiante {

    private String _id;
    private String _idPeriodo;
    private String _idEstudiante;
    private String _idTutorEmpresarial;
    private String _idTutorAcademico;
    private String _idEmpresaSucursal;
    private String _idNivel;
    private String _notaInstituto;
    private String _notaEmpresa;

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

    public String getIdEstudiante() {
        return _idEstudiante;
    }

    public void setIdEstudiante(String _idEstudiante) {
        this._idEstudiante = _idEstudiante;
    }

    public String getIdTutorEmpresarial() {
        return _idTutorEmpresarial;
    }

    public void setIdTutorEmpresarial(String _idTutorEmpresarial) {
        this._idTutorEmpresarial = _idTutorEmpresarial;
    }

    public String getIdTutorAcademico() {
        return _idTutorAcademico;
    }

    public void setIdTutorAcademico(String _idTutorAcademico) {
        this._idTutorAcademico = _idTutorAcademico;
    }

    public String getIdEmpresaSucursal() {
        return _idEmpresaSucursal;
    }

    public void setIdEmpresaSucursal(String _idEmpresaSucursal) {
        this._idEmpresaSucursal = _idEmpresaSucursal;
    }

    public String getIdNivel() {
        return _idNivel;
    }

    public void setIdNivel(String _idNivel) {
        this._idNivel = _idNivel;
    }

    public String getNotaInstituto() {
        return _notaInstituto;
    }

    public void setNotaInstituto(String _notaInstituto) {
        this._notaInstituto = _notaInstituto;
    }

    public String getNotaEmpresa() {
        return _notaEmpresa;
    }

    public void setNotaEmpresa(String _notaEmpresa) {
        this._notaEmpresa = _notaEmpresa;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    // </editor-fold>
    
    public String[] crearActualizar(SeguimientoEstudiante datos) {

        try {
            this._sql = "select *from sp_siged_seguimiento_estudiante_crear_actualizar(?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
            sentencia = Conexion.getConexion().prepareStatement(this._sql);
            sentencia.setString(1, datos.getAccion());
            sentencia.setInt(2, Integer.parseInt(datos.getId()));
            sentencia.setInt(3, Integer.parseInt(datos.getIdPeriodo()));
            sentencia.setInt(4, Integer.parseInt(datos.getIdEstudiante()));
            sentencia.setInt(5, Integer.parseInt(datos.getIdTutorEmpresarial()));
            sentencia.setInt(6, Integer.parseInt(datos.getIdTutorAcademico()));
            sentencia.setInt(7, Integer.parseInt(datos.getIdEmpresaSucursal()));
            sentencia.setString(8, datos.getIdNivel());
            sentencia.setDouble(9, Double.parseDouble(datos.getNotaInstituto()));
            sentencia.setDouble(10, Double.parseDouble(datos.getNotaEmpresa()));

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

    public String eliminar(SeguimientoEstudiante datos) {
        try {
            this._sql = "select *from sp_siged_eliminar('seguimiento_estudiante',?);";
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
