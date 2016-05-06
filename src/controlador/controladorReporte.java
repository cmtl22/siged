package controlador;

import java.util.Date;

import net.sf.jasperreports.view.JasperDesignViewer;
import net.sf.jasperreports.view.JasperViewer;
import ar.com.fdvs.dj.domain.DynamicReport;
import ar.com.fdvs.dj.domain.builders.FastReportBuilder;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.ReportBase;

public class controladorReporte extends ReportBase {

    public void generarReporte() {
        try {
            controladorReporte reporte = new controladorReporte();
            reporte.generateReport();
            reporte.exportToJRXML();
            JasperViewer.viewReport(reporte.jp);	//finally display the report report
            JasperDesignViewer.viewReportDesign(reporte.jr);
        } catch (Exception ex) {
            Logger.getLogger(controladorReporte.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public DynamicReport buildReport() throws Exception {

        FastReportBuilder drb = new FastReportBuilder();

        drb
                .addColumn("Estudiante", "estudiante", String.class.getName(), 30)
                .addColumn("Tutor Académico", "tutorEmpresarial", String.class.getName(), 30)
                .addColumn("Tutor Empresarial", "tutorEmpresarial", Integer.class.getName(), 10)
                .addColumn("Periodo", "periodo", String.class.getName(), 50)
                .setTitle("Seguimiento Estudiante")
                .setSubtitle("Generado " + new Date())
                .setPrintBackgroundOnOddRows(true)
                .setUseFullPageWidth(true);

        return drb.build();

    }

}
