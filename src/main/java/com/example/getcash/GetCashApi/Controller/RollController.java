package com.example.getcash.GetCashApi.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.getcash.GetCashApi.models.RollModel;
import com.example.getcash.GetCashApi.service.RollService;

@RestController
@RequestMapping("/userrole")
public class RollController {

	@Autowired
	private RollService rollSerivice;

	@PostMapping("/update")
	public void rollUpdate(@RequestBody RollModel rollModel) {
		rollSerivice.updateRoll(rollModel); 
	}

}
