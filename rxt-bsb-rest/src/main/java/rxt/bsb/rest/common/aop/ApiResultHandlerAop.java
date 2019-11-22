package rxt.bsb.rest.common.aop;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;
import rxt.bsb.rest.common.ApiResult;
import rxt.bsb.rest.common.Enums.ResultCode;

import java.lang.reflect.AnnotatedElement;
import java.util.Arrays;


@ControllerAdvice(annotations = RestController.class)
public class ApiResultHandlerAop implements ResponseBodyAdvice {

    private static ThreadLocal<ObjectMapper>  mapperThreadLocal = ThreadLocal.withInitial(ObjectMapper::new);

    private static final Class[] annos = {
            RequestMapping.class,
            GetMapping.class,
            PostMapping.class,
            DeleteMapping.class,
            PutMapping.class
    };

    /**
     * 对所有RestController的接口方法进行拦截
     */
    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        AnnotatedElement element = returnType.getAnnotatedElement();
        return Arrays.stream(annos).anyMatch(anno -> anno.isAnnotation() && element.isAnnotationPresent(anno));
    }


    @Override
    public Object beforeBodyWrite(@Nullable Object body, MethodParameter returnType, MediaType selectedContentType, Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        Object out;
        ObjectMapper mapper = mapperThreadLocal.get();
        response.getHeaders().setContentType(MediaType.APPLICATION_JSON_UTF8);


        if(body instanceof ApiResult){
            out = body;
        }
        else if (body == null ){
            out = ApiResult.of(ResultCode.SERVER_ERROR);
        }

        else if (body instanceof ResultCode){
            ResultCode rCode = (ResultCode) body;
            out = ApiResult.of(rCode);
        }

        else if (body instanceof String){
            ApiResult result = ApiResult.successOf(body);
            try {
                //因为是String类型，我们要返回Json字符串，否则SpringBoot框架会转换出错
                out = mapper.writeValueAsString(result);
            } catch (JsonProcessingException e) {
                out =  ApiResult.of(ResultCode.JSON_PARSE_ERROR);

            }
        }

        else{
            out = ApiResult.successOf(body);
        }

        return out;
    }

}
