package graduate.reponsitory;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import graduate.domain.Account;



@Repository
public interface AccountReponsitory extends JpaRepository<Account, String>{
	
}
