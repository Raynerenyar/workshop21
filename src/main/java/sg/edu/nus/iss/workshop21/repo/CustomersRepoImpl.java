package sg.edu.nus.iss.workshop21.repo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import sg.edu.nus.iss.workshop21.models.Customer;
import sg.edu.nus.iss.workshop21.models.Orders;

@Repository
public class CustomersRepoImpl implements CustomersRepo {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<Customer> getListOfCustomers(int offset) {

        List<Customer> listOfCustomers;
        listOfCustomers = jdbcTemplate.query(Queries.SELECT_CUSTOMER_SQL, new PreparedStatementSetter() {

            @Override
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setInt(1, offset);
            }

        }, new ResultSetExtractor<List<Customer>>() {

            @Override
            public List<Customer> extractData(ResultSet rs) throws SQLException, DataAccessException {
                List<Customer> listOfCustomers = new LinkedList<>();
                BeanPropertyRowMapper<Customer> bprm = new BeanPropertyRowMapper<Customer>(Customer.class);
                while (rs.next()) {
                    Customer c = (Customer) bprm.mapRow(rs, 0);
                    listOfCustomers.add(c);
                }
                return listOfCustomers;
            }

        });
        return listOfCustomers;
    }

    @Override
    public Integer getNumCustomers() {
        return jdbcTemplate.query(Queries.COUNT_CUSTOMER_SQL, new ResultSetExtractor<Integer>() {

            @Override
            public Integer extractData(ResultSet rs) throws SQLException, DataAccessException {
                rs.next();
                return rs.getInt("count");
            }

        });
    }

    @Override
    public Customer getCustomerById(int id) {
        Customer cus = new Customer();
        try {
            cus = jdbcTemplate.queryForObject(Queries.GET_CUSTOMER_BY_ID_SQL,
                    new BeanPropertyRowMapper<Customer>(Customer.class),
                    id);
        } catch (DataAccessException e) {
            return null;
        }
        return cus;
    }

    @Override
    public List<Orders> getCustomerOrders(Integer id) {
        Object[] arr = new Object[] { id };
        int[] types = new int[] { Types.INTEGER };
        return jdbcTemplate.query(Queries.GET_CUSTOMER_ORDERS_SQL, arr, types,
                new BeanPropertyRowMapper<Orders>(Orders.class));

    }

}
