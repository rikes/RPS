package br.edu.ifes.rps.entity.jpa;

import java.util.List;


import br.edu.ifes.rps.model.Receita;
import br.edu.ifes.rps.model.SubCategoria;
import br.edu.ifes.rps.repository.ReceitaDAO;
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
			///////////////
			//Receitas
			
			ReceitaDAO receitaDAO = ReceitaDAO.getInstance();
			List<Receita> receitas = receitaDAO.buscaReceita("peru");
			System.out.println(receitas.size());
			
			
		
			
						
//			for (Receita receita : receitas) {
//				System.out.println(receita.getNomeReceita());
//			}
			/*
			 * [{"ingredientes":"1 colher (sopa) de óleo"},
			 * {"ingredientes":"3 colheres (sopa) de cebola ralada"},
			 * {"ingredientes":"1 dente de alho picado"},
			 * {"ingredientes":"1 1/2 xícara (chá) de arroz lavado e escorrido"},
			 * {"ingredientes":"3 xícaras (chá) de água fervente"},{"ingredientes":"1 cubo de caldo de legumes"},{"ingredientes":"Sal e pimenta do reino a gosto"},{"ingredientes":"1 xícara (chá) de frango cozido e desfiado"},{"ingredientes":"1/2 xícara (chá) de cenoura em cubos pequenos"},{"ingredientes":"1 xícara (chá) de ervilha fresca congelada"},{"ingredientes":"1 pimentão vermelho picado"},{"ingredientes":"1/4 xícara (chá) de uvas passas pretas sem sementes"}]
			 */
			
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

