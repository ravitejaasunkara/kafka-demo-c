defaualt ports
zookeeper - 2181
kafka - 9092
default partitions in a topic - 1
replication factor - 1

.\bin\windows\kafka-topics.bat --bootstrap-server localhost:9092 --list

 .\bin\windows\kafka-console-producer.bat --broker-list localhost:9092 --topic ravitopic1

https://github.com/basanta-spring-boot/documents/blob/main/README.md

consumer rebalancing

2 partitions - only 2 consumers will consume	
