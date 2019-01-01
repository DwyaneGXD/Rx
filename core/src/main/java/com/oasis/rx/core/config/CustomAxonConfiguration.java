package com.oasis.rx.core.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import lombok.AllArgsConstructor;
import lombok.val;
import org.axonframework.eventhandling.saga.repository.SagaStore;
import org.axonframework.eventsourcing.eventstore.EventStorageEngine;
import org.axonframework.mongo.eventhandling.saga.repository.MongoSagaStore;
import org.axonframework.mongo.eventsourcing.eventstore.DefaultMongoTemplate;
import org.axonframework.mongo.eventsourcing.eventstore.MongoEventStorageEngine;
import org.axonframework.mongo.eventsourcing.eventstore.MongoTemplate;
import org.axonframework.mongo.eventsourcing.eventstore.documentperevent.DocumentPerEventStorageStrategy;
import org.axonframework.serialization.Serializer;
import org.axonframework.serialization.json.JacksonSerializer;
import org.axonframework.spring.eventsourcing.SpringAggregateSnapshotterFactoryBean;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
@ImportAutoConfiguration(classes = {RxRabbitConfiguration.class})
@AllArgsConstructor
public class CustomAxonConfiguration
{
  private final MongoProperties properties;

  @Bean
  public JacksonSerializer axonJsonSerializer(final ObjectMapper mapper)
  {
    return new JacksonSerializer(mapper);
  }

  @Bean
  public EventStorageEngine eventStorageEngine(final Serializer serializer, final MongoTemplate mongoTemplate)
  {
    return new MongoEventStorageEngine(serializer, null, mongoTemplate, new DocumentPerEventStorageStrategy());
  }

  @Bean
  public MongoTemplate axonMongoTemplate(final MongoClient mongoClient)
  {
    return new DefaultMongoTemplate(mongoClient, properties.getDatabase(), "events", "snapshots");
  }

  @Bean
  public MongoClient mongoClient()
  {
    val uri = new StringBuilder()
                .append("mongodb://")
                .append(properties.getHost()).append(":")
                .append(properties.getPort()).append("/")
                .append(properties.getDatabase()).toString();
    val clientUri = new MongoClientURI(uri);
    return new MongoClient(clientUri);
  }

  @Bean
  public SpringAggregateSnapshotterFactoryBean snapshotterFactoryBean()
  {
    return new SpringAggregateSnapshotterFactoryBean();
  }

  @Bean
  public SagaStore sagaStore(final MongoClient mongoClient, final Serializer serializer)
  {
    val template = new org.axonframework.mongo.eventhandling.saga.repository.DefaultMongoTemplate(mongoClient, properties.getDatabase(), "sagas");

    return new MongoSagaStore(template, serializer);
  }

  @Bean
  public RestTemplate restTemplate()
  {
    return new RestTemplate();
  }
}
