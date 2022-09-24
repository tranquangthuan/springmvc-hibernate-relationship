package com.fa.demomvc.repository;

import java.util.List;

import com.fa.demomvc.entity.Product;
import com.fa.demomvc.page.PageAble;

public interface ProductRepository {

	public List<Product> findAll();

	public List<Product> findWithPageAble(PageAble pageAble);

	public void saveOrUpdate(Product product);

	public void delete(Product product);

	public Product findById(long id);

	public long count();

}
