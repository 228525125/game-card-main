package org.cx.game.card.config;

import org.cx.game.tools.SharedConfig;
import org.cx.game.card.controller.IController;
import org.cx.game.card.service.IService;
import org.cx.game.card.tools.ITools;
import org.cx.game.filter.ITraceUserContext;
import org.cx.game.hystrix.IThreadLocalForHystrix;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses={IController.class, IService.class, SharedConfig.class, ITools.class, ITraceUserContext.class, IThreadLocalForHystrix.class})
public class WebConfig {

}
