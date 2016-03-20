package controlador;

import java.util.Map;
import javax.swing.JOptionPane;
import modelo.Usuario;

public class ControladorUsuario {

    // <editor-fold defaultstate="collapsed" desc="Declaracion de variables">    
    private String camposObligatorios;
    private String camposInvalidos;
    private boolean bandera;
    private String[] respuesta;
    // </editor-fold >    

    // <editor-fold defaultstate="collapsed" desc="Metodos">    
    public ControladorUsuario() {
        this.bandera = false;
        this.respuesta = new String[3];
    }

    public boolean crearActualizar(Map datos) {
        camposObligatorios = validarCamposObligatorios(datos);
        camposInvalidos = validarDatos(datos);
        if (camposObligatorios.equals("")) {
            if (camposInvalidos.equals("")) {
                Usuario usuario = new Usuario();
                usuario.setAccion((String) datos.get("accion"));
                usuario.setId((String) datos.get("id"));
                usuario.setIdPersona((String) datos.get("idPersona"));
                usuario.setIdRol((String) datos.get("idRol"));
                usuario.setNombre((String) datos.get("nombreUsuario"));
                usuario.setClave((String) datos.get("clave"));

                respuesta = usuario.crearActualizar(usuario);

                controladorMensaje.getInstance().getMsgGuardar(respuesta[1]);
                bandera = controladorVariablesSesion.getInstance().validarRespuestaDB(respuesta[2]);
            } else {
                controladorMensaje.getInstance().getMsgCamposInvalidos(camposInvalidos);
            }
        } else {
            controladorMensaje.getInstance().getMsgCamposObligatorios(camposObligatorios);
        }
        return bandera;
    }

    public void eliminar(Map datos) {

        Usuario usuario = new Usuario();
        usuario.setId((String) datos.get("id"));
        controladorMensaje.getInstance().getMsgEliminar(usuario.eliminar(usuario));

    }

    public String validarCamposObligatorios(Map datos) {
        camposObligatorios = "";
        if (datos.get("idPersona").equals("-1")) {
            camposObligatorios += "Escoja una Persona\n";
        }
        if (datos.get("idRol").equals("-1")) {
            camposObligatorios += "Escoja una Rol\n";
        }
        if (datos.get("nombreUsuario").equals("")) {
            camposObligatorios += "Ingrese un nombre de usuario\n";
        }
        if (datos.get("clave").equals("")) {
            camposObligatorios += "Ingrese una clave\n";
        }

        return camposObligatorios;
    }

    public String validarDatos(Map datos) {
        camposInvalidos = "";
        if (!datos.get("clave").equals(datos.get("repetirClave"))) {
            camposInvalidos += "Las contraseñas no coinciden\n";
        }
        return camposInvalidos;
    }

    public String validarUsuario(Map datos) {
        String[] usuarioValido = new String[3];
        Usuario usuario = new Usuario();
        usuario.setNombre((String) datos.get("nombreUsuario"));
        usuario.setClave((String) datos.get("clave"));

        usuarioValido = usuario.validarUsuario(usuario);
        if (usuarioValido != null) {
            switch (usuarioValido[2]) {
                case "1":
                    controladorVariablesSesion.getInstance().setCodigoUsuario(usuarioValido[0]);
                    controladorVariablesSesion.getInstance().setNombreUsuario((String) datos.get("nombreUsuario"));
                    controladorVariablesSesion.getInstance().setPerfilUsuario(usuarioValido[1]);
                    controladorVariablesSesion.getInstance().setCorreoUsuario(usuarioValido[3]);
                    controladorConfiguraciones.getInstance().setContadorIntentosLogin(Integer.parseInt(usuarioValido[4]));
                    controladorVariablesSesion.getInstance().setNombresPersona(usuarioValido[5]);

                    break;
                case "2":
                    controladorVariablesSesion.getInstance().setCodigoUsuario(usuarioValido[0]);
                    controladorVariablesSesion.getInstance().setNombreUsuario((String) datos.get("nombreUsuario"));
                    controladorVariablesSesion.getInstance().setPerfilUsuario(usuarioValido[1]);
                    controladorVariablesSesion.getInstance().setCorreoUsuario(usuarioValido[3]);
                    controladorConfiguraciones.getInstance().setContadorIntentosLogin(Integer.parseInt(usuarioValido[4]));
                    controladorVariablesSesion.getInstance().setNombresPersona(usuarioValido[5]);
                    break;
                default:
                    controladorVariablesSesion.getInstance().setCodigoUsuario(null);
                    controladorVariablesSesion.getInstance().setNombreUsuario(null);
                    controladorVariablesSesion.getInstance().setPerfilUsuario(null);
                    controladorConfiguraciones.getInstance().setContadorIntentosLogin(Integer.parseInt(usuarioValido[4]));
                    controladorVariablesSesion.getInstance().setNombresPersona(null);
            }
        }

        return usuarioValido[2];
    }

    public String bloquearUsuario(Map datos) {
        String[] usuarioValido = new String[2];
        Usuario usuario = new Usuario();
        usuario.setNombre((String) datos.get("nombreUsuario"));

        usuario.bloquearUsuario(usuario);

        controladorVariablesSesion.getInstance().setCodigoUsuario(null);
        controladorVariablesSesion.getInstance().setNombreUsuario(null);
        controladorVariablesSesion.getInstance().setPerfilUsuario(null);

        return usuarioValido[1];
    }

    public String recuperarClave(Map datos) {

        Usuario usuario = new Usuario();
        usuario.setNombre(datos.get("nombreUsuario").toString());
        usuario.recuperarClave(usuario);

        Email correo = new Email();
        String correoAdministrador = "cmtl22@hotmail.com";
        String asunto = "Recuperar Contraseña SIGED";
        String mensaje = "Petición de recuperación de contraseña"
                + "\n\nUsuario: " + datos.get("nombreUsuario").toString()
                + "\n\nSolicitud en proceso!!!";
        if (correo.send(correoAdministrador, asunto, mensaje)) {
            JOptionPane.showMessageDialog(null, "Sus datos fueron enviados correctamente al Administrador: ", "Enviado", JOptionPane.INFORMATION_MESSAGE);
        }

        return datos.get("nombreUsuario").toString();
    }

    public boolean cambiarClave(Map datos) {

        Usuario usuario = new Usuario();
        usuario.setId(datos.get("id").toString());
        usuario.setClave(datos.get("clave").toString());

        respuesta = usuario.cambiarClave(usuario);

        controladorMensaje.getInstance().getMsgGuardar(respuesta[1]);
        bandera = controladorVariablesSesion.getInstance().validarRespuestaDB(respuesta[2]);
        Email correo = new Email();
        String correoAdministrador = datos.get("correo").toString();
        String asunto = "Cambio de Contraseña SIGED";
        String mensaje = "Petición de cambio de contraseña"
                + "\n\nUsuario: " + datos.get("nombreUsuario").toString()
                + "\n\nNueva Contraseña: " + datos.get("clave").toString();
        if (correo.send(correoAdministrador, asunto, mensaje)) {
            JOptionPane.showMessageDialog(null, "Sus datos fueron enviados correctamente:\n " + datos.get("correo").toString(), "Enviado", JOptionPane.INFORMATION_MESSAGE);
        }

        return bandera;
    }

    public String enviarDatosUsuario(String asunto, String mensaje, String correo) {

        Email email = new Email();
        String correoAdministrador = correo;
        if (email.send(correoAdministrador, asunto, mensaje)) {
            JOptionPane.showMessageDialog(null, "Datos Enviados Correctamente: " + correo, "Enviado", JOptionPane.INFORMATION_MESSAGE);
        }

        return "";
    }
    // </editor-fold>    
}
