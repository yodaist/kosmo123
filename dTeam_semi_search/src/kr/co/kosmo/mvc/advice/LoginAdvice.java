package kr.co.kosmo.mvc.advice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import kr.co.kosmo.mvc.dao.MemberDaoInter;
import kr.co.kosmo.mvc.vo.LoginLoggerDTO;

@Component // controller�� �ƴ� �Ϲ� �� ����
@Aspect // AOP_Advice : Around,Before..��밡��
public class LoginAdvice {
	private String userAgent;

	@Autowired
	private MemberDaoInter memberdao;

	//@Around("execution(* kr.co.kosmo.mvc.controller.member.Login*.logProcess*(..))")
	public ModelAndView loginLogger(ProceedingJoinPoint jp) {
		ModelAndView rpath = null;

		// 1) �޼����� �̸��� ������ �α��ΰ� �α׾ƿ��� �����Ѵ�.
		String methodName = jp.getSignature().getName();
		System.out.println("methodName: " + methodName);

		// 2) JoinPoint�κ��� �޼����� Ÿ�� ��ü�� �޼��� ���ڰ� �޾ƿ���
		Object[] fd = jp.getArgs();
		
		// 3) �޼��忡 ���� �α���/�α׾ƿ� ����
		if (methodName.equals("logProcessIn")) { //3-1) �α���
			// =======================================
			try {
				rpath = (ModelAndView) jp.proceed(); // �α��� �޼��� ȣ��
				//rpath: ModelAndView: reference to view with name 'main/mainbody'; model is null
			} catch (Throwable e) {
				e.printStackTrace();
			}
			// =======================================
			// getArgs: session_���ǿ� �ִ� id, request_ip, DTO_,userAgent_��ġ -> 4��
			// session�� ��������
			HttpSession session = (HttpSession) fd[0];
			String uid = (String) session.getAttribute("sessionID");
			System.out.println("uid: " + uid);
			// ip�� �������� -> localhost�� �ڽ��� ip�ֱ�
			String reip = ((HttpServletRequest) (fd[1])).getRemoteAddr();
			System.out.println("ip: " + reip);
			// ���� ��ġ �������� -> userAgent
			userAgent = (String) fd[3];
			System.out.println("agent: " + userAgent);

			// =========���� ������ ������ DB�� �ֱ�(�α���)=============
			LoginLoggerDTO vo = new LoginLoggerDTO();
			vo.setMidn(uid); // ����϶�
			vo.setStatus("login");
			vo.setReip(reip);
			vo.setUagent(userAgent);
			vo.setRuntime(0);
			memberdao.addLoginLogging(vo);
		} else if (methodName.equals("logProcessOut")) { //3-2) �α׾ƿ�
			// =======================================
			// getArgs: ����,request(2��)
			HttpSession session = (HttpSession) fd[0];
			String uid = (String) session.getAttribute("sessionID");
			String reip = ((HttpServletRequest) (fd[1])).getRemoteAddr();
			// =========���� ������ ������ DB�� �ֱ�(�α׾ƿ�)=============
			// �α���~�α׾ƿ� �ð����-----
			//int runtime = 0;
			// ---------------------			
			LoginLoggerDTO vo = new LoginLoggerDTO();
			vo.setMidn(uid); // ����϶�
			vo.setStatus("logout");
			vo.setReip(reip);
			vo.setUagent(userAgent);
			//vo.setRuntime(runtime);
			vo.setRuntime(0);
			memberdao.addLoginLogging(vo);
			// =======================================
			try {
				rpath = (ModelAndView) jp.proceed(); // �α׾ƿ� �޼��� ȣ��
			} catch (Throwable e) {
				e.printStackTrace();
			}
		}
		return rpath;
	}

}
