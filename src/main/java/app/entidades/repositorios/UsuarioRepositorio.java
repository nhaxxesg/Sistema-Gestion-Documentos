package app.entidades.repositorios;

import java.util.List;

import javax.persistence.*;

import org.eclipse.persistence.mappings.converters.ObjectTypeConverter;

import app.Utilidades.ValidarInformacion;
import app.entidades.Usuario;

public class UsuarioRepositorio {
	private EntityManager em;
	private EntityTransaction etx;
	private EntityManagerFactory emf;

	public UsuarioRepositorio() {
		super();
		this.emf = Persistence.createEntityManagerFactory("persistence");
		this.em = emf.createEntityManager();
		this.etx = em.getTransaction();
	}

	public String persistirUsuario(Usuario usuario) {
		String idAsignado = null;
		if (!ValidarInformacion.esNulo(usuario) && !existeUsuario(usuario)) {
			try {
				etx.begin();
				em.persist(usuario);
				etx.commit();
				idAsignado = usuario.getCodigo();
			} catch (Exception e) {
				etx.rollback();
			}
		}
		return idAsignado;
	}

	public boolean existeUsuario(Usuario usuario) {
		boolean existe = false;
		if (em.find(Usuario.class, usuario.getCodigo()) != null) {
			existe = true;
		}
		return existe;
	}

	public boolean existeUsuario(String codigoUsuario) {
		boolean existe = false;
		if (em.find(Usuario.class, codigoUsuario) != null) {
			existe = true;
		}
		return existe;
	}

	public Usuario buscarUsuario(String codigo) {
		return em.find(Usuario.class, codigo);
	}

	public void persistirUsuarioRefactorizado(Usuario usuario) {
		this.etx.begin();
		this.em.persist(usuario);
		this.etx.commit();

	}

	@SuppressWarnings("unchecked")
	public List<Object[]> obtenerUsuarios() {
		List<Object[]> lista = this.em.createQuery(
				"select u.codigo, u.nombre, p.nombre, p.estado, COUNT(d) from Usuario u JOIN u.procesos p JOIN p.documentos d GROUP BY u.codigo, u.nombre, p.nombre, p.estado")
				.getResultList();
		return lista;
	}

	@SuppressWarnings("unchecked")
	public List<Object[]> buscarInformacionUsuariosPorPatron(String patron) {
		List<Object[]> lista = this.em.createQuery(
				"select u.codigo, u.nombre, p.nombre, p.estado, COUNT(d) from Usuario u JOIN u.procesos p JOIN p.documentos d where CONCAT(u.codigo, u.nombre, p.nombre, p.estado) like :patron GROUP BY u.codigo, u.nombre, p.nombre, p.estado")
				.setParameter("patron", ('%' + patron + '%'))
				.getResultList();
		return lista;
	}

	public void actualizarUsuario(Usuario usuarioActualizado) {
		this.etx.begin();
		em.merge(usuarioActualizado);
		this.etx.commit();
	}

	public Object buscarUsuarioPorCorreoInstitucional(String correoInstitucional) {
		Object resultado = em.createQuery("select u from Usuario u where u.correoInstitucional like :correo")
				.setParameter("correo", correoInstitucional)
				.getSingleResult();
		return resultado;
	}
}
