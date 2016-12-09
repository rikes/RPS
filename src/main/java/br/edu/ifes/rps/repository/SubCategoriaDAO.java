package br.edu.ifes.rps.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.edu.ifes.rps.model.SubCategoria;

public class SubCategoriaDAO {
	

	private static SubCategoriaDAO instance;
    protected EntityManager entityManager;
    
    /*
     * Cria uma instância única de EntityManagerFactory.
     */     
    public static SubCategoriaDAO getInstance(){
              if (instance == null){
                       instance = new SubCategoriaDAO();
              }
              
              return instance;
    }
    
    
    private SubCategoriaDAO() {
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
    public SubCategoria getById(final int id) {
              return entityManager.find(SubCategoria.class, id);
    }

    /*
     * Retorna uma Lista com todos os objetos da Classe que existem no Banco
     */
    @SuppressWarnings("unchecked")
    public List<SubCategoria> findAll() {
              return entityManager.createQuery("FROM " + SubCategoria.class.getName()).getResultList();
    }
    
    /*
     * Método para salvar um objeto no Banco de dados
     */

    public void persist(SubCategoria subCategoria) {
              try {
                       entityManager.getTransaction().begin();
                       entityManager.persist(subCategoria);
                       entityManager.getTransaction().commit();
              } catch (Exception ex) {
                       ex.printStackTrace();
                       entityManager.getTransaction().rollback();
              }
    }
    
    /*
     * Atualiza um registro no banco, caso não exista ele cria um novo
     */
    public void merge(SubCategoria subCategoria) {
              try {
                       entityManager.getTransaction().begin();
                       entityManager.merge(subCategoria);
                       entityManager.getTransaction().commit();
              } catch (Exception ex) {
                       ex.printStackTrace();
                       entityManager.getTransaction().rollback();
              }
    }
    /*
     * Remove um objeto do banco de dados
     */
    public void remove(SubCategoria subCategoria) {
              try {
                       entityManager.getTransaction().begin();
                       subCategoria = entityManager.find(SubCategoria.class, subCategoria.getId());
                       entityManager.remove(subCategoria);
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
                       SubCategoria subCategoria = getById(id);
                       remove(subCategoria);
              } catch (Exception ex) {
                       ex.printStackTrace();
              }
    }

}
