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
		this.livros = new ArrayList<Livro>();
		
		Livro l1 = new Livro();
		Livro l2 = new Livro();
		
		l1.setId(1);
		l1.setIsbn("978-0071625098");
		l1.setTitulo("JavaServer Faces 2.0, The Complete Reference");
		l1.setAutor("Ed Burns e  Chris Schalk");
		l1.setEditora(edtDAO.consultarPorId(1)); 
		l1.setPreco(28.96f);
		l1.setDataPublicacao(FormatDate.getDate("28/12/2009"));
		this.livros.add(l1);

		l2.setId(2);
		l2.setIsbn("978-0137012893");
		l2.setTitulo("Core JavaServer Faces (3rd Edition)");
		l2.setAutor("David Geary e Cay S. Horstmann");
		l2.setEditora(edtDAO.consultarPorId(2));
		l2.setPreco(36.91f);
		l2.setDataPublicacao(FormatDate.getDate("27/05/2010"));
		this.livros.add(l2);
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
}
