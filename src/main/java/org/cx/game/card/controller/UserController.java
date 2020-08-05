package org.cx.game.card.controller;

import org.cx.game.filter.UserContextHolder;
import org.cx.game.pojo.User;
import org.cx.game.tools.Logger;
import org.cx.game.card.dao.IStorageDao;
import org.cx.game.card.dao.domain.Storage;
import org.cx.game.card.exception.DataException;
import org.cx.game.card.exception.LoginException;
import org.cx.game.card.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import org.cx.game.utils.Error;

@RestController
@RequestMapping("/v1/User")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private IStorageDao storageDao;
	
	@RequestMapping(value="/login",method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> Login(@RequestBody User param) {
		User u = userService.get(param.getAccount());
		if(null==u || !u.getPassword().equals(param.getPassword())) throw new LoginException(); 
		ResponseEntity<User> responseEntity = getResponseEntity(u);
		return responseEntity;
	}
	
	@RequestMapping(value="/save",method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> registration(@RequestBody User user){
		if(0l==user.getId()) user.setId(null);        //兼容C#，id是long无法设置为null
		Storage storage = new Storage();
		storage.setAccount(user.getAccount());
		User u = userService.save(user);
		storageDao.save(storage);
		ResponseEntity<?> responseEntity = getResponseEntity(u);
		return responseEntity;
	}
	
	//测试用方法
	@RequestMapping(value="/{account}",method = RequestMethod.GET)
	public User get(@PathVariable("account") String account) {
		//userService.testHystrix();
		Logger.debug("UserController.get: {}", UserContextHolder.getContext().getCorrelationId());
		UserContextHolder.getContext().setUserId(account);
		return userService.get(account);
	}
	
	@ExceptionHandler({LoginException.class})
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public Error handleException(DataException e) {
		String msg = e.getMessage();
		return new Error(HttpStatus.BAD_REQUEST.value(), msg);
	}
	
	private static <T> ResponseEntity<T> getResponseEntity(T body) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
		
		ResponseEntity<T> responseEntity = new ResponseEntity<T>(body, headers, HttpStatus.OK);
		return responseEntity;
	}
}
