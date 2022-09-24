package com.fa.demomvc.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fa.demomvc.entity.Category;
import com.fa.demomvc.page.PageAble;
import com.fa.demomvc.repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository CategoryRepository;

	@Override
	@Transactional
	public List<Category> findAll() {
		return CategoryRepository.findAll();
	}

	@Override
	@Transactional
	public void saveOrUpdate(Category Category) {
		CategoryRepository.saveOrUpdate(Category);
	}

	@Override
	@Transactional
	public void delete(long id) {
		Category Category = findById(id);
		if (Category != null) {
			CategoryRepository.delete(Category);
		}
	}

	@Override
	@Transactional
	public Category findById(long id) {
		return CategoryRepository.findById(id);
	}

	@Override
	@Transactional
	public List<Category> findWithPageAble(PageAble pageAble) {
		return CategoryRepository.findWithPageAble(pageAble);
	}

	@Override
	@Transactional
	public int totalPages(PageAble pageAble) {
		long totalRecord = CategoryRepository.count();
		return (int) Math.ceil((double) totalRecord / pageAble.getSize());
	}

}
