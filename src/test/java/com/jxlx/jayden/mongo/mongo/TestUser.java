package com.jxlx.jayden.mongo.mongo;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Maps;
import com.jxlx.jayden.mongo.dao.UserDao;
import com.jxlx.jayden.mongo.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User : jianjun.xu
 * Date : 2016/9/28
 * Time : 12:00
 * Desc :
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:application-mongo.xml")
public class TestUser {
	private static final Logger LOGGER = LoggerFactory.getLogger(TestUser.class);
	@Autowired
	private UserDao userDao;
	private static String collectionName = "users";


	@Test
	public void testAdd() {
		User user = new User();
		user.setId("" + 101);
		user.setAge(101);
		user.setName("jayden" + 101);
		user.setPassword("jayden" + 101);
		userDao.insert(user, collectionName);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("maxAge", 50);
		List<User> list = userDao.findAll(params, collectionName);
		System.out.println("user.count()==" + list.size());
	}

	@Test
	public void testFindOne() {
		Map<String, Object> params = Maps.newHashMap();
		params.put("id", "1");
		User user = (User) userDao.findOne(params, collectionName);
		LOGGER.info("----------user:{}", JSON.toJSONString(user));
	}

	@Test
	public void testUpdate() {
		Map<String, Object> params = Maps.newHashMap();
		params.put("id", "1");
		params.put("name", "xujianjun");
		userDao.update(params, collectionName);
	}

	@Test
	public void testDelete() {
		Map<String, Object> params = Maps.newHashMap();
		params.put("id", "100");
		userDao.remove(params, collectionName);
	}
}
