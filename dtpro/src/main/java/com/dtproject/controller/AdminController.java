package com.dtproject.controller;


import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.dtproject.model.Category;
import com.dtproject.model.Product;
import com.dtproject.model.Supplier;
import com.dtproject.service.CategoryService;
import com.dtproject.service.ProductService;
import com.dtproject.service.SupplierService;

@Controller

public class AdminController 
{
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private SupplierService supplierService;
	@Autowired
	private productService productService;
	
	@RequestMapping("/adding")
	public ModelAndView adding() 
	{
		
		ModelAndView mv=new ModelAndView();
		Product product=new Product();
		Category category=new Category();
		Supplier supplier=new Supplier();
		
		mv.addObject("pro", product);
		mv.addObject("cat", category);
		mv.addObject("sup", supplier);
		
		List<Category> categoryList=(List<Category>)categoryService.getAllCategories();
		
		List<Product> productList=productService.getAllProducts();
		
		mv.addObject("catList",categoryList);
		mv.addObject("proList",productList);
		
		return mv;
	}
		@RequestMapping(value="/saveCategory",method=RequestMethod.POST)
		public String saveCategory(@ModelAttribute Category category)
		{
			categoryService.saveCategory(category);
			return "redirect:/adding";
		}
		@RequestMapping(value="/saveProduct",method=RequestMethod.POST)
		public String saveProduct(@ModelAttribute Product product,@RequestParam("pic") MultipartFile mFile)
		{
			String fileName= mFile.getOriginalFilename();
			System.out.println(product.getpName());
			String rootPath="E:\\dtpro\\src\\main\\resources\\images";
		if(!mFile.isEmpty())
		{
			try
			{
				byte b[]=mFile.getBytes();
				File file=new File(rootPath+File.separator+fileName);
				FileOutputStream fout=new FileOutputStream(file);
				BufferedOutputStream bout=new BufferedOutputStream(fout);
				bout.write(b);
				bout.close();
				fout.close();
				System.out.println("file saved successfully");
				product.setImgName(fileName);
			
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
			productService.saveProduct(product);
			
			return "redirect:/adding";
		}
		
		@RequestMapping(value="/saveSupplier",method=RequestMethod.POST)
		public String saveSupplier(@ModelAttribute Supplier supplier,@RequestParam int pId)
		{
			supplierService.saveSupplier(supplier, pId);
			return "redirect:/adding";
		
		}
		
		@RequestMapping("/showProduct")
		public String showProduct(ModelAndView m)
		{
			List<Product> product=productService.getAllProducts();
			m.addObject("proList",product);
			m.setViewName("showProducts");
			return "m";
		}
		
		
		
	}
