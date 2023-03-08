package kr.co.kosmo.mvc.controller.scheduler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/scheduler")
public class SchedulerController {
	@GetMapping(value = "/schePath")
	public String schedulerPath() {
		return "scheduler/schedulerPage";
	}

}
