# SIMS
## Student Information Management System

***

* It is our Java exam project, so I just implemented some basic features such as modifying or deleting student information and adding student information via Excel. Due to the limited time, I did not control access, I will solve this issue later if I have enough time.

* This project is based on Wang's Blade MVC framework and Chen's Jet-brick template engine.

* It actually only took me about 11 hours to write. So... you know 😋

## Project Features
***
Based on `Blade MVC` framework, no more repositories
* [x] Built-in `Netty` server, no Tomcat, just run as Java Application, you can start it
* [x] `Restful` style routing design
* [x] Abandon J2EE JSP, use `Jetbrick` template engine to make view development more flexible
* [x] You can open the web service by running the `JAR` package

## Start method
***
>First, use sql script to set up the database
```
sims.sql is provided in src / main / resources
```
>Then, modify the database link in DBLoadConfig
```java 
@Bean
public class DBLoadConfig implements BeanProcessor {

	@Override
	public void processor(Blade blade) {
		String version = blade.environment().get("app.version", "0.0.1");
		// Conifg of DB
		DruidDataSource dataSource = new DruidDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/sims?useUnicode=true&characterEncoding=utf-8");
		dataSource.setUsername("root");
		dataSource.setPassword("yourpasswd");
		...
		}
```
> Finally, start Application.java in Com.cam <b>(Run as Java Application)</b>, then visit `yourhost`: 9000 / teacher, everything is ok



## 学生信息管理系统
***
* 它是我们的Java考试项目，所以我只是实现了一些基本功能比如修改或删除学生信息，和通过Excel增加学生信息。由于时间有限，我并没有进行访问权限控制，如果我有充足的时间以后我会解决这些问题。

* 这个项目是基于王爵大佬的Blade框架和陈国强大佬的Jetbrick模板引擎构建的。 

* 实际上我只花了大约11个小时工作时间进行编写。 所以。。。你懂的  😋

## 项目特性

* [x] 基于`Blade MVC`框架，不依赖更多的库
* [x] 内置`Netty`服务器，无需Tomcat,一键run as Java Application轻松启动
* [x] `Restful`风格路由设计
* [x] 放弃J2EE的JSP，拥抱`Jetbrick`模板引擎，视图开发更灵活
* [x] 运行 `JAR` 包即可开启 web 服务

## 启动方法
***
>使用sql脚本建立数据库
```
sims.sql在src/main/resources里提供
```
>在DBLoadConfig里面修改数据库链接
```java 
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
		dataSource.setPassword("yourpasswd");
		...
		}
```

> 启动com.cam中的Application.java <b>(Run as Java Application)</b>，然后访问`yourhost`:9000/teacher，最后，希望各位大佬在右上角砸个Star🌟，一切就完美了👆🏼

## 问题反馈
在使用中有任何问题，欢迎反馈给我，可以用以下联系方式跟我交流(注意，这是maven项目，请以maven形式导入并联网拉去jar包)

* 邮件：1273391194cam#gmail.com(将“#”替换为“@”)
* QQ: 1273391194

## 感激
感谢以下的项目,排名不分先后

* [Blade](https://github.com/biezhi/blade) 
* [Druid](https://github.com/alibaba/druid) 
* [Jetbrick-template-2x](https://github.com/subchen/jetbrick-template-2x) 
