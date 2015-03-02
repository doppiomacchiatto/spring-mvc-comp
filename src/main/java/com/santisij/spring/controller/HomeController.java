package com.santisij.spring.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/")
public class HomeController {

	@RequestMapping(value="/login", method = RequestMethod.GET)
	public ModelAndView login(ModelMap model) {
 
		return new ModelAndView("login");
 
	}
 
	@RequestMapping(value="/loginfailed", method = RequestMethod.GET)
	public ModelAndView loginFailed(ModelMap model) {
		model.addAttribute("loginError", "true");
		return new ModelAndView("login");
 
	}
 
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public ModelAndView logout(ModelMap model) {
 
		return new ModelAndView("login");
 
	}

	@RequestMapping
	public ModelAndView test(HttpServletResponse response) throws IOException{
		return new ModelAndView("home");
	}
	@RequestMapping(value = "/{name}", method = RequestMethod.GET)
	public ModelAndView displayName(@PathVariable String name, ModelMap model) {
		model.addAttribute("name", name);
		return new ModelAndView("list");
	}
	
	@RequestMapping(value = "/f", method = RequestMethod.GET)
	public ModelAndView getName(@RequestParam (value="name", defaultValue="world") String name, ModelMap model) {	 
		model.addAttribute("name", name);
		return new ModelAndView("list");
 
	}
}
