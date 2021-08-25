package com.ruoyi.web.controller.config;

import com.ruoyi.common.tmp.UserDto;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @author oweson
 * @date 2021/8/22 22:59
 */

@Component
public class UserEvent {
	@EventListener(condition = "#user.name!=null")
	public void handleEvent(UserDto user) throws Exception{
		System.out.println(user.getName());
		System.out.println(user.getSex());
	}
}
