package com.bookstore.cls.api.application;

import com.bookstore.cls.api.application.exception.BusinessRuleException;
import com.bookstore.cls.api.application.exception.ResourceNotFoundException;
import com.bookstore.cls.api.domain.Customer;
import com.bookstore.cls.api.infrastructure.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CustomerServiceTest {

    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private CustomerService customerService;

    private Customer buildCustomer(String cpf) {
        Customer customer = new Customer();
        customer.setName("Ana Souza");
        customer.setCpf(cpf);
        customer.setEmail("ana@email.com");
        customer.setAddress("Rua A, 10");
        return customer;
    }

    @Test
    void create_shouldThrowException_whenCpfAlreadyExists() {
        Customer customer = buildCustomer("123.456.789-09");
        when(customerRepository.existsByCpf("12345678909")).thenReturn(true);

        assertThrows(BusinessRuleException.class, () -> customerService.create(customer));
        verify(customerRepository, never()).save(any());
    }

    @Test
    void create_shouldThrowException_whenCpfDoesNotHave11Digits() {
        Customer customer = buildCustomer("123");

        assertThrows(BusinessRuleException.class, () -> customerService.create(customer));
        verify(customerRepository, never()).save(any());
    }

    @Test
    void create_shouldSaveCustomerWithOnlyDigits_whenCpfIsValid() {
        Customer customer = buildCustomer("123.456.789-09");
        when(customerRepository.existsByCpf("12345678909")).thenReturn(false);
        when(customerRepository.save(any(Customer.class))).thenAnswer(invocation -> invocation.getArgument(0));

        Customer saved = customerService.create(customer);

        assertEquals("12345678909", saved.getCpf());
        verify(customerRepository).save(customer);
    }

    @Test
    void findById_shouldThrowException_whenCustomerDoesNotExist() {
        UUID id = UUID.randomUUID();
        when(customerRepository.findById(id)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> customerService.findByid(id));
    }

    @Test
    void update_shouldThrowException_whenCpfBelongsToAnotherCustomer() {
        UUID id = UUID.randomUUID();
        Customer existing = buildCustomer("111.111.111-11");
        existing.setId(id);

        Customer another = buildCustomer("123.456.789-09");
        another.setId(UUID.randomUUID());

        Customer data = buildCustomer("123.456.789-09");

        when(customerRepository.findById(id)).thenReturn(Optional.of(existing));
        when(customerRepository.findByCpf("12345678909")).thenReturn(Optional.of(another));

        assertThrows(BusinessRuleException.class, () -> customerService.update(id, data));
        verify(customerRepository, never()).save(any());
    }

    @Test
    void update_shouldAllowSameCpf_whenCustomerKeepsOwnCpf() {
        UUID id = UUID.randomUUID();
        Customer existing = buildCustomer("12345678909");
        existing.setId(id);

        Customer data = buildCustomer("123.456.789-09");
        data.setName("Ana Souza Lima");

        when(customerRepository.findById(id)).thenReturn(Optional.of(existing));
        when(customerRepository.findByCpf("12345678909")).thenReturn(Optional.of(existing));
        when(customerRepository.save(any(Customer.class))).thenAnswer(invocation -> invocation.getArgument(0));

        Customer updated = customerService.update(id, data);

        assertEquals("Ana Souza Lima", updated.getName());
        verify(customerRepository).save(existing);
    }
}
