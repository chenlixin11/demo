package rxt.bsb.rest.service;

import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerFontProvider;
import com.itextpdf.tool.xml.XMLWorkerHelper;
import freemarker.template.Configuration;
import freemarker.template.Template;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import rxt.bsb.rest.common.util.SystemUtil;
import rxt.bsb.rest.dao.ContrUsercontractDao;
import rxt.bsb.rest.po.ContrUsercontract;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.charset.Charset;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class SignAgreementService {
    @Value("${DEST}")
    private String dest;
    @Value("${HTML}")
    private String html;
    @Value("${FONT}")
    private String font;
    private static Configuration freemarkerCfg = null;

    @Autowired
    private ContrUsercontractDao contrUsercontractDao;

    //文件预览
    public void signAgreement(HttpServletResponse response) throws Exception {
        //需要填充的参数
        Map<String, Object> data = new HashMap<>();
        data.put("title", "");
        data.put("name", "XXX");
        String content = freeMarkerRender(data, html);
        String des = dest + "XXX平台协议.pdf";
        //创建pdf
        createPdf(content, des);

        // 读取pdf并预览
        readPdf(response, des);
    }

    //创建pdf
    public void createPdf(String content, String des) throws Exception {
        // step 1
        Document document = new Document();
        // step 2
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(des));
        // step 3
        document.open();
        // step 4
        XMLWorkerFontProvider fontImp = new XMLWorkerFontProvider(XMLWorkerFontProvider.DONTLOOKFORFONTS);
        fontImp.register(font);
        XMLWorkerHelper.getInstance().parseXHtml(writer, document,
                new ByteArrayInputStream(content.getBytes("UTF-8")), null, Charset.forName("UTF-8"), fontImp);
        // step 5
        document.close();

    }

    /**
     * freemarker渲染html
     */
    public String freeMarkerRender(Map<String, Object> data, String htmlTmp) {
        Writer out = new StringWriter();

        try {
            // 获取模板,并设置编码方式
            setFreemarkerCfg();
            Template template = freemarkerCfg.getTemplate(htmlTmp);
            template.setEncoding("UTF-8");
            //将合并后的数据和模板写入到流中，这里使用的字符流
            template.process(data, out);
            out.flush();
            return out.toString();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return null;
    }

    /**
     * 设置freemarkerCfg
     */
    private void setFreemarkerCfg() {

        freemarkerCfg = new Configuration();
        //freemarker的模板目录
        try {
            freemarkerCfg.setDirectoryForTemplateLoading(new ClassPathResource("template").getFile());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 读取本地pdf,这里设置的是预览
     */
    private void readPdf(HttpServletResponse response, String des) {
        response.reset();
        response.setContentType("application/pdf");
        try {
            File file = new File(des);
            FileInputStream fileInputStream = new FileInputStream(file);
            OutputStream outputStream = response.getOutputStream();
            IOUtils.write(IOUtils.toByteArray(fileInputStream), outputStream);
            response.setHeader("Content-Disposition",
                    "inline; filename= file");
            outputStream.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //提交保存用户协议及数据
    public Integer subInfo(HttpServletRequest request, ContrUsercontract contrUsercontract) throws Exception {
        String userName = contrUsercontract.getUserName();
        Map<String, Object> data = new HashMap<>();
        data.put("title", userName + "_");
        data.put("name", userName);
        String content = freeMarkerRender(data, html);
        String des = dest + userName + "_平台协议.pdf";
        //创建pdf
        createPdf(content, des);
        //获取项目根目录
        String path = SystemUtil.getPath(request);
        contrUsercontract.setContractPath(path + "/" + des);
        contrUsercontract.setCreateTime(new Date());
        return contrUsercontractDao.insertSelective(contrUsercontract);
    }
}
