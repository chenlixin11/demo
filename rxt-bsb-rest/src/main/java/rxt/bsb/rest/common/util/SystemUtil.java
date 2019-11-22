package rxt.bsb.rest.common.util;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

public class SystemUtil {

    //获取项目的根目录
    public static String getPath(HttpServletRequest request) throws IOException {
        File file = new File("");
        String path = file.getCanonicalPath();
        return path;
    }

    //获取ip和端口
    public static String getContextPath(HttpServletRequest request){
        String path = request.getContextPath();
        String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
        return basePath;
    }
}
