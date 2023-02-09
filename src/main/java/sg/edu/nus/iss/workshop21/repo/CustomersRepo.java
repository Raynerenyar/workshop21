package sg.edu.nus.iss.workshop21.repo;

import java.util.List;

import sg.edu.nus.iss.workshop21.models.Customer;
import sg.edu.nus.iss.workshop21.models.Orders;

public interface CustomersRepo {
    List<Customer> getListOfCustomers(int offset);

    Integer getNumCustomers();

    Customer getCustomerById(int id);

    List<Orders> getCustomerOrders(Integer id);

}
