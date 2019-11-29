# sprring-rabbitmq-kafka

Spring messaging  example project using Kafka or RabbitMQ, based on RabbitMQ quick starter examples.

## How to run Kafka example

### 1. Configure hosts file of OS (/etc/hosts):

Add these hosts:
```
127.0.0.1 zookeeper
127.0.0.1 kafka1
127.0.0.1 kafka2
127.0.0.1 kafka3
```

### Execute Kafka Cluster

```docker-compose -f src/main/docker/kafka-cluster.yml up -d```

### Create hello topic

```
docker-compose -f src/main/docker/kafka-cluster.yml exec -T kafka1 \
 kafka-topics --create --zookeeper zookeeper:2181 --topic hello --replication-factor 3 --partitions 3
```

### Execute Spring Boot applications:
* KafkaReceiverApplication: A consumer application
* KafkaMessageSender: Producer application 


