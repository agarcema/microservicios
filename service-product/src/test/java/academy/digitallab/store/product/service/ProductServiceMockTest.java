package academy.digitallab.store.product.service;

import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import academy.digitallab.store.service.product.entity.Category;
import academy.digitallab.store.service.product.entity.Product;
import academy.digitallab.store.service.product.repository.ProductRepository;
import academy.digitallab.store.service.product.service.ProductService;
import academy.digitallab.store.service.product.service.ProductServiceImpl;


@SpringBootTest(classes = ProductService.class)
class ProductServiceMockTest {

	
	@Mock
	private ProductRepository productRepository;
	
	private ProductService productService;

	
	@BeforeEach
	void setup() throws Exception{
		//MockitoAnnotations.initMocks(productRepository);
		productService = new ProductServiceImpl(productRepository);
		Product computer = Product.builder()
				.id(1L)
				.name("computer")
				.category(Category.builder().id(1L).build())
				.stock(Double.parseDouble("5"))
				.price(Double.parseDouble("12.5"))
				.build();
		
		Mockito.when(productRepository.findById(1L))
			.thenReturn(Optional.of(computer));
		
		Mockito.when(productRepository.save(computer)).thenReturn(computer);
		
	}
	
	@Test
	void whenValidGetID_ThenReturnProduct() {
		
		Product found = productService.getProduct(1L);
		Assertions.assertThat(found.getName()).isEqualTo("computer");
	}
	
	@Test
	public void whenValidUpdateStock_ThenReturnNewStock() {
		
		Product newStock = productService.updateStock(1L, Double.parseDouble("8"));
		Assertions.assertThat(newStock.getStock()).isEqualTo(13);
	}
	
}
