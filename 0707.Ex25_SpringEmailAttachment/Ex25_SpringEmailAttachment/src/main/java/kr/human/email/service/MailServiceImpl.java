package kr.human.email.service;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

@Service("mailService")
public class MailServiceImpl implements MailService{

	@Autowired
	private JavaMailSender mailSender;
	
	@Override
	public void sendEmail() {
		MimeMessagePreparator preparator = new MimeMessagePreparator() {
			@Override
			public void prepare(MimeMessage mimeMessage) throws Exception {
                MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
				// 보낼 메일의 양식을 만든다.
                helper.setFrom("oss7140@naver.com"); // XML의 인증 계정과 같아야 한다.
                helper.setTo("oss7140@naver.com");
                helper.setSubject("나는 제목입니다.");
                helper.setText("<html><body><p>나는 내용</p><img src='cid:company-logo'></body></html>", true);
                // 첨부파일을 메일의 내용에 이름을 company-logo로 바꿔서 붙여준다.
                helper.addInline("company-logo", new ClassPathResource("linux-icon.png"));
			}
		};
		try {
			mailSender.send(preparator);
			System.out.println("메일 발송 성공");
		}catch (Exception e) {
			System.err.print("에러 : " + e.getMessage());
		}
	}

	@Override
	public void sendEmail(String toAddress, String subject, String content) {
		MimeMessagePreparator preparator = new MimeMessagePreparator() {
			@Override
			public void prepare(MimeMessage mimeMessage) throws Exception {
                MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
				// 보낼 메일의 양식을 만든다.
                helper.setFrom("oss7140@naver.com"); // XML의 인증 계정과 같아야 한다.
                helper.setTo(toAddress);
                helper.setSubject(subject);
                helper.setText(content);
                
                // 파일을 첨부파일로 추가한다.
                helper.addAttachment("cutie.png", new ClassPathResource("linux-icon.png"));
                
			}
		};
		try {
			mailSender.send(preparator);
			System.out.println("메일 발송 성공");
		}catch (Exception e) {
			System.err.print("에러 : " + e.getMessage());
		}
	}

}
