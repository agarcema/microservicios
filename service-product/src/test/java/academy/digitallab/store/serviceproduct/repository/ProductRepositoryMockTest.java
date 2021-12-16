package academy.digitallab.store.serviceproduct.repository;

import java.util.Date;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import academy.digitallab.store.service.product.entity.Category;
import academy.digitallab.store.service.product.entity.Product;
import academy.digitallab.store.service.product.repository.ProductRepository;

@TestPropertySource(locations = "classpath:application-test.properties")
@SpringBootTest
class ProductRepositoryMockTest {
	
	@Autowired
	private ProductRepository productRepository;
	

	@BeforeEach
	void setUp() throws Exception {
		//productRepository.deleteAll();
		
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	
	@Test
	public void whenFindByCategory_thenResturnListProduct() {
		
		Product product01 = Product.builder()
				.name("computer")
				.category(Category.builder().id(1L).build())
				.description("")
				.stock(Double.parseDouble("10"))
				.price(Double.parseDouble("1240.99"))
				.status("Created")
				.createAt(new Date()).build();
		productRepository.save(product01);
		
		List<Product> founds = productRepository.findByCategory(product01.getCategory());
		
		Assertions.assertThat(founds.size()).isEqualTo(6);
	}

}
