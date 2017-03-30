package com.qiwx;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author qiwx
 * @time 2017��3��30�� ����4:59:49
 * @Des
 **/
public class BasicServlet extends HttpServlet {

	@Override
	public void init() throws ServletException {
		System.out.println("init");
		//�ֲ�����
		String usernameString=this.getInitParameter("username");
		System.out.println(usernameString);
		//ȫ�ֲ���
		String url=this.getServletContext().getInitParameter("url");
		System.out.println(url);
	}

	@Override
	public void destroy() {
		System.out.println("destroy");
	}

	public BasicServlet() {
		System.out.println("���췽��");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// super.doGet(req, resp);
		System.out.println("do get");
		resp.setContentType("text/html;charset=utf-8"); 
		String username=req.getParameter("username");	
		PrintWriter out=resp.getWriter();
		out.print("my servlet");
		if(username!=null&&username.equals("amaker")){
			//����ת�� ����request������
			//req.getRequestDispatcher("/Success.html").forward(req, resp);
			//�����ض���,������request������
			//resp.sendRedirect("http://www.baidu.com");
			
			//�������
			req.getRequestDispatcher("/Success.html").include(req, resp);
		}else{
			req.getRequestDispatcher("/Fail.html").forward(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// super.doPost(req, resp);
		System.out.println(" doPost");
		String username=req.getParameter("username");
		
		PrintWriter out=resp.getWriter();
		out.print("my servlet");
		if(username!=null&&username.equals("amaker")){
			//����ת�� ����request������
			//req.getRequestDispatcher("/Success.html").forward(req, resp);
			//�����ض���,������request������
			//resp.sendRedirect("http://www.baidu.com");
			
			//�������
			resp.setContentType("text/html;charset=gbk");
			resp.setCharacterEncoding("gbk");
			req.setCharacterEncoding("gbk");
			req.getRequestDispatcher("/Success.html").include(req, resp);
		}else{
			req.getRequestDispatcher("/Fail.html").forward(req, resp);
		}
		
	}
	/*@Override
	public void service(ServletRequest request, ServletResponse response)
			throws ServletException, IOException {
		// super.service(request, response);
		System.out.println(" service");
	}*/

}
