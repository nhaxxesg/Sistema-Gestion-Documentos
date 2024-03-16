package app;

import java.util.Date;

import app.entidades.Documento;
import app.entidades.Empleado;
import app.entidades.Estudiante;
import app.entidades.Observacion;
import app.entidades.Proceso;
import app.entidades.Usuario;
import app.entidades.repositorios.DocumentoRepositorio;
import app.entidades.repositorios.ProcesoRepositorio;
import app.entidades.repositorios.UsuarioRepositorio;
import app.servicio.UsuarioServicio;

public class App {
	public static void main(String args[]) {
		UsuarioServicio usr=new UsuarioServicio();
		/*
		Usuario estudiante = new Estudiante("231DS14","Josue Angel", "Ferro", "Quispe", "jferro.231ds13@istta.edu.pe","Estudiante", "967191391", "minibumer12", "NO", "DSI", "6");
		Usuario empleado = new Empleado("231DS15","Fernando", "Cuellar", "Izquierdo", "fCuellar.231ds14@istta.edu.pe","Profesor", "967191391", "minibumer12", "NO", "Secretaria Academica", null);
		usr.crearUsuario(empleado);
		*/
		/*Usuario empleado = new Empleado("231DS15","Fernando", "Cuellar", "Izquierdo", "fCuellar.231ds14@istta.edu.pe","Profesor", "967191391", "minibumer12", "NO", "Secretaria Academica", null, null);
		Date fechaActual = new Date();
		Proceso proceso= new Proceso("nuevo proceso2",fechaActual, fechaActual,"pendiente", empleado, null);
		
		Documento documento= new Documento("documento con observacion", fechaActual, fechaActual, fechaActual, "observado", "fisico", proceso);
		Observacion observacion = new Observacion("EL documento no tiene dni", fechaActual, (Empleado)empleado);
		usr.crearProceso(proceso);
		usr.crearDocumento(documento);
		usr.crearObservacion(observacion);*/
		//usr.crearProceso(proceso);
		
		DocumentoRepositorio dc=new DocumentoRepositorio();
		ProcesoRepositorio pc=new ProcesoRepositorio();
		UsuarioRepositorio uc=new UsuarioRepositorio();
		Usuario estudiante = new Estudiante("231DS19","Jimmy", "Perez", "Quispe", "jperez.231ds17@istta.edu.pe","Estudiante", "967191391", "minibumer12", "NO", "DSI", "6", null);
		Date fechaActual = new Date();
		Proceso proceso= new Proceso("",fechaActual, fechaActual,"pendiente", estudiante, null);
		
		Documento documento= new Documento("documento con observacion", fechaActual, fechaActual, fechaActual, "observado", "fisico", proceso);
		
		dc.crearDocumento(documento, pc.crearProceso(proceso, uc.persistirUsuario(estudiante)));
		
		System.out.println("hola mundo");
	}
	
}