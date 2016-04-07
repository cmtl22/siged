package controlador;

import java.util.Map;
import modelo.Reporte;

public class controladorReporte {

    Reporte reporteClass;
    String cadena = "";

    public void generarReporte(String nombreReporte, Map parametros) {
        reporteClass = new Reporte();
        reporteClass.generarReporte(nombreReporte, parametros);

    }

    public void generarReporteViabilidad(String nombreReporte, Map parametros) {
        reporteClass = new Reporte();
        reporteClass.generarReporte(nombreReporte, parametros);

    }
}
