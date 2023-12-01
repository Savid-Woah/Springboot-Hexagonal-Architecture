package com.springboothexagonal.customer.infrastructure.api;

import com.springboothexagonal.customer.application.mapper.dto.CustomerDTOMapper;
import com.springboothexagonal.customer.application.mapper.request.CustomerAddRequestMapper;
import com.springboothexagonal.customer.application.service.CustomerService;
import com.springboothexagonal.customer.domain.request.CustomerAddRequest;
import com.springboothexagonal.customer.infrastructure.entities.dto.SpringCustomerDTO;
import com.springboothexagonal.customer.infrastructure.entities.request.SpringCustomerAddRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin
@ResponseBody
@RequiredArgsConstructor
@RequestMapping("api/customers/")
public class CustomerController {

    private final CustomerService customerService;
    private final CustomerDTOMapper customerDTOMapper;
    private final CustomerAddRequestMapper customerAddRequestMapper;

    @GetMapping
    public ResponseEntity<?> getAllCustomers(){

        List<SpringCustomerDTO> customers = customerService.getAllCustomers()
                .stream()
                .map(customerDTOMapper::toSpringCustomerDTO)
                .collect(Collectors.toList());

        return ResponseEntity.ok().body(customers);
    }

    @PostMapping
    public ResponseEntity<?> addCustomer(@Validated @RequestBody SpringCustomerAddRequest springCustomerAddRequest){

        CustomerAddRequest customerAddRequest = customerAddRequestMapper
                .toCustomerAddRequest(springCustomerAddRequest);

        if(customerService.addCustomer(customerAddRequest)){
            return ResponseEntity.status(HttpStatus.CREATED).body("Customer created successfully!");
        }
        else{
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error creating Customer");
        }
    }

    @GetMapping(path = "{customer-uuid}")
    public ResponseEntity<?> getCustomer(@PathVariable("customer-uuid") String customerUuid){
        return ResponseEntity.ok().body(customerService.getCustomer(customerUuid));
    }

    @DeleteMapping(path = "{customer-uuid}")
    public ResponseEntity<?> deleteCustomer(@PathVariable("customer-uuid") String customerUuid){
        if(customerService.deleteCustomer(customerUuid)){
            return ResponseEntity.status(HttpStatus.OK).body("Customer deleted successfully!");
        }
        else{
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error deleting Customer");
        }
    }
}