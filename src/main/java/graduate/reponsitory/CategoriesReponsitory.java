package graduate.reponsitory;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import graduate.domain.Categories;



@Repository
public interface CategoriesReponsitory extends JpaRepository<Categories, String>{
	List<Categories> findByNameContaining(String name);
	Page<Categories> findByNameContaining(String name, Pageable pageable);
}
