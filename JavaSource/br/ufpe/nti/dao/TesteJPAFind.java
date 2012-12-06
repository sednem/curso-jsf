package br.ufpe.nti.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.ufpe.nti.entity.Livro;

public class TesteJPAFind {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JSF");
		EntityManager em = emf.createEntityManager();
		try {
            em.getTransaction().begin();
 
            Livro livro = em.find(Livro.class, 1L);
            
            System.out.println();
            System.out.println();
            System.out.println(livro.getTitulo());
            
            System.out.println();
            System.out.println();
            System.out.println(livro.getEditora().getNome());
            
            em.getTransaction().commit();
        }
        catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        }
        finally{
    		em.close();
    		emf.close();
        }
		
	}
}
