package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Instituto {

    private String _id;
    private String _idPersona;
    private String _nombre;
    private String _direccion;
    private String _telefono;
    private String _correo;
    private String _siglas;
    private String _coordinacionZonal;
    private String _fechaCreacion;
    private String _creacionResolucion;
    private String _secuencialViabilidad;

    private String _archivos;
    private String _ruta;
    private String _descripcion;

    private String accion;
    private boolean bandera;
    private String sql;
    private PreparedStatement sentencia;
    private ResultSet resultadoQuery;
    private final String respuesta[] = new String[3];

    // <editor-fold defaultstate="collapsed" desc="Getters and Setters">
    public String getSecuencialViabilidad() {
        return _secuencialViabilidad;
    }

    public void setSecuencialViabilidad(String _secuencialViabilidad) {
        this._secuencialViabilidad = _secuencialViabilidad;
    }

    public String getId() {
        return _id;
    }

    public void setId(String _id) {
        this._id = _id;
    }

    public String getIdPersona() {
        return _idPersona;
    }

    public void setIdPersona(String _idPersona) {
        this._idPersona = _idPersona;
    }

    public String getNombre() {
        return _nombre;
    }

    public void setNombre(String _nombre) {
        this._nombre = _nombre;
    }

    public String getDireccion() {
        return _direccion;
    }

    public void setDireccion(String _direccion) {
        this._direccion = _direccion;
    }

    public String getTelefono() {
        return _telefono;
    }

    public void setTelefono(String _telefono) {
        this._telefono = _telefono;
    }

    public String getCorreo() {
        return _correo;
    }

    public void setCorreo(String _correo) {
        this._correo = _correo;
    }

    public String getSiglas() {
        return _siglas;
    }

    public void setSiglas(String _siglas) {
        this._siglas = _siglas;
    }

    public String getCoordinacionZonal() {
        return _coordinacionZonal;
    }

    public void setCoordinacionZonal(String _coordinacionZonal) {
        this._coordinacionZonal = _coordinacionZonal;
    }

    public String getFechaCreacion() {
        return _fechaCreacion;
    }

    public void setFechaCreacion(String _fechaCreacion) {
        this._fechaCreacion = _fechaCreacion;
    }

    public String getCreacionResolucion() {
        return _creacionResolucion;
    }

    public void setCreacionResolucion(String _creacionResolucion) {
        this._creacionResolucion = _creacionResolucion;
    }

    public String getArchivos() {
        return _archivos;
    }

    public void setArchivos(String _archivos) {
        this._archivos = _archivos;
    }

    public String getRuta() {
        return _ruta;
    }

    public void setRuta(String _ruta) {
        this._ruta = _ruta;
    }

    public String getDescripcion() {
        return _descripcion;
    }

    public void setDescripcion(String _descripcion) {
        this._descripcion = _descripcion;
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

    public void setSql(String _sql) {
        this.sql = _sql;
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
    
    public String[] crearActualizar(Instituto datos) {

        try {
            sql = "select *from sp_siged_instituto_crear_actualizar(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
            sentencia = Conexion.getConexion().prepareStatement(sql);

            sentencia.setString(1, datos.getAccion());
            sentencia.setInt(2, Integer.parseInt(datos.getId()));
            sentencia.setInt(3, Integer.parseInt(datos.getIdPersona()));
            sentencia.setString(4, datos.getNombre());
            sentencia.setString(5, datos.getDireccion());
            sentencia.setString(6, datos.getTelefono());
            sentencia.setString(7, datos.getCorreo());
            sentencia.setString(8, datos.getSiglas());
            sentencia.setString(9, datos.getCoordinacionZonal());
            sentencia.setString(10, datos.getFechaCreacion());
            sentencia.setString(11, datos.getCreacionResolucion());
            //sentencia.setInt(12, Integer.parseInt(datos.getSecuencialViabilidad()));

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

    public String eliminar(Instituto datos) {
        try {
            sql = "select *from sp_siged_eliminar('instituto',?);";
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
