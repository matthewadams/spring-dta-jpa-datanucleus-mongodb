package app.domain.repo.impl;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnitUtil;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.util.Assert;

import app.domain.Persistable;
import app.domain.repo.CrudJpaRepository;

@Configurable
public abstract class CrudJpaRepositoryImpl<T extends Persistable, ID extends Serializable>
		implements CrudJpaRepository<T, ID> {

	@PersistenceContext
	protected EntityManager em;

	protected EntityManagerFactory emf;

	protected PersistenceUnitUtil puu;

	protected Class<T> type;

	protected CrudJpaRepositoryImpl(Class<T> type) {
		setType(type);
	}

	protected CrudJpaRepositoryImpl(Class<T> type, EntityManager em) {
		setType(type);
		this.em = em;
	}

	protected void setType(Class<T> type) {
		Assert.notNull(type);
		this.type = type;
	}

	@Override
	public <S extends T> S save(S entity) {
		if (em.getEntityManagerFactory().getPersistenceUnitUtil()
				.getIdentifier(entity) == null) {
			em.persist(entity);
		}
		// else no-op; changes will be persisted at commit
		return entity;
	}

	@Override
	public <S extends T> Iterable<S> save(Iterable<S> entities) {
		for (S entity : entities) {
			save(entity);
		}
		return entities;
	}

	@Override
	public T findOne(ID id) {
		return em.find(type, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Iterable<T> findAll() {
		Query q = em.createQuery(
				String.format("select x from %s x", type.getName()), type);
		return q.getResultList();
	}

	@Override
	public long count() {
		Query q = em.createQuery(
				String.format("select count(x) from %s x", type.getName()),
				type);
		return (Long) q.getSingleResult();
	}

	@Override
	public void delete(ID id) {
		Query q = em.createQuery(
				String.format("delete from %s x where x.id = %s",
						type.getName(), id), type);
		q.executeUpdate();
	}

	@Override
	public void delete(T entity) {
		em.remove(entity);
	}

	@Override
	public void delete(Iterable<? extends T> entities) {
		for (T t : entities) {
			delete(t);
		}
	}

	@Override
	public void deleteAll() {
		Query q = em.createQuery(
				String.format("delete from %s x", type.getName()), type);
		q.executeUpdate();
	}

	@Override
	public void flush() {
		em.flush();
	}

	@Override
	public T saveAndFlush(T entity) {
		em.persist(entity);
		em.flush();
		return entity;
	}
}
