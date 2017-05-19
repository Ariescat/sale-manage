package org.lqz.sale.web;

import java.io.UnsupportedEncodingException;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.util.ServletContextAware;
import org.lqz.sale.domain.User;
import org.lqz.sale.utils.SysConstant;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

//通过RequestAware, SessionAware, ApplicationAware实行接口获得request,session,application对象，action中就可直接调用
public class BaseAction extends ActionSupport implements ServletRequestAware, ServletContextAware {
	private static Logger log = Logger.getLogger(BaseAction.class);

	private static final long serialVersionUID = 1L;

	protected HttpServletRequest request;
	protected HttpSession session;
	protected ServletContext application;

	@Override
	public void setServletContext(ServletContext arg0) {
		this.application = arg0;
	}

	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		this.request = arg0;
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		this.session = request.getSession();
	}

	/**
	 * 
	 * 将对象放入值栈的栈顶
	 */
	public void push(Object obj) {
		ActionContext.getContext().getValueStack().push(obj);
	}

	/**
	 * 将key-value对放入值栈的 context中
	 * 
	 */
	public void put(String key, Object value) {
		ActionContext.getContext().put(key, value);
	}

	/**
	 * 获取当前登录用户的信息
	 */
	public User getCurUser() {
		User user = (User) session.getAttribute(SysConstant.CURRENT_USER_INFO);
		return user;
	}
}
