package app.servicio;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.eclipse.persistence.internal.oxm.schema.model.List;

import app.entidades.*;
import app.entidades.repositorios.DocumentoRepositorio;
import app.entidades.repositorios.ObservacionRepositorio;
import app.entidades.repositorios.ProcesoRepositorio;
import app.entidades.repositorios.UsuarioRepositorio;

public class ControladorRegistrarProceso {
    private UsuarioRepositorio usuarioRepositorio;
    private ProcesoRepositorio procesoRepositorio;
    private ObservacionRepositorio observacionRepositorio;
    private DocumentoRepositorio documentoRepositorio;
    private EntityManager em;
	private EntityTransaction etx;
	private EntityManagerFactory emf;

    public ControladorRegistrarProceso(){
        this.usuarioRepositorio = new UsuarioRepositorio();
        this.procesoRepositorio = new ProcesoRepositorio();
        this.observacionRepositorio = new ObservacionRepositorio();
        this.documentoRepositorio = new DocumentoRepositorio();
        this.emf = Persistence.createEntityManagerFactory("persistence");
		this.em = emf.createEntityManager();
		this.etx = em.getTransaction();
    }

    /* FUNCION registrarProceso (usuario)                                         
        ES                                                                         
        proceso = obtener proceso de usuario                                       
        documentos = obtener lista de documento de proceso                         
                                                                                
                                                                                
        idAsignadoUsuario =  persistirUsuario();                                   
        idAsignadoProceso = persistirProceso()                                     
        PARA documento DE una lista de documento                                   
        persistirDocumento(documento)                                              
        observaciones = obtener observaciones de documento                         
        PARA observacion DE observaciones                                          
        persistir observacion  */
    public void registrarProceso(Usuario usuario){
        String idAsignadoUsuario = this.usuarioRepositorio.persistirUsuario(usuario);
        Proceso proceso= usuario.getProcesos().get(0);
        java.util.List<Documento> documentos = proceso.getDocumentos();
        Integer idAsignadoProceso = this.procesoRepositorio.persistirProceso(proceso, idAsignadoUsuario);
        for (Documento documento : documentos) {
            Integer idAsignadoDocumento = this.documentoRepositorio.persistirDocumento(documento, idAsignadoProceso);
            java.util.List<Observacion> observaciones = documento.getObservaciones();
            for (Observacion observacion : observaciones) {
                this.observacionRepositorio.persistirObservacion(observacion, idAsignadoDocumento, idAsignadoUsuario);
            }
        }
    }

    public void informacionProcesos(){
        
    }

}
