package com.wlt.web.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;

import com.wlt.domain.User;
import com.wlt.myconventer.Myconventer;
import com.wlt.service.UserService;
import com.wlt.service.impl.UserServiceImpl;
import com.wlt.utils.MD5Utils;
import com.wlt.utils.UUIDUtils;

/**
 * 用户相关的servlet
 */
@WebServlet("/user")
public class UserServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	
	public String add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//
		return null;
	}
	/**
	 * 跳转到注册页面
	 * @param req
	 * @param resp
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String registerUI(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//
		return "/jsp/register.jsp";
	}
	/**
	 * 用户注册
	 * @param req
	 * @param resp
	 * @return
	 * @throws Exception 
	 */
	public String regist(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		//封装数据
		User user = new User();
		//注册自定义转换器
		ConvertUtils.register(new Myconventer(), Date.class);
		BeanUtils.populate(user, req.getParameterMap());
		//设置用户id
		user.setUid(UUIDUtils.getId());
		//设置激活码
		user.setCode(UUIDUtils.getCode());
		//密码加密
		user.setPassword(MD5Utils.md5(user.getPassword()));
		//调用service完成注册
		UserService s=new UserServiceImpl();
		s.regist(user);
		//页面请求转发
		req.setAttribute("msg", "用户注册成功,请去邮箱激活");
		return "/jsp/msg.jsp";
	}
	/**
	 * 用户激活
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception 
	 */
	public String active(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//获取激活码
		String code = request.getParameter("code");
		//调用service完成激活
		UserService s=new UserServiceImpl();
		User user=s.active(code);
		if (user==null) {
			request.setAttribute("msg", "请重新激活");
		}else {
			//添加信息
			request.setAttribute("msg", "激活成功");
		}
		//请求转发
		return "/jsp/msg.jsp";
	}
   
   
}
