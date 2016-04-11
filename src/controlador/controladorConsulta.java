package controlador;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import modelo.Conexion;

public class controladorConsulta {

    private String sql = "";
    private ResultSet resultadoConsulta;
    private String[] datosBuscados;
    private ArrayList<String> codigoCombo = new ArrayList<>();
    private DefaultComboBoxModel modeloCombo;

    public ArrayList<String> getCodigoCombo() {
        return codigoCombo;
    }

    public void setCodigoCombo(ArrayList<String> codigoCombo) {
        this.codigoCombo = codigoCombo;
    }

    public ResultSet consultarDatos(String tabla, String tipo, String[] criterioBusqueda) {
        switch (tipo) {
            //muestra la informacion para llenar los grid
            case "grid":
                sql = "select *from v_" + tabla + "_grid;";
                break;
            case "grid_filtro":
                sql = "select *from v_" + tabla + "_grid where codigo =" + criterioBusqueda[0];
                break;
            case "grid_checkbox":
                sql = "select *from v_" + tabla + "_checkbox where codigo=" + criterioBusqueda[0];
                break;

            //muestra informacion en base a las cabeceras de las tablas
            case "filtroGrupo":
                sql = "select *from v_" + tabla + "_filtro_grupo where codigo =" + criterioBusqueda[0];
                break;
            //muestra informacion en base a una condicion especifica
            case "filtroIndividual":
                sql = "select *from v_" + tabla + "_todo where codigo=" + criterioBusqueda[0];
                break;

            case "documento_anexos":
                sql = "select *from v_documento_anexos_grid where referencia=" + criterioBusqueda[0] + " and tipo='" + criterioBusqueda[1] + "';";
                break;

            default:
                sql = "No existe la vista en la base de datos";
        }
        System.out.println("--------------------------------------------------------------------------------------------------");
        System.out.println(sql);

        if (Conexion.getInstance().consultarQuery(sql)) {
            resultadoConsulta = Conexion.getInstance().getResultado();
            Conexion.getInstance().cerrarConexion();
        } else {
            resultadoConsulta = null;
            Conexion.getInstance().cerrarConexion();
        }
        return resultadoConsulta;
    }

    public ArrayList<Object> obtenerConsulta(String tabla, String tipo, String[] criterio) {
        try {
            System.out.println("columnas" + getNumColumnas());
            ArrayList<Object> datosConsulta = new ArrayList<>();
            ResultSet resultado = consultarDatos(tabla, tipo, criterio);

            while (resultado.next()) {

                for (int i = 0; i < getNumColumnas(); i++) {
                    datosConsulta.add(resultado.getObject(i + 1));
                }
            }
            return datosConsulta;
        } catch (SQLException ex) {
            return null;
        }

    }

    public ArrayList<Object> obtenerConsultaVarios(String tabla, String tipo, String[] criterio) {
        try {
            System.out.println("columnas" + getNumColumnas());
            ArrayList<Object> datosConsulta = new ArrayList<>();
            ResultSet resultado = consultarDatos(tabla, tipo, criterio);

            while (resultado.next()) {

                datosConsulta.add(resultado.getObject(1));

            }
            return datosConsulta;
        } catch (SQLException ex) {
            return null;
        }

    }

    private void guardarDatosBuscados() {
        datosBuscados = new String[Conexion.getInstance().getNumColumnas()];
        datosBuscados[0] = "";
        int cont = 0;
        try {
            while (resultadoConsulta.next()) {
                for (int i = 0; i < Conexion.getInstance().getNumColumnas(); i++) {
                    datosBuscados[i] = resultadoConsulta.getString(i + 1);
                }
                cont++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(controladorConsulta.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    public String[] getDatosBuscados() {
        guardarDatosBuscados();
        return datosBuscados;
    }

    public String[] getNombColumnas() {
        return Conexion.getInstance().getNombresColumnas();
    }

    public int getNumColumnas() {
        return Conexion.getInstance().getNumColumnas();
    }

    public void buscar(String tabla, String tipo, String id) {
        String[] datos = new String[3];
        datos[0] = tabla;
        datos[1] = tipo;
        datos[2] = id;
        controladorVariablesSesion.getInstance().setDatosConsulta(datos);
    }

    public DefaultComboBoxModel consultarCombo(String[] criterioBusqueda) {
        modeloCombo = new DefaultComboBoxModel();
        switch (criterioBusqueda[1]) {
            case "enumeracion":
                sql = "select *from v_enumeracion_combo_filtro where tipo = '" + criterioBusqueda[0] + "';";
                break;
            case "tabla":
                sql = "select *from v_" + criterioBusqueda[0] + "_combo;";
                break;
            case "filtrar":
                sql = "select *from v_" + criterioBusqueda[0] + "_combo where codigo = " + criterioBusqueda[2] + ";";
                break;
            default:
                sql = "error";
        }
        System.out.println("sql combos: " + sql);
        if (Conexion.getInstance().consultarQuery(sql)) {
            try {
                resultadoConsulta = Conexion.getInstance().getResultado();
                int i = 0;
                modeloCombo.addElement("SELECCIONE...");
                codigoCombo.add("-1");
                while (resultadoConsulta.next()) {
                    codigoCombo.add(resultadoConsulta.getString("referencia"));
                    modeloCombo.addElement(resultadoConsulta.getObject("nombre"));

                    i++;
                }
                Conexion.getInstance().cerrarConexion();
                return modeloCombo;
            } catch (SQLException ex) {
                modeloCombo = null;
                Logger.getLogger(controladorConsulta.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            modeloCombo = null;
            Conexion.getInstance().cerrarConexion();

        }
        return modeloCombo;
    }
}
