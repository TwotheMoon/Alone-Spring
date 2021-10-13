package hello.hello_springstudy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication
public class HelloSpringStudyApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloSpringStudyApplication.class, args);
	}

}
