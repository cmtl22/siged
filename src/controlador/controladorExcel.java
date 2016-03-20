package controlador;

import modelo.Excel;

public class controladorExcel {

    private static controladorExcel instancia;

    public static controladorExcel getInstance() {
        if (instancia == null) {
            instancia = new controladorExcel();
        }
        return instancia;
    }

    public void generarExcel2(String[] archivoXLS, String[][] registros) {

        Excel.getInstance().generarExcel(archivoXLS, registros);
    }

}
