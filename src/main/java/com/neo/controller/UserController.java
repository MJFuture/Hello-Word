package com.neo.controller;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neo.entity.UserEntity;
import com.neo.mapper.UserMapper;
import com.neo.util.StringUtils;

@RestController
public class UserController {
	
	@Autowired
	UserMapper userMapper;
	
	@RequestMapping("/list")
	public List<UserEntity> sayHello(){
        return userMapper.getAll();
    }
	@RequestMapping("/wehcatDoLogin")
	public Object fellBack(HttpServletResponse response,HttpServletRequest request,@ModelAttribute UserEntity entity){
		if(!StringUtils.isNull(entity.getUserName())){
			List<UserEntity> entities = userMapper.listUsers(entity);
			if(!entities.isEmpty()){
				try {
//					outPrint(entities, response);
					return entities.get(0);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else{
				try {
//					outPrint(null, response);
					return null;
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}else{
			System.out.println("没有数据");
			return null;
		}
		return null;
	}
	/**
	 * 暴露數據
	 * @param object
	 * @param response
	 * @throws Exception
	 */
	public static void outPrint(Object object, HttpServletResponse response)throws Exception{
		PrintWriter out = response.getWriter();
		out.print(object);
		out.flush();
		out.close();
		out =null;
	}
}