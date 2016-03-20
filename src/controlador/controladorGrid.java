package controlador;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class controladorGrid {

    private static controladorGrid instancia;
    TableRowSorter<TableModel> sorter;

    String[] nombresColmunas;

    public String[] getNombresColmunas() {
        return nombresColmunas;
    }

    private controladorGrid() {

    }

    public static controladorGrid getInstance() {
        if (instancia == null) {
            instancia = new controladorGrid();
        }
        return instancia;
    }

    public DefaultTableModel llenarGrid(String tabla, String tipo, String[] criterioBusqueda, boolean editable) {

        controladorConsulta consultaClass = new controladorConsulta();
        DefaultTableModel modelo = null;
        try {
            ResultSet resultado;

            resultado = consultaClass.consultarDatos(tabla, tipo, criterioBusqueda);

            int numCol = consultaClass.getNumColumnas();
            nombresColmunas = new String[numCol];
            nombresColmunas = consultaClass.getNombColumnas();
            Object[] datosTabla = new Object[numCol];

            if (editable) {
                modelo = new DefaultTableModel(nombresColmunas, 0) {
                    public boolean isCellEditable(int row, int column) {
                        return false;
                    }
                };
            } else {
                modelo = new DefaultTableModel(nombresColmunas, 0);
            }

            while (resultado.next()) {

                for (int i = 1; i <= numCol; i++) {
                    if (resultado.getObject(i) != null) {
                        datosTabla[i - 1] = resultado.getObject(i);

                    } else {
                        datosTabla[i - 1] = "";
                    }
                }
                modelo.addRow(datosTabla);
            }
        } catch (SQLException ex) {

        }
        return modelo;
    }

    public DefaultTableModel llenarGridPermisos(String tabla, String tipo, String[] criterioBusqueda) {

        controladorConsulta consultaClass = new controladorConsulta();
        DefaultTableModel modelo = null;
        try {
            ResultSet resultado;

            resultado = consultaClass.consultarDatos(tabla, tipo, criterioBusqueda);

            int numCol = consultaClass.getNumColumnas();
            nombresColmunas = new String[numCol];
            nombresColmunas = consultaClass.getNombColumnas();

            modelo = (new DefaultTableModel(
                    nombresColmunas, 0) {

                Class[] types = new Class[]{
                    java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class, java.lang.Object.class
                };

                public Class getColumnClass(int columnIndex) {
                    return types[columnIndex];
                }
            });

            ArrayList<Object> datosTabla;
            while (resultado.next()) {
                //          JOptionPane.showMessageDialog(null,"id: "+ resultado.getObject(1));
                datosTabla = new ArrayList();
                if (resultado.getObject(1) != null) {

                    datosTabla.add(resultado.getObject(1));
                    datosTabla.add(resultado.getObject(2));
                    datosTabla.add(resultado.getObject(3));
                    datosTabla.add(resultado.getObject(4));

                } else {

                    datosTabla.add("0");
                    datosTabla.add("SN");
                    datosTabla.add(true);
                    datosTabla.add("0");
                }

                modelo.addRow(arrayListToArray(datosTabla));
            }
        } catch (Exception ex) {

        }
        return modelo;
    }

     public DefaultTableModel llenarGridCheckBox(String tabla, String tipo, String[] criterioBusqueda) {

        controladorConsulta consultaClass = new controladorConsulta();
        DefaultTableModel modelo = null;
        try {
            ResultSet resultado;

            resultado = consultaClass.consultarDatos(tabla, tipo, criterioBusqueda);

            int numCol = consultaClass.getNumColumnas();
            nombresColmunas = new String[numCol];
            nombresColmunas = consultaClass.getNombColumnas();

            modelo = (new DefaultTableModel(
                    nombresColmunas, 0) {

                Class[] types = new Class[]{
                    java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
                };

                public Class getColumnClass(int columnIndex) {
                    return types[columnIndex];
                }
            });

            ArrayList<Object> datosTabla;
            while (resultado.next()) {
                //          JOptionPane.showMessageDialog(null,"id: "+ resultado.getObject(1));
                datosTabla = new ArrayList();
                if (resultado.getObject(1) != null) {

                    datosTabla.add(resultado.getObject(1));
                    datosTabla.add(resultado.getObject(2));
                    datosTabla.add(resultado.getObject(3));
                    

                } else {

                    datosTabla.add("0");
                    datosTabla.add("SN");
                    datosTabla.add(true);
                    
                }

                modelo.addRow(arrayListToArray(datosTabla));
            }
        } catch (Exception ex) {

        }
        return modelo;
    }
    
    public DefaultTableModel llenarGridAnexos(String tabla, String tipo, String[] criterioBusqueda) {

        controladorConsulta consultaClass = new controladorConsulta();
        DefaultTableModel modelo = null;
        try {
            ResultSet resultado;

            resultado = consultaClass.consultarDatos(tabla, tipo, criterioBusqueda);

            int numCol = consultaClass.getNumColumnas();
            nombresColmunas = new String[numCol];
            nombresColmunas = consultaClass.getNombColumnas();

            modelo = (new DefaultTableModel(
                    //new String[]{" ", "", "", "ARCHIVO ", "DESCRIPCIÓN"}, 0) {
                    new String[]{" ", "ARCHIVO ", "DESCRIPCIÓN"}, 0) {
                //nombresColmunas, 0) {

                Class[] types = new Class[]{
                    java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
                };

                public Class getColumnClass(int columnIndex) {
                    return types[columnIndex];
                }
            });

            ArrayList<Object> datosTabla;
            while (resultado.next()) {
                datosTabla = new ArrayList();
                if (resultado.getObject(1) != null) {

                    datosTabla.add(resultado.getObject(1));
                    //datosTabla.add("");
                    //datosTabla.add("");
                    datosTabla.add(resultado.getObject(4));
                    datosTabla.add(resultado.getObject(5));

                } else {

                    datosTabla.add("0");
                    //datosTabla.add("");
                    //datosTabla.add("");
                    datosTabla.add("");
                    datosTabla.add("");
                }

                modelo.addRow(arrayListToArray(datosTabla));
            }
        } catch (Exception ex) {

        }
        return modelo;
    }

    private Object[] arrayListToArray(ArrayList modulos) {
        Object[] tmpPermisos = new Object[modulos.size()];

        for (int i = 0; i < modulos.size(); i++) {
            //          JOptionPane.showMessageDialog(null, modulos.get(i));
            tmpPermisos[i] = modulos.get(i);
        }
        //    JOptionPane.showMessageDialog(null, "fin for    ");
        return tmpPermisos;
    }

}
