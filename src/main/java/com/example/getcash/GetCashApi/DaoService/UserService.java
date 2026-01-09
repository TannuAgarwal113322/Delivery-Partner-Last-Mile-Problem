package com.example.getcash.GetCashApi.DaoService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.getcash.GetCashApi.Entities.UserEntity;
import com.example.getcash.GetCashApi.models.UserModel;
import com.example.getcash.GetCashApi.models.UserRegisterRequestResponseModel;
import com.example.getcash.GetCashApi.respositories.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;

	public List<UserEntity> getAllUser() {
		return userRepository.findAll();

	}

	public boolean userEmail(String userEmail) {
		Optional<UserEntity> vv = userRepository.findByEmail(userEmail);
		return vv.isPresent();

	}

	public UserEntity setModelToEntity(UserRegisterRequestResponseModel userRegisterRequest) {
		UserEntity usrEntity = new UserEntity();
		usrEntity.setEmail(userRegisterRequest.getEmail());
		usrEntity.setPassword(userRegisterRequest.getEmail());
		usrEntity.setUsername(userRegisterRequest.getName());
		UserEntity dbres = userRepository.save(usrEntity);
		return dbres;

	}

	public boolean userEmailValidation(String userEmail) {
		Optional<UserEntity> vv = userRepository.findByEmail(userEmail);
		return vv.isPresent();
	}

	public UserEntity findUserEmailValidation(String userEmail) {
		Optional<UserEntity> vv = userRepository.findByEmail(userEmail);
		return vv.get();
	}

	public void deleteByid(Long id) {
		userRepository.deleteById(id);
	}

	public UserModel putMappings(Long id) {
		// TODO Auto-generated method stub
		UserModel us = new UserModel();
		Optional<UserEntity> user = userRepository.findById(id).map(e -> {
			e.setPassword("Put");
			return userRepository.save(e);
		});
		us.setPassword(user.get().getPassword());
		return us;
	}
}
