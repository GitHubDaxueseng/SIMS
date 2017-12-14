package com.cam.vo;

import java.util.Date;

import com.blade.jdbc.annotation.Table;
import com.blade.jdbc.core.ActiveRecord;

import lombok.Data;

@Data
@Table(value = "student", pk = "STUDENT_ID")
public class Student extends ActiveRecord {
	public String student_id;
	public String name;
	public String sex;
	public Date birthday;
	public String citizen_id;
	public String address;
	public String political_status;
	public Integer grade;
	public Integer classes_id;
	public Integer school_id;
	public String student_pwd;

	public String getStudent_id() {
		return student_id;
	}

	public void setStudent_id(String student_id) {
		this.student_id = student_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getCitizen_id() {
		return citizen_id;
	}

	public void setCitizen_id(String citizen_id) {
		this.citizen_id = citizen_id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPolitical_status() {
		return political_status;
	}

	public void setPolitical_status(String political_status) {
		this.political_status = political_status;
	}

	public Integer getGrade() {
		return grade;
	}

	public void setGrade(Integer grade) {
		this.grade = grade;
	}

	public Integer getClasses_id() {
		return classes_id;
	}

	public void setClasses_id(Integer classes_id) {
		this.classes_id = classes_id;
	}

	public Integer getSchool_id() {
		return school_id;
	}

	public void setSchool_id(Integer school_id) {
		this.school_id = school_id;
	}

	public String getStudent_pwd() {
		return student_pwd;
	}

	public void setStudent_pwd(String student_pwd) {
		this.student_pwd = student_pwd;
	}

}
