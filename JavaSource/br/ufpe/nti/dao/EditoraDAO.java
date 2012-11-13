package br.ufpe.nti.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.ufpe.nti.entity.Editora;

public class EditoraDAO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private List<Editora> editoras;
	
	public EditoraDAO(){
		this.editoras = new ArrayList<Editora>();
		
		Editora e1 = new Editora();
		Editora e2 = new Editora();
		Editora e3 = new Editora();
		Editora e4 = new Editora();
		
		e1.setId(1);
		e1.setNome("McGraw-Hill Osborne Media");
		this.editoras.add(e1);

		e2.setId(2);
		e2.setNome("Prentice Hall");
		this.editoras.add(e2);

		e3.setId(3);
		e3.setNome("Novatec Editora");
		this.editoras.add(e3);

		e4.setId(4);
		e4.setNome("Manning");
		this.editoras.add(e4);
	}
	
	/**
	 * Persiste a editora
	 * @param u Editora a ser persistido
	 */
	public void inserir(Editora u){
		this.editoras.add(u);
	}
	
	/**
	 * Consulta todos as editoras cadastradas
	 * @return Lista de Editoras cadastradas
	 */
	public List<Editora> listar(){
		return this.editoras;
	}
	
	/**
	 * Consulta uma editora pelo ID
	 * @param id da editora desejada
	 * @return Editara que possui o id informado.
	 */
	public Editora consultarPorId(long id){
		Editora editora = null;
		for (Editora e : this.editoras) {
			if(e.getId() == id){
				editora = e;
				break;
			}
		}
		return editora;
	}
}
