package com.almostman.util;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.ResultSet;
import java.util.List;


/**
 * 对象自动装配器
 * @author CjloveXf
 *
 * @param <T> 装配对象的类型
 */
public class AutoWise<T> {


	/**
	 * 获取装配好的对象
	 * @param classPath  装配对象（bean）的路径
	 * @param list 用于存放装配对象的集合
	 * @param set 从数据库获取的结果集
	 * @throws Exception
	 */
	public void getObject(String classPath, List<T> list, ResultSet set) throws Exception{
		
		Class<?> t = Class.forName(classPath);
		 
		while(set.next()){
			T obj = (T) t.newInstance();
			
			Method[] methods  = t.getMethods();
			
			for (Method method : methods) {
				if(method.getName().startsWith("set")){
					String methodName = method.getName().substring(method.getName().indexOf("set")+3);
					methodName = methodName.toLowerCase();
					
					method.invoke(obj, set.getObject(methodName));
				}
			}
			
			list.add(obj);
		}
		
		
	}
	
}
