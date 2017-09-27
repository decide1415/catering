//��������

package com.Uitl;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
public class CharactorFilter implements Filter { //�̳�Filter��
    //�ַ�����
    String encoding="UTF-8";
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain) throws IOException, ServletException {
        if(encoding!=null){
        //����request�ַ�����
            request.setCharacterEncoding(encoding);
         //����response�ַ�����
            response.setContentType("text/html;charset="+encoding);
        }
     //���ݸ���һ��������
        chain.doFilter(request, response);
    }
    public void init(FilterConfig filterConfig) throws ServletException {
      //��ȡ��ʼ������
        encoding=filterConfig.getInitParameter("encoding");
    }
    public void destroy() {
        // TODO Auto-generated method stub
        encoding=null;
    }
}