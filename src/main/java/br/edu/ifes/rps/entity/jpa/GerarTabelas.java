package br.edu.ifes.rps.entity.jpa;

import java.util.List;


import br.edu.ifes.rps.model.SubCategoria;
import br.edu.ifes.rps.repository.SubCategoriaDAO;


public class GerarTabelas {
	public static void main(String[] args) {
		try {

			
			SubCategoriaDAO subCategoriaDAO = SubCategoriaDAO.getInstance();
			List<SubCategoria> listaCategoria = subCategoriaDAO.findAll();
			
			for (SubCategoria categoria : listaCategoria) {
				  System.out.println(categoria.getSubCategoria());
				}
			
			String quebraLinha = System.getProperty("line.separator"); 
			
			System.out.println(quebraLinha+"Gerado");
		} catch (Exception e) {
			System.out.println("Não Gerado: " + e.getMessage());
		}
	}
}
/*EntityManagerFactory factory = Persistence.createEntityManagerFactory("crudHibernate");

EntityManager manager = factory.createEntityManager();
@SuppressWarnings("unchecked")
List<Categoria> lista = manager
		  .createQuery("select c from Categoria as c")
		  .getResultList();

		for (Categoria categoria : lista) {
		  System.out.println(categoria.getCategoria());
		}
factory.close();*/

