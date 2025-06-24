package com.springboot;

import java.net.URI;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.launchdarkly.eventsource.EventHandler;
import com.launchdarkly.eventsource.EventSource;

@Service
public class WikimediaChangesProducer {
	
	@Value("${spring.kafka.topic.name}")
    private String topicName;

	private static final Logger LOGGER=LoggerFactory.getLogger(WikimediaChangesProducer.class);
	
	private KafkaTemplate<String, String> kafkaTemplate;

	//Constructor Based Injection
	public WikimediaChangesProducer(KafkaTemplate<String, String> kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
	}
	
	public void sendMessage() throws InterruptedException {
		
		//To read real time Stream Data from wikimedia,we have to use event source
		EventHandler eventHandler=new WikimediaChangesHandler(kafkaTemplate, topicName);
		
		//Adding the API of wikimedia to read the Data 
		String url="https://stream.wikimedia.org/v2/stream/recentchange";
		EventSource.Builder builder=new EventSource.Builder(eventHandler, URI.create(url));
		EventSource eventSource=builder.build();
		eventSource.start();
		
		//After 10min It should be Stopped
		TimeUnit.MINUTES.sleep(10);
	}
	
	
}
