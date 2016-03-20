package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Asignatura {

    private String _id;
    private String _idCarrera;
    private String _nombre;
    private String _resultadoAprendizaje;
    private String _equipamiento;
    private String _similitud;

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

    public String getIdCarrera() {
        return _idCarrera;
    }

    public void setIdCarrera(String _idCarrera) {
        this._idCarrera = _idCarrera;
    }

    public String getNombre() {
        return _nombre;
    }

    public void setNombre(String _nombre) {
        this._nombre = _nombre;
    }

    public String getResultadoAprendizaje() {
        return _resultadoAprendizaje;
    }

    public void setResultadoAprendizaje(String _resultadoAprendizaje) {
        this._resultadoAprendizaje = _resultadoAprendizaje;
    }

    public String getEquipamiento() {
        return _equipamiento;
    }

    public void setEquipamiento(String _equipamiento) {
        this._equipamiento = _equipamiento;
    }

    public String getSimilitud() {
        return _similitud;
    }

    public void setSimilitud(String _similitud) {
        this._similitud = _similitud;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }
 // </editor-fold>
    
    public String[] crearActualizar(Asignatura datos) {

        try {
            sql = "select *from sp_siged_asignatura_crear_actualizar(?, ?, ?, ?, ?, ?, ?);";
            sentencia = Conexion.getConexion().prepareStatement(sql);
            sentencia.setString(1, datos.getAccion());
            sentencia.setInt(2, Integer.parseInt(datos.getId()));
            sentencia.setInt(3, Integer.parseInt(datos.getIdCarrera()));
            sentencia.setString(4, datos.getNombre());
            sentencia.setString(5, datos.getResultadoAprendizaje());
            sentencia.setString(6, datos.getEquipamiento());
            sentencia.setString(7, datos.getSimilitud());
            

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

    public String eliminar(Asignatura datos) {
        try {
            sql = "select *from sp_siged_eliminar('asignatura',?);";
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
