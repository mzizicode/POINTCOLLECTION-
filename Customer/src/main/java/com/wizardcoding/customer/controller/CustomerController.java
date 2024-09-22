import com.wizardcoding.customer.CustomerRegistrationRequest;
import com.wizardcoding.customer.service;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@Slf4j
@RequestMapping(path = "api/v1/customer")
public class CustomerController {

    private final Customerservice customerService;

    // Define a method to handle HTTP POST requests for customer registration
    @PostMapping
    // Use @RequestBody annotation to map the request body to the CustomerRegistrationRequest object
    public void registerCustomer(@RequestBody CustomerRegistrationRequest customerRegistrationRequest) {
        log.info("new customer registration {}",customerRegistrationRequest);
        // Call the registerCustomer method from the injected CustomerService
        customerservice.registerCustomer(customerRegistrationRequest);
    }


    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponse> getCustomerById(@PathVariable("id") Long id) {

        CustomerResponse customer = customerservice.getCustomerById(id);
        log.info("get customer registration {}",customer);
        return ResponseEntity.status(HttpStatus.OK).body(customer);


    }
  //create a put mapping method to handle the update of customer details
    @PutMapping("/{id}")
    public ResponseEntity<CustomerResponse> updateCustomer(@PathVariable("id") Long id, @RequestBody CustomerRegistrationRequest customerRegistrationRequest) {
        log.info("update customer registration {}",customerRegistrationRequest);
        CustomerResponse customer = customerservice.updateCustomer(id, customerRegistrationRequest);
        return ResponseEntity.status(HttpStatus.OK).body(customer);
    }
    //create a delete mapping method to handle the deletion of customer details
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable("id") Long id) {
        log.info("delete customer registration {}",id);
        customerservice.deleteCustomer(id);
        return ResponseEntity.status(HttpStatus.OK).body("Customer deleted successfully");
    }
}

