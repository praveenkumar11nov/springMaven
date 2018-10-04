package com.mkyong.web.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.core.Request;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/web",method= {RequestMethod.GET,RequestMethod.POST})
public class WebServiceController {

	@RequestMapping(value="/getdetail",method= {RequestMethod.GET,RequestMethod.POST})
	public String getDetails(){
		System.err.println("_______________________/getdetail____________________________");
		List<Map<String,Object>> list=new ArrayList<>();
		Map<String,Object> map=new HashMap<>();
		map.put("Name","RAM");
		map.put("Country","Nepal");
		list.add(map);
		
		return list.toString();
	}
	
}
