package kr.human.jpa.dao;

import org.springframework.data.repository.CrudRepository;

import kr.human.jpa.vo.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
     
}