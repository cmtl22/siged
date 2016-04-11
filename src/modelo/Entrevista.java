package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Entrevista {

    private String _id;
    private String _idEmpresaSucursal;
    private String _idEstudiante;
    private String _idPeriodo;
    private String _idEstado;
    private String _idNivel;
    private String _observaciones;
    private String _fecha;

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

    public String getIdEmpresaSucursal() {
        return _idEmpresaSucursal;
    }

    public void setIdEmpresaSucursal(String _idEmpresaSucursal) {
        this._idEmpresaSucursal = _idEmpresaSucursal;
    }

    public String getIdEstudiante() {
        return _idEstudiante;
    }

    public void setIdEstudiante(String _idEstudiante) {
        this._idEstudiante = _idEstudiante;
    }

    public String getIdPeriodo() {
        return _idPeriodo;
    }

    public void setIdPeriodo(String _idPeriodo) {
        this._idPeriodo = _idPeriodo;
    }

    public String getIdEstado() {
        return _idEstado;
    }

    public void setIdEstado(String _idEstado) {
        this._idEstado = _idEstado;
    }

    public String getIdNivel() {
        return _idNivel;
    }

    public void setIdNivel(String _idNivel) {
        this._idNivel = _idNivel;
    }

    public String getObservaciones() {
        return _observaciones;
    }

    public void setObservaciones(String _observaciones) {
        this._observaciones = _observaciones;
    }

    public String getFecha() {
        return _fecha;
    }

    public void setFecha(String _fecha) {
        this._fecha = _fecha;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }
   
     // </editor-fold>
    
    public String[] crearActualizar(Entrevista datos) {

        try {
            sql = "select *from sp_siged_entrevista_estudiante_crear_actualizar(?, ?, ?, ?, ?, ?, ?, ?, ?);";
            sentencia = Conexion.getConexion().prepareStatement(sql);
            sentencia.setString(1, datos.getAccion());
            sentencia.setInt(2, Integer.parseInt(datos.getId()));
            sentencia.setInt(3, Integer.parseInt(datos.getIdEmpresaSucursal()));
            sentencia.setInt(4, Integer.parseInt(datos.getIdEstudiante()));
            sentencia.setInt(5, Integer.parseInt(datos.getIdPeriodo()));
            sentencia.setString(6, datos.getObservaciones());
            sentencia.setString(7, datos.getIdNivel());
            sentencia.setString(8, datos.getIdEstado());
            sentencia.setString(9, datos.getFecha());
                      

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

    public String eliminar(Entrevista datos) {
        try {
            sql = "select *from sp_siged_eliminar('entrevista_estudiante',?);";
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

}
