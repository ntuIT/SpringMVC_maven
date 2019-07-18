package jp.ivs.helper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import jp.ivs.model.Customer;

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

    public static void fixOrderDetail() throws SQLException
    {
        //region chuẩn bị môi trường
        String update = " UPDATE `groot`.`orderdetails` t " +
                "SET t.`OrderID` = (t.`OrderID`-10247) " +
                "WHERE  t.`OrderID` = ? and t.OrderID>10000 ";
        Connection connection = MySQLhelper.connectToMySQL();
        MySQLhelper.setUseDb(connection, "groot");
        Statement command = connection.createStatement();
        String select = " select o.OrderID as 'OrderID', o.OrderDetailID as 'OrderDetailID' "
             +   " from orderdetails o ";
        ResultSet dataLine = command.executeQuery(select); //endregion
        System.out.println("chạy đến đây");

        while (dataLine.next())
        {
            int orderId = dataLine.getInt("OrderId");
            int odId = dataLine.getInt("OrderDetailID");
            if (orderId>=10000)
            {
                PreparedStatement writer = connection.prepareStatement(update);
                writer.setInt(1, orderId);
                writer.executeUpdate();
                writer.close();
            }
        }
        command.close(); connection.close();
    }
}
