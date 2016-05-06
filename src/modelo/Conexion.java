package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class Conexion {

    private static Conexion instancia;

    private static Connection _conexion;
    private static String _user = "postgres";
    private static String _password = "root";
    Statement sentencia;
    private ResultSet _resultado;
    private ResultSetMetaData _mtd;
    private String[] _columnas;
    private String _error;
    private boolean flag = true;

    public static Conexion getInstance() {
        if (instancia == null) {
            instancia = new Conexion();
        }
        return instancia;
    }

    public static final Connection getConexion() {
        try {
            Class.forName("org.postgresql.Driver");
            String connectString = "jdbc:postgresql://localhost:5432/siged_produccion";
            //String connectString = "jdbc:postgresql://192.168.88.244:5432/siged_pruebas";
            _conexion = DriverManager.getConnection(connectString, _user, _password);

            if (_conexion != null) {
                System.out.println("Succes conexion");
            } else {
                _conexion = null;
            }

        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Por favor comunicarse con el administrador de la base de datos", "Error al conectar con la base de datos", JOptionPane.ERROR_MESSAGE);
            _conexion = null;
        } finally {
            return _conexion;
        }

    }

    public boolean ejecutarQuery(String sql) {
        try {
            sentencia = getConexion().createStatement();
            sentencia.executeUpdate(sql);
            flag = true;
        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, e);
            flag = false;

        } finally {
            return flag;
        }

    }

    public boolean consultarQuery(String sql) {
        try {
            sentencia = getConexion().createStatement();
            _resultado = sentencia.executeQuery(sql);
            _mtd = _resultado.getMetaData();
            _error = null;
            _conexion.close();

            flag = true;
        } catch (Exception e) {
            this._error = e.getMessage();
            System.out.println(_error);
            flag = false;
            _conexion.close();

        } finally {
            return flag;
        }

    }

    public String getError() {
        return this._error;
    }

    public ResultSet getResultado() {
        return _resultado;
    }

    public String[] getNombresColumnas() {
        try {
            int numColumnas = this._mtd.getColumnCount();
            _columnas = new String[numColumnas];

            for (int i = 0; i < numColumnas; i++) {
                _columnas[i] = _mtd.getColumnLabel(i + 1);
            }
            return _columnas;
        } catch (SQLException ex) {

            return null;

        }
    }

    public int getNumColumnas() {
        try {
            return this._mtd.getColumnCount();
        } catch (SQLException ex) {
            return 0;
        }
    }

    public void cerrarConexion() {
        try {
            _conexion.close();
        } catch (SQLException ex) {

        }
    }
}
