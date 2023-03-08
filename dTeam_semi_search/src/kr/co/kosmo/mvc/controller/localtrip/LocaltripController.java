package kr.co.kosmo.mvc.controller.localtrip;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import kr.co.kosmo.mvc.controller.service.LocalService;
import kr.co.kosmo.mvc.dao.LocalDaoInter;
import kr.co.kosmo.mvc.dao.ReviewDaoInter;
import kr.co.kosmo.mvc.vo.ItemVO;
import kr.co.kosmo.mvc.vo.LocalVO;
import kr.co.kosmo.mvc.vo.ReviewVO;

@Controller
@RequestMapping(value = "/local")
public class LocaltripController {
	@Autowired
	private LocalDaoInter localdaointer;

	@Autowired
    private LocalService localService;
	
	@Autowired
	private ReviewDaoInter reviewDaoInter;

	// �������� View�� �̵�
	@GetMapping(value = "/localtrip")
	public ModelAndView localtrip() {
		ModelAndView mav = new ModelAndView("localtrip/localtrip");
		return mav;
	}

//============================================================================
	// insert �� �� ����� form���� �̵��ϴ� �޼���
	@GetMapping(value = "/localUpForm")
	public ModelAndView localUpForm() {
		ModelAndView mav = new ModelAndView("localtrip/localUpForm");
		return mav;
	}

	// form���� insert�� �� ����ϴ� �޼���
		@PostMapping(value = "/localUpProcess")
		public String localUpProcess(LocalVO dto, ItemVO itemvo, HttpServletRequest request) {
			// request�� ������ �̹����� ��� �޾� ���
			String img_path = "resources\\imgfile"; // �ӽ� ���� ���� *
			String r_path = request.getRealPath("");
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
				dto.getMfile().transferTo(f); // ���� ***
				// �̹��� �̸��� db�� �����ϱ� ���� DTO���� �缳�� => �ش簪 DB�� �ֱ�!
				dto.setLimg(oriFn);
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			}

			// ------------------------ List<ContentVO>
			List<ItemVO> list = new ArrayList<ItemVO>();
			
			char itype = 'A';
			String[] iname = request.getParameterValues("iname");
			String[] iprice = request.getParameterValues("iprice");
			List<MultipartFile> ifile = new ArrayList<MultipartFile>();
			ifile.add(itemvo.getIfile());
			if (itemvo.getIfile2() != null) {
				ifile.add(itemvo.getIfile2());
			}
			if (itemvo.getIfile3() != null) {
				ifile.add(itemvo.getIfile3());
			}
			if (itemvo.getIfile4() != null) {
				ifile.add(itemvo.getIfile4());
			}
			if (itemvo.getIfile5() != null) {
				ifile.add(itemvo.getIfile5());
			}
			if (itemvo.getIfile6() != null) {
				ifile.add(itemvo.getIfile6());
			}
			if (itemvo.getIfile7() != null) {
				ifile.add(itemvo.getIfile7());
			}
			if (itemvo.getIfile8() != null) {
				ifile.add(itemvo.getIfile8());
			}
			if (itemvo.getIfile9() != null) {
				ifile.add(itemvo.getIfile9());
			}
			if (itemvo.getIfile10() != null) {
				ifile.add(itemvo.getIfile10());
			}
			String[] istock = request.getParameterValues("istock");

			int i = 0;
			int i2 = 0;
			int i3 = 0;
			int i4 = 0;

			for (String e : iname) {
				for (String e2 : iprice) {
					if (i == i2) {
						for (MultipartFile e3 : ifile) {
							if (i == i3) {
								for (String e4 : istock) {
									if (i == i4) {
										ItemVO vo = new ItemVO();
										
										vo.setItype(String.valueOf(itype));
										vo.setIname(iname[i]);
										vo.setIprice(Integer.parseInt(iprice[i2]));
										vo.setIstock(Integer.parseInt(istock[i4]));

										oriFn = ifile.get(i3).getOriginalFilename();
										path = new StringBuffer();
										path.append(r_path).append(img_path).append("\\").append(oriFn);

										f = new File(path.toString());

										try {
											ifile.get(i3).transferTo(f); // ���� ***
											// �̹��� �̸��� db�� �����ϱ� ���� DTO���� �缳�� => �ش簪 DB�� �ֱ�!
											vo.setIimg(oriFn);
										} catch (IllegalStateException | IOException ex) {
											ex.printStackTrace();
										}
										
										list.add(vo);
										
										itype++;
										i4++;
									}
								}
								i3++;
							}
						}
						i2++;
					}
				}
				i++;
			}
			// ------------------------
			localService.insert(dto, list);

			return "redirect:localboardList";
		}

//============================================================================	
	@RequestMapping("/localboardList")
	public String localboardList(Model model) {
		List<LocalVO> list = localdaointer.getList();
		model.addAttribute("list", list);

		return "localtrip/localboardList";
	}

//============================================================================
	@RequestMapping("/localdetail")
	public String localdetail(Model m, int num) {
		LocalVO vo = localdaointer.detailLocal(num);
		m.addAttribute("vo", vo);
		
		//Review : ��۱�� �߰�==========================
		List<ReviewVO> listReview = reviewDaoInter.listReview(num);
        m.addAttribute("listReview",listReview);
        //============================================
        
		return "localtrip/localDetail";
	}

//============================================================================	
	@RequestMapping("/localdelete")
	public String localdelete(int num) {
		localdaointer.delLocal(num);
		return "redirect:localboardList";
	}

//============================================================================	
	@GetMapping("/localmodifyForm")
	public String localmodifyform(Model m, int num) {
		LocalVO vo = localdaointer.detailLocal(num);
		m.addAttribute("vo", vo);
		return "localtrip/localmodify";
	}

	@PostMapping("/localmodify")
	public String localmodify(Model m, LocalVO dto, HttpServletRequest request) {

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
			dto.setLimg(oriFn);
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
		localdaointer.localmodify(dto);

		return "redirect:localboardList";
	}

//============================================================================	
	// =================��� �߰��ϱ�========================
	@RequestMapping(value = "/addReview")
	public String addReview(Model m, ReviewVO vo) {
		reviewDaoInter.addReview(vo);
		return "redirect:localboardList";
	}
}
