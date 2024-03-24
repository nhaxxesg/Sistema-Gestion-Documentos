package app;

import java.util.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.eclipse.persistence.internal.jpa.metadata.structures.ArrayAccessor;


import app.entidades.*;
import app.entidades.repositorios.*;
import app.servicio.ControladorActualizarProcesos;
import app.servicio.ControladorRegistrarProceso;
import app.servicio.ControladorVerProcesos;
import app.servicio.UsuarioServicio;


public class App {
	public static void main(String args[]) {
		/*UsuarioRepositorio usr=new UsuarioRepositorio();
		ControladorRegistrarProceso cusr=new ControladorRegistrarProceso();
		Date fecha=new Date();
		
		Documento documento1=new Documento("FUT-prueba2", fecha, fecha, fecha, "activo", "fisico");
		Documento documento2=new Documento("FUT2-prueba2", fecha, fecha, fecha, "activo2", "fisico2");
		java.util.List<Documento> documentos = new ArrayList<>();
		documentos.add(documento1);
		documentos.add(documento2);
		java.util.List<Proceso> procesos = new ArrayList<>();
		Proceso proceso1 = new Proceso("titulacion-prueba4", fecha,fecha, "activo",documentos);
		procesos.add(proceso1);
		documento1.setProceso(proceso1);
		documento2.setProceso(proceso1);

		Usuario usuario2=new Estudiante("231DS54", "josue-prueba2", "ferro", "quispe", "jferro@istta.edu.pe", "estudiante", "23496262", "asdfadfa", "si","dsi", "3", procesos);
		proceso1.setUsuario(usuario2);
		cusr.registrarProceso(usuario2);
		ControladorVerProcesos cvu=new ControladorVerProcesos();
		cvu.obtenerUsuarios();*/

		//insertar observaciones despues
		/*Date fecha=new Date();
		ObservacionRepositorio obs=new ObservacionRepositorio();
		Observacion observacion= new Observacion("este documento no cuenta no cositas xd", fecha);
		obs.persistirObservacion(observacion, 1, "231DS30");*/
		ControladorActualizarProcesos cta = new ControladorActualizarProcesos();
		UsuarioRepositorio usr=new UsuarioRepositorio();
		Usuario usuarioModificar = usr.buscarUsuario("231DS54");
		usuarioModificar.setNombre("pancracio modificado");

		List<Proceso> procesos =  usuarioModificar.getProcesos();
		Proceso procesoIdentificado = procesos.get(0);
		procesoIdentificado.setNombre("proceso modificaodo");
		usuarioModificar.setProcesos(procesos);
		
		cta.actualizarUsuario( usuarioModificar);


	}
	
}