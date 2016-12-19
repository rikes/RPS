package br.edu.ifes.rps.managedbean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;

import org.json.JSONArray;

import br.edu.ifes.rps.model.Receita;
import br.edu.ifes.rps.repository.ReceitaDAO;
import br.edu.ifes.rps.util.JSFUtil;

@ManagedBean(name="inicioBean", eager = true)

@SessionScoped
public class InicioBean {
	
	private UIComponent uiComponent;
	
	private ReceitaDAO receitaDAO;
	private Receita receita;
	private List<Receita> receitas;
	private List<Receita> receitasFind;
	private List<String> ingredientes;
	private List<String> modoPreparo;
	
	@PostConstruct
	public void inicioManagedBean(){
		this.receitaDAO = ReceitaDAO.getInstance();
		this.receita = new Receita();
	}
	
	public String consulta(){
		if( this.receita.getNomeReceita() == null){
			JSFUtil.adicionarMensagemAviso("Insira uma receita para pesquisa");
			return null;
		}
		this.receitasFind =  this.receitaDAO.buscaReceita(this.receita.getNomeReceita());
		this.receita = new Receita();
		return "listaReceita";
	}
	
	public String detalhes(Receita receita){
		setReceita(receita);
		this.ingredientes = new ArrayList<String>();
		this.modoPreparo = new ArrayList<String>();
		
		JSONArray jIngredientes = new JSONArray(receita.getIngredientes().toString());
		
		for(int i = 0; i < jIngredientes.length(); i++){
			this.ingredientes.add((String)jIngredientes.getJSONObject(i).get("ingredientes"));
		}
		
		JSONArray jmodoPreparo = new JSONArray(receita.getModoPreparo().toString());
		
		for(int i = 0; i < jmodoPreparo.length(); i++){
			this.modoPreparo.add((String)jmodoPreparo.getJSONObject(i).get("preparo"));
		}		
		return "receita";
	}
	
	
	public Receita getReceita() {
		return receita;
	}

	public void setReceita(Receita receita) {
		this.receita = receita;
	}

	public List<Receita> getReceitas() {
		return receitas;
	}

	public void setReceitas(List<Receita> receitas) {
		this.receitas = receitas;
	}

	public UIComponent getUiComponent() {
		return uiComponent;
	}

	public void setUiComponent(UIComponent uiComponent) {
		this.uiComponent = uiComponent;
	}

	public List<Receita> getReceitasFind() {
		return receitasFind;
	}

	public void setReceitasFind(List<Receita> receitasFind) {
		this.receitasFind = receitasFind;
	}

	public List<String> getIngredientes() {
		return ingredientes;
	}

	public void setIngredientes(List<String> ingredientes) {
		this.ingredientes = ingredientes;
	}

	public List<String> getModoPreparo() {
		return modoPreparo;
	}

	public void setModoPreparo(List<String> modoPreparo) {
		this.modoPreparo = modoPreparo;
	}

	
	
		
	
	
	
	
	
}
