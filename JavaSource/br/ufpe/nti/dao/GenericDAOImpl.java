package br.ufpe.nti.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class GenericDAOImpl<T, I extends Serializable> implements GenericDAO<T, I>, Serializable {

	private static final long serialVersionUID = 6067158566682014012L;
	
	@PersistenceContext
	private EntityManager entityManager = null;
	private Class<?> domain;
	
	public EntityManager getEntityManager() {
		return entityManager;
	}

	private Class<?> getDomainClass() {
		if (this.domain == null) {
			this.domain = getGenericTypeArgument(this.getClass(), 0);
		}
		return this.domain;
	}

	@SuppressWarnings("unchecked")
	public static <T> Class<T> getGenericTypeArgument(final Class<?> clazz, final int idx) {
		final Type type = clazz.getGenericSuperclass();
		ParameterizedType paramType;
		try {
			paramType = (ParameterizedType) type;
		} catch (ClassCastException cause) {
			paramType = (ParameterizedType) ((Class<T>) type).getGenericSuperclass();
		}
		return (Class<T>) paramType.getActualTypeArguments()[idx];
	}

	@Transactional
	@Override
	public void insert(T object) {
		this.entityManager.persist(object);
	}
	@Transactional
	@Override
	public void delete(T object) {
		object = this.entityManager.merge(object);
		this.entityManager.remove(object);
	}
	@Transactional
	@Override
	public T update(T object) {
		return this.entityManager.merge(object);
	}
	@Transactional
	@Override
	public T findByPK(I id) {
		@SuppressWarnings("unchecked")
		T object = (T) this.entityManager.find(getDomainClass(), id);
		return object;
	}
	@Override
	public List<T> findAll() {
		String jpql = "select this from "+ getDomainClass().getSimpleName() +" this";
		Query q = this.entityManager.createQuery(jpql); 
		@SuppressWarnings("unchecked")
		List<T> lista = q.getResultList();
		return lista;
	}
	
}