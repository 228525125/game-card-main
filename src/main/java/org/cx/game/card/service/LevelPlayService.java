package org.cx.game.card.service;

import static org.cx.game.tools.HttpURL.*;

import java.util.List;

import org.cx.game.host.Record;
import org.cx.game.utils.Command;
import org.cx.game.utils.Connect;
import org.cx.game.utils.WithConnectCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.*;

@Service
public class LevelPlayService {

	private String connectUrl = http+cardlevel+version+Play+connect;
	private String actionUrl = http+cardlevel+version+Play+action;;
	private String operateUrl = http+cardlevel+version+Play+operate;
	private String synUrl = http+cardlevel+version+Play+syn;
	
	@Autowired
	private RestTemplate restTemplate;
	
	private HttpEntity<?> getHttpEntity(String cmdString) {
		Command cmd = new Command();
		cmd.setCommand(cmdString);
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		HttpEntity<Command> requestEntity = new HttpEntity<Command>(cmd, headers);
		return requestEntity;
	}
	
	private HttpEntity<?> getHttpEntity(Connect conn, String cmdString) {
		WithConnectCommand cmd = new WithConnectCommand();
		cmd.setConnect(conn);
		cmd.setCommand(cmdString);
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		HttpEntity<WithConnectCommand> requestEntity = new HttpEntity<WithConnectCommand>(cmd, headers);
		return requestEntity;
	}
	
	@HystrixCommand(commandProperties={
		@HystrixProperty(name="metrics.rollingStats.timeInMilliseconds", value="5000")}   //Hystrix收集和监控服务调用的统计信息的滚动窗口（以毫秒为单位）
	)
	public ResponseEntity<?> connect(String cmdStr) {
		HttpEntity<?> requestEntity = getHttpEntity(cmdStr);
		try {
			ResponseEntity<Connect> response = restTemplate.exchange(
					connectUrl, 
					HttpMethod.POST, 
					requestEntity, Connect.class);
			return response;
		} catch (HttpClientErrorException e) {             //当服务端响应的状态码不是200时，就会抛出异常
			// TODO: handle exception
			System.out.println(e.getStatusCode());
			System.out.println(e.getResponseBodyAsString());
		}
		return null;
	}
	
	@HystrixCommand(commandProperties={
		@HystrixProperty(name="metrics.rollingStats.timeInMilliseconds", value="5000")}   //Hystrix收集和监控服务调用的统计信息的滚动窗口（以毫秒为单位）
	)
	public ResponseEntity<?> action(Connect conn, String cmdStr) {
		HttpEntity<?> requestEntity = getHttpEntity(conn, cmdStr);
		try {
			ResponseEntity<?> response = restTemplate.exchange(
					actionUrl, 
					HttpMethod.POST, 
					requestEntity, new ParameterizedTypeReference<List<Record>>(){});
			return response;
		} catch (HttpClientErrorException e) {             //当服务端响应的状态码不是200时，就会抛出异常
			// TODO: handle exception
			System.out.println(e.getStatusCode());
			System.out.println(e.getResponseBodyAsString());
		}
		return null;
	}
	
	@HystrixCommand(commandProperties={
		@HystrixProperty(name="metrics.rollingStats.timeInMilliseconds", value="5000")}   //Hystrix收集和监控服务调用的统计信息的滚动窗口（以毫秒为单位）
	)
	public ResponseEntity<?> operate(Connect conn, String cmdStr) {
		HttpEntity<?> requestEntity = getHttpEntity(conn, cmdStr);
		try {
			ResponseEntity<?> response = restTemplate.exchange(
					operateUrl, 
					HttpMethod.POST, 
					requestEntity, String.class);
			return response;
		} catch (HttpClientErrorException e) {             //当服务端响应的状态码不是200时，就会抛出异常
			// TODO: handle exception
			System.out.println(e.getStatusCode());
			System.out.println(e.getResponseBodyAsString());
		}
		return null;
	}
}
