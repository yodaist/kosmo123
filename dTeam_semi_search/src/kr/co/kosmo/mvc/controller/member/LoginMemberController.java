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
	// �α��� : loginForm���� �̵�
	@GetMapping(value = "/loginForm")
	public ModelAndView loginForm() {
		ModelAndView mav = new ModelAndView("login/loginForm");
		return mav;
	}

	// �α��� : Form���� �ۼ��� �����ͷ� loginInsert + ���ǽɱ� => Main���� �̵�
	@PostMapping(value = "/loginProcess")
	public ModelAndView logProcessIn(HttpSession session, HttpServletRequest request, MemberVO vo,
			@RequestHeader("User-Agent") String userAgent) {
		MemberVO dto = memberdao.login(vo);
		ModelAndView mav = new ModelAndView("main/mainbody");
		if (dto == null) { // �α��� ����
			System.out.println("�α��ν���"); // test�� => �ٲٱ�
		} else {
			session.setAttribute("sessionNum", dto.getMnum());
			session.setAttribute("sessionID", dto.getMid());
			session.setAttribute("sessionName", dto.getMname());
			session.setAttribute("sessionEmail", dto.getMemail());
			System.out.println("�α��μ���!"); // test�� => �ٲٱ�
		}
		return mav;
	}

	// �α׾ƿ� : ��������� => Main���� �̵�
	@GetMapping(value = "/logoutProcess")
	public ModelAndView logProcessOut(HttpSession session,HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("main/mainbody");
		session.removeAttribute("sessionNum");		
		session.removeAttribute("sessionID");
		session.removeAttribute("sessionName");
		System.out.println("�α׾ƿ�!"); // test�� => �ٲٱ�
		return mav;
	}

//========================================================================
	// ID&PWDã�� �������� �̵�
	@GetMapping(value = "/idpwdSearch")
	public ModelAndView idpwdSearch() {
		ModelAndView mav = new ModelAndView("login/idpwdSearch");
		return mav;
	}

//========================================================================
	// IDã�� : idSearchForm���� �̵�
	@GetMapping(value = "/idSearch")
	public ModelAndView idSearch() {
		ModelAndView mav = new ModelAndView("login/idSearch");
		return mav;
	}

	// IDã�� : Form���� �ۼ��� ������ �˻� �� ���Ϲ߼�/Ȯ��
	@PostMapping(value = "/idSearchProcess")
	public ModelAndView idSearchProcess() {
		ModelAndView mav = new ModelAndView("login/idSearchProcess");
		return mav;
	}

//========================================================================
	// PWDã�� : pwdSearchForm���� �̵�
	@GetMapping(value = "/pwdSearch")
	public ModelAndView pwdSearch() {
		ModelAndView mav = new ModelAndView("login/resetForm");
		return mav;
	}

	// PWDã�� : Form���� �ۼ��� ������ �˻� �� ���Ϲ߼�
	@PostMapping(value = "/pwdSearchProcess")
	public ModelAndView pwdSearchProcess() {
		ModelAndView mav = new ModelAndView("login/pwdSearchProcess");
		return mav;
	}

}
