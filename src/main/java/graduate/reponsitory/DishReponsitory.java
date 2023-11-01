package graduate.reponsitory;

import graduate.domain.Categories;
import graduate.domain.Dish;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DishReponsitory extends JpaRepository<Dish, String> {
  List<Dish> findByNameContaining(String name);
  Page<Dish> findByNameContaining(String name, Pageable pageable);
  Page<Dish> findByNameContaining(Categories categories, Pageable pageable);
}
