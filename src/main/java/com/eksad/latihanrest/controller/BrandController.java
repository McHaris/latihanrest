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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.eksad.latihanrest.dao.BrandDao;
import com.eksad.latihanrest.model.Brand;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/api/v1")
@Api(tags = "Brand")
public class BrandController {
	
	@Autowired
	BrandDao brandDao;
	
	
	@ApiOperation(
			value= "API to get all Brand braadddd",
			notes= "Return data with JSON Format ",
			tags= "Get Data API"
			)	
	@GetMapping("getAll")
	public List <Brand> getAll() {
		
		List<Brand>result = new ArrayList<>();
		
		brandDao.findAll().forEach(result::add);
		
		return result;
	}
	@ApiOperation(
			value= "API to get one braddd",
			notes= "Return data with JSON Format ",
			tags= "Get Data API"
			)	
	@GetMapping("getOne/{id}")
	public Brand getOne(@PathVariable Long id) {
		
		return brandDao.findById(id).orElse(null);
				
	}
	
	
	@ApiOperation(
			value= "API to save Brand braaddd",
			notes= "Return data with JSON Format ",
			tags= "Data Manipulating API"
			)	
	@PostMapping(value = "save")
	public Brand save(@RequestBody Brand brand) { //untuk membaca data dalam postman dalam bentuk brand
		try {
			
			return brandDao.save(brand);
		} catch (Exception e) {
		
			e.printStackTrace();
			return null;
		}
	}
	
	@ApiOperation(
			value= "API to update Brand braaddddd",
			notes= "Return data with JSON Format ",
			tags= "Data Manipulating API"
			)	
	@PutMapping(value ="update/{id}")
	public Brand update(@RequestBody Brand brand, @PathVariable Long id) {
		
		Brand brandSelected = brandDao.findById(id).orElse(null);
		if (brandSelected!= null) {
			brandSelected.setName(brand.getName());
			brandSelected.setProductType(brand.getProductType());
			
			brandDao.save(brandSelected);
			return brandDao.save(brandSelected);
		}
		else {
			return null;
		}
		
				
	}
	
	@ApiOperation(
			value= "API to delete Brand bradddd",
			notes= "Return data with JSON Format ",
			tags= "Data Manipulating API"
			)	
	@DeleteMapping(value ="delete/{id}")
	public HashMap<String, Object> delete(@PathVariable Long id) {
		HashMap<String, Object> result = new HashMap<String, Object>();
		brandDao.deleteById(id);
		result.put("message", "Berhasil Dihapus");
		return result;
	}
	
}























