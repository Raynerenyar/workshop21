package sg.edu.nus.iss.workshop21.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import sg.edu.nus.iss.workshop21.models.Customer;
import sg.edu.nus.iss.workshop21.models.Orders;
import sg.edu.nus.iss.workshop21.repo.CustomersRepo;

@Service
public class CustomerService {

    @Autowired
    CustomersRepo cr;

    public List<Customer> getListOfCustomers() {
        int count = cr.getNumCustomers();
        List<Customer> listOf = new LinkedList<>();
        for (int i = 0; i < count; i += 5) {
            listOf.addAll(cr.getListOfCustomers(i));
        }
        return listOf;
    }

    public Customer getCustomerById(int id) {
        return cr.getCustomerById(id);
    }

    public List<Orders> getCustomersOrders(int id) {
        return cr.getCustomerOrders(id);
    }

    public JsonObject returnNotFoundJson(int id) {
        return Json.createObjectBuilder()
                .add("error", 404)
                .add("message", "not found")
                .add("id", id)
                .build();
    }
}
