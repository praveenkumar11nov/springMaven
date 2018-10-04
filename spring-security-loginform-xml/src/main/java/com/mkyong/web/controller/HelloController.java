package com.mkyong.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	@RequestMapping(value = { "/", "/welcome" }, method = RequestMethod.GET)
	public ModelAndView welcomePage() {
		System.err.println("________________________________welcomePage________________________________");
		ModelAndView model = new ModelAndView();
		model.addObject("title", "Home Page");
		model.addObject("message", "Welcomes User");
		model.setViewName("hello");
		return model;
	}
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public ModelAndView adminPage() {
		System.err.println("________________________________adminPage________________________________");
		ModelAndView model = new ModelAndView();
		model.addObject("title", "Spring Security Custom Login Form");
		model.addObject("message", "This is protected page!");
		model.setViewName("admin");
		return model;
	}
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout) {
		System.err.println("________________________________login________________________________");
		ModelAndView model = new ModelAndView();
		if (error != null) {
			model.addObject("error", "Invalid username and password!");
		}
		if (logout != null) {
			model.addObject("msg", "You've been logged out successfully.");
		}
		model.setViewName("login");
		return model;
	}
	@RequestMapping(value = "/commentsubmit", method = RequestMethod.POST)
	public String commentsubmit(HttpServletRequest request,Model model) {
		System.out.println("comment posting "+request.getParameter("name"));
		model.addAttribute("name",request.getParameter("name"));
		model.addAttribute("email",request.getParameter("email"));
		model.addAttribute("comment",request.getParameter("comment"));
		return "comment";
	}
	@RequestMapping(value="/getDataFromApplication",method={RequestMethod.GET},produces="application/json")
	public @ResponseBody String getdataFromApp() {
		System.out.println("__________________________/getDataFromApplication__________________________");
		return getResponse();
	}

	public String getResponse() {
		JSONObject response=new JSONObject();
		JSONArray response1=new JSONArray();
		JSONObject response2=new JSONObject();
		JSONObject response3=new JSONObject();
		try {
			response2.put("name","Praveen");
			response2.put("address","Bangalore");
			response2.put("mobile","9738716976");
			response2.put("email","praveen.kumar@bcits.in");
			
			response3.put("name","Kumar");
			response3.put("address","Delhi");
			response3.put("mobile","7205606332");
			response3.put("email","kumar@bcits.in");
			
			response1.put(response2);
			response1.put(response3);
			response.put("data",response1);
		} 
		catch (Exception e) {
			
		}
		return response.toString();
	}
	

}