package com.jxlx.jayden.mongo.mongo;

import com.jxlx.jayden.mongo.util.Constant;
import com.mongodb.DB;
import com.mongodb.Mongo;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.UnknownHostException;
import java.util.Set;

/**
 * User : jianjun.xu
 * Date : 2016/9/28
 * Time : 11:45
 * Desc :
 */
public class TestMongo {
	private static final Logger LOGGER = LoggerFactory.getLogger(TestMongo.class);

	@Test
	public void testMongo() throws UnknownHostException {
		Mongo mongo = new Mongo(Constant.MONGO_HOST, Constant.MONGO_PORT);
		//根据mongodb数据库的名称获取mongodb对象 ,
		DB db = mongo.getDB("test");
		Set<String> collectionNames = db.getCollectionNames();
		// 打印出test中的集合
		for (String name : collectionNames) {
			LOGGER.info("collectionName===" + name);
		}
	}
}
