package com.cam.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.blade.Blade;
import com.blade.Environment;
import com.blade.event.BeanProcessor;
import com.blade.ioc.annotation.Bean;
import com.blade.jdbc.Base;
import com.blade.mvc.view.template.JetbrickTemplateEngine;

@Bean
public class DBLoadConfig implements BeanProcessor {

	@Override
	public void processor(Blade blade) {
		String version = blade.environment().get("app.version", "0.0.1");
		// 配置数据库
		DruidDataSource dataSource = new DruidDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/sims?useUnicode=true&characterEncoding=utf-8");
		dataSource.setUsername("root");
		dataSource.setPassword("123456");

		dataSource.setInitialSize(5);
		dataSource.setMaxActive(5);
		dataSource.setMinIdle(2);
		dataSource.setMaxWait(6000);

		Base.open(dataSource);
	}
}