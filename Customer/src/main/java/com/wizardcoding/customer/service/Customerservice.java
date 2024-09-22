


import com.wizardcoding.customer.CustomerRegistrationRequest;
import com.wizardcoding.customer.enitity.Customer;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class Customerservice {

  private final CustomerRepository customerRepository;


  private  final ProductClient  productClient;



  private  ModelMapper mapper;




    public void registerCustomer(CustomerRegistrationRequest request) {
        // Creating a new customer entity using the CustomerRegistrationRequest object

        Customer customer= Customer.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .build();
         customerRepository.save(customer);

    }



    public CustomerResponse getCustomerById(Long id) {

        Optional<Customer> customer = customerRepository.findById(id);
        // Mapping the customer entity to a CustomerResponse using ModelMapper
        CustomerResponse customerResponse=mapper.map(customer,CustomerResponse.class);

        // Using a FeignClient (ProductClient) to retrieve product information associated with the customer ID

        ResponseEntity<ProductResponse> productResponse = productClient.getProductByCustomerId(id);
        // Setting the product response in the CustomerResponse object

        customerResponse.setProductResponse(productResponse.getBody());


        // // Returning the final CustomerResponse object
        
        return  customerResponse;
        //is the above code correct?

//is the above code correct?

    }


    public void deleteCustomer(Long id) {
        //create a method to delete a customer by id
        customerRepository.deleteById(id);
        //create an error message to be returned if the customer is not found
    }

    public CustomerResponse updateCustomer(Long id, CustomerRegistrationRequest customerRegistrationRequest) {
        //create a method to update a customer by id
        Optional<Customer> customer = customerRepository.findById(id);
        //return an error message if the customer is not found
        if (!customer.isPresent()) {
            throw new IllegalStateException("Customer with id " + id + " does not exist");
        }
        //update the customer details
        customer.get().setFirstName(customerRegistrationRequest.firstName());
        customer.get().setLastName(customerRegistrationRequest.lastName());
        customer.get().setEmail(customerRegistrationRequest.email());
        //save the updated customer details
        customerRepository.save(customer.get());
        //return the updated customer details
        return mapper.map(customer,CustomerResponse.class);

    }
}









