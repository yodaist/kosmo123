package kr.co.kosmo.mvc.controller.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.co.kosmo.mvc.dao.MemberDaoInter;
import kr.co.kosmo.mvc.vo.ChargeMVO;
import kr.co.kosmo.mvc.vo.MemberVO;
import kr.co.kosmo.mvc.vo.MembershipVO;

@Controller
@RequestMapping(value = "/member")
public class MemberController {
	@Autowired
	private MemberDaoInter memberdao;
	

	//ȸ������ : signupForm���� �̵�
	@GetMapping(value = "/signUpForm")
	public ModelAndView signUpForm() {
		ModelAndView mav = new ModelAndView("member/signUpForm");
		return mav;
	}
	//ȸ������ : Form���� �ۼ��� ������ ����  => �������� �̵�
	@PostMapping(value = "/signUpProcess")
	public String signUpProcess(MemberVO vo) {
		memberdao.addMember(vo);
		return "redirect:/main";
	}
//====================================================
	//����������
	@GetMapping(value = "/mypage")
	public ModelAndView mypage(String mid) {
		ModelAndView mav = new ModelAndView("member/mypage");
		//���+�����------------------------------------
		MembershipVO mbsvo = memberdao.memMembership(mid);
		mav.addObject("mbsvo", mbsvo);
		//--------------------------------------------
		return mav;
	}
	
	
	//���������� �� Ķ����
	
	
//====================================================
	//ȸ������ : ȸ������Form���� �̵�
	@GetMapping(value = "/upmemForm")
	public ModelAndView upmemForm() {
		ModelAndView mav = new ModelAndView("member/upmemForm");
		return mav;
	}
	//ȸ������ : ȸ������Form���� �ۼ��� ������ ����  => �������� �̵�
	@PostMapping(value = "/updateProcess")
	public String updateProcess(MemberVO vo) {
		memberdao.upMember(vo);
		return "redirect:/main";
	}
//====================================================
	//ȸ��Ż�� : ȸ������ �� main���� �̵�
	@GetMapping(value = "/delmem")
	public String upmemForm(String mid , HttpSession session) {
		memberdao.delMember(mid);
		//����� ���� ����
		session.removeAttribute("sessionID");
		session.removeAttribute("sessionName");
		return "redirect:/main";
	}
}
