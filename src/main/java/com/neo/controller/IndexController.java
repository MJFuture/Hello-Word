package com.neo.controller;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neo.entity.UserEntity;
import com.neo.mapper.UserMapper;
import com.neo.util.StringUtils;

@Controller
public class IndexController {
	
	@Autowired
	UserMapper userMapper;
	
	private UserEntity entity;
	
	public List<UserEntity> sayHello(String name){
        return userMapper.getAll();
    }
	@RequestMapping("/index")
	public ModelAndView index(){
		System.out.println("**********");
		List<UserEntity> entities = userMapper.getAll();
		return new ModelAndView("index","uers",entities);
	}
	@RequestMapping("/doLogin")
	public ModelAndView doLogin(@Param("userName") String userName,@Param("passWord") String passWord ){
		List<UserEntity> entities = userMapper.getAll();
		return new ModelAndView("index/MyHtml","uers",entities);
	}
	@RequestMapping("/mian")
	public ModelAndView mians(@RequestParam(required = false,defaultValue = "1",value = "pn")Integer pn,@RequestParam(required = false,defaultValue = "10",value = "pr")Integer pr){
		entity = new UserEntity();
		PageHelper.startPage(pn, pr);
		List<UserEntity> entities = userMapper.listUsers(entity);
//		List<UserEntity> entities = userMapper.list();
		PageInfo<UserEntity>  p = new PageInfo<>(entities);
		return new ModelAndView("index/MyHtml","uers",p);
	}
	
	@RequestMapping("/adduser")
	public ModelAndView adduser(@Param("alias") String alias){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("entity", new UserEntity());
		map.put("alias", "add");
		return new ModelAndView("index/adduser","data",map);
	}
	@RequestMapping("/edituser")
	public ModelAndView edituser(@Param("alias") String alias,@Param("id") Long id){
		Map<String, Object> map = new HashMap<String, Object>();
		if (!StringUtils.isNull(id.toString())){
			entity = userMapper.getOne(id);
			map.put("entity", entity);
		}
		map.put("alias", "edit");
		return new ModelAndView("index/adduser","data",map);
	}
	@RequestMapping("/addUserInfo")
	public void addUserInfo(HttpServletResponse response,HttpServletRequest request,@ModelAttribute UserEntity entity){
		if(!StringUtils.isNull(entity.getUserName())){
//			entity.setId((long) 14);
			System.out.println("+++++++"+entity.getUserName());
			userMapper.insert(entity);
		}
		String rest = "<script type='text/javascript'>parent.layer.closeAll('iframe');parent.location.reload();</script>";
		try {
			outPrint(rest, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
	public UserEntity getEntity() {
		return entity;
	}
	public void setEntity(UserEntity entity) {
		this.entity = entity;
	}
	
}