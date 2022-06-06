package br.com.caelum.livraria.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.caelum.livraria.dao.DAO;
import br.com.caelum.livraria.modelo.Autor;
import br.com.caelum.livraria.modelo.Livro;

@ManagedBean
public class AutorBean {

	private Autor autor = new Autor();
	
	private Integer autorId;

	public Autor getAutor() {
		return autor;
	}
	
	
	public Integer getAutorId() {
		return autorId;
	}



	public void setAutorId(Integer autorId) {
		this.autorId = autorId;
	}



	public void setAutor(Autor autor) {
		this.autor = autor;
	}



	public List<Autor> getAllAutores(){
		return new DAO<Autor>(Autor.class).listaTodos();
	}

	public String gravar() {
		System.out.println("Gravando autor " + this.autor.getNome());
		if(this.autor == null ){
			new DAO<Autor>(Autor.class).adiciona(this.autor);
		}else{
			new DAO<Autor>(Autor.class).atualiza(this.autor);
		}
		
		this.autor = new Autor();
		return "livro?faces-redirect=true";
	}
	
	public void remover(Autor autor){
		System.out.println("apagando autor .....");
		new DAO<Autor>(Autor.class).remove(autor);
	}
	public void editar(Autor autor){
		System.out.println("Editando .......");
		this.autor = autor;
	}
	
	public void carregaPelaId() {
	  this.autor = new DAO<Autor>(Autor.class).buscaPorId(autorId);
	}
}
