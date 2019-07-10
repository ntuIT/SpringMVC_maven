package jp.ivs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletRequest;

@Controller
public class StudentController
{
    @RequestMapping("/student/show-form")
    public String showStudentForm()
    {
        return "student/form";
    }

    @RequestMapping("/student/student-savedata")
    public String saveForm(ServletRequest request)
    {
        String name = request.getParameter("name");
        String mark = request.getParameter("mark");
        String major = request.getParameter("major");

        request.setAttribute("name", name);
        request.setAttribute("mark", mark);
        request.setAttribute("major", major);

        return "/student/success";
    }
}

