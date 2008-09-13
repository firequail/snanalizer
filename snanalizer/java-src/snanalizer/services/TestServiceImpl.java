package snanalizer.services;

import java.util.Date;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public class TestServiceImpl implements TestService {

	public String getDate() {
		return new Date().toString();
	}
}
