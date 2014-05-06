package com.alexgaoyh.unbusiness.freemarker;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;

/**
 * 修改demo()方法内部的root.put()的value值，运行即可
 * @author gaoyihang
 *
 */
public class GenerateJavaFile {

	public static void main(String[] args) {
		demo();
	}

	public static void demo() {

		Map<String, Object> root = new HashMap<String, Object>();
		root.put("packageName", "com.alexgaoyh.freemarkerTest.freemarker");//包路径
		root.put("className", "User");//类名称
		root.put("springName", "user");//类名称的首字母小写
		root.put("author", "alexgaoyh");//作者
		root.put("tableName", "user");//表名称
		root.put("entityNameCN", "用户表");//类描述
		root.put("date", new Date().toString());//创建时间
		
		String workDir = (String) System.getProperties().get("user.dir");

		try {
			entity(workDir, root);
			dao(workDir, root);
			daoImpl(workDir, root);
			service(workDir, root);
			serviceImpl(workDir, root);
			action(workDir, root);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public static void entity(String workDir, Map<String, Object> input) throws Exception {

		String fileName = workDir + "/src/main/java/"
				+ input.get("packageName").toString().replaceAll("\\.", "/")
				+ "/entity/" + input.get("className").toString() + ".java";
		
		File myFile = new File(fileName);
		myFile.getParentFile().mkdirs();
		myFile.createNewFile();

		buildFile("templete/entity.ftl", fileName, input);
	}
	
	public static void dao(String workDir, Map<String, Object> input) throws Exception {

		String fileName = workDir + "/src/main/java/"
				+ input.get("packageName").toString().replaceAll("\\.", "/")
				+ "/dao/" + input.get("className").toString() + "Dao.java";
		
		File myFile = new File(fileName);
		myFile.getParentFile().mkdirs();
		myFile.createNewFile();

		buildFile("templete/dao.ftl", fileName, input);
	}
	
	public static void daoImpl(String workDir, Map<String, Object> input) throws Exception {

		String fileName = workDir + "/src/main/java/"
				+ input.get("packageName").toString().replaceAll("\\.", "/")
				+ "/dao/impl/" + input.get("className").toString() + "DaoImpl.java";
		
		File myFile = new File(fileName);
		myFile.getParentFile().mkdirs();
		myFile.createNewFile();

		buildFile("templete/daoImpl.ftl", fileName, input);
	}
	
	public static void service(String workDir, Map<String, Object> input) throws Exception {

		String fileName = workDir + "/src/main/java/"
				+ input.get("packageName").toString().replaceAll("\\.", "/")
				+ "/service/" + input.get("className").toString() + "Service.java";
		
		File myFile = new File(fileName);
		myFile.getParentFile().mkdirs();
		myFile.createNewFile();

		buildFile("templete/service.ftl", fileName, input);
	}
	
	public static void serviceImpl(String workDir, Map<String, Object> input) throws Exception {

		String fileName = workDir + "/src/main/java/"
				+ input.get("packageName").toString().replaceAll("\\.", "/")
				+ "/service/impl/" + input.get("className").toString() + "ServiceImpl.java";
		
		File myFile = new File(fileName);
		myFile.getParentFile().mkdirs();
		myFile.createNewFile();

		buildFile("templete/serviceImpl.ftl", fileName, input);
	}
	
	public static void action(String workDir, Map<String, Object> input) throws Exception {

		String fileName = workDir + "/src/main/java/"
				+ input.get("packageName").toString().replaceAll("\\.", "/")
				+ "/action/" + input.get("className").toString() + "Action.java";
		
		File myFile = new File(fileName);
		myFile.getParentFile().mkdirs();
		myFile.createNewFile();

		buildFile("templete/action.ftl", fileName, input);
	}

	/**
	 * 生成文件
	 * @param templateName 模板文件
	 * @param fileName 生成文件
	 * @param root 参数
	 */
	private static void buildFile(String templateName, String fileName, Map root) {
		Configuration freemarkerCfg = new Configuration();
		freemarkerCfg.setClassForTemplateLoading(GenerateJavaFile.class, "/");
		freemarkerCfg.setEncoding(Locale.getDefault(), "UTF-8");
		Template template;
		try {
			template = freemarkerCfg.getTemplate(templateName);
			template.setEncoding("UTF-8");
			File htmlFile = new File(fileName);
			Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(htmlFile), "UTF-8"));
			template.process(root, out);
			out.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}