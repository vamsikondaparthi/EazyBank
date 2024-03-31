package com.org.eazybank.repository;

import com.org.eazybank.models.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface CustomerRepository extends CrudRepository<Customer,Long> {


    List<Customer> findByEmail(String email);

    @Override
    <S extends Customer> S save(S entity);
}
