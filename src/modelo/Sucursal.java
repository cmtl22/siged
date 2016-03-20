
package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Sucursal {
          // esto es de la abla ubicacion
    private String _id;
    private String _idEmpresa;
    private String _idUbicacion;
    private String _nombre;
    private String _tipo;
    
         
    private String accion;
    private boolean bandera;
    private String sql;
    private PreparedStatement sentencia;
    private ResultSet resultadoQuery;
    private final String respuesta[] = new String[3];
    
    

    // <editor-fold defaultstate="collapsed" desc="Getters y setters">
    public String getTipo() {
        return _tipo;
    }
    
    public void setTipo(String _tipo) {
        this._tipo = _tipo;
    }

    public String getId() {
        return _id;
    }

    public void setId(String _id) {
        this._id = _id;
    }

    public String getIdEmpresa() {
        return _idEmpresa;
    }

    public void setIdEmpresa(String _idEmpresa) {
        this._idEmpresa = _idEmpresa;
    }

    public String getIdUbicacion() {
        return _idUbicacion;
    }

    public void setIdUbicacion(String _idUbicacion) {
        this._idUbicacion = _idUbicacion;
    }

    public String getNombre() {
        return _nombre;
    }

    public void setNombre(String _nombre) {
        this._nombre = _nombre;
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
   public String[] crearActualizar(Sucursal datosSucursal, Ubicacion datosUbicacion) {

        try {
            sql = "select * from sp_siged_empresa_sucursal_crear_actualizar(?, ?, ?, ?, ?, ?,? ,? ,? ,? ,? ,? ,? ,?, ?);";
            
            sentencia = Conexion.getConexion().prepareStatement(sql);
            
            sentencia.setString(1, datosSucursal.getAccion());
            
            sentencia.setInt(2, Integer.parseInt(datosSucursal.getId()));
            sentencia.setInt(3, Integer.parseInt(datosSucursal.getIdEmpresa()));
            sentencia.setInt(4, Integer.parseInt(datosSucursal.getIdUbicacion()));
            sentencia.setString(5, datosSucursal.getNombre());
            sentencia.setString(6, datosSucursal.getTipo());
            sentencia.setString(7, datosUbicacion.getPais());
            sentencia.setString(8, datosUbicacion.getProvincia());
            sentencia.setString(9, datosUbicacion.getCanton());
            sentencia.setString(10, datosUbicacion.getCiudad());
            sentencia.setString(11, datosUbicacion.getSector());
            sentencia.setString(12, datosUbicacion.getReferencia());            
            sentencia.setString(13, datosUbicacion.getCallePrincipal());
            sentencia.setString(14, datosUbicacion.getCalleInterseccion());
            sentencia.setString(15, datosUbicacion.getNumero());
            
            
            

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

    public String eliminar(Sucursal datos) {
        try {
            sql = "select * from sp_siged_eliminar('empresa_sucursal',?);";
            sentencia = Conexion.getConexion().prepareStatement(sql);
            sentencia.setInt(1, Integer.parseInt(datos.getId()));
            resultadoQuery = sentencia.executeQuery();
            System.out.println(sentencia);
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
