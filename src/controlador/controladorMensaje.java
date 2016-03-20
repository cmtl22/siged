package controlador;

import javax.swing.JOptionPane;

public class controladorMensaje {

    private static controladorMensaje instancia;

    public static controladorMensaje getInstance() {
        if (instancia == null) {
            instancia = new controladorMensaje();
        }
        return instancia;
    }
// <editor-fold defaultstate="collapsed" desc="Declaracion de variables">
    private static final String MSG_GUARDAR = "Guardado Correctamente";
    private static final String MSG_TITULO_GUARDAR = "Guardar";
    private static final String MSG_ERROR_GUARDAR = "No se pudo guardar!!!";

    private static final String MSG_MODIFICAR = "Se guardaron los cambios correctamente";
    private static final String MSG_TITULO_MODIFICAR = "Modificar";
    private static final String MSG_ERROR_MODIFICAR = "No se pudo modificar!!!";

    private static final String MSG_ELIMINAR = "Eliminado Correctamente";
    private static final String MSG_TITULO_ELIMINAR = "Eliminar";
    private static final String MSG_ERROR_ELIMINAR = "No se pudo eliminar!!!";

    private static final String MSG_COMPLETAR = "Debe completar todos los campos con *";
    private static final String MSG_TITULO_COMPLETAR = "Completar";

    private static final String MSG_INGRESO_SYS = "Bienvendio al sistema";
    private static final String MSG_TITULO_INGRESO_SYS = "Ingreso Válido";

    private static final String MSG_LOGIN_ = "Usuario y/o Contraseña incorrectos";
    private static final String MSG_TITULO_LOGIN = "Login";

    private static final String MSG_ABRIR_VENTANA = "Debe cerrar todas las ventanas abiertas!!!";
    private static final String MSG_TITULO_ABRIR_VENTANA = "Mensaje";

    private static final String MSG_CAMPOS_INCORRECTOS = "Algunos campos están mal ingresados";
    private static final String MSG_TITULO_CAMPOS_INCORRECTOS = "Información Inválida";

    private static final String MSG_ERROR_CERRAR_SESION = "Error al cerrar sesión";
    private static final String MSG_TITULO_ERROR_CERRAR_SESION = "Cerrar Sesión";

    private static final String MSG_ERROR_USUARIO = "Debe completar el campo de usuario";
    private static final String MSG_TITULO_ERROR_USUARIO = "Login";

    private static final String MSG_ERROR_PASSWORD = "Debe completar el campo de contraseña";
    private static final String MSG_TITULO_ERROR_PASSWORD = "Login";

    private static final String MSG_ERROR_TIPO = "Debe seleccionar un tipo!!!";
    private static final String MSG_TITULO_ERROR_TIPO = "Tipo";

    private static final String MSG_ERROR_TABLA = "Debe seleccionar por lo menos un producto/servicio!!!";
    private static final String MSG_TITULO_ERROR_TABLA = "Error";

    private static final String MSG_ERROR_CONEXION = "Revise la coneccion a la base de datos";
    private static final String MSG_TITULO_ERROR_CONEXION = "Coneccion base de datos";

    private static final String MSG_ERROR_ASIGNAR_BODEGA = "Debe asignar una bodega a su usuario";
    private static final String MSG_TITULO_ERROR_ASIGNAR_BODEGA = "Asignar Bodega";

    private static final String MSG_ELEGIR_ELIMINAR = "Debe elegir antes de poder eliminar";
    private static final String MSG_TITULO_ELEGIR_ELIMINAR = "Elegir antes de eliminar";

// </editor-fold >
// <editor-fold defaultstate="collapsed" desc="Metodos">
    public void getMsgGuardar(String contenido) {
        JOptionPane.showMessageDialog(null, contenido, "Guardar/Actualizar", JOptionPane.INFORMATION_MESSAGE);
    }

    public void getMsgActualizar(String contenido) {
        JOptionPane.showMessageDialog(null, contenido, "Actualizado", JOptionPane.INFORMATION_MESSAGE);
    }

    public void getMsgEliminar(String contenido) {
        JOptionPane.showMessageDialog(null, contenido, "Eliminado", JOptionPane.INFORMATION_MESSAGE);
    }

    public void getMsgCamposObligatorios(String contenido) {
        JOptionPane.showMessageDialog(null, contenido, "Completar", JOptionPane.WARNING_MESSAGE);
    }

    public void getMsgCamposInvalidos(String contenido) {
        JOptionPane.showMessageDialog(null, contenido, "Información Inválida", JOptionPane.ERROR_MESSAGE);
    }

// </editor-fold>
}
