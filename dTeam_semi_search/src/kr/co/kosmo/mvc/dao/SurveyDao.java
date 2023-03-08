package kr.co.kosmo.mvc.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import kr.co.kosmo.mvc.vo.SurveyCheckVO;
import kr.co.kosmo.mvc.vo.SurveyContentVO;
import kr.co.kosmo.mvc.vo.SurveyCountVO;
import kr.co.kosmo.mvc.vo.SurveyVO;

@Repository
public class SurveyDao {
	@Autowired
	private SqlSessionTemplate ss;
	
	//sub-----------------------------
	public void addSurvey(SurveyVO vo) {
		ss.insert("survey.add", vo);
	}

	//subContent-----------------------------
	//���� insert => List
	//List�� ������ SQL������ for������ �ϳ��� ���� ó����
	public void addSurveyContent(List<SurveyContentVO> list) {
		ss.insert("survey.addcontent", list);
	}

	//========================================================
	public List<SurveyVO> listSurvey() {
		return ss.selectList("survey.listSurvey");
	}
	
	//========================================================
	public SurveyVO adminDetail(int num) {
		SurveyVO vo = ss.selectOne("survey.adminDetail", num);
		List<SurveyContentVO> list = vo.getSubvey();
		System.out.println("SurveyContentVO Size"+list.size());
		return vo;
	}

	//========================================================
	public void updateSurveyCnt(SurveyContentVO subvo) {
		ss.update("survey.updateSurveyCnt", subvo);
	}
	
	public void addsc(SurveyCheckVO scvo) {
		ss.insert("survey.addsc", scvo);
	}
	
	public int surveycheck(SurveyCheckVO scvo) {
		return ss.selectOne("survey.surveychk",scvo);
	}
	
	public SurveyCountVO getcount(int num) {
		return ss.selectOne("survey.genderc",num);
	}
	

}
