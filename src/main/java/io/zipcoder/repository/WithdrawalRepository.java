package io.zipcoder.repository;

import io.zipcoder.domain.Withdrawal;
import org.springframework.data.repository.CrudRepository;

public interface WithdrawalRepository extends CrudRepository<Withdrawal, Long>{
    Iterable<Withdrawal> findAllByPayee_id(Long id);
}
