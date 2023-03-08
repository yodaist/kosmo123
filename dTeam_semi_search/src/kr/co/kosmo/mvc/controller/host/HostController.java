package kr.co.kosmo.mvc.controller.host;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.co.kosmo.mvc.dao.HostDaoInter;
import kr.co.kosmo.mvc.vo.HostVO;
import kr.co.kosmo.mvc.vo.MembershipVO;

@Controller
@RequestMapping(value = "/host")
public class HostController {
	@Autowired
	private HostDaoInter hostdao;

//========================================================================
	// ȸ������ : signupForm���� �̵�
	@GetMapping(value = "/hostSignup")
	public String hostsignUpForm() {
		return "host/hostSignup";
	}

	// ȸ������ : Form���� �ۼ��� ������ ���� => �������� �̵�
	// ��Ϲ�ư ������ ��� �����Ͱ� ����.
	@PostMapping(value = "/hsignUpProcess")
	public String hsignUpProcess(HostVO vo) {
		hostdao.addHost(vo);
		return "redirect:/main";
	}
	
//========================================================================
	//ȸ��Ż�� : ȸ������ �� main���� �̵�
		@GetMapping(value = "/delmem")
		public String upmemForm(String hid , HttpSession session) {
			hostdao.delHost(hid);
			//����� ���� ����
			session.removeAttribute("sessionHID");
			session.removeAttribute("sessionHName");
			return "redirect:/main";
		}

//========================================================================
	// host/hostpage
	@GetMapping(value = "/hostpage")
	public ModelAndView hostpage(String hid) {
		ModelAndView mav = new ModelAndView("host/hostpage");
		HostVO hvo = hostdao.hostpage(hid);
		mav.addObject("hvo", hvo);

		return mav;
	}

//========================================================================
	@GetMapping(value = "/uphostForm")
	public ModelAndView uphostForm() {
		ModelAndView mav = new ModelAndView("host/uphostForm");
		return mav;
	}

	@PostMapping(value = "/hostupdate")
	public String hostupdate(HostVO vo) {
		hostdao.hostupdate(vo);
		return "redirect:/main";
	}

}