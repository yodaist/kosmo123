package kr.co.kosmo.mvc.advice;

import java.util.List;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import kr.co.kosmo.mvc.dao.ReviewDaoInter;
import kr.co.kosmo.mvc.dao.SendMailDaoInter;
import kr.co.kosmo.mvc.vo.BookVO;
import kr.co.kosmo.mvc.vo.ChargeMVO;
import kr.co.kosmo.mvc.vo.SendMailVO;



@Component
@Aspect
public class AdviceTest {
	@Autowired
	private JavaMailSenderImpl mailSender;
	@Autowired
	private SendMailDaoInter sendmaildao;
	
	/*@AfterReturning("execution(* kr.co.kosmo.mvc.controller.member.Login*.logProcessIn(..))")
	public void test() {
		mailSender.send(new MimeMessagePreparator() {
			@Override
			public void prepare(MimeMessage mimeMessage) throws Exception {
				MimeMessageHelper mimeMsgHelperObj = new MimeMessageHelper(mimeMessage, true, "UTF-8");
				mimeMsgHelperObj.setTo("spfdp1@naver.com");
				mimeMsgHelperObj.setFrom("apdlfdyd2@naver.com");
				mimeMsgHelperObj.setText("test");
				mimeMsgHelperObj.setSubject("���ִ� ����ڿ��� �α��� �߽��ϴ�");
			}
		});
		System.out.println("\n ���� ���� ���� \n");
	}
	
	@AfterReturning("execution(* kr.co.kosmo.mvc.controller.member.Login*.logProcessOut(..))")
	public void test2() {
		mailSender.send(new MimeMessagePreparator() {
			@Override
			public void prepare(MimeMessage mimeMessage) throws Exception {
				MimeMessageHelper mimeMsgHelperObj = new MimeMessageHelper(mimeMessage, true, "UTF-8");
				mimeMsgHelperObj.setTo("spfdp1@naver.com");
				mimeMsgHelperObj.setFrom("apdlfdyd2@naver.com");
				mimeMsgHelperObj.setText("test");
				mimeMsgHelperObj.setSubject("���ִ� ����ڿ��� �α׾ƿ� �߽��ϴ�");
			}
		});
		System.out.println("\n ���� ���� ���� \n");
	}*/
	
	
	@AfterReturning("execution(* kr.co.kosmo.mvc.controller.book.Book*.reservProcess(..))")
	public void reserveSendMail() {
		mailSender.send(new MimeMessagePreparator() {
			@Override
			public void prepare(MimeMessage mimeMessage) throws Exception {
				MimeMessageHelper mimeMsgHelperObj = new MimeMessageHelper(mimeMessage, true, "UTF-8");
				SendMailVO vo = (SendMailVO) sendmaildao.reservemail();
				System.out.println("==========Test�ϴ°� ����!===========");
				System.out.println(vo.getChpay());
				System.out.println(vo.getSdate());
				System.out.println(vo.getEdate());
				System.out.println("==========Test�ϴ°� ��!===========");
				String text="��¥ : "+vo.getSdate()+"~"+vo.getEdate()+"\n ����ݾ� : "+vo.getChpay()+"��";
				
				mimeMsgHelperObj.setTo("spfdp1@naver.com");
				mimeMsgHelperObj.setFrom("apdlfdyd2@naver.com");
				mimeMsgHelperObj.setText(text);
				mimeMsgHelperObj.setSubject("���༺��");
				
			}
		});
		System.out.println("\n ���� ���� ���� \n");
	}
	
	
}
