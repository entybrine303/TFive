package graduate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import graduate.config.StorageProperties;

@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class GraduateProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(GraduateProjectApplication.class, args);
	}

}
