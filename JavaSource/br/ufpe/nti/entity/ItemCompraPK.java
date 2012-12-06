package br.ufpe.nti.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ItemCompraPK implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Column
    private long livro;
    @Column
    private long compra;
    
    public ItemCompraPK(){
    }

    @Override
    public boolean equals(Object obj) {
    	
    	return this.hashCode() == obj.hashCode();
    }
    
    @Override
    public int hashCode() {
    	String hash = 
    			this.getCompra()+":"+this.getLivro();
    	return hash.hashCode();
    }

	public long getLivro() {
		return livro;
	}

	public void setLivro(long livro) {
		this.livro = livro;
	}

	public long getCompra() {
		return compra;
	}

	public void setCompra(long compra) {
		this.compra = compra;
	}
}