package com.qztc.fun.config;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import lombok.Data;
import org.bson.Document;

/**
 * mongodb基础配置
 *
 * @author jiacheng.chen
 */
@Data
public class MongoDao {

    private String database = System.getenv("MONGO_DATABASE");

    private String taskCollection = "sonic_code_download_task";
    private String sonicConfigCollection = "sonic_info";
    private String taskBatchCollection = "lab_fun_example";
    private String taskDetailCollection = "sonic_code_download_task_detail";


    /**
     * 获取表【sonic_code_download_task】collection
     *
     * @return
     */
    public MongoCollection<Document> getTaskCollection(MongoClient mongoClient) {
        return getMongoCollection(mongoClient, taskCollection);
    }

    /**
     * 1.获取表【sonic_info】collection
     *
     * @return
     */
    public MongoCollection<Document> getSonicInfoCollection(MongoClient mongoClient) {
        return getMongoCollection(mongoClient, sonicConfigCollection);
    }

    /**
     * 2.获取表【sonic_code_download_task_batch】collection
     *
     * @return
     */
    public MongoCollection<Document> getTaskBatchCollection(MongoClient mongoClient) {
        return getMongoCollection(mongoClient, taskBatchCollection);
    }

    /**
     * 3.获取表【sonic_code_download_task_detail】collection
     *
     * @return
     */
    public MongoCollection<Document> getTaskDetailCollection(MongoClient mongoClient) {
        return getMongoCollection(mongoClient, taskDetailCollection);
    }


    /**
     * 获取collection
     *
     * @param mongoClient MongoClient
     * @param collectionName mongodb文档集合名称
     * @return MongoCollection<Document>
     */
    private MongoCollection<Document> getMongoCollection(MongoClient mongoClient, String collectionName) {
        MongoDatabase mongoDatabase = mongoClient.getDatabase(database);
        return mongoDatabase.getCollection(collectionName);
    }

}
