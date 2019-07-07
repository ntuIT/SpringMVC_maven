package jp.ivs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@Controller
public class WelcomeController
{
    @RequestMapping("/login")
    public String goLogin()
    {
        return "login";
    }

    @RequestMapping(value = "/index")
    public String goIndex(ServletRequest request)
    {
        ModelAndView maView = new ModelAndView("index");
        String id = request.getParameter("txt_id");
        request.setAttribute("customer_no", id);
        return "index";
    }

}
