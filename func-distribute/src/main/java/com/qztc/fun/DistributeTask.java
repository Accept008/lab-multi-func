package com.qztc.fun;

import com.alibaba.fastjson.JSON;
import com.aliyun.fc.runtime.Context;
import com.aliyun.fc.runtime.PojoRequestHandler;
import com.qztc.fun.dto.DescriptionDTO;
import com.qztc.fun.service.TaskService;

/**
 * 函数计算-任务拆分
 *
 * @author jiacheng.chen
 */
public class DistributeTask implements PojoRequestHandler<DescriptionDTO, String> {
    TaskService taskService = new TaskService();

    @Override
    public String handleRequest(DescriptionDTO description, Context context) {

        // 2.任务拆分、发送消息到MNS
        taskService.saveManyTaskBatch(JSON.toJSONString(description));
        context.getLogger().info("description = " + description);
        return "success distribute task";
    }

}