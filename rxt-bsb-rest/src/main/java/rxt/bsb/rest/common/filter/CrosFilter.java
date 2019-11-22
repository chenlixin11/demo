package rxt.bsb.rest.common.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class CrosFilter implements Filter {


    private final static Logger logger = LoggerFactory.getLogger(CrosFilter.class);


    private static String [] ACCESSURL;




    private static String LOCAL_ADDRESS = "http://127.0.0.1";
    @Value("${custom.access-url}")
    public  void setACCESSURL(String[] ACCESSURL) {
        CrosFilter.ACCESSURL = ACCESSURL;
    }


    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response  = (HttpServletResponse) resp;
        logger.info(  String.format( "sessionId 为:%s", request.getSession().getId() ));
        cross(req , resp);
        chain.doFilter(req, response);
    }



    public static void cross( ServletRequest req, ServletResponse resp ){
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response  = (HttpServletResponse) resp;

        String origin = request.getHeader("Origin");
        if(origin != null &&  access(origin)  ){
            response.setHeader("Access-Control-Allow-Origin", origin );
        }else{
            response.setHeader("Access-Control-Allow-Origin", LOCAL_ADDRESS );
        }

        response.setStatus(HttpServletResponse.SC_OK);
        response.setContentType("application/json;charset=UTF-8");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS, PUT, DELETE");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "Content-Type,XFILENAME,XFILECATEGORY,XFILESIZE");

    }


    static boolean  access( String accessUrl ) {
        boolean access = false;
        for( String acc: ACCESSURL  ) {
            if( access = acc.equals( accessUrl)) break;
        }

        return  access;
    }

    @Override
    public void destroy() {

    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

}
