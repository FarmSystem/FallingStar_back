package login_test.controller;

import login_test.rest.Product;
import login_test.rest.ProductManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DemoRestController {
    @Autowired
    ProductManager pm;

    @GetMapping("/User")
    public List<Product> getAll(){
        return pm.getDatas();
    }
    @GetMapping("/User/{id}")
    public Product getProduct(@PathVariable int id){
        return pm.getDatas().get(id - 1);
    }
    @PostMapping("/User")
    public String addProduct(@RequestBody Product p){
        pm.addProduct(p);
        return "유저 정보가 저장되었습니다.";
    }
    @DeleteMapping("/User/{id}")
    public String delProduct(@PathVariable int id) {
        pm.delProduct(id);
        return "유저 정보가 삭제되었습니다.";
    }
}
