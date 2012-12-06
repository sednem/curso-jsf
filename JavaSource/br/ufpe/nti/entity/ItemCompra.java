package br.ufpe.nti.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="item_compra")
@IdClass(ItemCompraPK.class)
public class ItemCompra implements Serializable {
	private static final long serialVersionUID = 1L;
	 
    @Id
    @ManyToOne
    @JoinColumn(name="ID_COMPRA")
    private Compra compra;
 
    @Id
    @ManyToOne
    @JoinColumn(name="ID_LIVRO")
    private Livro livro;
 
    @Column(name="QUANTIDADE")
    private int quantidade;
    
    public ItemCompra(){
    }

	public Compra getCompra() {
		return compra;
	}

	public void setCompra(Compra compra) {
		this.compra = compra;
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
}
