package org.cx.game.card.service;

import org.cx.game.filter.UserContextHolder;
import org.cx.game.pojo.User;

import static org.cx.game.tools.HttpURL.*;
import org.cx.game.tools.Logger;
import org.cx.game.utils.Command;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.*;

@Service
public class UserService {

	@Autowired
	private RestTemplate restTemplate;
	
	@HystrixCommand
	public User get(String account) {
		ResponseEntity<User> restExchange = restTemplate.exchange(
				http+userservice+version+User+"/{account}", 
				HttpMethod.GET, 
				null, User.class, account);
		return restExchange.getBody();
	}
	
	public User save(User user) {
		// TODO Auto-generated method stub
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<User> requestEntity = new HttpEntity<User>(user, headers);
		
		ResponseEntity<User> restExchange = restTemplate.exchange(
				http+userservice+version+User+"/save", 
				HttpMethod.POST, 
				requestEntity, User.class, user);
		return restExchange.getBody();
	}
	
	//测试THREAD隔离级别下的关联ID
		/*@HystrixCommand(//fallbackMethod = "buildFallback",                                               //标识类中的方法，如果远程调用超时，将调用该方法。回调方法必须与@HystrixCommand注解在同一个类中，并且必须具有与调用类相同的方法签名。如果值不存在，Hystrix会抛出异常
	            threadPoolKey = "licenseByOrgThreadPool",                                                   //给予@HystrixCommand一个唯一的名称，名称，并创建一个独立于默认线程池的线程池。如果没有定义任何值，则将使用默认的Hystrix线程池
	            threadPoolProperties =                                                                      //核心的Hystrix注解属性，用于配置线程池的行为
	                    {@HystrixProperty(name = "coreSize",value="30"),                                    //设置线程池的大小
	                     @HystrixProperty(name="maxQueueSize", value="10")},                                //设置线程池前面的最大队列大小。如果设置为−1，则不使用队列，Hystrix将阻塞请求，直到有一个线程可用来处理
	            commandProperties={
	                     @HystrixProperty(name="circuitBreaker.requestVolumeThreshold", value="10"),        //设置Hystrix开始检查断路器是否跳闸之前滚动窗口中必须处理的最小请求数
	                     @HystrixProperty(name="circuitBreaker.errorThresholdPercentage", value="75"),      //在断路器跳闸之前，滚动窗口内必须达到的故障百分比
	                     @HystrixProperty(name="circuitBreaker.sleepWindowInMilliseconds", value="7000"),   //在断路器跳闸之后，Hystrix尝试进行服务调用之前将要等待的时间（以毫秒为单位）
	                     @HystrixProperty(name="metrics.rollingStats.timeInMilliseconds", value="15000"),   //Hystrix收集和监控服务调用的统计信息的滚动窗口（以毫秒为单位）
	                     @HystrixProperty(name="metrics.rollingStats.numBuckets", value="5")}               //Hystrix在一个监控窗口中维护的度量桶的数量。监视窗口内的桶数越多，Hystrix在窗口内监控故障的时间越
	    )
		public void testHystrix() {
			System.out.println("UserService.testHystrix: " + UserContextHolder.getContext().getCorrelationId());
		}*/
}
