package com.weixin.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.weixin.utils.SignUtil;

/**
 * 
 * @author Administrator
 * ������΢�ŷ�����������Ϣ
 */
public class CoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
     * ȷ����������΢�ŷ�����
     */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//΢�ż��ܺ���
		String signature=request.getParameter("signature");
		//�r�g��
		String timestamp=request.getParameter("timetamp");
		//�S�C��
		String nonce=request.getParameter("nonce");
		//�S�C�ַ���
		String echostr=request.getParameter("echostr");
		
		PrintWriter out=response.getWriter();
        // ͨ������signature���������У�飬��У��ɹ���ԭ������echostr����ʾ����ɹ����������ʧ��
		if(SignUtil.checkSignature(signature, timestamp, nonce)){
			out.print(echostr);
		}
		out.close();
		out=null;
	}

	/**
     * ����΢�ŷ�������������Ϣ
     */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO ��Ϣ�Ľ��ա�������Ӧ
	}

}
