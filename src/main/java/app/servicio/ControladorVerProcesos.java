package app.servicio;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.ListCellRenderer;
import javax.swing.text.html.parser.Entity;

import com.mysql.cj.protocol.InternalTime;

import app.entidades.Documento;
import app.entidades.Observacion;
import app.entidades.Proceso;
import app.entidades.Usuario;
import app.entidades.externos.ValidarInformacion;
import app.entidades.repositorios.DocumentoRepositorio;
import app.entidades.repositorios.ObservacionRepositorio;
import app.entidades.repositorios.ProcesoRepositorio;
import app.entidades.repositorios.UsuarioRepositorio;


public class ControladorVerProcesos {
    private DocumentoRepositorio documentoRepositorio;
    private ProcesoRepositorio procesoRepositorio;
    private UsuarioRepositorio usuarioRepositorio;
    private ObservacionRepositorio observacionRepositorio;
    

    public ControladorVerProcesos() {
        this.documentoRepositorio = new DocumentoRepositorio();
        this.procesoRepositorio = new ProcesoRepositorio();
        this.observacionRepositorio = new ObservacionRepositorio();
        this.usuarioRepositorio = new UsuarioRepositorio();
    }


    public List<Documento> obtenerDocumentosPorProceso(Integer idProceso){
        List<Documento> documentosRecuperados=null;
        Proceso procesoAsociado = procesoRepositorio.buscaProceso(idProceso);
        if (!ValidarInformacion.esNulo(procesoAsociado)) {
            documentosRecuperados= documentoRepositorio.verDocumentosPorProceso(procesoAsociado);
        }
        return documentosRecuperados;
    }

    public Usuario buscarUsuarioPorCodigo(String codigo){
        return usuarioRepositorio.buscarUsuario(codigo);
    }

    public Proceso buscaProcesoPorId(Integer idProceso){
        return procesoRepositorio.buscaProceso(idProceso);
    }

    public List<Object[]> obtenerInformacionGeneral(){
        return usuarioRepositorio.obtenerUsuarios();
    }

    public List<Observacion> obtenerObservacionesPorDocumento(Integer documento){
        List<Observacion> observacionesRecuperadas=null;
        Documento documentoAsociado = documentoRepositorio.buscarDocumento(documento);
        if(!ValidarInformacion.esNulo(documentoAsociado)){
            observacionesRecuperadas = observacionRepositorio.recuperarObservacionesPorDocumento(documentoAsociado);
        }
        return observacionesRecuperadas;
    }

    public List<Object[]> buscarPorPatron(String patron){
        return usuarioRepositorio.buscarInformacionUsuariosPorPatron(patron);
    }

}
