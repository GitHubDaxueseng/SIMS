package com.cam.controller;

import com.blade.mvc.annotation.Param;
import com.blade.mvc.annotation.Path;
import com.blade.mvc.annotation.PostRoute;
import com.blade.mvc.http.Request;
import com.cam.dao.AdminVerifly;
import com.cam.dao.StuVerifly;

@Path
public class LoginRegController {
	@PostRoute("login")
	public String adminLogin(@Param String login, @Param String password) {
		AdminVerifly av = new AdminVerifly();
		if (av.adminVerifly(login, password)) {
			return "index";
		} else {
			return "error.html";
		}
	}

	@PostRoute("stulogin")
	public String stuLogin(@Param String username, @Param String password, Request req) {
		StuVerifly sv = new StuVerifly();
		if (sv.adminVerifly(username, password) != null) {
			req.attribute("stu", sv.adminVerifly(username, password));
			return "index2";
		} else {
			return "error.html";
		}
	}

}
