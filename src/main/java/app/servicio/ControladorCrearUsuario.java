package app.servicio;

import app.Utilidades.Encoder;
import app.Utilidades.ValidarInformacion;
import app.entidades.*;
import app.entidades.repositorios.UsuarioRepositorio;

public class ControladorCrearUsuario {
    private UsuarioRepositorio usuarioRepositorio;

    public ControladorCrearUsuario() {
        this.usuarioRepositorio = new UsuarioRepositorio();
    }

    public void crearUsuario(Usuario usuario) {
        if (!ValidarInformacion.esNulo(usuario) && !usuarioRepositorio.existeUsuario(usuario)) {
            String contrasenaEncriptada = Encoder.passwordEncoder(usuario.getContrasena());
            usuario.setContrasena(contrasenaEncriptada);
            usuarioRepositorio.persistirUsuarioRefactorizado(usuario);
        }
    }

    public boolean iniciarSesion(String contrasena, String correoInstitucional){
        boolean estaRegistrado = false;
        Usuario usuarioEncontrado = (Usuario)usuarioRepositorio.buscarUsuarioPorCorreoInstitucional(correoInstitucional);
        if(!ValidarInformacion.esNulo(usuarioEncontrado)){
            estaRegistrado = Encoder.passwordMatching(usuarioEncontrado.getContrasena(), contrasena);
        }
        return estaRegistrado;
    }
}
