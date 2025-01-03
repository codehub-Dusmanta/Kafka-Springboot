# Kafka-Springboot


1. to start the zookeeper

zookeeper-server-start.bat ..\..\config\zookeeper.properties


8183247962

2. start the broker

kafka-server-start.bat ..\..\config\server.properties


3.Create the topic 

C:\kafka_2.13-3.9.0\bin\windows>
kafka-topics.bat --create --topic my-topics --bootstrap-server localhost:9092 --replication-factor 1 --partitions 3
Created topic my-topics.


4. Start the producer 

C:\kafka_2.13-3.9.0\bin\windows>
kafka-console-producer.bat --broker-list localhost:9092 --topic my-topic


5. start the consumer

C:\kafka_2.13-3.9.0\bin\windows>
kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic my-topic --from-beginning


kafka-console-consumer.bat --topic kafkaTopic1_json quickstart-events --from-beginning --bootstrap-server localhost:9092

http://localhost:8080/a/v1/kafka/publish?message=hello


CREATE TABLE employees_details (
    id SERIAL PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    email VARCHAR(100) NOT NULL,
    salary NUMERIC(10, 2) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL
);
