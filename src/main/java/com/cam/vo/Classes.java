package com.cam.vo;

import com.blade.jdbc.annotation.Table;
import com.blade.jdbc.core.ActiveRecord;

@Table(value = "classes")
public class Classes extends ActiveRecord {
	public Integer classes_id;
	public String name;
	public Integer grade;

	public Integer getClasses_id() {
		return classes_id;
	}

	public void setClasses_id(Integer classes_id) {
		this.classes_id = classes_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getGrade() {
		return grade;
	}

	public void setGrade(Integer grade) {
		this.grade = grade;
	}

	public String getTeacher() {
		return teacher;
	}

	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}

	public String teacher;
}
