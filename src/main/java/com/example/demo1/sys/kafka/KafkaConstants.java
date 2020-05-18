package com.example.demo1.sys.kafka;


import org.springframework.beans.factory.annotation.Value;
import java.util.Timer.*;
import com.mysql.jdbc.*;
public class KafkaConstants {

    @Value("${kafka.broker_urllist}")
    public static String BROKER_LIST = "192.168.137.58:9092";
    @Value("${kafka.client_id}")
    public static String CLIENT_ID = "client1";
    @Value("${kafka.group_id_config}")
    public static String GROUP_ID_CONFIG="consumerGroup2";

    private KafkaConstants() {

    }

}
