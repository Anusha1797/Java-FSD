package com.service;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import com.product.Product;
	@Repository
	public class ProductDao extends JdbcDaoSupport{
		
		public int addProduct(Product product) {
			int storedStatus=getJdbcTemplate().update("INSERT INTO product values(?,?,?,?)",new Object[]{product. getProductId(),product. getProductName(),product.getQuantity(),product.getProductDescription()});
			System.out.println(storedStatus);
			return product.getProductId();
		}

		public int deleteProduct(int productId) {
			
			int deletedStatus=getJdbcTemplate().update("DELETE from product WHERE product_id = ?",new Object[]{productId});
			System.out.println(deletedStatus);
			return deletedStatus;
		}

		public int updateProduct(Product product) {
			int updateStatus=getJdbcTemplate().update("UPDATE product set product_name = ? , product_quantity = ? , product_description = ? where product_id = ?",new Object[]{product. getProductId(),product. getProductName(),product.getQuantity(),product.getProductDescription()});
		//	System.out.println(updateStatus);
			return updateStatus;
		}

		public Product getProductById(int productId) {
			   Product product = getJdbcTemplate().queryForObject("SELECT * FROM product WHERE product_id = ?",
					     new Object[] { productId }, new BeanPropertyRowMapper<Product>(Product.class));
			return product;
		}

		

		

	}


}
