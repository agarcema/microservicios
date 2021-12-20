package academy.digitallab.store.serviceshopping.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import academy.digitallab.store.serviceshopping.model.Customer;

@FeignClient(name="service-customer")
//@RequestMapping("/customers")
public interface CustomerClient {

	  @GetMapping(value = "/app/customers/{id}")
	    public ResponseEntity<Customer> getCustomer(@PathVariable("id") long id);
}
