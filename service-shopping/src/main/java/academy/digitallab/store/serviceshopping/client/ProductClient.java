package academy.digitallab.store.serviceshopping.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import academy.digitallab.store.serviceshopping.model.Product;

@FeignClient(name="product-service")
//@RequestMapping("/products")
public interface ProductClient {

	
	@GetMapping( value = "/app/products/{id}")
	public ResponseEntity<Product> getProduct(@PathVariable("id") Long id);
	
	@GetMapping( value ="/app/products/{id}/stock")
	public ResponseEntity<Product> updateStockProduct(@PathVariable("id")Long id, @RequestParam(name= "quantity", required = true) Double quantity);
}
