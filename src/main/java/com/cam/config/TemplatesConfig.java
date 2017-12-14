package com.cam.config;

import com.blade.Blade;
import com.blade.event.BeanProcessor;
import com.blade.ioc.annotation.Bean;
import com.blade.mvc.view.template.JetbrickTemplateEngine;

@Bean
public class TemplatesConfig implements BeanProcessor {
	// 配置模板引擎
	@Override
	public void processor(Blade blade) {
		blade.templateEngine(new JetbrickTemplateEngine());
	}
}