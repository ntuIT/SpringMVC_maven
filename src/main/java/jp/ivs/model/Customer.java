package jp.ivs.model;

public class Customer
{
    int customerID;
    String customerName, contactName, customerNo,
        customerAddress, customerCity,customerCountry;

    //region hàm tạo ()
    public Customer() { }
    public Customer(int customerID) { this.customerID = customerID; }
    public Customer(String name, String contactName, String no, String address, String city, String country)
    {
        this.customerName = name;
        this.contactName = contactName;
        this.customerNo = no;
        this.customerAddress = address;
        this.customerCity = city;
        this.customerCountry = country;
    } //endregion

    //region getter và setter
    public int getCustomerID() { return customerID; }
    public void setCustomerID(int customerID) { this.customerID = customerID; }

    public String getCustomerName() { return customerName; }
    public void setCustomerName(String customerName)
    { this.customerName = customerName; }

    public String getContactName() { return contactName; }
    public void setContactName(String contactName)
    { this.contactName = contactName; }

    public String getCustomerNo() { return customerNo; }
    public void setCustomerNo(String customerNo)
    { this.customerNo = customerNo; }

    public String getCustomerAddress() { return customerAddress; }
    public void setCustomerAddress(String customerAddress)
    { this.customerAddress = customerAddress; }

    public String getCustomerCity() { return customerCity; }
    public void setCustomerCity(String customerCity)
    { this.customerCity = customerCity; }

    public String getCustomerCountry() { return customerCountry; }
    public void setCustomerCountry(String customerCountry)
    { this.customerCountry = customerCountry; } //endregion
    //
}
