package com.fa.demomvc.service;

import java.util.List;

import com.fa.demomvc.entity.Category;
import com.fa.demomvc.page.PageAble;

public interface CategoryService {

	public List<Category> findAll();

	public List<Category> findWithPageAble(PageAble pageAble);

	public void saveOrUpdate(Category Category);

	public void delete(long id);

	public Category findById(long id);

	public int totalPages(PageAble pageAble);
}
