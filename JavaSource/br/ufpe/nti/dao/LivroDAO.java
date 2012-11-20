package br.ufpe.nti.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.ufpe.nti.entity.Livro;
import br.ufpe.nti.util.FormatDate;

public class LivroDAO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private List<Livro> livros;
	
	public LivroDAO(){
		EditoraDAO edtDAO = new EditoraDAO();
		//AutorDAO autorDAO = new AutorDAO();
		this.livros = new ArrayList<Livro>();
		
		Livro l1 = new Livro();
		Livro l2 = new Livro();
		Livro l3 = new Livro();
		
		l1.setId(1);
		l1.setIsbn("978-0071625098");
		l1.setTitulo("JavaServer Faces 2.0, The Complete Reference");
		l1.setAutor("Ed Burns e  Chris Schalk");
//		List<Autor> autores1 = new ArrayList<Autor>();
//		autores1.add(autorDAO.consultarPorId(1));
//		autores1.add(autorDAO.consultarPorId(2));
//		l1.setAutores(autores1);
		l1.setEditora(edtDAO.consultarPorId(1)); 
		l1.setPreco(28.96f);
		l1.setDataPublicacao(FormatDate.getDate("28/12/2009"));
		this.livros.add(l1);

		l2.setId(2);
		l2.setIsbn("978-0137012893");
		l2.setTitulo("Core JavaServer Faces (3rd Edition)");
		l2.setAutor("David Geary e Cay Horstmann");
//		List<Autor> autores2 = new ArrayList<Autor>();
//		autores2.add(autorDAO.consultarPorId(3));
//		autores2.add(autorDAO.consultarPorId(4));
//		l2.setAutores(autores2);
		l2.setEditora(edtDAO.consultarPorId(2));
		l2.setPreco(36.91f);
		l2.setDataPublicacao(FormatDate.getDate("27/05/2010"));
		this.livros.add(l2);

		l3.setId(3);
		l3.setIsbn("978-1-933988-54-2");
		l3.setTitulo("Open Source SOA");
		l3.setAutor("Jeff Davis");
//		List<Autor> autores2 = new ArrayList<Autor>();
//		autores2.add(autorDAO.consultarPorId(3));
//		autores2.add(autorDAO.consultarPorId(4));
//		l3.setAutores(autores2);
		l3.setEditora(edtDAO.consultarPorId(4));
		l3.setPreco(49.99f);
		l3.setDataPublicacao(FormatDate.getDate("01/05/2009"));
		this.livros.add(l3);
	}
	
	/**
	 * Persiste o usuário
	 * @param u Livro a ser persistido
	 */
	public void inserir(Livro u){
		this.livros.add(u);
	}
	
	/**
	 * Consulta todos os usuário cadastrados
	 * @return Lista de Livros cadastrados
	 */
	public List<Livro> listar(){
		return this.livros;
	}
	
	/**
	 * Consulta um livro pelo ID
	 * @param id do livro desejado
	 * @return Livro que possui o id informado.
	 */
	public Livro consultarPorId(long id){
		Livro livro = null;
		for (Livro l : this.livros) {
			if(l.getId() == id){
				livro = l;
				break;
			}
		}
		return livro;
	}

	public void editar(Livro livro) {
		this.livros.remove(this.consultarPorId(livro.getId()));
		
		this.livros.add(livro);
	}
}
