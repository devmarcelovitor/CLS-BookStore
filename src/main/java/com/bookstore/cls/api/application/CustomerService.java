package com.bookstore.cls.api.application;

import com.bookstore.cls.api.application.exception.BusinessRuleException;
import com.bookstore.cls.api.application.exception.ResourceNotFoundException;
import com.bookstore.cls.api.domain.Customer;
import com.bookstore.cls.api.infrastructure.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    @Transactional
    public Customer create(Customer customer) {
        String cpf = normalizeCpf(customer.getCpf());
        if(customerRepository.existsByCpf(cpf)) {
            throw new BusinessRuleException("CPF already exists");
        }
        customer.setCpf(cpf);
        return customerRepository.save(customer);


    }
    @Transactional(readOnly = true)
    public Customer findByid(UUID id){
        return customerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found"+id));
    }
    @Transactional(readOnly = true)
    public List<Customer> findAll(){
        return customerRepository.findAll();
    }
    @Transactional
    public void delete(UUID id){
        Customer customer = findByid(id);
        customerRepository.delete(customer);
    }
    private String normalizeCpf(String cpf){
        String digits = cpf == null ? "0" : cpf.replaceAll("\\D","");
        if(digits.length()!= 11){
            throw new BusinessRuleException("Invalid CPF number");
        }
        return digits;
    }
    @Transactional
    public Customer update(UUID id, Customer data){
        Customer customer = findByid(id);
        String cpf = normalizeCpf(data.getCpf());

        customerRepository.findByCpf(cpf).filter(other -> !other.getId().equals(id)).ifPresent(other->{
            throw new BusinessRuleException("CPF already exists");
        });
        customer.setCpf(cpf);
        customer.setName(data.getName());
        customer.setAddress(data.getAddress());
        customer.setPhone(data.getPhone());
        customer.setEmail(data.getEmail());
        return customerRepository.save(customer);

    }

}
