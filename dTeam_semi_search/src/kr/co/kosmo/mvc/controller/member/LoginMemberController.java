package kr.co.kosmo.mvc.controller.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.co.kosmo.mvc.dao.MemberDaoInter;
import kr.co.kosmo.mvc.vo.MemberVO;

@Controller
@RequestMapping(value = "/login")
public class LoginMemberController {
	@Autowired
	private MemberDaoInter memberdao;

//========================================================================
	// 로그인 : loginForm으로 이동
	@GetMapping(value = "/loginForm")
	public ModelAndView loginForm() {
		ModelAndView mav = new ModelAndView("login/loginForm");
		return mav;
	}

	// 로그인 : Form에서 작성한 데이터로 loginInsert + 세션심기 => Main으로 이동
	@PostMapping(value = "/loginProcess")
	public ModelAndView logProcessIn(HttpSession session, HttpServletRequest request, MemberVO vo,
			@RequestHeader("User-Agent") String userAgent) {
		MemberVO dto = memberdao.login(vo);
		ModelAndView mav = new ModelAndView("main/mainbody");
		if (dto == null) { // 로그인 실패
			System.out.println("로그인실패"); // test용 => 바꾸기
		} else {
			session.setAttribute("sessionNum", dto.getMnum());
			session.setAttribute("sessionID", dto.getMid());
			session.setAttribute("sessionName", dto.getMname());
			session.setAttribute("sessionEmail", dto.getMemail());
			System.out.println("로그인성공!"); // test용 => 바꾸기
		}
		return mav;
	}

	// 로그아웃 : 세션지우기 => Main으로 이동
	@GetMapping(value = "/logoutProcess")
	public ModelAndView logProcessOut(HttpSession session,HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("main/mainbody");
		session.removeAttribute("sessionNum");		
		session.removeAttribute("sessionID");
		session.removeAttribute("sessionName");
		System.out.println("로그아웃!"); // test용 => 바꾸기
		return mav;
	}

//========================================================================
	// ID&PWD찾기 페이지로 이동
	@GetMapping(value = "/idpwdSearch")
	public ModelAndView idpwdSearch() {
		ModelAndView mav = new ModelAndView("login/idpwdSearch");
		return mav;
	}

//========================================================================
	// ID찾기 : idSearchForm으로 이동
	@GetMapping(value = "/idSearch")
	public ModelAndView idSearch() {
		ModelAndView mav = new ModelAndView("login/idSearch");
		return mav;
	}

	// ID찾기 : Form에서 작성한 데이터 검사 및 메일발송/확인
	@PostMapping(value = "/idSearchProcess")
	public ModelAndView idSearchProcess() {
		ModelAndView mav = new ModelAndView("login/idSearchProcess");
		return mav;
	}

//========================================================================
	// PWD찾기 : pwdSearchForm으로 이동
	@GetMapping(value = "/pwdSearch")
	public ModelAndView pwdSearch() {
		ModelAndView mav = new ModelAndView("login/resetForm");
		return mav;
	}

	// PWD찾기 : Form에서 작성한 데이터 검사 및 메일발송
	@PostMapping(value = "/pwdSearchProcess")
	public ModelAndView pwdSearchProcess() {
		ModelAndView mav = new ModelAndView("login/pwdSearchProcess");
		return mav;
	}

}
