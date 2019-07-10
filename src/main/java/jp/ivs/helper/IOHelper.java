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

    public static void fixShipperID() throws SQLException
    {
        //region chuẩn bị môi trường
        String update = "UPDATE `groot`.orders SET ShipperID = ? WHERE OrderID = ? ";
        Connection connection = MySQLhelper.connectToMySQL();
        Statement command = connection.createStatement();
        String select = " select OrderID, ShipperID from orders ";
        ResultSet dataLine = command.executeQuery(select); //endregion

        while (dataLine.next())
        {
            int orderId = dataLine.getInt("OrderId");
            int shipperId = dataLine.getInt("ShipperId");
            if (shipperId>=90)
            {
                shipperId-=90;
                PreparedStatement writer = connection.prepareStatement(update);
                writer.setInt(1, shipperId);
                writer.setInt(2, orderId);
                writer.executeUpdate();
                writer.close();
            }
        }
        //
    }
}
