package utils;
import org.hibernate.validator.HibernateValidator;
import org.springframework.context.annotation.Configuration;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Iterator;
import java.util.Set;


@Configuration
public class ValidationUtils {

    /**
     * 使用hibernate的注解来进行验证
     */
    private static Validator validator = Validation
            .byProvider(HibernateValidator.class).configure().failFast(true).buildValidatorFactory().getValidator();

    /**
     * 功能描述: <br>
     * 〈注解验证参数〉
     *
     * @param obj
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public static <T> String validate(T obj) {
        Set<ConstraintViolation<T>> constraintViolations = validator.validate(obj);
        // 抛出检验异常
        if (constraintViolations.size() > 0) {
        	/*String result = "";
        	for(int i=0;i<constraintViolations.size();i++){
        		result = result + constraintViolations.iterator().next().getMessage();
        	}
        	return result;*/
        	StringBuffer buffer = new StringBuffer(64);//用于存储验证后的错误信息
        	Iterator<ConstraintViolation<T>> iter = constraintViolations.iterator();
        	while (iter.hasNext()) {
        		String message = iter.next().getMessage();
        		buffer.append(message);
        	}
        	return buffer.toString();
        }

        return "1";
    }
}