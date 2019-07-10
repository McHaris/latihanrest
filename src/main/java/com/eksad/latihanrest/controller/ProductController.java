package com.eksad.latihanrest.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eksad.latihanrest.dao.BrandDao;
import com.eksad.latihanrest.dao.ProductDao;
import com.eksad.latihanrest.model.Brand;
import com.eksad.latihanrest.model.Product;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/api/v1")
@Api(tags = "Product")
public class ProductController {
	@Autowired
	ProductDao productDao;
	
	@Autowired
	BrandDao brandDao;
	@ApiOperation(
			  value = "API to retrieve Product data by Brand Id braadd ",
			  notes = "Return data with JSON Format",
			  tags = "Get Data API")
	@GetMapping("getByBrandIdProduct/{brandId}")
	public List<Product> getByBrandId(@PathVariable Long brandId) {
		List<Product> result = new ArrayList<Product>();
		productDao.findByBrandId(brandId).forEach(result::add);
		return result;
	}
	@ApiOperation(
			  value = "API to insert data Product bradd",
			  notes = "Return data with JSON Format",
			  tags = "Data Manipulation API")
	@PostMapping(value = "saveproduct")
	public Product save(@RequestBody Product product) {
		Brand brand = brandDao.findById(product.getBrandId()).orElse(null);
		if(brand != null) {
			product.setBrand(brand);
			return productDao.save(product);
		}
		return null;
	}
	@ApiOperation(
			  value = "API to update data product braaddd",
			  notes = "Return data with JSON Format",
			  tags = "Data Manipulation API")
	@PutMapping(value ="updateproduct/{id}")
	public String update(@RequestBody Product product,@PathVariable Long id) {
		Product productSelected = productDao.findById(id).orElse(null);
		
		if(productSelected != null) {
			productSelected.setName(product.getName());
			productSelected.setBrandId(product.getBrandId());
			productSelected.setBrand(product.getBrand());
			productSelected.setPrice(product.getPrice());
			
			productDao.save(productSelected);
			return "berhasil memperbaharui";
		}else {
			return "gagal memperbaharui";
		}
	}
	@ApiOperation(
			  value = "API to delete Product braddd",
			  notes = "Return data with JSON Format",
			  tags = "Data Manipulation API")
	@DeleteMapping(value ="deleteproduct/{id}")
	public HashMap<String, Object> delete(@PathVariable Long id){
		HashMap<String, Object> result = new HashMap<String, Object>();
		productDao.deleteById(id);
		result.put("message","Berhasil di hapus");
		return result;
	}
	
	@ApiOperation(
			  value = "API to search data Product by Name braadddd",
			  notes = "Return data with JSON Format",
			  tags = "Get Data API")
	@GetMapping(value ="search/{name}")
	public List<Product> search(@PathVariable String search){
		List<Product> result = new ArrayList<Product>();
		productDao.findBySearch(search).forEach(result::add);
		
		return result;
		};
	}