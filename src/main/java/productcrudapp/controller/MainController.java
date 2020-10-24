package productcrudapp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import productcrudapp.dao.ProductDao;
import productcrudapp.model.Product;

@Controller
public class MainController {

/*	by giving / as url pattern in @RequestMapping we able to acces home page in view folder 
 * that we are unable to access or acces by redirect code in index.jsp page created default by eclips
 * we have to option this / and page redirecting code
*/	
	@Autowired
	private ProductDao productDao;
	
	@RequestMapping("/")
	public String home(Model m){
	List<Product> products= productDao.getproducts();
	m.addAttribute("products",products);
		return"index";
	}
	
	//show add product form
	@RequestMapping("/add-product")
	public String addProduct(Model m) {
		m.addAttribute("title","Add Product");
		return "add_product_form";
	}
	//handle add product form
	@RequestMapping(value = "/handle-product",method=RequestMethod.POST)
	public RedirectView handleProduct(@ModelAttribute Product product,HttpServletRequest request) {
		System.out.println(product);
		productDao.createProduct(product);
		RedirectView redirectView =new RedirectView();
		redirectView.setUrl(request.getContextPath()+"/");
		return redirectView;
	}
	
	
	//delete handler
	@RequestMapping("/delete/{productId}")
	public RedirectView deleteProduct(@PathVariable("productId") int productId,HttpServletRequest request) {
		this.productDao.deleteProduct(productId);
		RedirectView redirectView =new RedirectView();
		redirectView.setUrl(request.getContextPath()+"/");
		return redirectView;	
	}
	
	//Update handler
		@RequestMapping("/update/{productId}")
		public String updateForm(@PathVariable("productId") int pid,Model model) {
			Product product = this.productDao.getproduct(pid);
			model.addAttribute("product",product);
			return "update_form";	
		}
	
	
	
	
}
