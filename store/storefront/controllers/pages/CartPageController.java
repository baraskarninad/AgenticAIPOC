import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import javax.servlet.http.HttpSession;
import java.util.List;
import com.storerepo.ProductPriceService;
import com.storerepo.ProductMgr;
import com.storerepo.Product;

public class CartPageController {
    @Autowired
    private ProductPriceService productPriceService;
    @Autowired
    private ProductMgr productMgr;

    public String showCart(Model model, HttpSession session) {
        List<Product> cartItems = getCartItemsFromSession(session);
        for (Product p : cartItems) {
            productPriceService.populatePrice(p);
            productMgr.calcMSRP(p);
            productMgr.setPMAT(p);
        }
        model.addAttribute("cartItems", cartItems);
        return "cartPage";
    }
    // ... other methods ...
}