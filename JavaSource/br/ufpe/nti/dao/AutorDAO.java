package br.ufpe.nti.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.ufpe.nti.entity.Autor;

public class AutorDAO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private List<Autor> autores;
	
	public AutorDAO(){
		this.autores = new ArrayList<Autor>();
		
		Autor a1 = new Autor();
		Autor a2 = new Autor();
		Autor a3 = new Autor();
		Autor a4 = new Autor();
		
		a1.setId(1);
		a1.setNome("Ed Burns");
		this.autores.add(a1);

		a2.setId(2);
		a2.setNome("Chris Schalk");
		this.autores.add(a2);

		a3.setId(3);
		a3.setNome("David Geary");
		this.autores.add(a3);

		a4.setId(4);
		a4.setNome("Cay S. Horstmann");
		this.autores.add(a4);
	}
	
	/**
	 * Persiste o Autor
	 * @param a Autor a ser persistido
	 */
	public void inserir(Autor a){
		this.autores.add(a);
	}
	
	/**
	 * Consulta todos os autores cadastrados
	 * @return Lista de Autores cadastrados
	 */
	public List<Autor> listar(){
		return this.autores;
	}
	
	/**
	 * Consulta um autor pelo ID
	 * @param id do autor desejado
	 * @return Autor que possui o id informado.
	 */
	public Autor consultarPorId(long id){
		Autor autor = null;
		for (Autor e : this.autores) {
			if(e.getId() == id){
				autor = e;
				break;
			}
		}
		return autor;
	}
}
