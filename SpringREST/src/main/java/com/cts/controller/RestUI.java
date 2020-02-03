
package com.cts.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestUI {
	@Autowired
	Product product;
	@Autowired
	ProductService pServ;

	//Adding Product 
	@RequestMapping(value="/product",method=RequestMethod.POST,produces = "application/json")
	public ResponseEntity<Product> addProduct(@RequestBody Product product) {
		HttpHeaders headers = new HttpHeaders();
		if(product == null) {
			return new ResponseEntity<Product>(HttpStatus.BAD_REQUEST);
		}
		pServ.addProduct(product);		headers.add("Product Object Created -",String.valueOf(product.getProdId()));
		return new ResponseEntity<Product>(product,headers,HttpStatus.CREATED);
	}
	
	//Get By ID
	@RequestMapping(value="/getbyid/{prodId}",method=RequestMethod.GET)
	public ResponseEntity<Product> getById(@PathVariable("prodId") int prodId) {
		Product product = pServ.getById(prodId);
		if(product == null) {
			return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Product>(product,HttpStatus.OK);
	}
	

	//Delete by ID
	@RequestMapping(value="/delete/{prodId}",method = RequestMethod.DELETE)
	public int deleteProduct(@PathVariable("prodId") int prodId){
		
		
		
		
		
		return pServ.deleteProduct(prodId);

	}
	

	//Update Product Details
	@RequestMapping(value="/update/{pid}", method = RequestMethod.PUT)
	public int updateProduct(@PathVariable("pid") int prodId, @RequestBody Product product){
		
		
		
	
	
		return pServ.updateProduct(product,prodId);
		
	}



}
