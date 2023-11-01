package graduate.service;

import graduate.domain.Categories;
import graduate.domain.Dish;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;

public interface DishService {


  List<Dish> findByNameContaining(String name);

  Page<Dish> findByNameContaining(Categories category, Pageable pageable);

  Dish save(Dish entity);

  <S extends Dish> Optional<S> findOne(Example<S> example);

  List<Dish> findAll();

  Page<Dish> findAll(Pageable pageable);

  List<Dish> findAll(Sort sort);

  List<Dish> findAllById(Iterable<String> ids);

  List<Dish> saveAll(List<Dish> entities);

  void flush();

  Dish saveAndFlush(Dish entity);

  <S extends Dish> List<S> saveAllAndFlush(Iterable<S> entities);

  <S extends Dish> Page<S> findAll(Example<S> example, Pageable pageable);

  Optional<Dish> findById(String id);

  void deleteInBatch(Iterable<Dish> entities);

  boolean existsById(String id);

  void deleteAllInBatch(List<Dish> entities);

  <S extends Dish> boolean exists(Example<S> example);

  void deleteAllByIdInBatch(Iterable<String> ids);

  <S extends Dish, R> R findBy(Example<S> example,
      Function<FetchableFluentQuery<S>, R> queryFunction);

  void deleteAllInBatch();

  void deleteById(String id);

  Dish getOne(String id);

  void delete(Dish entity);

  Dish getById(String id);

  void deleteAllById(Iterable<? extends String> ids);

  void deleteAll(Iterable<? extends Dish> entities);

  void deleteAll();

  Dish getReferenceById(String id);

  <S extends Dish> List<S> findAll(Example<S> example);

  <S extends Dish> List<S> findAll(Example<S> example, Sort sort);
}
