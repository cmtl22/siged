package modelo;

import java.io.File;
import java.util.Map;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

public class Reporte {

    private String sql = "";

    public void generarReporte(String nombreReporte, Map parametros) {

        File reportFile = new File("");
        String path = "";
        String titulo = "";
        switch (nombreReporte) {
            case "estudiantes":
                path = reportFile.getAbsolutePath() + "\\reportes\\rpt_acercamiento_empresas.jasper";
                titulo = "Estudiantes";
                break;
            case "generar_factura":
                path = reportFile.getAbsolutePath() + "/reportes/rpt_facturaIndividual.jasper";
                titulo = "Factura";
                break;
            case "3":
                path = reportFile.getAbsolutePath() + "/reportes/rpt_fechaIngreso.jasper";
                titulo = "Ordenes de Ingreso";
                break;
            case "4":
                path = reportFile.getAbsolutePath() + "/reportes/rpt_fechaIngresoDonaciones.jasper";
                titulo = "Ingresos Por Donaciones";
                break;
            case "5":
                path = reportFile.getAbsolutePath() + "/reportes/rpt_fechaPedido.jasper";
                titulo = "Pedidos Pendientes";
                break;
            case "6":
                path = reportFile.getAbsolutePath() + "/reportes/rpt_donaciones.jasper";
                titulo = "Donaciones";
                break;
            case "7":
                path = reportFile.getAbsolutePath() + "/reportes/rpt_deBaja.jasper";
                titulo = "Dados de Baja";
                break;
            default:
                path = reportFile.getAbsolutePath() + "/reportes/rpt_existencia_activos.jasper";
                titulo = "Existencias Activos";
        }

        JasperReport reporte = null;
        System.out.println(path);
        try {
            reporte = (JasperReport) JRLoader.loadObjectFromFile(path);

            JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, parametros, Conexion.getConexion());

            JasperViewer jv = new JasperViewer(jasperPrint, false);

            jv.setVisible(true);
            /*

            String fileName = "C:\\Users\\itsbj\\Documents\\NetBeansProjects\\siged\\reportes\\rpt_estudiantes.jasper";
            String outFileName = "d:\\test.pdf";
            HashMap hm = new HashMap();
            try {
                JasperPrint print = JasperFillManager.fillReport(
                        fileName,
                        hm,
                        new JREmptyDataSource());
                JRExporter exporter
                        = new net.sf.jasperreports.engine.export.JRPdfExporter();
                exporter.setParameter(
                        JRExporterParameter.OUTPUT_FILE_NAME,
                        outFileName);
                exporter.setParameter(
                        JRExporterParameter.JASPER_PRINT, print);
                exporter.exportReport();
                System.out.println("Created file: " + outFileName);
            } catch (JRException e) {
                e.printStackTrace();
                System.exit(1);
            } catch (Exception e) {
                e.printStackTrace();
                System.exit(1);
            }*/
        } catch (Exception ex) {
            JOptionPane.showConfirmDialog(null, ex.getMessage());
        }
    }

    /*  public void generarOrden(String tipo, String id) {
        File reportFile = new File("");
        String path = "";
        String subreport_dir = "";
        String op = null;
        String _id = null;
        switch (tipo) {
            case "generar_factura":
                path = reportFile.getAbsolutePath() + "/reportes/rpt_facturaIndividual.jasper";
                op = "Factura";
                _id = "id_factura";
                break;
            case "":
                path = reportFile.getAbsolutePath() + "/reportes/rpt_ordenPedido.jasper";
                op = "Orden de Pedido";
                _id = "id_pedido";
                break;
            case "2":
                path = reportFile.getAbsolutePath() + "/reportes/rpt_devolucion.jasper";
                op = "Devolución";
                _id = "id_pedido";
                break;
            default:
                path = reportFile.getAbsolutePath() + "/reportes/rpt_existencia_activos.jasper";
        }

        JasperReport jr = null;

        try {
            jr = (JasperReport) JRLoader.loadObjectFromFile(path);

            Map parametro = new HashMap();
            parametro.put(_id, id);
            parametro.put("SUBREPORT_DIR", reportFile.getAbsoluteFile() + "\\reportes\\");
            JasperPrint jp = JasperFillManager.fillReport(jr, parametro, Conexion.getConexion());

            JasperViewer jv = new JasperViewer(jp, false);

            jv.setVisible(true);
            jv.setTitle(op);

        } catch (Exception ex) {
            JOptionPane.showConfirmDialog(null, "GEnerar reporte: " + ex.getMessage());
        }
    }
     */
}
