package br.ufpe.nti.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.ufpe.nti.entity.Autor;
import br.ufpe.nti.entity.Compra;
import br.ufpe.nti.entity.Editora;
import br.ufpe.nti.entity.Endereco;
import br.ufpe.nti.entity.ItemCompra;
import br.ufpe.nti.entity.Livro;
import br.ufpe.nti.entity.Usuario;
import br.ufpe.nti.util.FormatDate;

public class TesteJPA {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JSF");
		EntityManager em = emf.createEntityManager();
		
		// 	Inerindo Autores.
		Autor a1 = new Autor();
		a1.setNome("Ed Burns");
		
		Autor a2 = new Autor();
		a2.setNome("David Geary");
		
		Autor a3 = new Autor();
		a3.setNome("Cay S. Horstmann");
		
		em.getTransaction().begin();
		em.persist(a1);
		em.persist(a2);
		em.persist(a3);
		em.getTransaction().commit();
		
		
		
		// 	Inserindo Editras
		Editora e1 = new Editora();
		Editora e2 = new Editora();
		Editora e3 = new Editora();
		Editora e4 = new Editora();
		
		e1.setId(1);
		e1.setNome("McGraw-Hill Osborne Media");

		e2.setId(2);
		e2.setNome("Prentice Hall");

		e3.setId(3);
		e3.setNome("Novatec Editora");

		e4.setId(4);
		e4.setNome("Manning");

		em.getTransaction().begin();
		em.persist(e1);
		em.persist(e2);
		em.persist(e3);
		em.persist(e4);
		em.getTransaction().commit();
		
		
		//	Inserindo Livros
		Livro l1 = new Livro();
		Livro l2 = new Livro();
		
		l1.setIsbn("9780071625098");
		l1.setTitulo("JavaServer Faces 2.0, The Complete Reference");
		List<Autor> autores1 = new ArrayList<Autor>();
		autores1.add(a1);		
		autores1.add(a2);
		l1.setAutores(autores1);
		l1.setEditora(e1); 
		l1.setPreco(28.96f);
		l1.setDataPublicacao(FormatDate.getDate("28/12/2009"));

		l2.setIsbn("9780137012893");
		l2.setTitulo("Core JavaServer Faces (3rd Edition)");
		List<Autor> autores2 = new ArrayList<Autor>();
		autores2.add(a3);
		l2.setAutores(autores2);
		l2.setEditora(e2);
		l2.setPreco(36.91f);
		l2.setDataPublicacao(FormatDate.getDate("27/05/2010"));

		em.getTransaction().begin();
		em.persist(l1);
		em.persist(l2);
		em.getTransaction().commit();
		
		
		// 	Inserir usuários
	
		Usuario u1 = new Usuario();
		Usuario u2 = new Usuario();
		
		u1.setCpf("12312312312");
		u1.setLogin("renato");
		u1.setSenha("123");
		u1.setNome("Renato Mendes");
		u1.setSexo("Masculino");
		u1.setDataNascimento(FormatDate.getDate("23/01/1989"));
		u1.setEmail("renato@email.com");
		Endereco end1 = new Endereco();
		end1.setLogradouro("Rua ABC, Nº 123");
		u1.setEndereco(end1);

		u2.setCpf("09898787676");
		u2.setLogin("maria");
		u2.setSenha("asd");
		u2.setNome("Maria José");
		u2.setSexo("Feminino");
		u2.setDataNascimento(FormatDate.getDate("25/05/1985"));
		u2.setEmail("maria@email.com");
		Endereco end2 = new Endereco();
		end2.setLogradouro("Rua 123, Nº 000");
		u2.setEndereco(end2);

		em.getTransaction().begin();
		em.persist(u1);
		em.persist(u2);
		em.getTransaction().commit();
		
		
		// 	Registrar Compra
		 
		Compra c1 = new Compra();
		ItemCompra i1c1 = new ItemCompra();
		ItemCompra i2c1 = new ItemCompra();
		
		Compra c2 = new Compra();
		ItemCompra i1c2 = new ItemCompra();
		
		c1.setUsuario(u1);
		c1.setDataCompra(new Date(System.currentTimeMillis()));
		
		i1c1.setCompra(c1);
		i1c1.setLivro(l1);
		i1c1.setQuantidade(2);
		
		i2c1.setCompra(c1);
		i2c1.setLivro(l2);
		i2c1.setQuantidade(1);
		
		List<ItemCompra> itens1 = new ArrayList<ItemCompra>();
		itens1.add(i1c1);
		itens1.add(i2c1);
		
		c1.setItensCompra(itens1);
		
		c2.setUsuario(u2);
		c2.setDataCompra(new Date(System.currentTimeMillis()));
		
		i1c2.setCompra(c2);
		i1c2.setLivro(l1);
		i1c2.setQuantidade(2);
		
		List<ItemCompra> itens2 = new ArrayList<ItemCompra>();
		itens2.add(i1c2);
		c2.setItensCompra(itens2);

		em.getTransaction().begin();
		em.persist(c1);
		em.persist(c2);
		em.getTransaction().commit();
		//*/
		
		String jpql = "select this from Usuario this";
		Query q = em.createQuery(jpql); 
		
		@SuppressWarnings("unchecked")
		List<Usuario> usuarios = q.getResultList();
		
		System.out.println();
		for (Usuario usuario : usuarios) {
			System.out.println(usuario.getNome());
			
			for (Compra compra : usuario.getCompras()) {
				System.out.println("Compra " + compra.getId() +
						" às " + compra.getDataCompra() +
						": ");
				for (ItemCompra item : compra.getItensCompra()) {
					System.out.println(item.getLivro().getTitulo() +
							" ("+ item.getQuantidade() + ") ");
				}
			}
		}
		System.out.println();
		/*
		String jpql2 = "select this from Compra this";
		Query q2 = em.createQuery(jpql2); 
		
		List<Compra> compras = q2.getResultList();
		for (Compra compra : compras) {
			System.out.println("Compra " + compra.getId() +
					" às " + compra.getDataCompra() +
					"( "+ compra.getUsuario().getNome() +
					" ): ");
			for (ItemCompra item : compra.getItensCompra()) {
				System.out.println(item.getLivro().getTitulo() +
						" ("+ item.getQuantidade() + ") ");
			}
			System.out.println();
		}*/
		
		em.close();
		emf.close();
	}
}