package org.cx.game.card.controller;

import java.util.List;

import org.cx.game.tools.JsonHelper;
import org.cx.game.tools.Util;
import org.cx.game.card.dao.ILevelDao;
import org.cx.game.card.domain.Deck;
import org.cx.game.card.domain.Level;
import org.cx.game.card.exception.DataException;
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
import org.cx.game.utils.Connect;
import org.cx.game.utils.Error;

@RestController
@RequestMapping("/v1/Level")
public class LevelController {

	@Autowired
	private JsonHelper jsonHelper;
	
	@Autowired
	private ILevelDao levelDao;
	
	@RequestMapping(value="/save",method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> save(@RequestBody Level item){
		if(0l==item.getId()) item.setId(null);        //兼容C#，id是long无法设置为null
		levelDao.save(item);
		ResponseEntity<?> responseEntity = getResponseEntity(item);
		return responseEntity;
	}
	
	@RequestMapping(value="/delete",method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> delete(@RequestBody Level item){
		levelDao.delete(item);
		ResponseEntity<?> responseEntity = getResponseEntity(item);
		return responseEntity;
	}
	
	@RequestMapping(value="/findAll",method=RequestMethod.GET)
	public ResponseEntity<?> findAll(){
		List<Level> list = levelDao.findAll(); 
		ResponseEntity<?> responseEntity = getResponseEntity(list);
		return responseEntity;
	}
	
	@RequestMapping(value="/findById/{id}",method=RequestMethod.GET)
	public ResponseEntity<?> findItemTypeById(@PathVariable Long id){
		Level item = levelDao.findById(id).get();
		ResponseEntity<?> responseEntity = getResponseEntity(item);
		return responseEntity;
	}
	
	@ExceptionHandler({DataException.class})
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
