package graduate.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import graduate.domain.Account;
import graduate.domain.DriverRegister;

public interface AccountService {

	void deleteAll();

	void deleteAll(Iterable<? extends Account> entities);

	void deleteAllById(Iterable<? extends String> ids);

	void delete(Account entity);

	void deleteById(String id);

	long count();

	List<Account> findAllById(List<String> ids);

	List<Account> findAll();

	boolean existsById(String id);

	Optional<Account> findById(String id);

	<S extends Account> List<S> saveAll(Iterable<S> entities);

	Account save(Account entity);

	Account login(String username, String password);
	

}
