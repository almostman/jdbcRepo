package com.almostman.util;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.ResultSet;
import java.util.List;


/**
 * �����Զ�װ����
 * @author CjloveXf
 *
 * @param <T> װ����������
 */
public class AutoWise<T> {


	/**
	 * ��ȡװ��õĶ���
	 * @param classPath  װ�����bean����·��
	 * @param list ���ڴ��װ�����ļ���
	 * @param set �����ݿ��ȡ�Ľ����
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
