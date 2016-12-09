package br.edu.ifes.rps.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;

import br.edu.ifes.rps.model.Usuario;

public class UsuarioDAO {

	private static UsuarioDAO instance;
	protected EntityManager entityManager;

	/*
	 * Cria uma instância única de EntityManagerFactory.
	 */
	public static UsuarioDAO getInstance() {
		if (instance == null) {
			instance = new UsuarioDAO();
		}

		return instance;
	}

	private UsuarioDAO() {
		entityManager = getEntityManager();
	}

	/*
	 * Retorna a instância inicializada ou cria uma nova
	 */
	private EntityManager getEntityManager() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("crudHibernate");
		if (entityManager == null) {
			entityManager = factory.createEntityManager();
		}

		return entityManager;
	}

	/*
	 * Retorna um Objeto da Classe de acordo com seu ID
	 */
	public Usuario getById(final int id) {
		return entityManager.find(Usuario.class, id);
	}

	/*
	 * Retorna uma Lista com todos os objetos da Classe que existem no Banco
	 */
	@SuppressWarnings("unchecked")
	public List<Usuario> findAll() {
		return entityManager.createQuery("FROM " + Usuario.class.getName()).getResultList();
	}

	/*
	 * Método para salvar um objeto no Banco de dados
	 */

	public void persist(Usuario usuario) {
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(usuario);
			entityManager.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}

	/*
	 * Atualiza um registro no banco, caso não exista ele cria um novo
	 */
	public void merge(Usuario usuario) {
		try {
			entityManager.getTransaction().begin();
			entityManager.merge(usuario);
			entityManager.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}

	/*
	 * Remove um objeto do banco de dados
	 */
	public void remove(Usuario usuario) {
		try {
			entityManager.getTransaction().begin();
			usuario = entityManager.find(Usuario.class, usuario.getId());
			entityManager.remove(usuario);
			entityManager.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}

	/*
	 * Remove um objeto do banco de dados passando o ID
	 */
	public void removeById(final int id) {
		try {
			Usuario usuario = getById(id);
			remove(usuario);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	/*
	 * Retorna usuário de acordo com seu email e senha Caso não exista retorna
	 * null
	 */
	public Usuario getUsuario(String email, String senha) {
	   
       try {
             Usuario usuario = (Usuario) entityManager.createQuery(
                                    "SELECT u from Usuario u where u.email = :email and u.senha = :senha")
                        .setParameter("email", email)
                        .setParameter("senha", senha).getSingleResult();

             return usuario;
       } catch (NoResultException e) {
             return null;
       }

	}
}
