package jp.ivs.controller;

import jp.ivs.helper.IOHelper;
import jp.ivs.helper.MySQLhelper;
import jp.ivs.model.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.sql.Connection;
import java.sql.SQLException;

@Controller
public class WelcomeController
{
    @RequestMapping("/login")
    public String goLogin()
    {
        try {
            IOHelper.fixShipperID();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "login";
    }

    @RequestMapping(value = "/index")
    public String goIndex(ServletRequest request)
    {
        String id = request.getParameter("txt_id");
        try {
            Connection connection = MySQLhelper.connectToMySQL();
            MySQLhelper.setUseDb(connection, "groot");
            Customer customer = IOHelper.get1CustomerByCode(connection, id);
            request.setAttribute("contactName", customer.getContactName());
            request.setAttribute("customerNo", customer.getCustomerNo());
            request.setAttribute("customerAddress", customer.getCustomerAddress());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return "index";
    }

}
