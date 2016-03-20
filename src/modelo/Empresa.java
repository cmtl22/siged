
package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class Empresa {
    
    private String _id;
    private String _ruc;
    private String _nombreComercial;
    private String _razonSocial;
    private String _tipo;
    private String _actividadEconomica;
    private String _telefono;
    private String _correo;
    
    private String _archivos;
    private String _ruta;
    private String _descripcion;
   
    private String accion;
    private boolean bandera;
    private String _sql;
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

    public String getRuc() {
        return _ruc;
    }

    public void setRuc(String _ruc) {
        this._ruc = _ruc;
    }

    public String getNombreComercial() {
        return _nombreComercial;
    }

    public void setNombreComercial(String _nombreComercial) {
        this._nombreComercial = _nombreComercial;
    }

    public String getRazonSocial() {
        return _razonSocial;
    }

    public void setRazonSocial(String _razonSocial) {
        this._razonSocial = _razonSocial;
    }

    public String getTipo() {
        return _tipo;
    }

    public void setTipo(String _tipo) {
        this._tipo = _tipo;
    }

    public String getActividadEconomica() {
        return _actividadEconomica;
    }

    public void setActividadEconomica(String _actividadEconomica) {
        this._actividadEconomica = _actividadEconomica;
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
        return _sql;
    }

    public void setSql(String _sql) {
        this._sql = _sql;
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
    
    
    
    // </editor-fold> 
    
    // <editor-fold defaultstate="collapsed" desc="Métodos">
    public String[] crearActualizar(Empresa datos) {

        try {
            this._sql = "select * from sp_siged_empresa_crear_actualizar(?, ?, ?, ?, ?, ?, ?, ?, ?);";
           
            sentencia = Conexion.getConexion().prepareStatement(this._sql);
            
            sentencia.setString(1, datos.getAccion());
            sentencia.setInt(2, Integer.parseInt(datos.getId()));
            sentencia.setString(3, datos.getRuc());
            sentencia.setString(4, datos.getNombreComercial());
            sentencia.setString(5, datos.getRazonSocial());
            sentencia.setString(6, datos.getTipo());
            sentencia.setString(7, datos.getActividadEconomica());
            sentencia.setString(8, datos.getTelefono());
            sentencia.setString(9, datos.getCorreo());

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

    public String eliminar(Empresa datos) {
        try {
            this._sql = "select * from sp_siged_empresa_eliminar(?);";
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
    // </editor-fold>
    
}
