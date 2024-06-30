package infnet.petshot.com.ApiVilardo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ApiVilardoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiVilardoApplication.class, args);
	}

}
