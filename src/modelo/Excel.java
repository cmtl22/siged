/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import controlador.controladorExcel;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

/**
 *
 * @author itsbj
 */
public class Excel {

    private static Excel instancia;

    public static Excel getInstance() {
        if (instancia == null) {
            instancia = new Excel();
        }
        return instancia;
    }

    

    public void generarExcel(String[] archivoRuta, String[][] registros) {
        try {
            /*La ruta donde se creará el archivo*/
            String rutaArchivo = archivoRuta[0] + ".xls";
            /*Se crea el objeto de tipo File con la ruta del archivo*/
            File archivoXLS = new File(rutaArchivo);
            /*Si el archivo existe se elimina*/
            if (archivoXLS.exists()) {
                archivoXLS.delete();
            }
            /*Se crea el archivo*/
            archivoXLS.createNewFile();

            /*Se crea el libro de excel usando el objeto de tipo Workbook*/
            Workbook libro = new HSSFWorkbook();
            /*Se inicializa el flujo de datos con el archivo xls*/
            FileOutputStream archivo = new FileOutputStream(archivoXLS);

            /*Utilizamos la clase Sheet para crear una nueva hoja de trabajo dentro del libro que creamos anteriormente*/
            Sheet hoja = libro.createSheet(archivoRuta[1]);

            /*Hacemos un ciclo para inicializar los valores de 10 filas de celdas*/
            int totalFilas = registros.length;
            int totalColumnas = registros[0].length;
            JOptionPane.showMessageDialog(null, "col " + totalColumnas + " \nfilas" + totalFilas);
            for (int f = 0; f < totalFilas; f++) {
                /*La clase Row nos permitirá crear las filas*/
                Row fila = hoja.createRow(f);

                /*Cada fila tendrá 5 celdas de datos*/
                for (int c = 0; c < totalColumnas - 1; c++) {
                    /*Creamos la celda a partir de la fila actual*/
                    Cell celda = fila.createCell(c);
                    /*Si la fila es la número 0, estableceremos los encabezados*/
                    if (f == 0) {
                        JOptionPane.showMessageDialog(null, registros[f][c + 1]);
                        celda.setCellValue(registros[f][c + 1]);
                    } else {
                        /*Si no es la primera fila establecemos un valor*/
                        JOptionPane.showMessageDialog(null, registros[f][c + 1]);
                        celda.setCellValue(registros[f][c + 1]);
                    }
                }
            }

            /*Escribimos en el libro*/
            libro.write(archivo);
            /*Cerramos el flujo de datos*/
            archivo.close();
            /*Y abrimos el archivo con la clase Desktop*/
            Desktop.getDesktop().open(archivoXLS);
        } catch (IOException ex) {
            Logger.getLogger(Excel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
