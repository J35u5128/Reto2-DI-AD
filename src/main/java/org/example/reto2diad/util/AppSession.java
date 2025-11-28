package org.example.reto2diad.util;
import org.example.reto2diad.model.Usuario;

public class AppSession {

    private static Usuario usuarioActual;

    public static Usuario getUsuarioActual() {
        return usuarioActual;
    }

    public static void setUsuarioActual(Usuario usuario) {
        usuarioActual = usuario;
    }

    public static void cerrarSesion() {
        usuarioActual = null;
    }

    public static boolean isAdmin() {
        return usuarioActual != null && usuarioActual.esAdministrador();
    }
}
