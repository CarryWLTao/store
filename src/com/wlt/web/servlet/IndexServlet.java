package com.wlt.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 和首页相关的
 */
@WebServlet("/index")
public class IndexServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
       
	public String index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//去数据库种查询商品数据将他们放入request域种请求转发
		return "/jsp/index.jsp";
	}


}
