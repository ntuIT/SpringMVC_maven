package jp.ivs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.SQLException;

import jp.ivs.helper.IOHelper;

@Controller
public class HomeController {
	@RequestMapping("/login")
	public String login(ModelMap model)
	{
		return "login";
	}
	@RequestMapping(value = "/index" , method = RequestMethod.POST)
	public String loginSuccess(ModelMap model
	, @RequestParam("loginEmail") String loginEmail
	, @RequestParam("loginPassword") String loginPassword)
	{
		System.out.println(loginEmail);
		System.out.println(loginPassword);
		return "index";
	}
}
