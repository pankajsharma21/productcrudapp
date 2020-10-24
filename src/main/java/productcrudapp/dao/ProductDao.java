package productcrudapp.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import productcrudapp.model.Product;

@Repository
public class ProductDao {
    @Autowired
	private HibernateTemplate hibernateTemplate;
	
    //create
    @Transactional
    public void createProduct(Product product){
    	
    	this.hibernateTemplate.saveOrUpdate(product);
    }
    
    //getall Products
    
    public List<Product> getproducts(){
    	List<Product> products = this.hibernateTemplate.loadAll(Product.class);
    	 return products;
    }
    //delete the single product
    @Transactional
    public void deleteProduct(int pid) {
    	
    	Product p = this.hibernateTemplate.load(Product.class,pid);
        this.hibernateTemplate.delete(p);     
    }
    
    //get the single product
    public Product getproduct(int pid) {
    	
    return this.hibernateTemplate.get(Product.class, pid);	
    	
    }
    }
    
