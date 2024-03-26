package app;

import java.util.*;


import app.entidades.*;
import app.entidades.repositorios.*;
import app.servicio.ControladorActualizarProcesos;
import app.servicio.ControladorRegistrarProceso;


public class App {
	public static void main(String args[]) {
		UsuarioRepositorio usr=new UsuarioRepositorio();
		ControladorRegistrarProceso cusr=new ControladorRegistrarProceso();
		ControladorActualizarProcesos cap=new ControladorActualizarProcesos();
		Date fecha=new Date();
		
		Documento documento1=new Documento("FUT-prueba2-modi2", fecha, fecha, fecha, "activo", "fisico");
		Documento documento2=new Documento(20,"FUT2-prueba2-modi2-este no se modificara", fecha, fecha, fecha, "activo2", "fisico2");
		java.util.List<Documento> documentos = new ArrayList<>();
		documentos.add(documento1);
		documentos.add(documento2);
		java.util.List<Proceso> procesos = new ArrayList<>();
		Proceso proceso1 = new Proceso("titulacion-prueba4-modi2", fecha,fecha, "activo",documentos);
		procesos.add(proceso1);
		documento1.setProceso(proceso1);
		documento2.setProceso(proceso1);

		Usuario usuario2=new Estudiante("231DS54", "josue-prueba2-modi2", "ferro", "quispe", "jferro@istta.edu.pe", "estudiante", "23496262", "asdfadfa", "si","dsi", "3", procesos);
		proceso1.setUsuario(usuario2);
		cap.actualizarUsuario(usuario2);

		//insertar observaciones despues
		/*Date fecha=new Date();
		ObservacionRepositorio obs=new ObservacionRepositorio();
		Observacion observacion= new Observacion("este documento no cuenta no cositas xd", fecha);
		obs.persistirObservacion(observacion, 1, "231DS30");
		ControladorActualizarProcesos cta = new ControladorActualizarProcesos();
		UsuarioRepositorio usr=new UsuarioRepositorio();
		Usuario usuarioModificar = usr.buscarUsuario("231DS54");
		usuarioModificar.setNombre("pancracio modificado");

		List<Proceso> procesos =  usuarioModificar.getProcesos();
		Proceso procesoIdentificado = procesos.get(0);
		procesoIdentificado.setNombre("proceso modificaodo");
		usuarioModificar.setProcesos(procesos);
		
		cta.actualizarUsuario( usuarioModificar);*/


	}
	
}