
package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Ubicacion {
    
      
    private String _id;
    private String _pais;
    private String _provincia;
    private String _canton;
    private String _ciudad;
    private String _sector;
    private String _referencia;
    private String _callePrincipal;
    private String _calleInterseccion;
    private String _numero;
      
    private String accion;
    private boolean bandera;
    private String sql;
    private PreparedStatement sentencia;
    private ResultSet resultadoQuery;
    private final String respuesta[] = new String[3];
    
// <editor-fold defaultstate="collapsed" desc="Getters y setters">

    public String getId() {
        return _id;
    }

    public void setId(String _id) {
        this._id = _id;
    }

    public String getPais() {
        return _pais;
    }

    public void setPais(String _pais) {
        this._pais = _pais;
    }

    public String getProvincia() {
        return _provincia;
    }

    public void setProvincia(String _provincia) {
        this._provincia = _provincia;
    }

    public String getCanton() {
        return _canton;
    }

    public void setCanton(String _canton) {
        this._canton = _canton;
    }

    public String getCiudad() {
        return _ciudad;
    }

    public void setCiudad(String _ciudad) {
        this._ciudad = _ciudad;
    }

    public String getSector() {
        return _sector;
    }

    public void setSector(String _sector) {
        this._sector = _sector;
    }

    public String getReferencia() {
        return _referencia;
    }

    public void setReferencia(String _referencia) {
        this._referencia = _referencia;
    }

    public String getCallePrincipal() {
        return _callePrincipal;
    }

    public void setCallePrincipal(String _callePrincipal) {
        this._callePrincipal = _callePrincipal;
    }

    public String getCalleInterseccion() {
        return _calleInterseccion;
    }

    public void setCalleInterseccion(String _calleInterseccion) {
        this._calleInterseccion = _calleInterseccion;
    }

    public String getNumero() {
        return _numero;
    }

    public void setNumero(String _numero) {
        this._numero = _numero;
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
    
    
// <editor-fold defaultstate="collapsed" desc="Métodos">
   public String[] crearActualizar(Ubicacion datos) {

        try {
            sql = "select * from sp_siged_ubicacion_crear_actualizar(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
            
            sentencia = Conexion.getConexion().prepareStatement(sql);
            
            sentencia.setString(1, datos.getAccion());
            sentencia.setInt(2, Integer.parseInt(datos.getId()));
            sentencia.setString(3, datos.getPais());
            sentencia.setString(4, datos.getProvincia());
            sentencia.setString(5, datos.getCanton());
            sentencia.setString(6, datos.getCiudad());
            sentencia.setString(7, datos.getSector());
            sentencia.setString(8, datos.getReferencia());
            sentencia.setString(9, datos.getCallePrincipal());
            sentencia.setString(10, datos.getCalleInterseccion());
            sentencia.setString(11, datos.getNumero());

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

    public String eliminar(Ubicacion datos) {
        try {
            sql = "select * from sp_siged_eliminar('ubicacion',?);";
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
    // </editor-fold>
    
}
