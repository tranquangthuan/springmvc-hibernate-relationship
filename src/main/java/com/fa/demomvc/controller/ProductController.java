package com.fa.demomvc.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fa.demomvc.entity.Category;
import com.fa.demomvc.entity.Product;
import com.fa.demomvc.page.PageAble;
import com.fa.demomvc.service.CategoryService;
import com.fa.demomvc.service.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productService;

	@Autowired
	private CategoryService categoryService;

	@GetMapping("/list")
	public String getAllProductWithPageAble(Model model, @RequestParam(defaultValue = "1") Integer page) {
		PageAble pageAble = new PageAble(page);
		List<Product> products = productService.findWithPageAble(pageAble);
		model.addAttribute("products", products);
		model.addAttribute("totalPages", productService.totalPages(pageAble));
		model.addAttribute("currentPage", page);

		return "/product/product-list";
	}

	@GetMapping("/add")
	public String showAddForm(Model model) {
		model.addAttribute("productForm", new Product());
		return "/product/new-product";
	}

	@PostMapping("/save")
	public String addNewProduct(@ModelAttribute(name = "productForm") @Valid Product product, BindingResult result) {
		if (result.hasErrors()) {
			return "/product/new-product";
		}
		productService.saveOrUpdate(product);
		return "redirect:/product/list";
	}

	@GetMapping("/delete")
	public String delete(@RequestParam(name = "id") long productId) {
		productService.delete(productId);
		return "redirect:/product/list";
	}

	@RequestMapping("/update/{id}")
	public String update(@PathVariable(name = "id") long productId, Model model) {
		Product product = productService.findById(productId);
		model.addAttribute("productForm", product);
		return "/product/new-product";
	}

	@ModelAttribute("categories")
	public List<Category> initCategories() {
		return categoryService.findAll();
	}

	@GetMapping("/search")
	public String delete(@RequestParam(name = "searchKey") String searchKey, Model model) {
		System.out.println("Search method " + searchKey);
		List<Product> products = productService.search(searchKey);
		model.addAttribute("products", products);
		model.addAttribute("searchKey", searchKey);

		return "/product/product-search";
	}
}
