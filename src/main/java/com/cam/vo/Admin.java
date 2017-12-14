package com.cam.vo;

import com.blade.jdbc.annotation.Table;
import com.blade.jdbc.core.ActiveRecord;

@Table(value = "admin")
public class Admin extends ActiveRecord {
	public String teacher;
	public String teacher_pwd;

	public String getTeacher() {
		return teacher;
	}

	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}

	public String getTeacher_pwd() {
		return teacher_pwd;
	}

	public void setTeacher_pwd(String teacher_pwd) {
		this.teacher_pwd = teacher_pwd;
	}

}
