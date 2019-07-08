package jp.ivs.helper;

import jp.ivs.model.Customer;

import java.sql.*;

public class IOHelper
{
    public static Customer get1CustomerByCode(Connection connection, String customerNo)
    {
        Customer customer = new Customer();
        try {
            PreparedStatement command = connection.prepareStatement(" select CustomerID as 'CustomerKey' " +
                " , CustomerName, ContactName " +
                ", PostalCode as 'CustomerNo' , Address " +
                " from customers " +
                " where PostalCode = ?");
            command.setString(1, customerNo);
            ResultSet report = command.executeQuery();
            report.next();
            customer.setCustomerID(report.getInt("CustomerKey"));
            customer.setCustomerName(report.getString("CustomerName"));
            customer.setContactName(report.getString("ContactName"));
            customer.setCustomerNo(report.getString("CustomerNo"));
            customer.setCustomerAddress(report.getString("Address"));
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Lỗi " + e.getMessage());
        }
        return customer;
    }
}
