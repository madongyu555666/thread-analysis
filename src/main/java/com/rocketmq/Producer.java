package com.rocketmq;

import com.alibaba.fastjson.JSON;
import com.alibaba.rocketmq.client.exception.MQClientException;
import com.alibaba.rocketmq.client.producer.DefaultMQProducer;
import com.alibaba.rocketmq.client.producer.SendResult;
import com.alibaba.rocketmq.common.message.Message;

public class Producer {
    public static void main(String[] args) throws MQClientException, InterruptedException {
        //在控制台查询生产者实例时会用到，对消息的发送没有直接影响
        DefaultMQProducer producer = new DefaultMQProducer("ConsumerGroupName");
        // 建议唯一，比如包含进程的pid
        producer.setInstanceName("PSConsumerGroupName");
        producer.setNamesrvAddr("10.112.178.137:9876;10.112.178.138:9876");
        producer.start();
        try {
            PSUser psUser=new PSUser();
            psUser.setUSERKEY("00009000");
            psUser.setPHONE("18611706666");
            String toJSONString = JSON.toJSONString(psUser);
            Message msg = new Message("HrStaff",// topic
                    "phone",// tag
                    "10316306",// key
                    toJSONString.getBytes());// body
            SendResult sendResult = producer.send(msg);
            System.out.println(sendResult);
        } catch (Exception e) {
            e.printStackTrace();
        }
        producer.shutdown();
    }
}
