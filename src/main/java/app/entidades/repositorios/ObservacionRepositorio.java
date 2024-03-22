package app.entidades.repositorios;

import javax.persistence.*;

import app.entidades.*;
import app.entidades.externos.ValidarInformacion;



public class ObservacionRepositorio {
    private EntityManager em;
	private EntityTransaction etx;
	private EntityManagerFactory emf;
	private DocumentoRepositorio documentoRepositorio;
    private UsuarioRepositorio usuarioRepositorio;

	public ObservacionRepositorio() {
		super();
		this.emf = Persistence.createEntityManagerFactory("persistence");
		this.em = emf.createEntityManager();
		this.etx = em.getTransaction();
        this. documentoRepositorio = new DocumentoRepositorio();
        this.usuarioRepositorio = new UsuarioRepositorio();
	}

    public Integer persistirObservacion(Observacion observacion, Integer idDocumento, String codigoEmpleado){
        Integer idAsignado= null;
        Documento documentoBuscado = documentoRepositorio.buscarDocumento(idDocumento);
        Usuario usuario = usuarioRepositorio.buscarUsuario(codigoEmpleado);
        //podriamos aplicar un validador de que la instancia del usuario recuperado sea un empleado ya que solo un empleado solo 
        //puede hacer obeservaciones
        if(!ValidarInformacion.esNulo(observacion) && !ValidarInformacion.esNulo(documentoBuscado) && !ValidarInformacion.esNulo(usuario)){
            try {
                etx.begin();
                observacion.setDocumento(documentoBuscado);
                observacion.setEmpleado((Empleado)usuario);
                etx.commit();
                idAsignado = observacion.getIdObservacion();
            } catch (Exception e) {
                etx.rollback();
            }
        }
        return idAsignado;
    }
}
