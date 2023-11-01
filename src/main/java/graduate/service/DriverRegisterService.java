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

import graduate.domain.DriverRegister;


public interface DriverRegisterService {

	<S extends DriverRegister> List<S> findAll(Example<S> example, Sort sort);

	<S extends DriverRegister> List<S> findAll(Example<S> example);

	void deleteAll();

	DriverRegister getReferenceById(String id);

	void deleteAll(Iterable<? extends DriverRegister> entities);

	void deleteAllById(Iterable<? extends String> ids);

	DriverRegister getById(String id);

	void delete(DriverRegister entity);

	DriverRegister getOne(String id);

	void deleteById(String id);

	void deleteAllInBatch();

	long count();

	<S extends DriverRegister, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction);

	void deleteAllByIdInBatch(Iterable<String> ids);

	<S extends DriverRegister> boolean exists(Example<S> example);

	void deleteAllInBatch(Iterable<DriverRegister> entities);

	<S extends DriverRegister> long count(Example<S> example);

	boolean existsById(String id);

	void deleteInBatch(Iterable<DriverRegister> entities);

	Optional<DriverRegister> findById(String id);

	<S extends DriverRegister> Page<S> findAll(Example<S> example, Pageable pageable);

	<S extends DriverRegister> List<S> saveAllAndFlush(Iterable<S> entities);

	<S extends DriverRegister> S saveAndFlush(S entity);

	void flush();

	<S extends DriverRegister> List<S> saveAll(Iterable<S> entities);

	List<DriverRegister> findAllById(Iterable<String> ids);

	List<DriverRegister> findAll(Sort sort);

	Page<DriverRegister> findAll(Pageable pageable);

	List<DriverRegister> findAll();

	<S extends DriverRegister> Optional<S> findOne(Example<S> example);

	<S extends DriverRegister> S save(S entity);


}
