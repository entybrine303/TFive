package graduate.service.imp;

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

import graduate.domain.Categories;
import graduate.reponsitory.CategoriesReponsitory;
import graduate.service.CategoriesService;

@Repository
public class CategoriesServiceImpl implements CategoriesService {
	@Autowired
	private CategoriesReponsitory categoriesRepository;

	public CategoriesServiceImpl(CategoriesReponsitory categoriesRepository) {
		this.categoriesRepository = categoriesRepository;
	}

	@Override
	public List<Categories> findByNameContaining(String name) {
		return categoriesRepository.findByNameContaining(name);
	}

	@Override
	public Page<Categories> findByNameContaining(String name, Pageable pageable) {
		return categoriesRepository.findByNameContaining(name, pageable);
	}

	@Override
	public Categories save(Categories entity) {
		return categoriesRepository.save(entity);
	}

	@Override
	public <S extends Categories> Optional<S> findOne(Example<S> example) {
		return categoriesRepository.findOne(example);
	}

	@Override
	public List<Categories> findAll() {
		return categoriesRepository.findAll();
	}

	@Override
	public Page<Categories> findAll(Pageable pageable) {
		return categoriesRepository.findAll(pageable);
	}

	@Override
	public List<Categories> findAll(Sort sort) {
		return categoriesRepository.findAll(sort);
	}

	@Override
	public List<Categories> findAllById(Iterable<String> ids) {
		return categoriesRepository.findAllById(ids);
	}

	@Override
	public List<Categories> saveAll(List<Categories> entities) {
		return categoriesRepository.saveAll(entities);
	}

	@Override
	public void flush() {
		categoriesRepository.flush();
	}

	@Override
	public Categories saveAndFlush(Categories entity) {
		return categoriesRepository.saveAndFlush(entity);
	}

	@Override
	public <S extends Categories> List<S> saveAllAndFlush(Iterable<S> entities) {
		return categoriesRepository.saveAllAndFlush(entities);
	}

	@Override
	public <S extends Categories> Page<S> findAll(Example<S> example, Pageable pageable) {
		return categoriesRepository.findAll(example, pageable);
	}

	@Override
	public Optional<Categories> findById(String id) {
		return categoriesRepository.findById(id);
	}

	@Override
	public void deleteInBatch(Iterable<Categories> entities) {
		categoriesRepository.deleteInBatch(entities);
	}

	@Override
	public boolean existsById(String id) {
		return categoriesRepository.existsById(id);
	}

	@Override
	public void deleteAllInBatch(List<Categories> entities) {
		categoriesRepository.deleteAllInBatch(entities);
	}

	@Override
	public <S extends Categories> boolean exists(Example<S> example) {
		return categoriesRepository.exists(example);
	}

	@Override
	public void deleteAllByIdInBatch(Iterable<String> ids) {
		categoriesRepository.deleteAllByIdInBatch(ids);
	}

	@Override
	public <S extends Categories, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
		return categoriesRepository.findBy(example, queryFunction);
	}

	@Override
	public void deleteAllInBatch() {
		categoriesRepository.deleteAllInBatch();
	}

	@Override
	public void deleteById(String id) {
		categoriesRepository.deleteById(id);
	}

	@Override
	public Categories getOne(String id) {
		return categoriesRepository.getOne(id);
	}

	@Override
	public void delete(Categories entity) {
		categoriesRepository.delete(entity);
	}

	@Override
	public Categories getById(String id) {
		return categoriesRepository.getById(id);
	}

	@Override
	public void deleteAllById(Iterable<? extends String> ids) {
		categoriesRepository.deleteAllById(ids);
	}

	@Override
	public void deleteAll(Iterable<? extends Categories> entities) {
		categoriesRepository.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		categoriesRepository.deleteAll();
	}

	@Override
	public Categories getReferenceById(String id) {
		return null;
	}

	@Override
	public <S extends Categories> List<S> findAll(Example<S> example) {
		return categoriesRepository.findAll(example);
	}

	@Override
	public <S extends Categories> List<S> findAll(Example<S> example, Sort sort) {
		return categoriesRepository.findAll(example, sort);
	}

	@Override
	public Page<Categories> findByNameContaining(String name, String categoriesID) {
		// TODO Auto-generated method stub
		return null;
	}

}
