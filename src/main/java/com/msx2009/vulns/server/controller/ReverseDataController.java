package com.msx2009.vulns.server.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.msx2009.vulns.server.model.ReverseData;
import com.msx2009.vulns.server.service.ReverseDataService;



@RestController
public class ReverseDataController {
	
	@Autowired
	ReverseDataService reverseDataService;
	
	@GetMapping("/getFastJsonReverseAddr")
	public  String getFastJsonReverseAddr() {
		
		return reverseDataService.getFastJsonReverseAddr();

	}
	
	@GetMapping("/getShadowsocksAddr")
	public  String getShadowsocksAddr() {
		
		return reverseDataService.getShadowsocksAddr();

	}

	@PostMapping("/getReverseRet")
	public  int getReverseRet(@RequestBody ReverseData reverseData) {
		
		return reverseDataService.getReverseRet(reverseData);
	}
}
