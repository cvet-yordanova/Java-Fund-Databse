package softuni.service.api;

import softuni.entities.Customer;
import softuni.models.binding.CustomerDto;

import java.util.List;

public interface CustomerService {

    List<Customer> findAll();
    Customer findOne(Long aLong);
    void delete(Long aLong);
    void delete(Customer car);
    void save(CustomerDto customerDto);
}