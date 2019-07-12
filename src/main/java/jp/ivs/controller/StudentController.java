package jp.ivs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.ServletRequest;

@Controller
@RequestMapping("/student")
public class StudentController
{
    @RequestMapping("/show-form")
    public String showStudentForm()
    {
        return "student/form";
    }
    @RequestMapping(value = ""
     , params = ""
     , method = RequestMethod.GET)
    public String student(ModelMap model
    , @RequestParam("txt_name") String name
    , @RequestParam("txt_mark") float mark
    , @RequestParam("txt_major") String major)
    {
        return "student/student";
    }

    @RequestMapping("/student-savedata")
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

