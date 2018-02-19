package com.gta.cardealer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.gta.cardealer.models.Car;
import com.gta.cardealer.service.CarService;
import com.gta.cardealer.service.LoginService;

@Controller
public class LoginHandler {

	@Autowired
	private LoginService ls;// = new LoginService();
	@Autowired
	private CarService cs;// = new LoginService();
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String showLoginPage() {
		return "login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String handleUserLogin(ModelMap model, @RequestParam String username,
			@RequestParam String password) {

		if (!ls.isUserValid(username, password)) {
			model.put("errorMessage", "Invalid Credentials");
			return "login";
		}
		
		model.addAttribute("name", username);
		return "welcome";
	}
	
//	@RequestMapping(value = "/cars", method = RequestMethod.POST)
//	public String handleUserInput(ModelMap model) {
//		//List<Car> al = cs.getCars();
//		model.addAttribute("cars", cs.getCars());
//		return "cars";
//	}
	
	@RequestMapping(value = "/cars", method = RequestMethod.POST)
	public ModelAndView handleUserInput(ModelMap model) {
		//List<Car> al = cs.getCars();
		//model.addAttribute("cars", cs.getCars());
		return new ModelAndView("cars", "cars", cs.getCars());
	}

}
