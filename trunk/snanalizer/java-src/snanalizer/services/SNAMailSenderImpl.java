package snanalizer.services;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.mail.internet.MimeMessage;

import org.springframework.core.task.TaskExecutor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.transaction.annotation.Transactional;

import snanalizer.domain.Recurso;

@Transactional
public class SNAMailSenderImpl implements SNAMailSender {

	@Resource
	private JavaMailSender javaMailSender;

	@Resource
	private TaskExecutor executor;

	public JavaMailSender getJavaMailSender() {
		return javaMailSender;
	}

	public void setJavaMailSender(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}

	public TaskExecutor getExecutor() {
		return executor;
	}

	public void setExecutor(TaskExecutor executor) {
		this.executor = executor;
	}

	public void enviarEncuesta(List<Recurso> recursos) {

		try {
			List<MimeMessage> mails = new ArrayList<MimeMessage>(recursos
					.size());

			for (Recurso recurso : recursos) {
				MimeMessage msg = javaMailSender.createMimeMessage();
				MimeMessageHelper helper = new MimeMessageHelper(msg, true);
				helper.setTo(recurso.getUsuario().getEmail());
				helper.setFrom("snanalizer@gmail.com");
				helper.setSubject("SNA");
				helper
						.setText(
								"<html><body><b>msg</b> de prueba de sna</body></html>",
								true);
				mails.add(msg);
			}

			send(mails);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void send(List<MimeMessage> mails) {
		final MimeMessage[] msgs = mails.toArray(new MimeMessage[0]);

		executor.execute(new Runnable() {
			public void run() {
				javaMailSender.send(msgs);
			}
		});
	}
}
