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
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import graduate.reponsitory.DriverRegisterReponsitory;
import graduate.domain.DriverRegister;
import graduate.reponsitory.DriverRegisterReponsitory;
import graduate.service.DriverRegisterService;

@Service
public class DriverRegisterServiceImpl implements DriverRegisterService {
	@Autowired
	private DriverRegisterReponsitory driverRegisterRepository;

	@Override
	public <S extends DriverRegister> S save(S entity) {
		
		return driverRegisterRepository.save(entity);
	}

	@Override
	public <S extends DriverRegister> Optional<S> findOne(Example<S> example) {
		return driverRegisterRepository.findOne(example);
	}

	@Override
	public List<DriverRegister> findAll() {
		return driverRegisterRepository.findAll();
	}

	@Override
	public Page<DriverRegister> findAll(Pageable pageable) {
		return driverRegisterRepository.findAll(pageable);
	}

	@Override
	public List<DriverRegister> findAll(Sort sort) {
		return driverRegisterRepository.findAll(sort);
	}

	@Override
	public List<DriverRegister> findAllById(Iterable<String> ids) {
		return driverRegisterRepository.findAllById(ids);
	}

	@Override
	public <S extends DriverRegister> List<S> saveAll(Iterable<S> entities) {
		return driverRegisterRepository.saveAll(entities);
	}

	@Override
	public void flush() {
		driverRegisterRepository.flush();
	}

	@Override
	public <S extends DriverRegister> S saveAndFlush(S entity) {
		return driverRegisterRepository.saveAndFlush(entity);
	}

	@Override
	public <S extends DriverRegister> List<S> saveAllAndFlush(Iterable<S> entities) {
		return driverRegisterRepository.saveAllAndFlush(entities);
	}

	@Override
	public <S extends DriverRegister> Page<S> findAll(Example<S> example, Pageable pageable) {
		return driverRegisterRepository.findAll(example, pageable);
	}

	@Override
	public Optional<DriverRegister> findById(String id) {
		return driverRegisterRepository.findById(id);
	}

	@Override
	public void deleteInBatch(Iterable<DriverRegister> entities) {
		driverRegisterRepository.deleteInBatch(entities);
	}

	@Override
	public boolean existsById(String id) {
		return driverRegisterRepository.existsById(id);
	}

	@Override
	public <S extends DriverRegister> long count(Example<S> example) {
		return driverRegisterRepository.count(example);
	}

	@Override
	public void deleteAllInBatch(Iterable<DriverRegister> entities) {
		driverRegisterRepository.deleteAllInBatch(entities);
	}

	@Override
	public <S extends DriverRegister> boolean exists(Example<S> example) {
		return driverRegisterRepository.exists(example);
	}

	@Override
	public void deleteAllByIdInBatch(Iterable<String> ids) {
		driverRegisterRepository.deleteAllByIdInBatch(ids);
	}

	@Override
	public <S extends DriverRegister, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
		return driverRegisterRepository.findBy(example, queryFunction);
	}

	@Override
	public long count() {
		return driverRegisterRepository.count();
	}

	@Override
	public void deleteAllInBatch() {
		driverRegisterRepository.deleteAllInBatch();
	}

	@Override
	public void deleteById(String id) {
		driverRegisterRepository.deleteById(id);
	}

	@Override
	public DriverRegister getOne(String id) {
		return driverRegisterRepository.getOne(id);
	}

	@Override
	public void delete(DriverRegister entity) {
		driverRegisterRepository.delete(entity);
	}

	@Override
	public DriverRegister getById(String id) {
		return driverRegisterRepository.getById(id);
	}

	@Override
	public void deleteAllById(Iterable<? extends String> ids) {
		driverRegisterRepository.deleteAllById(ids);
	}

	@Override
	public void deleteAll(Iterable<? extends DriverRegister> entities) {
		driverRegisterRepository.deleteAll(entities);
	}

	@Override
	public DriverRegister getReferenceById(String id) {
		return driverRegisterRepository.getReferenceById(id);
	}

	@Override
	public void deleteAll() {
		driverRegisterRepository.deleteAll();
	}

	@Override
	public <S extends DriverRegister> List<S> findAll(Example<S> example) {
		return driverRegisterRepository.findAll(example);
	}

	@Override
	public <S extends DriverRegister> List<S> findAll(Example<S> example, Sort sort) {
		return driverRegisterRepository.findAll(example, sort);
	}
	
	
}
