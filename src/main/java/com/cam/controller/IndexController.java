package com.cam.controller;

import com.blade.mvc.annotation.GetRoute;
import com.blade.mvc.annotation.Path;
import com.blade.mvc.ui.ModelAndView;

@Path
public class IndexController {
	@GetRoute("/stu")
	public ModelAndView login(ModelAndView mav) {
		mav.setView("stulogin.html");
		return mav;
	}

	@GetRoute("/teacher")
	public ModelAndView t_login(ModelAndView mav) {
		mav.setView("login.html");
		return mav;
	}
}