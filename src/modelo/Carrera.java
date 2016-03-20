package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Carrera {

    private String _id;
    private String _idInstituto;
    private String _idPersona;
    private String _nombre;
    private String _descripcion;
    private String _fecha;
    private String _numeroResolucion;

    private String accion;
    private boolean bandera;
    private String sql;
    PreparedStatement sentencia;
    ResultSet resultadoQuery;
    private final String respuesta[] = new String[3];

    // <editor-fold defaultstate="collapsed" desc="Getters and Setters">
    public String getId() {
        return _id;
    }

    public void setId(String _id) {
        this._id = _id;
    }

    public String getIdInstituto() {
        return _idInstituto;
    }

    public void setIdInstituto(String _idInstituto) {
        this._idInstituto = _idInstituto;
    }

    public String getNombre() {
        return _nombre;
    }

    public void setNombre(String _nombre) {
        this._nombre = _nombre;
    }

    public String getDescripcion() {
        return _descripcion;
    }

    public void setDescripcion(String _descripcion) {
        this._descripcion = _descripcion;
    }

    public String getFecha() {
        return _fecha;
    }

    public void setFecha(String _fecha) {
        this._fecha = _fecha;
    }

    public String getNumeroResolucion() {
        return _numeroResolucion;
    }

    public void setNumeroResolucion(String _numeroResolucion) {
        this._numeroResolucion = _numeroResolucion;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }
   
    public String getIdPersona() {
        return _idPersona;
    }

    public void setIdPersona(String _idPersona) {
        this._idPersona = _idPersona;
    }
     // </editor-fold>
    
    public String[] crearActualizar(Carrera datos) {

        try {
            sql = "select *from sp_siged_carrera_crear_actualizar(?, ?, ?, ?, ?, ?, ?, ?);"; //aumentar una signo de interrogacion por el carid
            sentencia = Conexion.getConexion().prepareStatement(sql);

            sentencia.setString(1, datos.getAccion());
            sentencia.setInt(2, Integer.parseInt(datos.getId()));
            sentencia.setInt(3, Integer.parseInt(datos.getIdInstituto()));
            sentencia.setInt(4, Integer.parseInt(datos.getIdPersona()));
            sentencia.setString(5, datos.getNombre());
            sentencia.setString(6, datos.getDescripcion());
            sentencia.setString(7, datos.getFecha());
            sentencia.setString(8, datos.getNumeroResolucion());//le puse ya que me permite aumentar un campo mas

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

    public String eliminar(Carrera datos) {
        try {
            sql = "select *from sp_siged_eliminar('carrera',?);";
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
