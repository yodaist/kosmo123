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
				mimeMsgHelperObj.setSubject("공주님 놀러가자에서 로그인 했습니다");
			}
		});
		System.out.println("\n 메일 전송 성공 \n");
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
				mimeMsgHelperObj.setSubject("공주님 놀러가자에서 로그아웃 했습니다");
			}
		});
		System.out.println("\n 메일 전송 성공 \n");
	}*/
	
	
	@AfterReturning("execution(* kr.co.kosmo.mvc.controller.book.Book*.reservProcess(..))")
	public void reserveSendMail() {
		mailSender.send(new MimeMessagePreparator() {
			@Override
			public void prepare(MimeMessage mimeMessage) throws Exception {
				MimeMessageHelper mimeMsgHelperObj = new MimeMessageHelper(mimeMessage, true, "UTF-8");
				SendMailVO vo = (SendMailVO) sendmaildao.reservemail();
				System.out.println("==========Test하는곳 시작!===========");
				System.out.println(vo.getChpay());
				System.out.println(vo.getSdate());
				System.out.println(vo.getEdate());
				System.out.println("==========Test하는곳 끝!===========");
				String text="날짜 : "+vo.getSdate()+"~"+vo.getEdate()+"\n 예약금액 : "+vo.getChpay()+"원";
				
				mimeMsgHelperObj.setTo("spfdp1@naver.com");
				mimeMsgHelperObj.setFrom("apdlfdyd2@naver.com");
				mimeMsgHelperObj.setText(text);
				mimeMsgHelperObj.setSubject("예약성공");
				
			}
		});
		System.out.println("\n 메일 전송 성공 \n");
	}
	
	
}
