package sg.edu.nus.iss.workshop21.models;

import java.math.BigDecimal;
import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Orders {
    public int id;
    public int employeeId;
    public int customerId;
    public Date orderDate;
    public Date shippedDate;
    public String shipperId;
    public String shipName;
    public String shipAddress;
    public String shipCity;
    public String shipStateProvince;
    public String shipZipPostalCode;
    public String shipCountryRegion;
    public BigDecimal shippingFee;
    public BigDecimal taxes;
    public String paymentType;
    public Date paidDate;
    public String notes;
    public Double taxRate;
    public String taxStatusId;
    public int statusId;
}
