package com.xworkz.login.service.login;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.xworkz.login.dao.login.RegisterDAO;
import com.xworkz.login.dto.login.RegisterDTO;
@Service
public class RegisterService {
@Autowired
private RegisterDAO dao;
	public RegisterDTO saveToDAO(RegisterDTO dto) {
		
		System.out.println("Entering saveToDAO in service class");
		try {
		if (!StringUtils.isEmpty(dto.getCname())&&!StringUtils.isEmpty(dto.getEmail())&&!StringUtils.isEmpty(dto.getPassword())) {
			System.out.println("First step validation completed");
			if(Objects.nonNull(dto.getCmobileNo())&&Objects.nonNull(dto.getDob())) {
				System.out.println("Second step validation completed");
				RegisterDTO dtoFromDB=dao.saveToDb(dto);
				
				
				return dtoFromDB;
			}
		}
		}catch (Exception e) {
			System.err.println("Object cannot be saved due to some Exception:"+e.getMessage());
		}
		return null;
			}
	}


