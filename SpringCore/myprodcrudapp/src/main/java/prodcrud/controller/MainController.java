package prodcrud.controller;

import jakarta.servlet.http.HttpServletRequest;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;
import prodcrud.dao.ProductDao;
import prodcrud.model.Product;

@Controller
public class MainController {

  @Autowired
  private ProductDao productDao;

  @RequestMapping("/home")
  public String home(Model m) {
    List<Product> products = productDao.getAllProducts();
    // System.out.println(products);
    m.addAttribute("products", products);
    return "home";
  }

  @RequestMapping("/addProduct")
  public String addProduct() {
    return "addProduct";
  }

  @PostMapping("/handleProduct")
  public RedirectView handleProduct(
    @ModelAttribute Product product,
    HttpServletRequest request
  ) {
    System.out.println(product);
    productDao.createProduct(product);
    RedirectView redirectView = new RedirectView();
    System.out.println(request.getContextPath() + "/");
    redirectView.setUrl(request.getContextPath() + "/");
    return redirectView;
  }

  @RequestMapping("/delete/{productId}")
  public RedirectView deleteProd(
    @PathVariable("productId") int productId,
    HttpServletRequest request
  ) {
    productDao.deleteProduct(productId);
    RedirectView redirectView = new RedirectView();
    redirectView.setUrl(request.getContextPath() + "/");
    return redirectView;
  }

  @RequestMapping("/update/{productId}")
  public String updateProd(@PathVariable("productId") int pid, Model m) {
    Product product = productDao.getProduct(pid);
    m.addAttribute("product", product);
    return "updateProduct";
  }
}
