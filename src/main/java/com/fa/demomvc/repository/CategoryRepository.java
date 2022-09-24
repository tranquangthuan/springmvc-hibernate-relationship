package com.fa.demomvc.repository;

import java.util.List;

import com.fa.demomvc.entity.Category;
import com.fa.demomvc.page.PageAble;

public interface CategoryRepository {

	public List<Category> findAll();

	public List<Category> findWithPageAble(PageAble pageAble);

	public void saveOrUpdate(Category Category);

	public void delete(Category Category);

	public Category findById(long id);

	public long count();

}
