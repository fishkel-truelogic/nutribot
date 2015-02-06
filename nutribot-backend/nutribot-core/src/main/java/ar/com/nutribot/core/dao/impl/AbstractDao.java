package ar.com.nutribot.core.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ar.com.nutribot.core.dao.Dao;

/**
 * @author lfishkel
 * 
 * @param <K>
 * @param <T>
 */
public class AbstractDao<K extends Serializable, T> implements Dao<K, T> {

	private SessionFactory sessionFactory;
	private Class<T> persistentType;

	@SuppressWarnings("unchecked")
	public AbstractDao() {
		ParameterizedType parameterizedType = (ParameterizedType) this.getClass().getGenericSuperclass();
		this.persistentType = (Class<T>) parameterizedType.getActualTypeArguments()[1];
	}

	@Override
	@SuppressWarnings("unchecked")
	@Transactional(propagation = Propagation.REQUIRED)
	public T findById(Serializable id) {
		Query q = this.getSession().createQuery(String.format("select pe from %s as pe where pe.id = :id", persistentType.getName()));
		q.setParameter("id", id);
		return (T) q.uniqueResult();
	}

	@Override
	@SuppressWarnings("unchecked")
	@Transactional(propagation = Propagation.REQUIRED)
	public List<T> findAll() {
		return this.getSession().createCriteria(this.persistentType).list();
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void save(T object) {
		this.getSession().persist(object);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void update(T object) {
		this.getSession().update(object);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void remove(T object) {
		this.getSession().delete(object);
	}

	@Override
	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	protected Class<T> getPersistentType() {
		return this.persistentType;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
}