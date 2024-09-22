



import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@Slf4j
@RestController
@RequestMapping(path = "api/v1/product")
// Controller class for handling product-related HTTP requests
public class ProductController {
    // Dependency injection of ProductService through constructor
    private final ProductService productService;

    // HTTP POST mapping for creating a new product
    @PostMapping
    // Method to create a product based on the provided registration request
    public void createProduct(@RequestBody ProductRegistrationRequest productRegistrationRequest) {
        log.info("new Product  {}",productRegistrationRequest);
        // Delegates the product creation logic to the ProductService
        productService.saveProduct(productRegistrationRequest);
    }

    @GetMapping("/{customerId}")
    // Method to handle requests for product information by customer ID
    public ResponseEntity<ProductResponse> getProductByCustomerId(@PathVariable("customerId") Long customerId) {
        // Delegates the product retrieval logic to the ProductService
        ProductResponse productResponse = productService.findProductByCustomerId(customerId);
        // Returns a ResponseEntity with the product response and HTTP status OK
        log.info("new customer registration {}",productResponse);
        return ResponseEntity.status(HttpStatus.OK).body(productResponse);
    }
}

