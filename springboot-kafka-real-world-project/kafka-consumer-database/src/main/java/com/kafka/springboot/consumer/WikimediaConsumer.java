package com.kafka.springboot.consumer;


import com.kafka.springboot.entiity.WikimediaData;
import com.kafka.springboot.repository.WikimediaDataRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class WikimediaConsumer {
    @Autowired
    private WikimediaDataRepository wikimediaDataRepository;
    private static final Logger LOGGER = LoggerFactory.getLogger(WikimediaConsumer.class);


    @KafkaListener(
            topics = "${spring.kafka.topic.name}",
            groupId = "${spring.kafka.consumer.group-id}"
    )
    //@KafkaListener(topics = "wikimedia_recentchange", groupId = "myGroup") //to listen the msg or event from the kafka
    public void consumeEvent(String eventMessage) {
        LOGGER.info(String.format("Event message received -> %s", eventMessage));
        WikimediaData wikimediaData = new WikimediaData();
        wikimediaData.setWikimediaEventData(eventMessage);
        wikimediaDataRepository.save(wikimediaData);
    }




}
