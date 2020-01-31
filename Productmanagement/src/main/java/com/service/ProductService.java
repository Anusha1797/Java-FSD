package com.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.Product;



@Service
public class ProductService {
	@Autowired
	private ProductDao productDao;
	public int addProduct(Product product){
			
			return productDao.addProduct(product);
		}

		
		public Product getProductById(int productId)
		{
			Product product = productDao.getProductById(productId);
			return product;
		}
		
		public int updateProduct(Product product)
		{
			return productDao.updateProduct(product);
		}
		
		public int deleteProduct(int productId)
		{
			return productDao.deleteProduct(productId);
		}
}	
		
		
		
		

	
