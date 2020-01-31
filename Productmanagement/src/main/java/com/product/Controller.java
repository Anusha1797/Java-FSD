package com.product;

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
public class Contoller {
	
	@Autowired
	private ProductService productService;
	//displayProductById
	@RequestMapping(value = "/Product/{pid}", method = RequestMethod.GET)
	public ResponseEntity<Product> getProductById(@PathVariable("pid") int productid) {
		
		Product product = productService.getProductById(productid);
		if (product == null) {
			   return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
			  }
			  return new ResponseEntity<Product>(product, HttpStatus.OK);	
	}
	
	@RequestMapping(value = "/Product/upadate/{id}",method = RequestMethod.PUT)
	public ResponseEntity<Product> updateProduct(@PathVariable("id") int productid,@RequestBody Product product)
	{
		HttpHeaders headers = new HttpHeaders();
		Product product1 = productService.getProductById(productid);
		
		if (product1 == null) {
			   return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
			  }
		else if (product == null) {
			   return new ResponseEntity<Product>(HttpStatus.BAD_REQUEST);
			  }
		
		productService.updateProduct(product);
			  headers.add("Product Updated  - ", String.valueOf(productid));
			  return new ResponseEntity<Product>(product, headers, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/product", method = RequestMethod.POST,produces = "application/json")
	 public ResponseEntity<Product> addProduct(@RequestBody Product product) {
	  HttpHeaders headers = new HttpHeaders();
	  if (product == null) {
	   return new ResponseEntity<Product>(HttpStatus.BAD_REQUEST);
	  }
	  productService.addProduct(product);
	  headers.add("Employee Created  - ", String.valueOf(product.getProductId()));
	  return new ResponseEntity<Product>(product, headers, HttpStatus.CREATED);
	 }
	@RequestMapping(value = "/product/delete/{id}", method = RequestMethod.DELETE,produces = "application/json")
	public ResponseEntity<Product> deleteProduct(@PathVariable("id") int productid)
	{
		HttpHeaders headers = new HttpHeaders();
		Product product1 = productService.getProductById(productid);
		
		if (product1 == null) {
			   return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
		}	
		    productService.deleteProduct(productid);
			  headers.add("Product Updated  - ", String.valueOf(productid));
			  return new ResponseEntity<Product>(product1, headers, HttpStatus.OK);
	}

	
	
	
}
}
