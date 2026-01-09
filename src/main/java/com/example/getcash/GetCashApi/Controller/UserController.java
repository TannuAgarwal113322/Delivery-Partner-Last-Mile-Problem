package com.example.getcash.GetCashApi.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.getcash.GetCashApi.DaoService.UserService;
import com.example.getcash.GetCashApi.Entities.UserEntity;
import com.example.getcash.GetCashApi.MailSender.EmailService;
import com.example.getcash.GetCashApi.UtilityHelper.CommonConstants.ApiConstant;
import com.example.getcash.GetCashApi.UtilityHelper.JwtHelper;
import com.example.getcash.GetCashApi.models.UserModel;
import com.example.getcash.GetCashApi.models.UserRegisterRequestResponseModel;
import com.example.getcash.GetCashApi.service.CostumeUserDetailsService;
import com.example.getcash.GetCashApi.service.UserLoginRequest;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private EmailService emailService;
	@Autowired
	private UserService userSerive;
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private JwtHelper jwthelper;
	@Autowired
	private CostumeUserDetailsService costumeUserDetailsService;
	@Autowired
	private UserService userService;

	@PostMapping("/registerUser")
	public UserRegisterRequestResponseModel registerUser(
			@RequestBody UserRegisterRequestResponseModel userRegisterRequest) throws Exception {
		System.out.println("The data is " + userRegisterRequest);
		boolean flag = userSerive.userEmailValidation(userRegisterRequest.getEmail());
		UserRegisterRequestResponseModel registerResponse = new UserRegisterRequestResponseModel();
		try {
			if (flag == true) {
				registerResponse.setAuthtoken(null);
				registerResponse.setApiValidation(ApiConstant.email_exist);
				return registerResponse;
			}

		} catch (Exception e) {
			e.printStackTrace();

		}
		try {
			UserEntity reposnse = userSerive.setModelToEntity(userRegisterRequest);
			registerResponse.setApiValidation(ApiConstant.SUCESSS);
			registerResponse.setName(reposnse.getUsername());
			registerResponse.setEmail(reposnse.getEmail());
			registerResponse.setUserStatus("UserRegister Sucessfully:");
		} catch (Exception e) {
			e.printStackTrace();
			registerResponse.setUserStatus("UserRegister Failure:");

		}
		try {
			if (registerResponse.getApiValidation().equals(ApiConstant.SUCESSS))
				emailService.registerSendOtp(registerResponse.getName(), registerResponse.getEmail());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return registerResponse;
	}

	@PostMapping("/loginOtp")
	public UserModel loginOtp(@RequestBody UserLoginRequest userRequest) throws Exception {
		UserEntity user = userService.findUserEmailValidation(userRequest.getEmail());
		UserModel usereponse = new UserModel();
		try {
			if (user.equals(null)) {
				usereponse.setOtpValid(ApiConstant.EMAIL_DOES_NOT_EXIST);
				return usereponse;
			} else {
				emailService.sendOtp(user.getUsername(), user.getEmail());
				usereponse.setStatus(ApiConstant.SUCESSS);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return usereponse;
	}

	@PostMapping("/login")
	public UserModel generateToken(@RequestBody UserLoginRequest userRequest) throws Exception {
		System.out.println("The data is " + userRequest);
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(userRequest.getEmail(), userRequest.getPassword()));
		} catch (UsernameNotFoundException e) {
			throw new Exception("Bad Credentials");
		}
		UserDetails userDetails = costumeUserDetailsService.loadUserByUsername(userRequest.getEmail());
		String token = jwthelper.generateToken(userDetails.getUsername());
		UserEntity userModel = userService.findUserEmailValidation(userRequest.getEmail());
		return new UserModel(userModel.getUsername(), token, userModel.getPassword(), userModel.getRolePrimary(),
				userModel.getTemporaryRole(), userModel.getLocationInfo(), userModel.getEmail(), "", "");
	}

	@GetMapping("/getalluser")
	public List<UserEntity> authenticationSucessfull() {
		return userService.getAllUser();
	}

	@DeleteMapping("/delete/{id}")
	public String deleteMapi(@PathVariable("id") Long id) {

		userService.deleteByid(id);
		return "SucessDelete";
	}

	@PutMapping("/put/{id}")
	public UserModel putMappings(@PathVariable("id") Long id) {

		UserModel us = userService.putMappings(id);
		return us;
	}
}
