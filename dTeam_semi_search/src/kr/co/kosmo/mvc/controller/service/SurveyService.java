           package kr.co.kosmo.mvc.controller.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.kosmo.mvc.dao.SurveyDao;
import kr.co.kosmo.mvc.vo.SurveyCheckVO;
import kr.co.kosmo.mvc.vo.SurveyContentVO;
import kr.co.kosmo.mvc.vo.SurveyVO;

//����ѷ����� Dao��ſ� ����! => Ʈ����� ó���� ���� ����ó��!
//Dao�� �� �޼��带 Service�� ����
@Service
public class SurveyService {
	@Autowired
	private SurveyDao surveyDao;
	
	//<tx:annotation-driven transaction-manager="tm"/> => @Transactional
	//@Transactional ���� �� ���� �޼��� ���� �� commit��!
	//�𵨿��� �޾ƿ� �� �����͸� Dao�� ���� �����ؼ� ����ó���� �ϱ����� �޼���
	
	@Transactional
	public void addSurvey(SurveyVO vo,List<SurveyContentVO> list) {
		surveyDao.addSurvey(vo); //commitX
		surveyDao.addSurveyContent(list); //commitX
		//commit��!
	}
	
	public List<SurveyVO> listSurvey() {
		return surveyDao.listSurvey();
	}

	public SurveyVO adminDetail(int num) {
		return surveyDao.adminDetail(num);
	}
	
	
	@Transactional
	public void updateSurveyCntck(SurveyContentVO subvo, SurveyCheckVO scvo) {
		surveyDao.updateSurveyCnt(subvo);
		surveyDao.addsc(scvo);
	}
	

	
	
}
