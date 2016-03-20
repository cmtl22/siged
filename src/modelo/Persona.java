package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Persona {

    private String _id;
    private String _tipoIdentificacion;
    private String _idCarreraEmpresa;
    private String _numeroIdentificacion;
    private String _nombres;
    private String _apellidos;
    private String _fechaNacimiento;
    private String _direccion;
    private String _telefonoFijo;
    private String _telefonoCelular;
    private String _correo;
    private String _tipo;
    private String _formacionAcademica;
    private String _informacionAdicional;
    private String _genero;
    private String _tipoGeneral;

    private String accion;
    private boolean bandera;
    private String sql;
    private PreparedStatement sentencia;
    private ResultSet resultadoQuery;
    private final String respuesta[] = new String[3];
    
    
    
    // <editor-fold defaultstate="collapsed" desc="Getters and Setters">

    public String getId() {
        return _id;
    }

    public void setId(String _id) {
        this._id = _id;
    }

    public String getIdCarreraEmpresa() {
        return _idCarreraEmpresa;
    }

    public void setIdCarreraEmpresa(String _idCarreraEmpresa) {
        this._idCarreraEmpresa = _idCarreraEmpresa;
    }

    public String getTipoIdentificacion() {
        return _tipoIdentificacion;
    }

    public void setTipoIdentificacion(String _tipoIdentificacion) {
        this._tipoIdentificacion = _tipoIdentificacion;
    }

    public String getNumeroIdentificacion() {
        return _numeroIdentificacion;
    }

    public void setNumeroIdentificacion(String _numeroIdentificacion) {
        this._numeroIdentificacion = _numeroIdentificacion;
    }

    public String getNombres() {
        return _nombres;
    }

    public void setNombres(String _nombres) {
        this._nombres = _nombres;
    }

    public String getApellidos() {
        return _apellidos;
    }

    public void setApellidos(String _apellidos) {
        this._apellidos = _apellidos;
    }

    public String getFechaNacimiento() {
        return _fechaNacimiento;
    }

    public void setFechaNacimiento(String _fechaNacimiento) {
        this._fechaNacimiento = _fechaNacimiento;
    }

    public String getDireccion() {
        return _direccion;
    }

    public void setDireccion(String _direccion) {
        this._direccion = _direccion;
    }

    public String getTelefonoFijo() {
        return _telefonoFijo;
    }

    public void setTelefonoFijo(String _telefonoFijo) {
        this._telefonoFijo = _telefonoFijo;
    }

    public String getTelefonoCelular() {
        return _telefonoCelular;
    }

    public void setTelefonoCelular(String _telefonoCelular) {
        this._telefonoCelular = _telefonoCelular;
    }

    public String getCorreo() {
        return _correo;
    }

    public void setCorreo(String _correo) {
        this._correo = _correo;
    }

    public String getTipo() {
        return _tipo;
    }

    public void setTipo(String _tipo) {
        this._tipo = _tipo;
    }


    public String getFormacionAcademica() {
        return _formacionAcademica;
    }

    public void setFormacionAcademica(String _formacionAcademica) {
        this._formacionAcademica = _formacionAcademica;
    }

    public String getInformacionAdicional() {
        return _informacionAdicional;
    }

    public void setInformacionAdicional(String _informacionAdicional) {
        this._informacionAdicional = _informacionAdicional;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    public String getTipoGeneral() {
        return _tipoGeneral;
    }

    public void setTipoGeneral(String _tipoGeneral) {
        this._tipoGeneral = _tipoGeneral;
    }

    public String getGenero() {
        return _genero;
    }

    public void setGenero(String _genero) {
        this._genero = _genero;
    }
    
    
    
// </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Métodos">
    public String[] crearActualizar(Persona datos) {

        try {
            sql = "select * from sp_siged_persona_crear_actualizar(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
            
            sentencia = Conexion.getConexion().prepareStatement(sql);

            sentencia.setString(1, datos.getAccion());
            sentencia.setInt(2, Integer.parseInt(datos.getId()));
            sentencia.setInt(3, Integer.parseInt(datos.getIdCarreraEmpresa()));
            sentencia.setString(4, datos.getTipoIdentificacion());             
            sentencia.setString(5, datos.getNumeroIdentificacion());
            sentencia.setString(6, datos.getNombres());
            sentencia.setString(7, datos.getApellidos());
            sentencia.setString(8, datos.getFechaNacimiento());
            sentencia.setString(9, datos.getDireccion());
            sentencia.setString(10, datos.getTelefonoFijo());
            sentencia.setString(11, datos.getTelefonoCelular());
            sentencia.setString(12, datos.getCorreo());
            sentencia.setString(13, datos.getTipo());
            sentencia.setString(14, datos.getFormacionAcademica());
            sentencia.setString(15, datos.getInformacionAdicional());
            sentencia.setString(16, datos.getTipoGeneral());
            sentencia.setString(17, datos.getGenero());

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

    public String eliminar(Persona datos) {
        try {
            sql = "select * from sp_siged_eliminar('persona',?);";
            sentencia = Conexion.getConexion().prepareStatement(sql);
            sentencia.setInt(1, Integer.parseInt(datos.getId()));
            System.out.println(sentencia);
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
