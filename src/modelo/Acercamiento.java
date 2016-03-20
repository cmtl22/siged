package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Acercamiento {

    private String _id;
    private String _idEmpresaSucursal;
    private String _fecha;
    private String _observaciones;
    private String _idEstadoAcercamiento;

    private String accion;
    private boolean bandera;
    private String sql;
    private PreparedStatement sentencia;
    private ResultSet resultadoQuery;
    private final String respuesta[] = new String[3];

    // <editor-fold defaultstate="collapsed" desc="Getters and Setters">
    public String getIdEstadoAcercamiento() {
        return _idEstadoAcercamiento;
    }

    public void setIdEstadoAcercamiento(String _idEstadoAcercamiento) {
        this._idEstadoAcercamiento = _idEstadoAcercamiento;
    }

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

    public String getFecha() {
        return _fecha;
    }

    public void setFecha(String _fecha) {
        this._fecha = _fecha;
    }

    public String getObservaciones() {
        return _observaciones;
    }

    public void setObservaciones(String _observaciones) {
        this._observaciones = _observaciones;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }
 // </editor-fold>
    
    public String[] crearActualizar(Acercamiento datos) {

        try {
            sql = "select *from sp_siged_acercamiento_crear_actualizar(?, ?, ?, ?, ?, ?);";
            sentencia = Conexion.getConexion().prepareStatement(sql);
            sentencia.setString(1, datos.getAccion());
            sentencia.setInt(2, Integer.parseInt(datos.getId()));
            sentencia.setInt(3, Integer.parseInt(datos.getIdEmpresaSucursal()));
            sentencia.setString(4, datos.getFecha());
            sentencia.setString(5, datos.getObservaciones());
            sentencia.setString(6, datos.getIdEstadoAcercamiento());

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

    public String eliminar(Acercamiento datos) {
        try {
            sql = "select *from sp_siged_eliminar('acercamiento',?);";
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
