package com.fa.demomvc.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fa.demomvc.entity.Product;
import com.fa.demomvc.page.PageAble;
import com.fa.demomvc.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Override
	@Transactional
	public List<Product> findAll() {
		return productRepository.findAll();
	}

	@Override
	@Transactional
	public void saveOrUpdate(Product product) {
		productRepository.saveOrUpdate(product);
	}

	@Override
	@Transactional
	public void delete(long id) {
		Product product = findById(id);
		if (product != null) {
			productRepository.delete(product);
		}
	}

	@Override
	@Transactional
	public Product findById(long id) {
		return productRepository.findById(id);
	}

	@Override
	@Transactional
	public List<Product> findWithPageAble(PageAble pageAble) {
		List<Product> products = productRepository.findWithPageAble(pageAble);
		return products;
	}

	@Override
	@Transactional
	public int totalPages(PageAble pageAble) {
		long totalRecord = productRepository.count();
		return (int) Math.ceil((double) totalRecord / pageAble.getSize());
	}

	@Override
	@Transactional
	public List<Product> search(String searchKey) {
		return productRepository.search(searchKey);
	}
}
