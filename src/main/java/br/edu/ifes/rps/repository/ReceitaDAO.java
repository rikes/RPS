package br.edu.ifes.rps.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.edu.ifes.rps.model.Receita;

public class ReceitaDAO {

	
	 private static ReceitaDAO instance;
     protected EntityManager entityManager;
     
     /*
      * Cria uma instância única de EntityManagerFactory.
      */     
     public static ReceitaDAO getInstance(){
               if (instance == null){
                        instance = new ReceitaDAO();
               }
               
               return instance;
     }
     
     
     private ReceitaDAO() {
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
     public Receita getById(final int id) {
               return entityManager.find(Receita.class, id);
     }

     /*
      * Retorna uma Lista com todos os objetos da Classe que existem no Banco
      */
     @SuppressWarnings("unchecked")
     public List<Receita> findAll() {
               return entityManager.createQuery("FROM " + Receita.class.getName()).getResultList();
     }
     
     /*
      * Método para salvar um objeto no Banco de dados
      */

     public void persist(Receita receita) {
               try {
                        entityManager.getTransaction().begin();
                        entityManager.persist(receita);
                        entityManager.getTransaction().commit();
               } catch (Exception ex) {
                        ex.printStackTrace();
                        entityManager.getTransaction().rollback();
               }
     }
     
     /*
      * Atualiza um registro no banco, caso não exista ele cria um novo
      */
     public void merge(Receita receita) {
               try {
                        entityManager.getTransaction().begin();
                        entityManager.merge(receita);
                        entityManager.getTransaction().commit();
               } catch (Exception ex) {
                        ex.printStackTrace();
                        entityManager.getTransaction().rollback();
               }
     }
     /*
      * Remove um objeto do banco de dados
      */
     public void remove(Receita receita) {
               try {
                        entityManager.getTransaction().begin();
                        receita = entityManager.find(Receita.class, receita.getId());
                        entityManager.remove(receita);
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
                        Receita receita = getById(id);
                        remove(receita);
               } catch (Exception ex) {
                        ex.printStackTrace();
               }
     }
}
