package dm.java.it.cvaihandler.config;

import feign.Feign;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableFeignClients(basePackages = "dm.java.it.cvaihandler")
@EnableWebMvc
public class OpenFeignConfig {

}
