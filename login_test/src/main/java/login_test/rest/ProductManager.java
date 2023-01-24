package login_test.rest;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class ProductManager {
    private List<Product> datas = new ArrayList<>();

    public ProductManager(){
        datas.add(new Product(1,
                "7월 10일",
                "가족과 지인이 함께했으면 좋겠어요",
                "매장묘",
                true,
                true,
                "이 몸이 죽고 죽어 일 백번 고쳐 죽어"));
    }

    public void addProduct(Product p){
        p.setId(datas.size()+1);
        datas.add(p);
    }
    public List<Product> getDatas(){
        return datas;
    }
    public Product getProduct(int id){
        return datas.get(id - 1);
    }
    public void delProduct(int id){
        datas.remove(id - 1);
    }
}
