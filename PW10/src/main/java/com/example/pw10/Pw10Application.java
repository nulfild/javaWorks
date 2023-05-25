package PW10.src.main.java.com.example.pw10;

import java.util.ArrayList;
import java.util.List;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class Pw10Application {

	public static List<Class> beans = new ArrayList<>();

	public static void main(String[] args) {
		beans.add(ConsolePrinter.class);
		beans.add(FilePrinter.class);

		if (args.length != 1) {
			System.out.println("Provide the name of the bean");
			return;
		}

		String beanName = "class com.example.pw10." + args[0];

		boolean hasClass = false;
		Class necessaryClass = null;
		for (Class beanClass : beans) {
			if (
				beanClass.toString().compareTo(beanName) == 0
			) {
				hasClass = true;
				necessaryClass = beanClass;
				break;
			}
		}

		if (!hasClass) {
			System.out.println(
				"Bean with name " + beanName + " not found"
			);
			return;
		}

		ApplicationContext context = new AnnotationConfigApplicationContext(
			ApplicationConfig.class
		);
		IPrinter printer = (IPrinter) context.getBean(
			necessaryClass
		);

		printer.doPrint();
	}
}
