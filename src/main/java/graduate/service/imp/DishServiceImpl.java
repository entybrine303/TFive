package graduate.service.imp;


import graduate.domain.Categories;
import graduate.domain.Dish;
import graduate.reponsitory.DishReponsitory;
import graduate.service.DishService;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Repository;

@Repository
public class DishServiceImpl  implements DishService {

  @Autowired
  private DishReponsitory dishRepository;


  @Override
  public List<Dish> findByNameContaining(String name) {
    return dishRepository.findByNameContaining(name);
  }


  @Override
  public Page<Dish> findByNameContaining(Categories category, Pageable pageable) {
    return dishRepository.findByNameContaining(category, pageable);
  }


  @Override
  public Dish save(Dish entity) {
    return dishRepository.save(entity);
  }

  @Override
  public <S extends Dish> Optional<S> findOne(Example<S> example) {
    return dishRepository.findOne(example);
  }

  @Override
  public List<Dish> findAll() {
    return dishRepository.findAll();
  }

  @Override
  public Page<Dish> findAll(Pageable pageable) {
    return dishRepository.findAll(pageable);
  }

  @Override
  public List<Dish> findAll(Sort sort) {
    return dishRepository.findAll(sort);
  }

  @Override
  public List<Dish> findAllById(Iterable<String> ids) {
    return dishRepository.findAllById(ids);
  }

  @Override
  public List<Dish> saveAll(List<Dish> entities) {
    return dishRepository.saveAll(entities);
  }

  @Override
  public void flush() {
    dishRepository.flush();
  }

  @Override
  public Dish saveAndFlush(Dish entity) {
    return dishRepository.saveAndFlush(entity);
  }

  @Override
  public <S extends Dish> List<S> saveAllAndFlush(Iterable<S> entities) {
    return dishRepository.saveAllAndFlush(entities);
  }

  @Override
  public <S extends Dish> Page<S> findAll(Example<S> example, Pageable pageable) {
    return dishRepository.findAll(example, pageable);
  }

  @Override
  public Optional<Dish> findById(String id) {
    return dishRepository.findById(id);
  }

  @Override
  public void deleteInBatch(Iterable<Dish> entities) {
    dishRepository.deleteInBatch(entities);
  }

  @Override
  public boolean existsById(String id) {
    return dishRepository.existsById(id);
  }

  @Override
  public void deleteAllInBatch(List<Dish> entities) {
    dishRepository.deleteAllInBatch(entities);
  }

  @Override
  public <S extends Dish> boolean exists(Example<S> example) {
    return dishRepository.exists(example);
  }

  @Override
  public void deleteAllByIdInBatch(Iterable<String> ids) {
    dishRepository.deleteAllByIdInBatch(ids);
  }

  @Override
  public <S extends Dish, R> R findBy(Example<S> example,
      Function<FetchableFluentQuery<S>, R> queryFunction) {
    return dishRepository.findBy(example, queryFunction);
  }

  @Override
  public void deleteAllInBatch() {
    dishRepository.deleteAllInBatch();
  }

  @Override
  public void deleteById(String id) {
    dishRepository.deleteById(id);
  }

  @Override
  public Dish getOne(String id) {
    return dishRepository.getOne(id);
  }

  @Override
  public void delete(Dish entity) {
    dishRepository.delete(entity);
  }

  @Override
  public Dish getById(String id) {
    return dishRepository.getById(id);
  }

  @Override
  public void deleteAllById(Iterable<? extends String> ids) {
    dishRepository.deleteAllById(ids);
  }

  @Override
  public void deleteAll(Iterable<? extends Dish> entities) {
    dishRepository.deleteAll(entities);
  }

  @Override
  public void deleteAll() {
    dishRepository.deleteAll();
  }

  @Override
  public Dish getReferenceById(String id) {
    return null;
  }

  @Override
  public <S extends Dish> List<S> findAll(Example<S> example) {
    return dishRepository.findAll(example);
  }

  @Override
  public <S extends Dish> List<S> findAll(Example<S> example, Sort sort) {
    return dishRepository.findAll(example, sort);
  }


}
