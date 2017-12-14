package com.cam.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.blade.mvc.Const;
import com.blade.mvc.annotation.GetRoute;
import com.blade.mvc.annotation.MultipartParam;
import com.blade.mvc.annotation.Param;
import com.blade.mvc.annotation.Path;
import com.blade.mvc.annotation.PathParam;
import com.blade.mvc.annotation.PostRoute;
import com.blade.mvc.http.Request;
import com.blade.mvc.multipart.FileItem;
import com.cam.dao.StuInfoInput;
import com.cam.vo.Classes;
import com.cam.vo.School;
import com.cam.vo.Student;

@Path
public class StuInfoController {
	/**
	 * 学生列表
	 * 
	 * @param req
	 * @return
	 */
	@GetRoute("stuInfoList")
	public String getStuInfo(Request req) {
		Student stu = new Student();
		List<Student> stus = stu.findAll();
		req.attribute("stus", stus);
		return "studentInfoList";
	}

	/*
	@GetRoute("addByExcel")
	public String addStuInfoByExcel(Request req,@MultipartParam FileItem file) {
		Student student = new Student();
		List<Student> stus = new ArrayList<Student>();
		System.out.println("wtffffffffffff"+file.getFileName());
		StuInfoInput sii = new StuInfoInput();
		stus = sii.readExcelFileToDB("C:/Users/Google/Desktop/emp.xls");
		for (Student stu : stus) {
			try {
				stu.save();
			} catch (Exception e) {
				// req.attribute("msg", "导入数据出错");
				// System.err.println("导入数据出错");
			}
		}
		stus = student.findAll();
		req.attribute("stus", stus);
		return "studentInfoList";
	}*/

	/**
	 * 转发到单独添加学生信息页
	 * 
	 * @param req
	 * @return
	 */
	@GetRoute("addOneStu")
	public String toAddPage(Request req) {
		// Student stu = new Student();
		School sc = new School();
		Classes cs = new Classes();
		List<School> scs = new ArrayList<School>();
		List<Classes> css = new ArrayList<Classes>();
		scs = sc.findAll();
		css = cs.findAll();
		req.attribute("scs", scs);
		req.attribute("css", css);
		return "popInput";
	}

	/**
	 * 单独添加学生信息
	 * 
	 * @param req
	 * @param student_name
	 * @param student_id
	 * @param citizen_id
	 * @param birthday
	 * @param school_id
	 * @param grade
	 * @param classes
	 * @param address
	 * @param poloticy
	 * @param sex
	 * @return
	 */
	@GetRoute("addIn")
	public String insertOneStudent(Request req, @Param String student_name, @Param String student_id,
			@Param String citizen_id, @Param Date birthday, @Param Integer school_id, @Param Integer grade,
			@Param Integer classes, @Param String address, @Param String poloticy, @Param String sex) {
		Student stu = new Student();
		System.out.println(birthday);
		stu.setName(student_name);
		stu.setStudent_id(student_id);
		stu.setCitizen_id(citizen_id);
		stu.setBirthday(new java.util.Date());
		stu.setSchool_id(school_id);
		stu.setAddress(address);
		stu.setGrade(grade);
		stu.setClasses_id(classes);
		stu.setPolitical_status(poloticy);
		stu.setSex(sex);
		try {
			stu.save();
			return "success";
		} catch (Exception e) {
			return "error";
		}
	}

	/**
	 * 修改学生信息
	 * 
	 * @param sid
	 * @param req
	 * @return
	 */
	@GetRoute("changeOneStu/:sid")
	public String updateOneStudent(@PathParam String sid, Request req) {
		Student stu = new Student();
		School sc = new School();
		Classes cs = new Classes();
		List<School> scs = new ArrayList<School>();
		List<Student> stus = new ArrayList<Student>();
		List<Classes> css = new ArrayList<Classes>();
		stu.setStudent_id(sid);
		stus = stu.findAll();
		System.out.println(stus.get(0).getName());
		scs = sc.findAll();
		css = cs.findAll();
		req.attribute("stu", stus.get(0));
		req.attribute("scs", scs);
		req.attribute("css", css);
		return "popUpdate";
	}

	/**
	 * 处理popUpdate传来的数据
	 * 
	 * @param req
	 * @param student_name
	 * @param student_id
	 * @param citizen_id
	 * @param birthday
	 * @param school_id
	 * @param grade
	 * @param classes
	 * @param address
	 * @param poloticy
	 * @param sex
	 * @return
	 */
	@GetRoute("updateIn")
	public String updateOneStudent(Request req, @Param String student_name, @Param String student_id,
			@Param String citizen_id, @Param Date birthday, @Param Integer school_id, @Param Integer grade,
			@Param Integer classes, @Param String address, @Param String poloticy, @Param String sex) {
		Student stu = new Student();
		System.out.println(birthday);
		System.out.println(student_name);
		System.out.println(student_id);
		stu.setName(student_name);
		stu.setCitizen_id(citizen_id);
		if (birthday != null) {
			stu.setBirthday(birthday);
		} else {
			stu.setBirthday(new java.util.Date());
		}
		stu.setSchool_id(school_id);
		stu.setAddress(address);
		stu.setGrade(grade);
		stu.setClasses_id(classes);
		stu.setPolitical_status(poloticy);
		stu.setSex(sex);
		try {
			stu.where("student_id", student_id).update();
			return "success";
		} catch (Exception e) {
			return "error";
		}
	}
	
	/**
	 * Excel批量添加
	 * 
	 * @param req
	 * @return
	 */
	@GetRoute("uploadsf")
	public String upload() {
		return "uploadExcel";
	}

	@PostRoute("uploadExcel")
	public String doUpload(@MultipartParam FileItem fileItem) {
		if (null != fileItem) {
			byte[] data = fileItem.getData();
			Student student = new Student();
			List<Student> stus = new ArrayList<Student>();
			// Save the temporary file to the specified path
			try {
				Files.deleteIfExists(Paths.get(Const.CLASSPATH + "/upload/" + fileItem.getFileName()));
				Files.write(Paths.get(Const.CLASSPATH + "/upload/" + fileItem.getFileName()), data);
				StuInfoInput sif = new StuInfoInput();
				try {
					System.out.println(fileItem.getFileName());
					stus = sif.readExcelFileToDB(Const.CLASSPATH + "/upload/" + fileItem.getFileName());
					for (Student stu : stus) {
						try {
							stu.save();
						} catch (Exception e) {
						}
					}
				} catch (Exception e) {
					return "error";
				}
				return "success";
			} catch (IOException e) {
				e.printStackTrace();
				return "error";
			}
		}
		return "error";
	}

	/**
	 * 删除学生信息
	 * 
	 * @param sid
	 * @param req
	 * @return
	 */
	@GetRoute("delelteStu/:sid")
	public String delete(@PathParam String sid, Request req) {
		System.out.println(sid);
		Student stu = new Student();
		List<Student> stus = new ArrayList<Student>();
		try {
			stu.where("student_id", sid).delete();
			stus = stu.findAll();
			req.attribute("stus", stus);
			return "studentInfoList";
		} catch (Exception e) {
			return "studentInfoList";
		}

	}

}
