package com.wlt.web.servlet;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 通用的servlet
 */
@WebServlet("/BaseServlet")
public class BaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		try {
			// 获取子类
			Class clazz = this.getClass();
			// 获取请求方法
			String m = req.getParameter("method");
			if (m==null) {
				m="index";
			}
			// 获取方法对象

			Method method = clazz.getMethod(m, HttpServletRequest.class, HttpServletResponse.class);
			
			//让方法执行
			String s = (String) method.invoke(this, req,resp);
			
			//判断s是否为空
			if (s!=null) {
				//服务器内部跳转
				req.getRequestDispatcher(s).forward(req, resp);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
	public String index(HttpServletRequest req, HttpServletResponse resp) throws Exception{
		
		
		return null;
		
		
	}


}
