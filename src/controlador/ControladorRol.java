package controlador;

import java.util.ArrayList;
import java.util.Map;
import modelo.Rol;

public class ControladorRol {

    private String camposObligatorios;
    private String camposInvalidos;
    private boolean bandera;
    String[] respuesta;

    public ControladorRol() {
        this.bandera = false;
        this.respuesta = new String[3];
    }

    /**
     *
     * @param datos
     * @param modulos
     * @param datosArchivos
     * @param tamanioArchivos
     * @return
     */
    public boolean crearActualizar(Map datos, ArrayList modulos) {
        camposObligatorios = validarCamposObligatorios(datos);
        if (camposObligatorios.equals("")) {
            Rol rol = new Rol();
            rol.setAccion((String) datos.get("accion"));
            rol.setId((String) datos.get("id"));
            rol.setNombre((String) datos.get("nombreRol"));
            rol.setIdModulos(arrayListToArrayString(modulos));
            respuesta = rol.crearActualizar(rol);

            controladorMensaje.getInstance().getMsgGuardar(respuesta[1]);
            bandera = controladorVariablesSesion.getInstance().validarRespuestaDB(respuesta[2]);
        } else {
            controladorMensaje.getInstance().getMsgCamposObligatorios(camposObligatorios);
        }
        return bandera;
    }

    private int[] arrayListToArrayString(ArrayList modulos) {
        int[] tmpModulos = new int[modulos.size()];
        for (int i = 0; i < modulos.size(); i++) {
            tmpModulos[i] = Integer.parseInt(modulos.get(i).toString());
        }
        return tmpModulos;
    }

    public void eliminar(Map datos) {

        Rol rol = new Rol();
        rol.setId((String) datos.get("id"));
        controladorMensaje.getInstance().getMsgEliminar(rol.eliminar(rol));

    }

    public String validarCamposObligatorios(Map datos) {
        camposObligatorios = "";
        if (datos.get("id").equals("")) {
            camposObligatorios += "Ingres el nombre del Rol\n";
        }
        if (datos.get("nombreRol").equals("")) {
            camposObligatorios += "Ingres el nombre del Rol\n";
        }

        return camposObligatorios;
    }

}
