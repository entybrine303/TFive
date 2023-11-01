package graduate.service.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import graduate.domain.Account;
import graduate.reponsitory.AccountReponsitory;
import graduate.reponsitory.CategoriesReponsitory;
import graduate.service.AccountService;
@Service
public class AccountSeviceImpl implements AccountService {
	@Autowired
	private AccountReponsitory accountReponsitory;
	
	@Override
	public Account login(String username, String password) {
		Optional<Account> optExist=findById(username);
		
		if (optExist.isPresent() && password.equals(optExist.get().getPassword())) {
//			optExist.get().setPassword(null);
			return optExist.get();
		}
		return null;
	}

	public Account save(Account entity) {
		return accountReponsitory.save(entity);
	}

	public List<Account> saveAll(List<Account> entities) {
		return  (List<Account>)accountReponsitory.saveAll(entities);
	}

	public Optional<Account> findById(String id) {
		return accountReponsitory.findById(id);
	}

	public boolean existsById(String id) {
		return accountReponsitory.existsById(id);
	}

	public List<Account> findAll() {
		return (List<Account>) accountReponsitory.findAll();
	}

	public List<Account> findAllById(List<String> ids) {
		return (List<Account>) accountReponsitory.findAllById(ids);
	}

	public long count() {
		return accountReponsitory.count();
	}

	public void deleteById(String id) {
		accountReponsitory.deleteById(id);
	}

	public void delete(Account entity) {
		accountReponsitory.delete(entity);
	}

	public void deleteAllById(Iterable<? extends String> ids) {
		accountReponsitory.deleteAllById(ids);
	}

	public void deleteAll(Iterable<? extends Account> entities) {
		accountReponsitory.deleteAll(entities);
	}

	public void deleteAll() {
		accountReponsitory.deleteAll();
	}

	
	

}
