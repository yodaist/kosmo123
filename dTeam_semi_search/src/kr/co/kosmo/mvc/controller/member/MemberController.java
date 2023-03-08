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
	

	//회원가입 : signupForm으로 이동
	@GetMapping(value = "/signUpForm")
	public ModelAndView signUpForm() {
		ModelAndView mav = new ModelAndView("member/signUpForm");
		return mav;
	}
	//회원가입 : Form에서 작성한 데이터 저장  => 메인으로 이동
	@PostMapping(value = "/signUpProcess")
	public String signUpProcess(MemberVO vo) {
		memberdao.addMember(vo);
		return "redirect:/main";
	}
//====================================================
	//마이페이지
	@GetMapping(value = "/mypage")
	public ModelAndView mypage(String mid) {
		ModelAndView mav = new ModelAndView("member/mypage");
		//멤버+멤버쉽------------------------------------
		MembershipVO mbsvo = memberdao.memMembership(mid);
		mav.addObject("mbsvo", mbsvo);
		//--------------------------------------------
		return mav;
	}
	
	
	//마이페이지 내 캘린더
	
	
//====================================================
	//회원수정 : 회원수정Form으로 이동
	@GetMapping(value = "/upmemForm")
	public ModelAndView upmemForm() {
		ModelAndView mav = new ModelAndView("member/upmemForm");
		return mav;
	}
	//회원수정 : 회원수정Form에서 작성한 데이터 저장  => 메인으로 이동
	@PostMapping(value = "/updateProcess")
	public String updateProcess(MemberVO vo) {
		memberdao.upMember(vo);
		return "redirect:/main";
	}
//====================================================
	//회원탈퇴 : 회원삭제 및 main으로 이동
	@GetMapping(value = "/delmem")
	public String upmemForm(String mid , HttpSession session) {
		memberdao.delMember(mid);
		//저장된 세션 삭제
		session.removeAttribute("sessionID");
		session.removeAttribute("sessionName");
		return "redirect:/main";
	}
}
