package br.edu.ifes.rps.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.edu.ifes.rps.model.Categoria;
public class CategoriaDAO {
	

	private static CategoriaDAO instance;
    protected EntityManager entityManager;
    
    /*
     * Cria uma instância única de EntityManagerFactory.
     */     
    public static CategoriaDAO getInstance(){
              if (instance == null){
                       instance = new CategoriaDAO();
              }
              
              return instance;
    }
    
    
    private CategoriaDAO() {
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
    public Categoria getById(final int id) {
              return entityManager.find(Categoria.class, id);
    }

    /*
     * Retorna uma Lista com todos os objetos da Classe que existem no Banco
     */
    @SuppressWarnings("unchecked")
    public List<Categoria> findAll() {
              return entityManager.createQuery("FROM " + Categoria.class.getName()).getResultList();
    }
    
    /*
     * Método para salvar um objeto no Banco de dados
     */

    public void persist(Categoria categoria) {
              try {
                       entityManager.getTransaction().begin();
                       entityManager.persist(categoria);
                       entityManager.getTransaction().commit();
              } catch (Exception ex) {
                       ex.printStackTrace();
                       entityManager.getTransaction().rollback();
              }
    }
    
    /*
     * Atualiza um registro no banco, caso não exista ele cria um novo
     */
    public void merge(Categoria categoria) {
              try {
                       entityManager.getTransaction().begin();
                       entityManager.merge(categoria);
                       entityManager.getTransaction().commit();
              } catch (Exception ex) {
                       ex.printStackTrace();
                       entityManager.getTransaction().rollback();
              }
    }
    /*
     * Remove um objeto do banco de dados
     */
    public void remove(Categoria categoria) {
              try {
                       entityManager.getTransaction().begin();
                       categoria = entityManager.find(Categoria.class, categoria.getId());
                       entityManager.remove(categoria);
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
                       Categoria categoria = getById(id);
                       remove(categoria);
              } catch (Exception ex) {
                       ex.printStackTrace();
              }
    }

}
