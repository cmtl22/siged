
package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Usuario
 */
public class EscenarioViabilidad {
    
    
    
    private String _id;
    private String _idViabilidad;
    private String _tipo;
    private String _numeroEstudiantes;
    private String _observaciones;    
    private String _actividades;
    private String _equipamiento;

    //variables auxiliares
    private String accion; 
    private boolean bandera; 
    private String _sql;
    PreparedStatement sentencia;
    ResultSet resultadoQuery;
    private final String respuesta[] = new String[3];
    
// <editor-fold defaultstate="collapsed" desc="Geters y Seters">

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

    public String getTipo() {
        return _tipo;
    }

    public void setTipo(String _tipo) {
        this._tipo = _tipo;
    }

    public String getNumeroEstudiantes() {
        return _numeroEstudiantes;
    }

    public void setNumeroEstudiantes(String _numeroEstudiantes) {
        this._numeroEstudiantes = _numeroEstudiantes;
    }

    public String getObservaciones() {
        return _observaciones;
    }

    public void setObservaciones(String _observaciones) {
        this._observaciones = _observaciones;
    }

    public String getActividades() {
        return _actividades;
    }

    public void setActividades(String _actividades) {
        this._actividades = _actividades;
    }

    public String getEquipamiento() {
        return _equipamiento;
    }

    public void setEquipamiento(String _equipamiento) {
        this._equipamiento = _equipamiento;
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
    
    // </editor-fold>
    
// <editor-fold defaultstate="collapsed" desc="Métodos">
    public String[] crearActualizar(EscenarioViabilidad datos) { //éste método crea y modifica a la misma vez

        try {
            this._sql = "select * from sp_siged_escenario_viabilidad_crear_actualizar_escenario_viabilidad( ?, ?, ?, ?, ?, ?, ?);";
            sentencia = Conexion.getConexion().prepareStatement(this._sql);

            sentencia.setString(1, datos.getAccion());
            
            sentencia.setInt(2, Integer.parseInt(datos.getId()));
            sentencia.setInt(3, Integer.parseInt(datos.getIdViabilidad()));
            sentencia.setString(4, datos.getTipo());
            sentencia.setInt(5, Integer.parseInt(datos.getNumeroEstudiantes()));
            sentencia.setString(6, datos.getObservaciones());
            sentencia.setInt(7, Integer.parseInt(datos.getActividades()));
            sentencia.setString(6, datos.getObservaciones());
            

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

    public String eliminar(EscenarioViabilidad datos) {
        try {
            this._sql = "select * from sp_siged_eliminar('escenario_viabilidad',?);";
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
