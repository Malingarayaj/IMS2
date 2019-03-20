package com.xworkz.login.service.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.xworkz.login.dao.login.LoginDAO;
import com.xworkz.login.dto.login.LoginDTO;

@Service
public class LoginService {
	@Autowired
	private LoginDAO dao;

	public LoginService() {
		System.out.println("Object created for:\t" + this.getClass().getSimpleName());
	}

	public LoginDTO loginToValidate(LoginDTO dtotoservice) {

		System.out.println("Entering loginToValidate method");
		try {
			if (!StringUtils.isEmpty(dtotoservice.getUserName()) && !StringUtils.isEmpty(dtotoservice.getPassword())) {
				System.out.println(dtotoservice);
				LoginDTO dtoFromDb = dao.validate(dtotoservice);
				
				System.out.println(dtoFromDb);
				if (dtotoservice.getUserName().equals(dtoFromDb.getUserName())
						&& dtotoservice.getPassword().equals(dtoFromDb.getPassword())) {
					System.out.println("Matching object is found for:" + dtoFromDb.getUserName());
					return dtoFromDb;
				}
			}
		} catch (Exception e) {
			System.err.println("Exception has occured:" + e.getMessage());
		}
		return null;
	}

}
