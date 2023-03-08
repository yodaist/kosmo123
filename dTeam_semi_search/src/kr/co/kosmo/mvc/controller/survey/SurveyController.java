package kr.co.kosmo.mvc.controller.survey;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.co.kosmo.mvc.controller.service.SurveyService;
import kr.co.kosmo.mvc.dao.SurveyDao;
import kr.co.kosmo.mvc.vo.SurveyCheckVO;
import kr.co.kosmo.mvc.vo.SurveyContentVO;
import kr.co.kosmo.mvc.vo.SurveyVO;

@Controller
@RequestMapping(value = "/survey")
public class SurveyController {
	@Autowired
	private SurveyService surveyservice;
	
	@Autowired
	private SurveyDao dao;
	
	@RequestMapping(value = "/surveyForm")
	public String surform() {
		return "survey/surveyAddform";
	}

	@RequestMapping(value = "/addsurvey")
	public ModelAndView surveyadd(SurveyVO vo,HttpServletRequest request) {
		//httpHttpServletRequest request : ������ surveytitle �Ѿ�ö� �Ķ���Ͱ� �ޱ�����
		String[] surveytitle = request.getParameterValues("surveytitle"); //subtitle�� �迭�� ����
		
		//DB�� �����ϱ� ���� List �����
		List<SurveyContentVO> list = new ArrayList<>();
		char stype = 'A';
		for (String e : surveytitle) {
			SurveyContentVO sv = new SurveyContentVO();
			sv.setSurveytitle(e);
			sv.setSurveycnt(0);
			sv.setSubtype(String.valueOf(stype));
			System.out.println("surveytitle : "+e);
			list.add(sv);
			stype++; //���ĺ� ����
		}
		System.out.println("����(Sub) : "+vo.getSub());		
		//surveyVO�� ���� Ÿ��Ʋ�� ������ List<SurveyContentVO> ���ڷ� ����
		vo.setSubvey(list);
		
		//service�� �� ���� => DB�� �����!
		surveyservice.addSurvey(vo, list);
		
		ModelAndView mav = new ModelAndView("redirect:surveylist");
		return mav;
	}
	
	@RequestMapping(value = "/surveyList")
    public ModelAndView surveylist() {
        ModelAndView mav = new ModelAndView("survey/surveyList");
        List<SurveyVO> list = surveyservice.listSurvey();
        mav.addObject("list", list);
        return mav;
	}
	
	@RequestMapping(value = "/surveyAdminDetail")
    public ModelAndView surveyDetail(int num) {
        ModelAndView mav = new ModelAndView("survey/surveyAdminDetail");
        SurveyVO vo = surveyservice.adminDetail(num);
        mav.addObject("vo", vo);
        return mav;
	}

	@RequestMapping(value = "/surveyDetail")
    public ModelAndView surveyClientDetail(int num) {
        ModelAndView mav = new ModelAndView("survey/surveyClientDetail");
        SurveyVO vo = surveyservice.adminDetail(num);
        mav.addObject("vo", vo);
        return mav;
	}

	@PostMapping(value = "/addSurveyClient")
    public String clientSurveyAdd(Model m, SurveyContentVO subvo, SurveyCheckVO scvo) {
		int cnt = dao.surveycheck(scvo);
		System.out.println(cnt);
		if(cnt==0) {
			System.out.println("Subcode : "+subvo.getSubcode());
			System.out.println("Subtype : " + subvo.getSubtype());
			System.out.println("Scid : " + scvo.getScid());
			System.out.println("Sccode : " + scvo.getSccode());
			System.out.println("Subtype : "+ scvo.getSubtype());
			surveyservice.updateSurveyCntck(subvo,scvo);			
		}else {
			System.out.println("else�� �ɸ�");
		}
		 return "redirect:surveylist";
	}
	

	
	
	
}
