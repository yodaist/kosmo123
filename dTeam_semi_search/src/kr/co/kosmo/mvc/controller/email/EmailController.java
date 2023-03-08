package kr.co.kosmo.mvc.controller.email;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/mail") //���� ���� �ּ�http://localhost/spring2023_0106_Aop_login/mail/sendEmail
public class EmailController {
	static final String emailFromRecipient = "apdlfdyd2@naver.com";

	@Autowired
	private JavaMailSenderImpl mailSender;

	@GetMapping(value = "/emailForm")
	public String emailForm() {
		return "email/emailForm";//��ȯ�� jsp�ּ�
		
	}
	@RequestMapping(value = "/sendEmail", method = RequestMethod.POST)
	public ModelAndView sendEmailToClient(HttpServletRequest request) {
		String emaiSubject = "test";
		String emailMessage = "test";
		String emailToRecipient = "spfdp1@naver.com";
		// ���� ������ �����ϴ� �޼��忡�� �����͸� �Է�

		mailSender.send(new MimeMessagePreparator() {

			@Override
			public void prepare(MimeMessage mimeMessage) throws Exception {
				MimeMessageHelper mimeMsgHelperObj = new MimeMessageHelper(mimeMessage, true, "UTF-8");
				mimeMsgHelperObj.setTo(emailToRecipient);
				mimeMsgHelperObj.setFrom(emailFromRecipient);
				mimeMsgHelperObj.setText(emailMessage);
				mimeMsgHelperObj.setSubject(emaiSubject);

			}
		});
		System.out.println("\n ���� ���� ���� \n");

		ModelAndView mav = new ModelAndView("success", "messageObj", "���� ���� ����");
		return mav;
	}

}