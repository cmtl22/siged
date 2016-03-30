package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Configuraciones {

    private String _id;
    private String _nombre;
    private String _valor;

    private String accion;
    private boolean bandera;
    private String sql;
    private PreparedStatement sentencia;
    private ResultSet resultadoQuery;
    private String[] respuesta = new String[3];

    ;

    public String getId() {
        return _id;
    }

    public void setId(String _id) {
        this._id = _id;
    }

    public String getNombre() {
        return _nombre;
    }

    public void setNombre(String _nombre) {
        this._nombre = _nombre;
    }

    public String getValor() {
        return _valor;
    }

    public void setValor(String _valor) {
        this._valor = _valor;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    public String[] crearActualizar(Configuraciones datos) {

        try {
            sql = "select *from sp_siged_configuraciones_crear_actualizar(?, ?, ?, ?);";
            sentencia = Conexion.getConexion().prepareStatement(sql);
            sentencia.setString(1, datos.getAccion());
            sentencia.setInt(2, Integer.parseInt(datos.getId()));
            sentencia.setString(3, datos.getNombre());
            sentencia.setString(4, datos.getValor());

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

    public String eliminar(Configuraciones datos) {
        try {
            sql = "select sp_siged_eliminar('enumeracion',?);";
            sentencia = Conexion.getConexion().prepareStatement(sql);
            sentencia.setInt(1, Integer.parseInt(datos.getId()));
            resultadoQuery = sentencia.executeQuery();
            resultadoQuery.next();
            respuesta[1] = resultadoQuery.getString(1);
            sentencia.close();
            return respuesta[1];
        } catch (SQLException ex) {
            return null;
        }
    }

}
