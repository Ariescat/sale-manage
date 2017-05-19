package org.lqz.sale.web;

import java.util.List;

import org.lqz.sale.domain.User;
import org.lqz.sale.service.UserService;
import org.lqz.sale.utils.SysConstant;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;

public class LoginAction extends BaseAction implements ModelDriven<User> {

	private static final long serialVersionUID = 1L;

	private User model = new User();
	@Override
	public User getModel() {
		return model;
	}

	private UserService userService;
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public String login() throws Exception {
		if (model.getName() == null) {
			// return "login";
			return SUCCESS;
		}
		String hql = "from User where name=?";
		List<User> list = userService.find(hql, User.class, new Object[] { model.getName() });
		User login = list.get(0);
		if (login != null) {
			ActionContext.getContext().getValueStack().push(login);
			session.setAttribute(SysConstant.CURRENT_USER_INFO, login); // 记录session
			return SUCCESS;
		}
		return "login";
	}

	public String logout() throws Exception {
		session.removeAttribute(SysConstant.CURRENT_USER_INFO); // 删除session
		return "logout";
	}

}
