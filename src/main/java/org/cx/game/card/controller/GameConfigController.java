package org.cx.game.card.controller;

import java.util.ArrayList;
import java.util.List;

import org.cx.game.card.config.GameConfig;
import org.cx.game.card.dao.IMessageDao;
import org.cx.game.card.dao.IPreloadDao;
import org.cx.game.card.dao.IBuildingDao;
import org.cx.game.card.dao.IItemDao;
import org.cx.game.card.dao.IKeywordDao;
import org.cx.game.card.dao.IRewardDao;
import org.cx.game.card.dao.ITagHelperDao;
import org.cx.game.card.dao.ITalentDao;
import org.cx.game.card.dao.IStoryDao;
import org.cx.game.card.dao.ITerritoryDao;
import org.cx.game.card.dao.ITradeDao;
import org.cx.game.card.dao.ILandformEffectDao;
import org.cx.game.card.dao.ILevelDao;
import org.cx.game.card.dao.ILifeDao;
import org.cx.game.card.dao.IManualDao;
import org.cx.game.card.dao.domain.Message;
import org.cx.game.card.dao.domain.Preload;
import org.cx.game.card.dao.domain.TagHelper;
import org.cx.game.card.dao.domain.level.Level;
import org.cx.game.card.dao.domain.level.Territory;
import org.cx.game.card.dao.domain.level.building.Building;
import org.cx.game.card.dao.domain.level.item.Item;
import org.cx.game.card.dao.domain.level.life.Life;
import org.cx.game.card.dao.domain.reward.Reward;
import org.cx.game.card.dao.domain.story.Story;
import org.cx.game.card.dao.domain.talent.Talent;
import org.cx.game.card.dao.domain.trade.Trade;
import org.cx.game.card.dao.domain.Keyword;
import org.cx.game.card.dao.domain.LandformEffect;
import org.cx.game.card.dao.domain.Manual;
import org.cx.game.card.exception.DataException;
import org.cx.game.card.tools.MessageBuilder;
import org.cx.game.card.tools.PreloadBuilder;
import org.cx.game.card.tools.BuildingBuilder;
import org.cx.game.card.tools.ItemBuilder;
import org.cx.game.card.tools.KeywordBuilder;
import org.cx.game.card.tools.RewardBuilder;
import org.cx.game.card.tools.TagHelperBuilder;
import org.cx.game.card.tools.TalentBuilder;
import org.cx.game.card.tools.StoryBuilder;
import org.cx.game.card.tools.TerritoryBuilder;
import org.cx.game.card.tools.TradeBuilder;
import org.cx.game.card.tools.LandformEffectBuilder;
import org.cx.game.card.tools.LevelBuilder;
import org.cx.game.card.tools.LifeBuilder;
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
	private StoryBuilder storyBuilder;
	
	@Autowired
	private IMessageDao messageDao;
	
	@Autowired
	private IStoryDao storyDao;
	
	@Autowired
	private TalentBuilder talentBuilder;
	
	@Autowired
	private ITalentDao talentDao;
	
	@Autowired
	private RewardBuilder rewardBuilder;
	
	@Autowired
	private IRewardDao rewardDao;
	
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
	private IKeywordDao keywordDao;
	
	@Autowired
	private ManualBuilder manualBuilder;
	
	@Autowired
	private KeywordBuilder keywordBuilder;
	
	@Autowired
	private IPreloadDao preloadDao;
	
	@Autowired
	private PreloadBuilder preloadBuilder;
	
	@Autowired
	private TagHelperBuilder tagHelperBuilder;
	
	@Autowired
	private ITagHelperDao tagHelperDao; 
	
	@Autowired
	private ItemBuilder itemBuilder;
	
	@Autowired
	private IItemDao itemDao;
	
	@Autowired
	private LifeBuilder lifeBuilder;
	
	@Autowired
	private ILifeDao lifeDao;
	
	@Autowired
	private BuildingBuilder buildingBuilder;
	
	@Autowired
	private IBuildingDao buildingDao;
	
	@Autowired
	private TradeBuilder tradeBuilder;
	
	@Autowired
	private ITradeDao tradeDao;
	
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
	
	@RequestMapping(value="/Story/import",method=RequestMethod.GET)
	public ResponseEntity<?> importTask(){
		List<Story> list = storyBuilder.getInstances();
		storyDao.deleteAll();
		storyDao.saveAll(list);
		ResponseEntity<?> responseEntity = getResponseEntity(list);
		return responseEntity;
	}
	
	@RequestMapping(value="/Story/findAll",method=RequestMethod.GET)
	public ResponseEntity<?> findAllTask(){
		List<Story> list = storyDao.findAll(); 
		ResponseEntity<?> responseEntity = getResponseEntity(list);
		return responseEntity;
	}
	
	@RequestMapping(value="/Story/findById/{id}",method=RequestMethod.GET)
	public ResponseEntity<?> findTaskById(@PathVariable Long id){
		Story item = storyDao.findById(id).get();
		ResponseEntity<?> responseEntity = getResponseEntity(item);
		return responseEntity;
	}
	
	@RequestMapping(value="/Talent/import",method=RequestMethod.GET)
	public ResponseEntity<?> importTalent(){
		List<Talent> list = talentBuilder.getInstances();
		talentDao.deleteAll();
		talentDao.saveAll(list);
		ResponseEntity<?> responseEntity = getResponseEntity(list);
		return responseEntity;
	}
	
	@RequestMapping(value="/Talent/findAll",method=RequestMethod.GET)
	public ResponseEntity<?> findAllTalent(){
		List<Talent> list = talentDao.findAll(); 
		ResponseEntity<?> responseEntity = getResponseEntity(list);
		return responseEntity;
	}
	
	@RequestMapping(value="/Talent/findById/{id}",method=RequestMethod.GET)
	public ResponseEntity<?> findTalentById(@PathVariable Long id){
		Talent item = talentDao.findById(id).get();
		ResponseEntity<?> responseEntity = getResponseEntity(item);
		return responseEntity;
	}
	
	@RequestMapping(value="/Reward/import",method=RequestMethod.GET)
	public ResponseEntity<?> importReward(){
		List<Reward> list = rewardBuilder.getInstances();
		rewardDao.deleteAll();
		rewardDao.saveAll(list);
		ResponseEntity<?> responseEntity = getResponseEntity(list);
		return responseEntity;
	}
	
	@RequestMapping(value="/Reward/findAll",method=RequestMethod.GET)
	public ResponseEntity<?> findAllReward(){
		List<Reward> list = rewardDao.findAll(); 
		ResponseEntity<?> responseEntity = getResponseEntity(list);
		return responseEntity;
	}
	
	@RequestMapping(value="/Reward/findById/{id}",method=RequestMethod.GET)
	public ResponseEntity<?> findRewardById(@PathVariable Long id){
		Reward item = rewardDao.findById(id).get();
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
		ResponseEntity<?> responseEntity = getResponseEntity(list);
		return responseEntity;
	}
	
	@RequestMapping(value="/Territory/findById/{id}",method=RequestMethod.GET)
	public ResponseEntity<?> findTerritoryById(@PathVariable Long id){
		Territory item = territoryDao.findById(id).get();
		ResponseEntity<?> responseEntity = getResponseEntity(item);
		return responseEntity;
	}
	
	@RequestMapping(value="/Level/import",method=RequestMethod.GET)
	public ResponseEntity<?> importLevel(){
		List<Level> list = levelBuilder.getInstances();
		levelDao.deleteAll();
		levelDao.saveAll(list);
		ResponseEntity<?> responseEntity = getResponseEntity(list);
		return responseEntity;
	}
	
	@RequestMapping(value="/Level/findAll",method=RequestMethod.GET)
	public ResponseEntity<?> findAllLevel(){
		List<Level> list = levelDao.findAll(); 
		ResponseEntity<?> responseEntity = getResponseEntity(list);
		return responseEntity;
	}
	
	@RequestMapping(value="/Level/findById/{id}",method=RequestMethod.GET)
	public ResponseEntity<?> findLevelById(@PathVariable Long id){
		Level item = levelDao.findById(id).get();
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
	
	@RequestMapping(value="/Keyword/import",method=RequestMethod.GET)
	public ResponseEntity<?> importKeyword(){
		List<Keyword> list = keywordBuilder.getInstances();
		keywordDao.deleteAll();
		keywordDao.saveAll(list);
		ResponseEntity<?> responseEntity = getResponseEntity(list);
		return responseEntity;
	}
	
	@RequestMapping(value="/Keyword/findAll",method=RequestMethod.GET)
	public ResponseEntity<?> findAllKeyword(){
		List<Keyword> list = keywordDao.findAll(); 
		ResponseEntity<?> responseEntity = getResponseEntity(list);
		return responseEntity;
	}
	
	@RequestMapping(value="/Keyword/findById/{id}",method=RequestMethod.GET)
	public ResponseEntity<?> findKeywordById(@PathVariable Long id){
		Keyword item = keywordDao.findById(id).get();
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
	
	@RequestMapping(value="/Item/import",method=RequestMethod.GET)
	public ResponseEntity<?> importItem(){
		List<Item> list = itemBuilder.getInstances();
		itemDao.deleteAll();
		itemDao.saveAll(list);
		ResponseEntity<?> responseEntity = getResponseEntity(list);
		return responseEntity;
	}
	
	@RequestMapping(value="/Item/findAll",method=RequestMethod.GET)
	public ResponseEntity<?> findAllItem(){
		List<Item> list = itemDao.findAll(); 
		ResponseEntity<?> responseEntity = getResponseEntity(list);
		return responseEntity;
	}
	
	@RequestMapping(value="/Item/findById/{id}",method=RequestMethod.GET)
	public ResponseEntity<?> findItemById(@PathVariable Long id){
		Item item = itemDao.findById(id).get();
		ResponseEntity<?> responseEntity = getResponseEntity(item);
		return responseEntity;
	}
	
	@RequestMapping(value="/Life/import",method=RequestMethod.GET)
	public ResponseEntity<?> importLife(){
		List<Life> list = lifeBuilder.getInstances();
		lifeDao.deleteAll();
		lifeDao.saveAll(list);
		ResponseEntity<?> responseEntity = getResponseEntity(list);
		return responseEntity;
	}
	
	@RequestMapping(value="/Life/findAll",method=RequestMethod.GET)
	public ResponseEntity<?> findAllLife(){
		List<Life> list = lifeDao.findAll(); 
		ResponseEntity<?> responseEntity = getResponseEntity(list);
		return responseEntity;
	}
	
	@RequestMapping(value="/Life/findById/{id}",method=RequestMethod.GET)
	public ResponseEntity<?> findLifeById(@PathVariable Long id){
		Life item = lifeDao.findById(id).get();
		ResponseEntity<?> responseEntity = getResponseEntity(item);
		return responseEntity;
	}
	
	@RequestMapping(value="/Building/import",method=RequestMethod.GET)
	public ResponseEntity<?> importBuilding(){
		List<Building> list = buildingBuilder.getInstances();
		buildingDao.deleteAll();
		buildingDao.saveAll(list);
		ResponseEntity<?> responseEntity = getResponseEntity(list);
		return responseEntity;
	}
	
	@RequestMapping(value="/Building/findAll",method=RequestMethod.GET)
	public ResponseEntity<?> findAllBuilding(){
		List<Building> list = buildingDao.findAll(); 
		ResponseEntity<?> responseEntity = getResponseEntity(list);
		return responseEntity;
	}
	
	@RequestMapping(value="/Building/findById/{id}",method=RequestMethod.GET)
	public ResponseEntity<?> findBuildingById(@PathVariable Long id){
		Building item = buildingDao.findById(id).get();
		ResponseEntity<?> responseEntity = getResponseEntity(item);
		return responseEntity;
	}
	
	@RequestMapping(value="/Trade/import",method=RequestMethod.GET)
	public ResponseEntity<?> importTrade(){
		List<Trade> list = tradeBuilder.getInstances();
		tradeDao.deleteAll();
		tradeDao.saveAll(list);
		ResponseEntity<?> responseEntity = getResponseEntity(list);
		return responseEntity;
	}
	
	@RequestMapping(value="/Trade/findAll",method=RequestMethod.GET)
	public ResponseEntity<?> findAllTrade(){
		List<Trade> list = tradeDao.findAll(); 
		ResponseEntity<?> responseEntity = getResponseEntity(list);
		return responseEntity;
	}
	
	@RequestMapping(value="/Trade/findById/{id}",method=RequestMethod.GET)
	public ResponseEntity<?> findTradeById(@PathVariable Long id){
		Trade item = tradeDao.findById(id).get();
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
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		ResponseEntity<T> responseEntity = new ResponseEntity<T>(body, headers, HttpStatus.OK);
		return responseEntity;
	}
}
