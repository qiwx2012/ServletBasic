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
 * @time 2017年3月30日 下午4:59:49
 * @Des
 **/
public class BasicServlet extends HttpServlet {

	@Override
	public void init() throws ServletException {
		System.out.println("init");
		//局部参数
		String usernameString=this.getInitParameter("username");
		System.out.println(usernameString);
		//全局参数
		String url=this.getServletContext().getInitParameter("url");
		System.out.println(url);
	}

	@Override
	public void destroy() {
		System.out.println("destroy");
	}

	public BasicServlet() {
		System.out.println("构造方法");
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
			//请求转发 共享request内数据
			//req.getRequestDispatcher("/Success.html").forward(req, resp);
			//请求重定向,不共享request内数据
			//resp.sendRedirect("http://www.baidu.com");
			
			//请求包含
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
			//请求转发 共享request内数据
			//req.getRequestDispatcher("/Success.html").forward(req, resp);
			//请求重定向,不共享request内数据
			//resp.sendRedirect("http://www.baidu.com");
			
			//请求包含
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
