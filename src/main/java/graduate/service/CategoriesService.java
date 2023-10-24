package graduate.service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Service;



import graduate.domain.Categories;
import graduate.dto.CategoriesDTO;
import graduate.repository.CategoriesRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


public interface CategoriesService {

	Page<Categories> findByNameContaining(String name, String categoriesID);

	<S extends Categories> List<S> findAll(Example<S> example, Sort sort);

	<S extends Categories> List<S> findAll(Example<S> example);

	Categories getReferenceById(Long id);

	void deleteAll();

	void deleteAll(Iterable<? extends Categories> entities);

	void deleteAllById(Iterable<? extends Long> ids);

	Categories getById(Long id);

	void delete(Categories entity);

	Categories getOne(Long id);

	void deleteById(Long id);

	void deleteAllInBatch();

	long count();

	<S extends Categories, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction);

	void deleteAllByIdInBatch(Iterable<Long> ids);

	<S extends Categories> boolean exists(Example<S> example);

	void deleteAllInBatch(List<Categories> entities);

	<S extends Categories> long count(Example<S> example);

	boolean existsById(String id);

	void deleteInBatch(Iterable<Categories> entities);

	Optional<Categories> findById(Long  id);

	<S extends Categories> Page<S> findAll(Example<S> example, Pageable pageable);

	<S extends Categories> List<S> saveAllAndFlush(Iterable<S> entities);

	Categories saveAndFlush(Categories entity);

	void flush();

	List<Categories> saveAll(List<Categories> entities);

	List<Categories> findAllById(Iterable<Long> ids);

	List<Categories> findAll(Sort sort);

	Page<Categories> findAll(Pageable pageable);

	List<Categories> findAll();

	<S extends Categories> Optional<S> findOne(Example<S> example);

	Categories save(Categories entity);

	Page<Categories> findByNameContaining(String name, Pageable pageable);

	List<Categories> findByNameContaining(String name);

	boolean existsById(Long id);


}
