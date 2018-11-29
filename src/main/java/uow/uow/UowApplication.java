package uow.uow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
public class UowApplication {

	public static void main(String[] args) {
		SpringApplication.run(UowApplication.class, args);
	}
}
