package com.dm.kafka.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {
    @Bean
    public NewTopic javaTopic(){
        return TopicBuilder.name("kafkaTopic1").build();
    }

    @Bean
    public NewTopic javaTopicJson(){
        return TopicBuilder.name("kafkaTopic1_json").build();
    }



}
