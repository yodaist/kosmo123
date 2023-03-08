package kr.co.kosmo.mvc.controller.oversea;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.co.kosmo.mvc.dao.OverseaDaoInter;
import kr.co.kosmo.mvc.dao.ReviewDaoInter;
import kr.co.kosmo.mvc.vo.OverseaVO;
import kr.co.kosmo.mvc.vo.ReviewVO;

@Controller
@RequestMapping(value = "/oversea")
public class OverseaController {
	@Autowired
	private OverseaDaoInter overseadaointer;
	@Autowired
	private ReviewDaoInter reviewDaoInter;
	
	//�ؿܿ��� view�� �̵�
	@GetMapping(value = "/overseatrip")
	public ModelAndView overseatrip() {
		ModelAndView mav = new ModelAndView("overseatrip/overseatrip");
		return mav;
	}
	//insert�� �� ��� �� form���� �̵��ϴ� �޼���
	@GetMapping(value = "/overseaUpForm")
	public ModelAndView overseaUpForm() {
		ModelAndView mav = new ModelAndView("overseatrip/overseaUpForm");
		return mav;
	}
	//form���� insert�Ҷ� ����ϴ� �޼���
	@PostMapping(value = "/overseaUpProcess")
	public String overseaUpProcess(Model m, OverseaVO dto, HttpServletRequest request) {
		//request�� ������ �̹����� ��θ� �޾� ���
		String img_path = "resources\\imgfile";
		String r_path = request.getRealPath("/");
		System.out.println("r path : " + r_path);
		String oriFn = dto.getMfile().getOriginalFilename();
		System.out.println("oriFn: " + oriFn);

		// �̹��� ������ �� contentType Ȯ��
		long size = dto.getMfile().getSize();
		// img���ϸ� �ް� ���� ��� ��, ������ �����ϰ���� �� if�� �Ἥ ���!
		String contentType = dto.getMfile().getContentType();
		System.out.println("����ũ��:" + size);
		System.out.println("����ũ�� type: " + contentType);
		
		// �޸𸮻�(�ӽ������)�� ������ �츮�� ������ ��ο� ����!
				// �̹����� ����� ��� �����
				StringBuffer path = new StringBuffer();
				path.append(r_path).append(img_path).append("\\");
				path.append(oriFn);
				System.out.println("FullPath: " + path);
				File f = new File(path.toString());
				try {
					dto.getMfile().transferTo(f); // ����
					// �̹��� �̸��� db�� �����ϱ� ���� DTO���� �缳�� => �ش簪 DB�� �ֱ�!
					dto.setOimg(oriFn);
				} catch (IllegalStateException | IOException e) {
					e.printStackTrace();
				}
				overseadaointer.addOversea(dto);
				return "redirect:overseaboardList";

	}
	@RequestMapping("/overseadetail")
	public String localdetail(Model m, int num) {
		OverseaVO vo = overseadaointer.detailOver(num);
		m.addAttribute("vo", vo);
		
		//Review : ��۱�� �߰�==========================
		List<ReviewVO> listReview = reviewDaoInter.listReview(num);
        m.addAttribute("listReview",listReview);
        //============================================
        
		return "overseatrip/overseaDetail";
	}

//============================================================================	
	@RequestMapping("/overseadelete")
	public String overseadelete(int num) {
		overseadaointer.delOver(num);
		return "redirect:overseaboardList";
	}

//============================================================================	
	@GetMapping("/overseamodifyForm")
	public String overseamodifyForm(Model m, int num) {
		OverseaVO vo = overseadaointer.detailOver(num);
		m.addAttribute("vo", vo);
		return "overseatrip/overseamodify";
	}

	@PostMapping("/overseamodify")
	public String overseamodify(Model m, OverseaVO dto, HttpServletRequest request) {

		String img_path = "resources\\imgfile";
		String r_path = request.getRealPath("/");
		System.out.println("r_path: " + r_path);

		// ���ε�� �̹����� �̸��� �޾� �̹��� ����, �̹��� �̸� Ȯ��
		String oriFn = dto.getMfile().getOriginalFilename();
		System.out.println("oriFn: " + oriFn);

		// �̹��� ������ �� contentType Ȯ��
		long size = dto.getMfile().getSize();
		// img���ϸ� �ް� ���� ��� ��, ������ �����ϰ���� �� if�� �Ἥ ���!
		String contentType = dto.getMfile().getContentType();
		System.out.println("����ũ��:" + size);
		System.out.println("����ũ�� type: " + contentType);

		// �޸𸮻�(�ӽ������)�� ������ �츮�� ������ ��ο� ����!
		// �̹����� ����� ��� �����
		StringBuffer path = new StringBuffer();
		path.append(r_path).append(img_path).append("\\");
		path.append(oriFn);
		System.out.println("FullPath: " + path);

		// �߻���(�̹����� ������ ���) ��ü ����
		File f = new File(path.toString());
		// �ӽø޸𸮿� ��� ���ε��� ������ �� => fileŬ������ ��η� ����
		try {
			dto.getMfile().transferTo(f); // ����
			// �̹��� �̸��� db�� �����ϱ� ���� DTO���� �缳�� => �ش簪 DB�� �ֱ�!
			dto.setOimg(oriFn);
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
		overseadaointer.overseamodify(dto);

		return "redirect:overseaboardList";
	}

//============================================================================	
	// =================��� �߰��ϱ�========================
	@RequestMapping(value = "/addReview")
	public String addReview(Model m, ReviewVO vo) {
		reviewDaoInter.addReview(vo);
		return "redirect:overseaboardList";
	}
	@RequestMapping("/overseaboardList")
	public String overseaboardList(Model model) {
		List<OverseaVO> list = overseadaointer.getList();
		model.addAttribute("list", list);

		return "overseatrip/overseaboardList";
	}
	
}