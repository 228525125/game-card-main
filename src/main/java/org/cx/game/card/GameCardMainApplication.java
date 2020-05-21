package org.cx.game.card;

import java.util.Collections;
import java.util.List;

import org.cx.game.card.config.MongoConfig;
import org.cx.game.card.config.WebConfig;
import org.cx.game.filter.UserContextInterceptor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;

@Import({MongoConfig.class, WebConfig.class})
@EnableCircuitBreaker    //使服务能够使用Hystrix库
@SpringBootApplication
public class GameCardMainApplication {

	public static void main(String[] args) {
		SpringApplication.run(GameCardMainApplication.class, args);
	}
	
	@LoadBalanced
    @Bean
    public RestTemplate getRestTemplate(){
        RestTemplate template = new RestTemplate();
        List<ClientHttpRequestInterceptor> interceptors = template.getInterceptors();
        if (interceptors == null) {      //将UserContextInterceptor添加到已创建的RestTemplate实例中
            template.setInterceptors(Collections.singletonList(new UserContextInterceptor()));
        } else {
            interceptors.add(new UserContextInterceptor());
            template.setInterceptors(interceptors);
        }

        return template;
    }

}
