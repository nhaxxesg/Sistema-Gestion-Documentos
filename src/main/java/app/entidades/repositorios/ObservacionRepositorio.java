package app.entidades.repositorios;

import java.util.List;

import javax.persistence.*;
import javax.swing.event.DocumentEvent;

import app.Utilidades.ValidarInformacion;
import app.entidades.*;

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
        this.documentoRepositorio = new DocumentoRepositorio();
        this.usuarioRepositorio = new UsuarioRepositorio();
    }

    public Integer persistirObservacion(Observacion observacion, Integer idDocumento, String codigoEmpleado) {
        Integer idAsignado = null;
        Documento documentoBuscado = documentoRepositorio.buscarDocumento(idDocumento);
        Usuario usuario = usuarioRepositorio.buscarUsuario(codigoEmpleado);
        // podriamos aplicar un validador de que la instancia del usuario recuperado sea
        // un empleado ya que solo un empleado solo
        // puede hacer obeservaciones
        if (!ValidarInformacion.esNulo(observacion) && !ValidarInformacion.esNulo(documentoBuscado)
                && !ValidarInformacion.esNulo(usuario)) {
            try {
                etx.begin();
                observacion.setDocumento(documentoBuscado);
                observacion.setEmpleado((Empleado) usuario);
                em.persist(observacion);
                etx.commit();
                idAsignado = observacion.getIdObservacion();
            } catch (Exception e) {
                etx.rollback();
            }
        }
        return idAsignado;
    }

    public List<Observacion> recuperarObservacionesPorDocumento(Documento documento) {
        List observacionsRecuperadas = em
                .createQuery("select o from Observacion o where o.documento = :id")
                .setParameter("id", documento)
                .getResultList();
        return (List<Observacion>) observacionsRecuperadas;
    }
}
