package snanalizer.install;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import snanalizer.services.InitDBService;

public class Installer {

	private ApplicationContext context;

	public static void main(String[] args) {
		new Installer().install();
	}
	
	public Installer(){
		context = new ClassPathXmlApplicationContext(
		"snanalizer/applicationContext.xml");
	}

	private void install() {
		System.out.print("Installing SNA...");
		
		initDB();
		
		System.out.println("OK");
	}
	
	private void initDB() {
		InitDBService initDB = (InitDBService) context.getBean("initDBService");
		initDB.recrearTestDB();
	}
}
