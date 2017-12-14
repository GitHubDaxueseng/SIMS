package com.cam.vo;

import com.blade.jdbc.annotation.Table;
import com.blade.jdbc.core.ActiveRecord;

@Table(value = "school")
public class School extends ActiveRecord {
	public Integer school_id;
	public String name;

	public Integer getSchool_id() {
		return school_id;
	}

	public void setSchool_id(Integer school_id) {
		this.school_id = school_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
