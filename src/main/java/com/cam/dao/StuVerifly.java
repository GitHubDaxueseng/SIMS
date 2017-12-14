package com.cam.dao;

import java.util.List;

import com.cam.vo.Admin;
import com.cam.vo.Student;

public class StuVerifly {
	/**
	 * 学生账号密码校验
	 * 
	 * @param username
	 * @param password
	 * @return
	 */
	public Student adminVerifly(String username, String password) {
		Student stu = new Student();
		stu.setStudent_id(username);
		List<Student> stuList = stu.findAll();
		try {
			if (stuList.get(0).getStudent_id().equals(username) && stuList.get(0).getStudent_pwd().equals(password)) {
				return stuList.get(0);
			} else {
				return null;
			}
		} catch (Exception e) {
			return null;
		}
	}
}
