package com.cam.dao;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFPatriarch;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import com.cam.vo.Student;

public class StuInfoInput {
	public List<Student> readExcelFileToDB(String filePath) {
		List<Student> list = new ArrayList<Student>();
		try {
			FileInputStream fis = new FileInputStream(filePath);
			POIFSFileSystem fs = new POIFSFileSystem(fis);
			HSSFWorkbook workbook = new HSSFWorkbook(fs);// 创建Excel工作簿对象
			HSSFSheet sheet = workbook.getSheetAt(0);// 获取第1个工作表
			HSSFPatriarch patriarch = sheet.getDrawingPatriarch();

			for (int i = 2; i <= sheet.getLastRowNum(); i++) {// 循环Excel文件的每一行
				Student stu = new Student();
				HSSFRow row = sheet.getRow(i);// 获取第i行
				HSSFCell cell0 = row.getCell(0);
				HSSFCell cell1 = row.getCell(1);
				HSSFCell cell2 = row.getCell(2);
				HSSFCell cell3 = row.getCell(3);
				HSSFCell cell4 = row.getCell(4);
				HSSFCell cell5 = row.getCell(5);
				HSSFCell cell6 = row.getCell(6);
				HSSFCell cell7 = row.getCell(7);
				HSSFCell cell8 = row.getCell(8);
				HSSFCell cell9 = row.getCell(9);
				HSSFCell cell10 = row.getCell(10);
				String STUDENT_ID = cell0.getStringCellValue();
				String NAME = cell1.getStringCellValue();
				String SEX = cell2.getStringCellValue();

				// 读取日期
				String CITIZEN_ID = cell4.getStringCellValue();
				String ADDRESS = cell5.getStringCellValue();
				String POLITICAL_STATUS = cell6.getStringCellValue();
				int GRADE = (int) cell7.getNumericCellValue();
				int CLASSES_ID = (int) cell8.getNumericCellValue();
				int SCHOOL_ID = (int) cell9.getNumericCellValue();
				String STUDENT_PWD = "111111";// 第10个是密码，初始化为111111
				stu.setStudent_id(STUDENT_ID);
				stu.setPolitical_status(POLITICAL_STATUS);
				stu.setName(NAME);
				stu.setSex(SEX);
				stu.setAddress(ADDRESS);
				stu.setBirthday(new Date());// poi玩不转，这个Date我没办法处理，先应付下再说吧
				stu.setCitizen_id(CITIZEN_ID);
				stu.setClasses_id(CLASSES_ID);
				stu.setSchool_id(SCHOOL_ID);
				stu.setGrade(GRADE);
				stu.setStudent_pwd("111111");
				//stu.save();
				list.add(stu);
			}
			fis.close();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public boolean deleteOneStu(String sid) {
		Student stu = new Student();
		try {
			stu.delete("sid", sid);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
