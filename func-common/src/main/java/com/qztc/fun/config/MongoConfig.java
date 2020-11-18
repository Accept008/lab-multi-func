package com.qztc.fun.config;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

/**
 * mongodb配置类
 *
 * @author jiacheng.chen
 */
public class MongoConfig {

    private String MongoURI = System.getenv("MONGO_URI");

    /**
     * 获取mongodb连接
     *
     * @return MongoClient
     */
    public MongoClient getMongoClient() {
        String uri = MongoURI;
        MongoClientURI clientURI = new MongoClientURI(uri);
        MongoClient mongoClient = new MongoClient(clientURI);
        return mongoClient;
    }
}
