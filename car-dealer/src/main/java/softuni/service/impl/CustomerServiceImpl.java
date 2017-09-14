package softuni.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.entities.Customer;
import softuni.io.DtoMappingUtil;
import softuni.models.binding.CustomerDto;
import softuni.repositories.CustomerRepository;
import softuni.service.api.CustomerService;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> findAll() {
        return this.customerRepository.findAll();
    }

    @Override
    public Customer findOne(Long aLong) {
        return this.customerRepository.findOne(aLong);
    }

    @Override
    public void delete(Long aLong) {
            this.customerRepository.delete(aLong);
    }

    @Override
    public void delete(Customer entity) {
            this.customerRepository.delete(entity);
    }

    //--------------------------------------------------------------------


    @Override
    public void save(CustomerDto customerDto) {
        Customer customer = DtoMappingUtil.convert(customerDto, Customer.class);
        this.customerRepository.save(customer);
    }
}