package com.jxlx.jayden.mongo.dao.impl;

import com.jxlx.jayden.mongo.dao.UserDao;
import com.jxlx.jayden.mongo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * User : jianjun.xu
 * Date : 2016/9/28
 * Time : 11:55
 * Desc :
 */
@Repository
public class UserDaoImpl implements UserDao {
	@Autowired
	private MongoTemplate mongoTemplate;

	public void insert(Object object, String collectionName) {
		mongoTemplate.insert(object, collectionName);
	}

	public void createCollection(String collectionName) {
		mongoTemplate.createCollection(collectionName);
	}

	public void remove(Map params, String collectionName) {
		mongoTemplate.remove(new Query(Criteria.where("id").is(params.get("id"))), User.class, collectionName);
	}

	public void update(Map params, String collectionName) {
		mongoTemplate.upsert(new Query(Criteria.where("id").is(params.get("id"))), new Update().set("name", params.get("name")), User.class, collectionName);
	}

	public List findAll(Map params, String collectionName) {
		return mongoTemplate.find(new Query(Criteria.where("age").lt(params.get("maxAge"))), User.class, collectionName);
	}

	public Object findOne(Map params, String collectionName) {
		return mongoTemplate.findOne(new Query(Criteria.where("id").is(params.get("id"))), User.class, collectionName);
	}
}
