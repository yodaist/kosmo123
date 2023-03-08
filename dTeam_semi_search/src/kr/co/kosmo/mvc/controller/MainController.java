package kr.co.kosmo.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

	//Aop�� ����Ǿ /main/index.jsp���� ${today} ��� ���� !
	@RequestMapping(value= {"/","/main"})
	public ModelAndView main() {
		//return "main/index";
		ModelAndView mav = new ModelAndView("main/mainbody");
		return mav;
	}

//===========================================================	
	//ȸ������ ������ �̵�(��� or ȣ��Ʈ)
	@GetMapping(value = "/chooseSignup")
	public ModelAndView chooseSignup() {
		ModelAndView mav = new ModelAndView("main/chooseSignupForm");
		return mav;
	}
	
//===========================================================	
	//�α��� ������ �̵�(��� or ȣ��Ʈ)
	@GetMapping(value = "/chooseLogin")
	public ModelAndView chooseLogin() {
		ModelAndView mav = new ModelAndView("main/chooseLoginForm");
		return mav;
	}
	
}
