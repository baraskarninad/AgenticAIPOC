// CartPageController.java
@RestController
@RequestMapping("/cart")
public class CartPageController {
    @Autowired
    private CartDetailsFacade cartDetailsFacade;

    @GetMapping("/lineStockAndPrice")
    public ResponseEntity<?> getCartLineStockAndPriceData() {
        try {
            CartLineStockAndPriceData data = cartDetailsFacade.generateCartLineStockAndPriceData();
            return ResponseEntity.ok(data);
        } catch (ErpException e) {
            System.err.println("ERP system error: " + e.getMessage());
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("error", "The system is temporarily unavailable. Please try again later.");
            errorResponse.put("details", e.getMessage() != null ? e.getMessage() : "");
            return new ResponseEntity<>(errorResponse, HttpStatus.SERVICE_UNAVAILABLE);
        } catch (Exception ex) {
            System.err.println("Unexpected error: " + ex.getMessage());
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("error", "An unexpected error occurred.");
            return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}