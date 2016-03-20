
package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Convenio {
    
    private String _id;
    private String _idViabilidad;
    private String _numero;
    private String _fechaFin;
    private String _fechaSuscripcion;
    private String _observaciones;
    private String _admEmpresaPrincipal;
    private String _admEmpresaSuplente;
    private String _admInstitutoPrincipal;
    private String _admInstitutoSuplente;
    
    //variables auxiliares
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

    public String getIdViabilidad() {
        return _idViabilidad;
    }

    public void setIdViabilidad(String _idViabilidad) {
        this._idViabilidad = _idViabilidad;
    }

    public String getNumero() {
        return _numero;
    }

    public void setNumero(String _numero) {
        this._numero = _numero;
    }

    public String getFechaFin() {
        return _fechaFin;
    }

    public void setFechaFin(String _fechaFin) {
        this._fechaFin = _fechaFin;
    }

    public String getFechaSuscripcion() {
        return _fechaSuscripcion;
    }

    public void setFechaSuscripcion(String _fechaSuscripcion) {
        this._fechaSuscripcion = _fechaSuscripcion;
    }

    
   public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    public String getSql() {
        return _sql;
    }

    public void setSql(String _sql) {
        this._sql = _sql;
    }

    public String getObservaciones() {
        return _observaciones;
    }

    public void setObservaciones(String _observaciones) {
        this._observaciones = _observaciones;
    }

    public String getAdmEmpresaPrincipal() {
        return _admEmpresaPrincipal;
    }

    public void setAdmEmpresaPrincipal(String _admEmpresaPrincipal) {
        this._admEmpresaPrincipal = _admEmpresaPrincipal;
    }

    public String getAdmEmpresaSuplente() {
        return _admEmpresaSuplente;
    }

    public void setAdmEmpresaSuplente(String _admEmpresaSuplente) {
        this._admEmpresaSuplente = _admEmpresaSuplente;
    }

    public String getAdmInstitutoPrincipal() {
        return _admInstitutoPrincipal;
    }

    public void setAdmInstitutoPrincipal(String _admInstitutoPrincipal) {
        this._admInstitutoPrincipal = _admInstitutoPrincipal;
    }

    public String getAdmInstitutoSuplente() {
        return _admInstitutoSuplente;
    }

    public void setAdmInstitutoSuplente(String _admInstitutoSuplente) {
        this._admInstitutoSuplente = _admInstitutoSuplente;
    }

    

// </editor-fold>
    
// <editor-fold defaultstate="collapsed" desc="Métodos">
    public String[] crearActualizar(Convenio datos) { //éste método crea y modifica a la misma vez

        try {
            this._sql = "select * from sp_siged_convenio_crear_actualizar( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
            sentencia = Conexion.getConexion().prepareStatement(this._sql);

            sentencia.setString(1, datos.getAccion());
            
            sentencia.setInt(2, Integer.parseInt(datos.getId()));
            sentencia.setInt(3, Integer.parseInt(datos.getIdViabilidad()));
            sentencia.setString(4, datos.getNumero());
            sentencia.setString(5, datos.getFechaFin());
            sentencia.setString(6, datos.getFechaSuscripcion());
            sentencia.setString(7, datos.getObservaciones());
            sentencia.setString(8, datos.getAdmEmpresaPrincipal());
            sentencia.setString(9, datos.getAdmEmpresaSuplente());
            sentencia.setString(10, datos.getAdmInstitutoPrincipal());
            sentencia.setString(11, datos.getAdmInstitutoSuplente());
            
            System.out.println(sentencia);//Imprimir la consulta
            resultadoQuery = sentencia.executeQuery(); //ejecuta la consulta
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

    public String eliminar(Convenio datos) {
        try {
            this._sql = "select * from sp_siged_eliminar('convenio',?);";
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
