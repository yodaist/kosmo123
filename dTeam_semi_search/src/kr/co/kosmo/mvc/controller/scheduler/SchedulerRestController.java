package kr.co.kosmo.mvc.controller.scheduler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.co.kosmo.mvc.dao.SchedulerDaoInter;
import kr.co.kosmo.mvc.vo.LocalVO;

@RestController
@RequestMapping(value = "/schedulerRest")
public class SchedulerRestController {
	@Autowired
	private SchedulerDaoInter scheduler;
	
	@RequestMapping(value = "/showList", produces = "application/json;charset=utf-8")
	public List<LocalVO> showList() {
		List<LocalVO> list = scheduler.showList();
		return list;
	}
	
	

}
