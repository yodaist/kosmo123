package kr.co.kosmo.mvc.controller.chart;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import kr.co.kosmo.mvc.controller.service.SurveyService;
import kr.co.kosmo.mvc.dao.SurveyDao;
import kr.co.kosmo.mvc.vo.SurveyContentVO;
import kr.co.kosmo.mvc.vo.SurveyCountVO;
import kr.co.kosmo.mvc.vo.SurveyVO;

@RestController
public class TourRestChartController {
	@Autowired
	private SurveyService surveyService;
	
	@Autowired
	private SurveyDao dao;
	
	//[{sub:���ɴ뺰~},Map]
	@RequestMapping(value = "/tourChartJson" , produces = "application/json;charset=utf-8")
	public String busan(int num) {
		//1. �ڵ鸵�� ������ VO�� ����
		SurveyVO vo = surveyService.adminDetail(num);
		 
		//2. survey ���� ���� => String
		//{sub:���ɴ뺰~}
		//String subject = vo.getSub();
		
		//3. survey ������ ���� => Map
		//{20��:500},{30��:500}...
		Map<String, Integer> map = new HashMap<String, Integer>();
		//3-1. foreach������ survey ������ map �ȿ� ����
		//SurveyVO�ȿ� List ����Ǿ����Ƿ� SurveyContentVO�� �� ���� => vo.getSubvey()
		for (SurveyContentVO e : vo.getSubvey()) {
			//key : e.getSurveytitle()
			//value : e.getSurveycnt()
			map.put(e.getSurveytitle(), e.getSurveycnt());
		}

		//4. return��ȯ ���� ����� ���� => String
		String result = null;
		
		//5. ObjectMapper ���� : ��ü�� ���ڿ��� ��ȯ => JSON?
		ObjectMapper objmapper = new ObjectMapper();
		
		//6. result�� ���ڿ��� ��ȯ�� ��(=Map_survey ������) ���� => writeValueAsString
		// => try/catch
		try {
			//{"30��":100,"20��":550,"50��":300,"40��":150,"60��":350}
			result = objmapper.writeValueAsString(map);

		//7. result�� JSON�� ���� �� �ִ� ���·� ���� �� ����(�ڵ鸵)
			//���� : [{"sub":"����"},map]
			result = "[{\"sub\":\""+ vo.getSub() +"\"},"+result+"]";

		} catch (JsonProcessingException e1) {
			e1.printStackTrace();
		}
		
		return result;
	}
	
	//[{sub:���ɴ뺰~},Map]
		@RequestMapping(value = "/surveycountJson" , produces = "application/json;charset=utf-8")
		public String count(int num) {
			//1. �ڵ鸵�� ������ VO�� ����
			
			SurveyCountVO vo = (SurveyCountVO) dao.getcount(num);
			//2. survey ���� ���� => String
			//{sub:���ɴ뺰~}
			//String sub = vo.getSub();
			
			//3. survey ������ ���� => Map
			//{20��:500},{30��:500}...
			Map<String, Integer> map = new HashMap<String, Integer>();
			//map.put("gender",vo.getGender());
			map.put("msum",vo.getMsum());
			map.put("wsum",vo.getWsum());
			//4. return��ȯ ���� ����� ���� => String
			String result = null;
			
			//5. ObjectMapper ���� : ��ü�� ���ڿ��� ��ȯ => JSON?
			ObjectMapper objmapper = new ObjectMapper();
			
			//6. result�� ���ڿ��� ��ȯ�� ��(=Map_survey ������) ���� => writeValueAsString
			// => try/catch
			try {
				//{"30��":100,"20��":550,"50��":300,"40��":150,"60��":350}
				result = objmapper.writeValueAsString(map);

			//7. result�� JSON�� ���� �� �ִ� ���·� ���� �� ����(�ڵ鸵)
				//���� : [{"sub":"����"},map]
				//result = "[{\"sub\":\""+ vo.getSub() +"\"},"+result+"]";
				result = "[{\"sub\":\""+ "��ǥ��������" +"\"},"+result+"]";

			} catch (JsonProcessingException e1) {
				e1.printStackTrace();
			}
			
			
			return result;
		}
		
		

		
		
		
		
		
		
}
