package org.cx.game.card.controller;

import java.util.List;

import org.cx.game.card.dao.ILandformEffectDao;
import org.cx.game.card.dao.domain.LandformEffect;
import org.cx.game.card.dao.domain.level.Level;
import org.cx.game.card.exception.DataException;
import org.cx.game.card.tools.LandformEffectBuilder;
import org.cx.game.utils.Error;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/LandformEffect")
public class LandformEffectController {

	@Autowired
	private LandformEffectBuilder landformEffectBuilder;
	
	@Autowired
	private ILandformEffectDao landformEffectDao;
	
	@RequestMapping(value="/import",method=RequestMethod.GET)
	public ResponseEntity<?> importLandformEffect(){
		List<LandformEffect> list = landformEffectBuilder.getInstances();
		landformEffectDao.saveAll(list);
		ResponseEntity<?> responseEntity = getResponseEntity(list);
		return responseEntity;
	}
	
	@RequestMapping(value="/findAll",method=RequestMethod.GET)
	public ResponseEntity<?> findAll(){
		List<LandformEffect> list = landformEffectDao.findAll(); 
		ResponseEntity<?> responseEntity = getResponseEntity(list);
		return responseEntity;
	}
	
	@RequestMapping(value="/findById/{id}",method=RequestMethod.GET)
	public ResponseEntity<?> findItemTypeById(@PathVariable Long id){
		LandformEffect item = landformEffectDao.findById(id).get();
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
