package app;

import app.entidades.Usuario;
import app.servicio.UsuarioServicio;

public class App {
	public static void main(String args[]) {
		UsuarioServicio usr=new UsuarioServicio();
		Usuario usuario = new Usuario("231DS13","Josue Angel", "Ferro", "Quispe", "jferro.231ds13@istta.edu.pe",
					"Estudiante", "967191391", "minibumer12", "NO");
		usr.crearUsuario(usuario);
	}
	
}
