package sg.edu.nus.iss.workshop21.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sg.edu.nus.iss.workshop21.models.Customer;
import sg.edu.nus.iss.workshop21.models.Orders;
import sg.edu.nus.iss.workshop21.service.CustomerService;

@RestController
public class CustomerRestController {

    @Autowired
    CustomerService cs;

    @GetMapping(path = "/api/customers", produces = "application/json")
    public List<Customer> getListOfCustomers() {
        List<Customer> listOfCustomers = cs.getListOfCustomers();
        return listOfCustomers;
    }

    @GetMapping(path = "/api/customer/{id}", produces = "application/json")
    public ResponseEntity<Object> getCustomerById(@PathVariable int id) {

        Customer c = new Customer();
        if ((c = cs.getCustomerById(id)) != null) {
            return ResponseEntity.status(HttpStatus.FOUND).body(c);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(cs.returnNotFoundJson(id).toString());

    }

    @GetMapping(path = "/api/customer/{id}/orders", produces = "application/json")
    public ResponseEntity<Object> getCustomerOrders(@PathVariable int id) {
        if (cs.getCustomerById(id) != null) {
            List<Orders> listofOrders = cs.getCustomersOrders(id);
            return ResponseEntity.status(HttpStatus.FOUND).body(listofOrders);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(cs.returnNotFoundJson(id).toString());
    }
}
