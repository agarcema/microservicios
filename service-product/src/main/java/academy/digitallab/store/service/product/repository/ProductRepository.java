package academy.digitallab.store.service.product.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import academy.digitallab.store.service.product.entity.Category;
import academy.digitallab.store.service.product.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
	
	public List<Product> findByCategory(Category category);

}
