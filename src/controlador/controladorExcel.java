package controlador;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import modelo.Excel;

public class controladorExcel {

    private static controladorExcel instancia;

    public static controladorExcel getInstance() {
        if (instancia == null) {
            instancia = new controladorExcel();
        }
        return instancia;
    }

    public void generarExcel(String[] archivoXLS, TableModel modelo) {
     
        Excel.getInstance().generarExcel(archivoXLS, modelo);
    }

}
