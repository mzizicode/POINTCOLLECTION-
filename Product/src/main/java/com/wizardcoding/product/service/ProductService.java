

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
// Lombok annotation to generate a constructor with all fields
@AllArgsConstructor
// Spring service annotation to indicate that this class is a service component
@Service
public class ProductService {

    // Dependency injection of ProductRepository through constructor
    @Autowired
    private final ProductRepository productRepository;

    private ModelMapper mapper;


    // Method to save a new product based on the provided registration request
    public void saveProduct(ProductRegistrationRequest products) {
        // Creating a Product object using a builder pattern and the provided request data
        Product product = Product.builder()
                .name(products.name())
                .price(products.price())
                .stock(products.stock())
                .productSerial(products.productSerial())
                .build();
        // Saving the product object to the repository
        productRepository.save(product);
    }


    // Method to find a product by customer ID and map the result to a ProductResponse object
    public ProductResponse findProductByCustomerId(Long customerId) {
        // Retrieving a product from the repository based on the provided customer ID
        Optional<Product> productByCustomerId = productRepository.findProductByCustomerId(customerId);

        // Mapping the product entity to a ProductResponse using ModelMapper
        ProductResponse productResponse = mapper.map(productByCustomerId, ProductResponse.class);

        // Returning the final ProductResponse object
        return productResponse;
    }
}