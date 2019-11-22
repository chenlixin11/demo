package utils;


import com.github.pagehelper.util.StringUtil;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/** 
 * @Copyright (c)</b> 2012融信通-版权所有<br/> 
 *
 * @createTime 2012-11-17下午2:49:32
 *
 * @author <a href="mailto:liujun@rokesoft.com">jun.liu</a>
 *
 * @Description: 校验工具类
 */
public class AnnotationValidate {

	/**
	 * 功能：校验传入对象数据合法性
	 * @return 通过返回true，否则false。
	 */
	public static boolean validate(Object targetObj){
		try {
			Class<? extends Object> cls = targetObj.getClass();
			Field[] fields = cls.getDeclaredFields();
			for (Field field : fields) {
				String fieldName = field.getName();
				String fieldType = field.getGenericType().toString();
				String fieldSimpleType = fieldType.substring(fieldType.lastIndexOf(".")+1);
				String modifer = Modifier.toString(field.getModifiers());
				Annotation[] annottationArray = field.getAnnotations();
				boolean exists = false;
				for (Annotation annotation : annottationArray) {
					Class<? extends Annotation> annotationClass = annotation.annotationType();
					if (annotationClass.toString().equals(IsNeedValidate.class.toString())) {
						exists = true;
					}
				}
				//判断是否存在校验注解
				if (!exists) {
					continue;
				}
				
				
				IsNeedValidate needValidate = field.getAnnotation(IsNeedValidate.class);
				String getMethodName = "get" + getMethodName(fieldName);//Get方法名
				Method targetMethod = null;
				try {
					targetMethod = cls.getMethod(getMethodName); //目标方法对象
				} catch (Exception e) {
					e.printStackTrace();
					throw new RuntimeException("\r\n属性名称：【"+fieldName+"】的GET方法：【"+getMethodName+"】不存在！");
				}
				
				
				/*
				 * 值为空时，是否跳过
				 */
				//if(StringUtil.isNull((String)targetMethod.invoke(targetObj))&&!needValidate.notNull()){
				//	continue;
				//}
				
				
				/*
				 * 值是否为空
				 */
				//if (StringUtil.isNull((String)targetMethod.invoke(targetObj))) {
				//	throw new RuntimeException("\r\n属性名称：【"+modifer+" "+fieldSimpleType+" "+fieldName+"】校验非法，不能为空值！");
				//}
				
				
				//判断待校验属性的类型
				if (("class java.lang.String").equals(fieldType)) {
					String validateValue = (String)targetMethod.invoke(targetObj);//获得属性值
					//校验是否为空
					//if (true == needValidate.notNull()) {
					//	if (StringUtil.isNull(validateValue)) {
					//		throw new RuntimeException("\r\n属性名称：【"+modifer+" "+fieldSimpleType+" "+fieldName+"】的值为：【"+validateValue+"】校验非法，不能为空值！");
					//	}
					//}
					//校验是否为数字类型
					if (true == needValidate.isNumber()) {
						if (!validateValue.matches("^\\d+$")) {
							throw new RuntimeException("\r\n属性名称：【"+modifer+" "+fieldSimpleType+" "+fieldName+"】的值为：【"+validateValue+"】校验非法，必须是数字类型！");
						}
					}
					//校验指定长度（必须相等）
					if (needValidate.fixedLength()>0) {
						int limitLength = needValidate.fixedLength();
						if(validateValue.length()!=limitLength){
							throw new RuntimeException("\r\n属性名称：【"+modifer+" "+fieldSimpleType+" "+fieldName+"】的值为：【"+validateValue+"】校验非法，长度必须为【"+ limitLength +"】！");
						}
					}
					//校验可变长度（小于等于）
					if (needValidate.changedLength()>0) {
						int limitLength = needValidate.changedLength();
						if(validateValue.length()>limitLength){
							throw new RuntimeException("\r\n属性名称：【"+modifer+" "+fieldSimpleType+" "+fieldName+"】的值为：【"+validateValue+"】校验非法，长度必须小于等于【"+ limitLength +"】！");
						}
					}
				}else {
					throw new RuntimeException("\r\n属性名称：【"+modifer+" "+fieldSimpleType+" "+fieldName+"】的类型【"+ fieldSimpleType +"】没有匹配上！");
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
		return true;
	}
	
	
	
	/**
	 * 功能:把一个字符串的第一个字母大写、效率是最高的、   
	 * @param fildeName
	 * @return
	 * @throws Exception
	 */
	private static String getMethodName(String fildeName) throws Exception{  
		StringBuffer sb  = new StringBuffer();
		fildeName = sb.append(fildeName.substring(0, 1).toUpperCase()).append(fildeName.substring(1)).toString();
		return fildeName; 
		
	}  
	
	
}
