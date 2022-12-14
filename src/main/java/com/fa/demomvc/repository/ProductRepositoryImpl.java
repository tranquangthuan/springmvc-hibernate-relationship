package com.fa.demomvc.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fa.demomvc.entity.Product;
import com.fa.demomvc.page.PageAble;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Product> findAll() {
		Session session = sessionFactory.getCurrentSession();
		List<Product> products = session.createQuery("SELECT p FROM Product p", Product.class).getResultList();
		return products;
	}

	@Override
	public void saveOrUpdate(Product product) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(product);
	}

	@Override
	public void delete(Product product) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(product);
	}

	@Override
	public Product findById(long id) {
		Session session = sessionFactory.getCurrentSession();
		return session.find(Product.class, id);
	}

	@Override
	public List<Product> findWithPageAble(PageAble pageAble) {
		Session session = sessionFactory.getCurrentSession();
		List<Product> products = session.createQuery("SELECT p FROM Product p", Product.class)
				.setFirstResult(pageAble.getOffset())// Offset
				.setMaxResults(pageAble.getSize()) // limit
				.getResultList();

		return products;
	}

	@Override
	public long count() {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("SELECT COUNT(*) FROM Product p", Long.class).getSingleResult();
	}

	@Override
	public List<Product> search(String searchKey) {
		Session session = sessionFactory.getCurrentSession();
		Query<Product> createQuery = session.createQuery("SELECT p FROM Product p where p.name like :searchKey",
				Product.class);
		createQuery.setParameter("searchKey", "%" + searchKey + "%");
		List<Product> products = createQuery.getResultList();
		return products;
	}
}
