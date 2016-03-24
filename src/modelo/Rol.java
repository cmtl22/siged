package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Rol {

    private String _id;
    private String _nombre;
    private int[] _idModulos;

    private String accion;
    private boolean bandera;
    private String sql;
    private PreparedStatement sentencia;
    private ResultSet resultadoQuery;
    private final String respuesta[] = new String[3];

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

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    public int[] getIdModulos() {
        return _idModulos;
    }

    public void setIdModulos(int[] _idModulos) {
        this._idModulos = _idModulos;
    }

    public String[] crearActualizar(Rol datos) {
        try {
            PostgreSQLInt4Array modulos = new PostgreSQLInt4Array(datos.getIdModulos());

            sql = "select *from sp_siged_rol_crear_actualizar(?, ?, ?,?);";
            sentencia = Conexion.getConexion().prepareStatement(sql);
            sentencia.setString(1, datos.getAccion());
            sentencia.setInt(2, Integer.parseInt(datos.getId()));
            sentencia.setString(3, datos.getNombre());
            sentencia.setArray(4, modulos);

            System.out.println(sentencia);
            resultadoQuery = sentencia.executeQuery();
            resultadoQuery.next();
            respuesta[0] = resultadoQuery.getString(1);
            respuesta[1] = resultadoQuery.getString(2);
            respuesta[2] = resultadoQuery.getString(3);
            System.out.println("1: " + resultadoQuery.getString(1) + "\n2: " + resultadoQuery.getString(2) + "\n3: " + resultadoQuery.getString(3));
            sentencia.close();
            return respuesta;

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

    public String eliminar(Rol datos) {
        try {
            sql = "select *from sp_siged_eliminar('rol',?);";
            sentencia = Conexion.getConexion().prepareStatement(sql);
            sentencia.setInt(1, Integer.parseInt(datos.getId()));
            resultadoQuery = sentencia.executeQuery();
            resultadoQuery.next();
            respuesta[1] = resultadoQuery.getString(2);
            sentencia.close();
            return respuesta[1];
        } catch (SQLException ex) {
            return null;
        }
    }

}
