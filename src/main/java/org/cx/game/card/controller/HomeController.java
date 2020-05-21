package org.cx.game.card.controller;

import static org.springframework.web.bind.annotation.RequestMethod.*;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({"/"})                 //将控制器映射到'/'
public class HomeController {

	@RequestMapping(method=GET)      //处理GET请求
	public String home(Model model) {
		return "home";                          //视图名
	}
}
