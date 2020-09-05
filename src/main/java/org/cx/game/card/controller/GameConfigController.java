package org.cx.game.card.controller;

import java.util.ArrayList;
import java.util.List;

import org.cx.game.card.config.GameConfig;
import org.cx.game.card.dao.IMessageDao;
import org.cx.game.card.dao.IPreloadDao;
import org.cx.game.card.dao.ITagHelperDao;
import org.cx.game.card.dao.ITerritoryDao;
import org.cx.game.card.dao.ILandformEffectDao;
import org.cx.game.card.dao.ILevelDao;
import org.cx.game.card.dao.IManualDao;
import org.cx.game.card.dao.domain.Message;
import org.cx.game.card.dao.domain.Preload;
import org.cx.game.card.dao.domain.TagHelper;
import org.cx.game.card.dao.domain.Territory;
import org.cx.game.card.dao.domain.LandformEffect;
import org.cx.game.card.dao.domain.Level;
import org.cx.game.card.dao.domain.Manual;
import org.cx.game.card.exception.DataException;
import org.cx.game.card.tools.MessageBuilder;
import org.cx.game.card.tools.PreloadBuilder;
import org.cx.game.card.tools.TagHelperBuilder;
import org.cx.game.card.tools.TerritoryBuilder;
import org.cx.game.card.tools.LandformEffectBuilder;
import org.cx.game.card.tools.LevelBuilder;
import org.cx.game.card.tools.ManualBuilder;
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
@RequestMapping("/v1/Config")
public class GameConfigController {

	@Autowired
	private GameConfig gameConfig;
	
	@Autowired
	private LandformEffectBuilder landformEffectBuilder;
	
	@Autowired
	private ILandformEffectDao landformEffectDao;
	
	@Autowired
	private MessageBuilder messageBuilder;
	
	@Autowired
	private IMessageDao messageDao;
	
	@Autowired
	private TerritoryBuilder territoryBuilder;
	
	@Autowired
	private ITerritoryDao territoryDao;
	
	@Autowired
	private ILevelDao levelDao;
	
	@Autowired
	private LevelBuilder levelBuilder;
	
	@Autowired
	private IManualDao manualDao;
	
	@Autowired
	private ManualBuilder manualBuilder;
	
	@Autowired
	private IPreloadDao preloadDao;
	
	@Autowired
	private PreloadBuilder preloadBuilder;
	
	@Autowired
	private TagHelperBuilder tagHelperBuilder;
	
	@Autowired
	private ITagHelperDao tagHelperDao; 
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<?> get(){
		ResponseEntity<?> responseEntity = getResponseEntity(gameConfig);
		return responseEntity;
	}
	
	@RequestMapping(value="/LandformEffect/import",method=RequestMethod.GET)
	public ResponseEntity<?> importLandformEffect(){
		List<LandformEffect> list = landformEffectBuilder.getInstances();
		landformEffectDao.deleteAll();
		landformEffectDao.saveAll(list);
		ResponseEntity<?> responseEntity = getResponseEntity(list);
		return responseEntity;
	}
	
	@RequestMapping(value="/LandformEffect/findAll",method=RequestMethod.GET)
	public ResponseEntity<?> findAllLandformEffect(){
		List<LandformEffect> list = landformEffectDao.findAll(); 
		ResponseEntity<?> responseEntity = getResponseEntity(list);
		return responseEntity;
	}
	
	@RequestMapping(value="/LandformEffect/findById/{id}",method=RequestMethod.GET)
	public ResponseEntity<?> findLandformEffectById(@PathVariable Long id){
		LandformEffect item = landformEffectDao.findById(id).get();
		ResponseEntity<?> responseEntity = getResponseEntity(item);
		return responseEntity;
	}
	
	@RequestMapping(value="/Message/import",method=RequestMethod.GET)
	public ResponseEntity<?> importI18n(){
		List<Message> list = messageBuilder.getInstances();
		messageDao.deleteAll();
		messageDao.saveAll(list);
		ResponseEntity<?> responseEntity = getResponseEntity(list);
		return responseEntity;
	}
	
	@RequestMapping(value="/Message/findAll",method=RequestMethod.GET)
	public ResponseEntity<?> findAllI18n(){
		List<Message> list = messageDao.findAll(); 
		ResponseEntity<?> responseEntity = getResponseEntity(list);
		return responseEntity;
	}
	
	@RequestMapping(value="/Message/findById/{id}",method=RequestMethod.GET)
	public ResponseEntity<?> findI18nById(@PathVariable Long id){
		Message item = messageDao.findById(id).get();
		ResponseEntity<?> responseEntity = getResponseEntity(item);
		return responseEntity;
	}
	
	@RequestMapping(value="/Territory/import",method=RequestMethod.GET)
	public ResponseEntity<?> importTerritory(){
		List<Territory> list = territoryBuilder.getInstances();
		territoryDao.deleteAll();
		territoryDao.saveAll(list);
		ResponseEntity<?> responseEntity = getResponseEntity(list);
		return responseEntity;
	}
	
	@RequestMapping(value="/Territory/findAll",method=RequestMethod.GET)
	public ResponseEntity<?> findAllTerritory(){
		List<Territory> list = territoryDao.findAll(); 
		for(Territory territory : list) {
			List<Level> levels = new ArrayList<Level>();
			for(Long lid : territory.getLevels()) levels.add(levelDao.findById(lid).get());
			territory.setLevelList(levels);	
		}
		ResponseEntity<?> responseEntity = getResponseEntity(list);
		return responseEntity;
	}
	
	@RequestMapping(value="/Territory/findById/{id}",method=RequestMethod.GET)
	public ResponseEntity<?> findTerritoryById(@PathVariable Long id){
		Territory item = territoryDao.findById(id).get();
		List<Level> list = new ArrayList<Level>();
		for(Long lid : item.getLevels()) list.add(levelDao.findById(lid).get());
		item.setLevelList(list);
		ResponseEntity<?> responseEntity = getResponseEntity(item);
		return responseEntity;
	}
	
	@RequestMapping(value="/Manual/import",method=RequestMethod.GET)
	public ResponseEntity<?> importManual(){
		List<Manual> list = manualBuilder.getInstances();
		manualDao.deleteAll();
		manualDao.saveAll(list);
		ResponseEntity<?> responseEntity = getResponseEntity(list);
		return responseEntity;
	}
	
	@RequestMapping(value="/Manual/findAll",method=RequestMethod.GET)
	public ResponseEntity<?> findAllManual(){
		List<Manual> list = manualDao.findAll(); 
		ResponseEntity<?> responseEntity = getResponseEntity(list);
		return responseEntity;
	}
	
	@RequestMapping(value="/Manual/findById/{id}",method=RequestMethod.GET)
	public ResponseEntity<?> findManualById(@PathVariable Long id){
		Manual item = manualDao.findById(id).get();
		ResponseEntity<?> responseEntity = getResponseEntity(item);
		return responseEntity;
	}
	
	@RequestMapping(value="/Preload/import",method=RequestMethod.GET)
	public ResponseEntity<?> importPreload(){
		List<Preload> list = preloadBuilder.getInstances();
		preloadDao.deleteAll();
		preloadDao.saveAll(list);
		ResponseEntity<?> responseEntity = getResponseEntity(list);
		return responseEntity;
	}
	
	@RequestMapping(value="/Preload/findAll",method=RequestMethod.GET)
	public ResponseEntity<?> findAllPreload(){
		List<Preload> list = preloadDao.findAll(); 
		ResponseEntity<?> responseEntity = getResponseEntity(list);
		return responseEntity;
	}
	
	@RequestMapping(value="/Preload/findById/{id}",method=RequestMethod.GET)
	public ResponseEntity<?> findPreloadById(@PathVariable Long id){
		Preload item = preloadDao.findById(id).get();
		ResponseEntity<?> responseEntity = getResponseEntity(item);
		return responseEntity;
	}
	
	@RequestMapping(value="/TagHelper/import",method=RequestMethod.GET)
	public ResponseEntity<?> importTagHelper(){
		TagHelper tagHelper = tagHelperBuilder.getInstance();
		tagHelperDao.deleteAll();
		tagHelperDao.save(tagHelper);
		ResponseEntity<?> responseEntity = getResponseEntity(tagHelper);
		return responseEntity;
	}
	
	@RequestMapping(value="/TagHelper",method=RequestMethod.GET)
	public ResponseEntity<?> getTagHelper(){
		TagHelper tagHelper = tagHelperDao.findById(1l).get();
		ResponseEntity<?> responseEntity = getResponseEntity(tagHelper);
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
}
