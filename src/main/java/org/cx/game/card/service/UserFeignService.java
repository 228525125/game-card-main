package org.cx.game.card.service;

import org.cx.game.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@FeignClient(value="userservice"/*, fallback=UserService.class*/)        //标识服务
public interface UserFeignService {

    @RequestMapping(method= RequestMethod.GET, value="/v1/User/{account}", consumes=MediaType.APPLICATION_JSON_VALUE)
    User get(@PathVariable("account") String account);
    
    @RequestMapping(value="/save",method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
    void save(@RequestBody User user);
}
