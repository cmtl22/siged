package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import controlador.controladorVariablesSesion;

public class Usuario {

    private String _id;
    private String _idPersona;
    private String _idRol;
    private String _nombre;
    private String _clave;

    private String accion;
    private boolean bandera;
    private String sql;
    private PreparedStatement sentencia;
    private ResultSet resultadoQuery;
    private final String respuesta[] = new String[6];

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

    public String getIdRol() {
        return _idRol;
    }

    public void setIdRol(String _idRol) {
        this._idRol = _idRol;
    }

    public String getNombre() {
        return _nombre;
    }

    public void setNombre(String _nombre) {
        this._nombre = _nombre;
    }

    public String getClave() {
        return _clave;
    }

    public void setClave(String _clave) {
        this._clave = _clave;
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

    public String[] crearActualizar(Usuario datos) {

        try {
            sql = "select *from sp_siged_usuario_crear_actualizar(?, ?, ?, ?, ?, ?,?,?);";
            sentencia = Conexion.getConexion().prepareStatement(sql);
            sentencia.setString(1, datos.getAccion());
            sentencia.setInt(2, Integer.parseInt(datos.getId()));
            sentencia.setInt(3, Integer.parseInt(datos.getIdPersona()));
            sentencia.setInt(4, Integer.parseInt(datos.getIdRol()));
            sentencia.setString(5, datos.getNombre());
            sentencia.setString(6, datos.getClave());
            sentencia.setInt(7, Integer.parseInt(controladorVariablesSesion.getInstance().getCodigoUsuario()));
            sentencia.setString(8, sentencia.toString());

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

    public String eliminar(Usuario datos) {
        try {
            sql = "select *from sp_siged_eliminar('usuario',?);";
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

    public String[] validarUsuario(Usuario datos) {
        try {

            sql = "select *from sp_siged_usuario_validar(?,?);";
            sentencia = Conexion.getConexion().prepareStatement(sql);
            sentencia.setString(1, datos.getNombre());
            sentencia.setString(2, datos.getClave());
            System.out.println(sentencia);
            resultadoQuery = sentencia.executeQuery();

            resultadoQuery.next();
            respuesta[0] = resultadoQuery.getString(1);//id del usuario
            respuesta[1] = resultadoQuery.getString(2);//rol del usuario
            respuesta[2] = resultadoQuery.getString(3);//existe el usuario
            respuesta[3] = resultadoQuery.getString(4);//correo
            respuesta[4] = resultadoQuery.getString(5);//intentos restantes
            respuesta[5] = resultadoQuery.getString(6);//intentos restantes
            System.out.println("\n" + "\n" + "\n" + "\n");
            System.out.println(resultadoQuery.getString(1) + "\n");
            System.out.println(resultadoQuery.getString(2) + "\n");
            System.out.println(resultadoQuery.getString(3) + "\n");
            System.out.println(resultadoQuery.getString(4) + "\n");
            System.out.println(resultadoQuery.getString(5) + "\n");
            sentencia.close();
            return respuesta;
        } catch (SQLException ex) {
            return null;
        }
    }

    public String[] bloquearUsuario(Usuario datos) {
        try {
            sql = "select *from sp_siged_usuario_bloquear(?);";
            sentencia = Conexion.getConexion().prepareStatement(sql);
            sentencia.setString(1, datos.getNombre());
            resultadoQuery = sentencia.executeQuery();
            resultadoQuery.next();
            respuesta[0] = resultadoQuery.getString(1);

            sentencia.close();
            return respuesta;
        } catch (SQLException ex) {
            return null;
        }
    }

    public String[] recuperarClave(Usuario datos) {
        try {
            sql = "select *from sp_siged_usuario_recuperar_clave(?);";
            sentencia = Conexion.getConexion().prepareStatement(sql);
            sentencia.setString(1, datos.getNombre());
            resultadoQuery = sentencia.executeQuery();
            resultadoQuery.next();
            respuesta[0] = resultadoQuery.getString(1);

            sentencia.close();
            return respuesta;
        } catch (SQLException ex) {
            return null;
        }
    }

    public String[] cambiarClave(Usuario datos) {
        try {
            sql = "select *from sp_siged_usuario_cambiar_clave(?,?);";
            sentencia = Conexion.getConexion().prepareStatement(sql);
            sentencia.setInt(1, Integer.parseInt(datos.getId()));
            sentencia.setString(2, datos.getClave());
            System.out.println(sentencia);
            resultadoQuery = sentencia.executeQuery();
            resultadoQuery.next();
            respuesta[0] = resultadoQuery.getString(1);
            respuesta[1] = resultadoQuery.getString(2);
            respuesta[2] = resultadoQuery.getString(3);

            sentencia.close();
            return respuesta;
        } catch (SQLException ex) {
            return null;
        }
    }

}
