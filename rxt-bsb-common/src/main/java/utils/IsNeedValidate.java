package utils;

import java.lang.annotation.*;

/** 
 * @Copyright (c)</b> 2012融信通-版权所有<br/> 
 *
 * @createTime 2012-11-16下午6:52:45
 *
 * @author <a href="mailto:liujun@rokesoft.com">jun.liu</a>
 *
 * @Description: 校验规则的注解类，可对任意对象设置校验策略。
 */

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface IsNeedValidate {
	boolean notNull() default true;
	boolean isNumber() default false;
	int changedLength() default 0;//变长
	int fixedLength() default 0;//定长
}
