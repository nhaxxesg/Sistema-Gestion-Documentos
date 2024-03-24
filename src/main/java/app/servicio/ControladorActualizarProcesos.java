package app.servicio;

import app.entidades.Usuario;
import app.entidades.repositorios.UsuarioRepositorio;

public class ControladorActualizarProcesos {
    private UsuarioRepositorio usuarioRepositorio = new UsuarioRepositorio();
   
    public void actualizarUsuario(Usuario usuario){
        usuarioRepositorio.actualizarUsuario(usuario);
    }
}
