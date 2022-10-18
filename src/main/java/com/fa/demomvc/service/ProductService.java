package com.fa.demomvc.service;

import java.util.List;

import com.fa.demomvc.entity.Product;
import com.fa.demomvc.page.PageAble;

public interface ProductService {

	public List<Product> findAll();

	public List<Product> findWithPageAble(PageAble pageAble);

	public void saveOrUpdate(Product product);

	public void delete(long id);

	public Product findById(long id);

	public int totalPages(PageAble pageAble);

	public List<Product> search(String searchKey);
}
