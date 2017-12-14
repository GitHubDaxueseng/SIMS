package com.cam.dao;

import java.util.List;

import com.cam.vo.Admin;

public class AdminVerifly {
	/**
	 * 管理员校验
	 * 
	 * @param username
	 * @param password
	 * @return
	 */
	public Boolean adminVerifly(String username, String password) {
		Admin admin = new Admin();
		List<Admin> adminList = admin.findAll();
		if (adminList.get(0).getTeacher().equals(username) && adminList.get(0).getTeacher_pwd().equals(password)) {
			return true;
		} else {
			return false;
		}
	}
}
