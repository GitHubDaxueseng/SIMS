package com.cam;

import com.blade.Blade;
import com.blade.mvc.annotation.Path;

@Path
public class Application {
	public static void main(String[] args) {
		Blade.me().showFileList(true).start(Application.class, args);
	}
}
