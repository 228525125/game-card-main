package org.cx.game.card.controller;

import org.cx.game.tools.JsonHelper;

import java.util.ArrayList;
import java.util.List;

import org.cx.game.card.dao.IStorageDao;
import org.cx.game.card.dao.domain.Storage;
import org.cx.game.card.dao.domain.story.Story;
import org.cx.game.card.exception.DataException;
import org.cx.game.card.tools.StorageBuilder;
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
@RequestMapping("/v1/Storage")
public class StorageController {

	@Autowired
	private JsonHelper jsonHelper;
	
	@Autowired
	private StorageBuilder builder;
	
	@Autowired
	private IStorageDao storageDao;
	
	@RequestMapping(value="/import",method=RequestMethod.GET)
	public ResponseEntity<?> importStorage(){
		List<Storage> list = builder.getInstances();
		//storageDao.deleteAll();
		storageDao.saveAll(list);
		ResponseEntity<?> responseEntity = getResponseEntity(list);
		return responseEntity;
	}
	
	@RequestMapping(value="/save",method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> saveStorage(@RequestBody Storage storage){
		Storage s = storageDao.save(storage);
		ResponseEntity<?> responseEntity = getResponseEntity(s);
		return responseEntity;
	}
	
	@RequestMapping(value="/findByAccount/{account}",method=RequestMethod.GET)
	public ResponseEntity<?> findByAccount(@PathVariable String account){
		Storage storage = storageDao.findByAccount(account);
		if(null == storage) storage = createStorage(account);
		ResponseEntity<?> responseEntity = getResponseEntity(storage);
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
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		ResponseEntity<T> responseEntity = new ResponseEntity<T>(body, headers, HttpStatus.OK);
		return responseEntity;
	}
	
	private Storage createStorage(String account) {
		Storage template = storageDao.findByAccount("DeckTemplate");
		Storage storage = new Storage();
		storage.setId(storageDao.count() + 1);
		storage.setAccount(account);
		storage.setHeroes(template.getHeroes());
		storage.setCards(template.getCards());
		storage.setNickName(template.getNickName());
		storage.setDefaultHero(template.getDefaultHero());
		storage.setNpcList(template.getNpcList());
		storage = storageDao.save(storage);
		return storage;
	}
}
