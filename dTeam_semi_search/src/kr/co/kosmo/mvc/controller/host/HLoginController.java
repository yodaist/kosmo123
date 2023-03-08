package kr.co.kosmo.mvc.controller.host;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.co.kosmo.mvc.dao.HostDaoInter;
import kr.co.kosmo.mvc.dao.MemberDaoInter;
import kr.co.kosmo.mvc.vo.HostVO;
import kr.co.kosmo.mvc.vo.MemberVO;

@Controller
@RequestMapping(value = "/hlogin")
public class HLoginController {
	@Autowired
	private HostDaoInter hostdao;

//========================================================================
	// �α��� : loginForm���� �̵�
	@GetMapping(value = "/hloginForm")
	public ModelAndView loginForm() {
		ModelAndView mav = new ModelAndView("login/hostLogForm");
		return mav;
	}

	// �α��� : Form���� �ۼ��� �����ͷ� loginInsert + ���ǽɱ� => Main���� �̵�
	@PostMapping(value = "/hloginProcess")
	public ModelAndView loginProcess(HttpSession session, HostVO vo) {
		HostVO dto = hostdao.hlogin(vo);
		ModelAndView mav = new ModelAndView("main/mainbody");
		if (dto == null) { // �α��� ����
			System.out.println("�α��ν���"); // test�� => �ٲٱ�
		} else {
			session.setAttribute("sessionHID", dto.getHid());
			session.setAttribute("sessionHName", dto.getHname());
			System.out.println("�α��μ���!"); // test�� => �ٲٱ�
		}
		return mav;
	}

	// �α׾ƿ� : ��������� => Main���� �̵�
	@GetMapping(value = "/hlogoutProcess")
	public ModelAndView logoutProcess(HttpSession session) {
		ModelAndView mav = new ModelAndView("main/mainbody");
		session.removeAttribute("sessionHID");
		session.removeAttribute("sessionHName");
		
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