package org.cx.game.card.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.cx.game.host.Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.cx.game.utils.Command;
import org.cx.game.utils.Connect;
import org.cx.game.utils.Error;
import org.cx.game.utils.WithConnectCommand;

@Controller
@RequestMapping("/test")
public class TestController {

	
	@Autowired
	private HttpServletRequest request;
	
	@RequestMapping(value="/sand",method=RequestMethod.POST)
	public String index(@Valid Command cmd, Errors errors) {
		RestTemplate rest = new RestTemplate();
		Connect conn = (Connect) request.getSession().getAttribute("conn");
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);
		
		try {
			if(null==conn) {
				String url = "http://localhost:8080/game/rest/create";
				HttpEntity<Command> requestEntity = new HttpEntity<Command>(cmd, headers);
				
				ResponseEntity<Connect> response = rest.exchange(url, HttpMethod.POST, requestEntity, Connect.class, cmd);
				conn = response.getBody();
			}else {
				String url = "http://localhost:8080/game/rest";
				WithConnectCommand wccmd = new WithConnectCommand();
				wccmd.setConnect(conn);
				wccmd.setCommand(cmd.getCommand());
				HttpEntity<WithConnectCommand> requestEntity = new HttpEntity<WithConnectCommand>(wccmd, headers);

				ResponseEntity<List> response = rest.exchange(url, HttpMethod.POST, requestEntity, List.class, cmd);
				List<Record> recordList = response.getBody();
				
			}
		} catch (HttpClientErrorException e) {             //当服务端响应的状态码不是200时，就会抛出异常
			// TODO: handle exception
			System.out.println(e.getStatusCode());
			System.out.println(e.getResponseBodyAsString());
		}
		return "home";
	}
}
