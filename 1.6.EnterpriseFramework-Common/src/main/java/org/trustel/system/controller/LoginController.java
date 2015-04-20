package org.trustel.system.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.trustel.system.form.LoginForm;
import org.trustel.system.service.IAuthenticationService;

@Controller
@RequestMapping(value = "/core/login")
public class LoginController {
	private Log logger = LogFactory.getLog(getClass());

	@Autowired
	private IAuthenticationService authenticationService;

	/**
	 * ��forwardʱ��������ѭ�� �ò������ε���Ϣ��ʾת��ָ��ҳ��(�����������) ֻ��ͨ��redirect��ת
	 */
	@RequestMapping(method = RequestMethod.POST)
	public String create(HttpServletRequest request,
			HttpServletResponse response, LoginForm form) { // ,BindingResult
		// ������Ҫ�ڷ���������
		logger.info(form.toString());
        return authenticationService.login(request, response, form);
		
	}

	@RequestMapping(method = RequestMethod.GET)
	public String getView(Model model) {
		return "/core/login/login";
	}

}
