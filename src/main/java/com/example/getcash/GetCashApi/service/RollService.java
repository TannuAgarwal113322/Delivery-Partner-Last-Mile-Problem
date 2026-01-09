package com.example.getcash.GetCashApi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.getcash.GetCashApi.DaoService.UserService;
import com.example.getcash.GetCashApi.Entities.UserEntity;
import com.example.getcash.GetCashApi.models.RollModel;
import com.example.getcash.GetCashApi.respositories.UserRepository;
@Service
public class RollService {

	@Autowired
	private UserService userService;

	@Autowired
	private UserRepository userRepository;

	public void updateRoll(RollModel rollModel) {
		// TODO Auto-generated method stub
		UserEntity user = userService.findUserEmailValidation(rollModel.getEmail());
		user.setRolePrimary(rollModel.getPrimaryRoll());
		user.setTemporaryRole(rollModel.getTemporaryRoll());
		userRepository.save(user);

	}

}
