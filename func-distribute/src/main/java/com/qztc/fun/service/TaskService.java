package com.qztc.fun.service;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.qztc.fun.config.MongoConfig;
import com.qztc.fun.config.MongoDao;
import org.bson.Document;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * 任务拆分
 *
 * @author jiacheng.chen
 */
public class TaskService {

    private MongoDao mongoDao = new MongoDao();
    MongoClient mongoClient = new MongoConfig().getMongoClient();

    /**
     * 保存记录
     */
    public void saveManyTaskBatch(String description) {
        MongoCollection<Document> collection = mongoDao.getTaskBatchCollection(mongoClient);
        List<Document> documents = new ArrayList<Document>();
        Document doc = new Document("_id", System.currentTimeMillis())
                .append("taskId", "taskId01")
                .append("accountId", "accountId01")
                .append("createAt", new Date())
                .append("description", description);
        documents.add(doc);
        collection.insertMany(documents);
    }

}
