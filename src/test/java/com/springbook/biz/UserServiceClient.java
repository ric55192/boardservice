package com.springbook.biz;


import com.springbook.biz.user.UserService;
import com.springbook.biz.user.UserVO;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class UserServiceClient {
    public static void main(String[] arg) {
        AbstractApplicationContext container = new GenericXmlApplicationContext("applicationContext.xml");

        UserService userService = (UserService) container.getBean("userService");

        UserVO vo = new UserVO();
        vo.setId("test");
        vo.setPassword("test123");


        UserVO user = userService.getUser(vo);
        if (user != null) {
            System.out.println(user.getName() + "님 환영합니다.");
        } else {
            System.out.println("로그인 실패");
        }


        container.close();

    }
}
