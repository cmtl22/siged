/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ITS Aloasi
 */
public class Viabilidad {
    
    

    //declaración de variables de la clase Viabilidad
    private String _id;
    private String _emprId;
    private String _numeroInforme;
    private String _fechaInforme;
    private String _asunto;
    private String _constatación;
    private String _deudaSri;
    private String _deudaIess;
    private String _deudaSercop;
    private String _deudaSupIntendencia;
    private String _observacionesDeudas;
    private String _recomendaciones;
    private String _fechaPrimerAcerc;
    private String _docuAcercamiento;
    private String _observacionesInforme;
    private String _numEstudiantes;
    private String _cantidadTutores;
    private String _plazo;
    private String _renuevaConvenio;
    private String _observacionesRenovacion;
    private String _administradorInst;
    private String _administradorEmpr;
    private String _procesoDesignacion;
    private String _uniformes;
    private String _equipoProteccion;
    private String _normasSeguridad;
    private String _observacionesCondiciones;
    private String _compensacion;
    private String _compensacionTipo;
    private String _compensacionCondiciones;
    private String _elaborado;
    private String _revisado;
    private String _aprobado;
    private String _estadoTramite;
    private String _idCarrera;
    
    //variables auxiliares
    private String accion; 
    private boolean bandera; 
    private String _sql;
    PreparedStatement sentencia;
    ResultSet resultadoQuery;
    private final String respuesta[] = new String[3];
    
// <editor-fold defaultstate="collapsed" desc="Getters and Setters">

    public String getIdCarrera() {
        return _idCarrera;
    }

    public void setIdCarrera(String _idCarrera) {
        this._idCarrera = _idCarrera;
    }
    

    
    
    public String getId() {
        return _id;
    }

    public void setId(String _id) {
        this._id = _id;
    }

    public String getEmprId() {
        return _emprId;
    }

    public void setEmprId(String _emprId) {
        this._emprId = _emprId;
    }

    public String getNumeroInforme() {
        return _numeroInforme;
    }

    public void setNumeroInforme(String _numeroInforme) {
        this._numeroInforme = _numeroInforme;
    }

    public String getFechaInforme() {
        return _fechaInforme;
    }

    public void setFechaInforme(String _fechaInforme) {
        this._fechaInforme = _fechaInforme;
    }

    public String getAsunto() {
        return _asunto;
    }

    public void setAsunto(String _asunto) {
        this._asunto = _asunto;
    }

    public String getConstatación() {
        return _constatación;
    }

    public void setConstatación(String _constatación) {
        this._constatación = _constatación;
    }

    public String getDeudaSri() {
        return _deudaSri;
    }

    public void setDeudaSri(String _deudaSri) {
        this._deudaSri = _deudaSri;
    }

    public String getDeudaIess() {
        return _deudaIess;
    }

    public void setDeudaIess(String _deudaIess) {
        this._deudaIess = _deudaIess;
    }

    public String getDeudaSercop() {
        return _deudaSercop;
    }

    public void setDeudaSercop(String _deudaSercop) {
        this._deudaSercop = _deudaSercop;
    }

    public String getDeudaSupIntendencia() {
        return _deudaSupIntendencia;
    }

    public void setDeudaSupIntendencia(String _deudaSupIntendencia) {
        this._deudaSupIntendencia = _deudaSupIntendencia;
    }

    public String getObservacionesDeudas() {
        return _observacionesDeudas;
    }

    public void setObservacionesDeudas(String _observacionesDeudas) {
        this._observacionesDeudas = _observacionesDeudas;
    }

    public String getRecomendaciones() {
        return _recomendaciones;
    }

    public void setRecomendaciones(String _recomendaciones) {
        this._recomendaciones = _recomendaciones;
    }

    public String getFechaPrimerAcerc() {
        return _fechaPrimerAcerc;
    }

    public void setFechaPrimerAcerc(String _fechaPrimerAcerc) {
        this._fechaPrimerAcerc = _fechaPrimerAcerc;
    }

    public String getDocuAcercamiento() {
        return _docuAcercamiento;
    }

    public void setDocuAcercamiento(String _docuAcercamiento) {
        this._docuAcercamiento = _docuAcercamiento;
    }

    public String getObservacionesInforme() {
        return _observacionesInforme;
    }

    public void setObservacionesInforme(String _observacionesInforme) {
        this._observacionesInforme = _observacionesInforme;
    }

    public String getNumEstudiantes() {
        return _numEstudiantes;
    }

    public void setNumEstudiantes(String _numEstudiantes) {
        this._numEstudiantes = _numEstudiantes;
    }

    public String getCantidadTutores() {
        return _cantidadTutores;
    }

    public void setCantidadTutores(String _cantidadTutores) {
        this._cantidadTutores = _cantidadTutores;
    }

    public String getPlazo() {
        return _plazo;
    }

    public void setPlazo(String _plazo) {
        this._plazo = _plazo;
    }

    public String getRenuevaConvenio() {
        return _renuevaConvenio;
    }

    public void setRenuevaConvenio(String _renuevaConvenio) {
        this._renuevaConvenio = _renuevaConvenio;
    }

    public String getObservacionesRenovacion() {
        return _observacionesRenovacion;
    }

    public void setObservacionesRenovacion(String _observacionesRenovacion) {
        this._observacionesRenovacion = _observacionesRenovacion;
    }

    public String getAdministradorInst() {
        return _administradorInst;
    }

    public void setAdministradorInst(String _administradorInst) {
        this._administradorInst = _administradorInst;
    }

    public String getAdministradorEmpr() {
        return _administradorEmpr;
    }

    public void setAdministradorEmpr(String _administradorEmpr) {
        this._administradorEmpr = _administradorEmpr;
    }

    public String getProcesoDesignacion() {
        return _procesoDesignacion;
    }

    public void setProcesoDesignacion(String _procesoDesignacion) {
        this._procesoDesignacion = _procesoDesignacion;
    }

    public String getUniformes() {
        return _uniformes;
    }

    public void setUniformes(String _uniformes) {
        this._uniformes = _uniformes;
    }

    public String getEquipoProteccion() {
        return _equipoProteccion;
    }

    public void setEquipoProteccion(String _equipoProteccion) {
        this._equipoProteccion = _equipoProteccion;
    }

    public String getNormasSeguridad() {
        return _normasSeguridad;
    }

    public void setNormasSeguridad(String _normasSeguridad) {
        this._normasSeguridad = _normasSeguridad;
    }

    public String getObservacionesCondiciones() {
        return _observacionesCondiciones;
    }

    public void setObservacionesCondiciones(String _observacionesCondiciones) {
        this._observacionesCondiciones = _observacionesCondiciones;
    }

    public String getCompensacion() {
        return _compensacion;
    }

    public void setCompensacion(String _compensacion) {
        this._compensacion = _compensacion;
    }

    public String getCompensacionTipo() {
        return _compensacionTipo;
    }

    public void setCompensacionTipo(String _CompensacionTipo) {
        this._compensacionTipo = _CompensacionTipo;
    }

    public String getCompensacionCondiciones() {
        return _compensacionCondiciones;
    }

    public void setCompensacionCondiciones(String _compensacionCondiciones) {
        this._compensacionCondiciones = _compensacionCondiciones;
    }

    public String getElaborado() {
        return _elaborado;
    }

    public void setElaborado(String _elaborado) {
        this._elaborado = _elaborado;
    }

    public String getRevisado() {
        return _revisado;
    }

    public void setRevisado(String _revisado) {
        this._revisado = _revisado;
    }

    public String getAprobado() {
        return _aprobado;
    }

    public void setAprobado(String _aprobado) {
        this._aprobado = _aprobado;
    }

    public String getEstadoTramite() {
        return _estadoTramite;
    }

    public void setEstadoTramite(String _estadoTramite) {
        this._estadoTramite = _estadoTramite;
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
    public String[] crearActualizar(Viabilidad datos) { //éste método crea y modifica a la misma vez
            
        try {
            
            _sql = "select * from sp_siged_viabilidad_crear_actualizar(?, ?, ?, ?, ?,"
                    + "                                              ?, ?, ?, ?, ?,"
                    + "                                              ?, ?, ?, ?, ?,"
                    + "                                              ?, ?, ?, ?, ?,"
                    + "                                              ?, ?, ?, ?, ?,"
                    + "                                              ?, ?, ?, ?, ?,"
                    + "                                              ?, ?, ?, ?, ?, ?);";
          
            sentencia = Conexion.getConexion().prepareStatement(_sql);            

            sentencia.setString(1, datos.getAccion());
            
            sentencia.setInt(2, Integer.parseInt(datos.getId()));
            sentencia.setInt(3, Integer.parseInt(datos.getEmprId()));
            sentencia.setString(4, datos.getNumeroInforme());
            sentencia.setString(5, datos.getFechaInforme());
            sentencia.setString(6, datos.getAsunto());
            sentencia.setInt(7, Integer.parseInt(datos.getConstatación()));
            sentencia.setInt(8, Integer.parseInt(datos.getDeudaSri()));
            sentencia.setInt(9, Integer.parseInt(datos.getDeudaIess()));
            sentencia.setInt(10, Integer.parseInt(datos.getDeudaSercop()));
            sentencia.setInt(11, Integer.parseInt(datos.getDeudaSupIntendencia()));
            sentencia.setString(12, datos.getObservacionesDeudas());
            sentencia.setString(13, datos.getRecomendaciones());
            sentencia.setString(14, datos.getFechaPrimerAcerc());
            sentencia.setString(15, datos.getDocuAcercamiento());
            sentencia.setString(16, datos.getObservacionesDeudas());
            sentencia.setInt(17, Integer.parseInt(datos.getNumEstudiantes()));
            sentencia.setInt(18, Integer.parseInt(datos.getCantidadTutores()));
            sentencia.setInt(19, Integer.parseInt(datos.getPlazo()));
            sentencia.setInt(20, Integer.parseInt(datos.getRenuevaConvenio()));
            sentencia.setString(21, datos.getObservacionesRenovacion());
            sentencia.setString(22, datos.getAdministradorInst());
            sentencia.setString(23, datos.getAdministradorEmpr());
            sentencia.setString(24, datos.getProcesoDesignacion());
            sentencia.setInt(25, Integer.parseInt(datos.getUniformes()));
            sentencia.setInt(26, Integer.parseInt(datos.getEquipoProteccion()));
            sentencia.setInt(27, Integer.parseInt(datos.getNormasSeguridad()));
            sentencia.setString(28, datos.getObservacionesCondiciones());
            sentencia.setInt(29, Integer.parseInt(datos.getCompensacion()));
            sentencia.setString(30, datos.getCompensacionTipo());
            sentencia.setString(31, datos.getCompensacionCondiciones());
            sentencia.setString(32, datos.getElaborado());
            sentencia.setString(33, datos.getRevisado());
            sentencia.setString(34, datos.getAprobado());
            sentencia.setString(35, datos.getEstadoTramite());
            sentencia.setInt(36, Integer.parseInt(datos.getIdCarrera()));
            
            
            
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

    public String eliminar(Viabilidad datos) {
        try {
            this._sql = "select * from sp_siged_eliminar('viabilidad',?);";
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
            System.out.println("err: "+ ex);
            return null;
        }
    }
    // </editor-fold>
 

}
