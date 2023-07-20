from confluent_kafka import Consumer, KafkaException, KafkaError
import json 
import random
from confluent_kafka import Producer
import socket


confp = {'bootstrap.servers': "localhost:9092",
        'client.id': socket.gethostname()}

producer = Producer(confp)

confc = {'bootstrap.servers': "localhost:9092",
        'group.id': "foo",
        'auto.offset.reset': 'smallest'}

consumer = Consumer(confc)


running = True

def send_Callback(err,msg):
    if err is not None:
        print(f"message delivery failed {err}")
    else:
         print(f"{msg.topic()}, {msg.key()}, {msg.value()}")

def basic_consume_loop(consumer, topic):
    try:
        consumer.subscribe(topic)

        while running:
            msg = consumer.poll(timeout=1.0)

            if msg is None:
                continue
    
            if msg.error():
                if msg.error().code() == KafkaError._PARTITION_EOF:
                    # End of partition event
                    print('%% %s [%d] reached end at offset %d\n' %
                                     (msg.topic(), msg.partition(), msg.offset()))
                elif msg.error():
                    raise KafkaException(msg.error())
            else:
                #Consume cyle

                #get message value and add age 
                NeWmsg = json.loads(msg.value().decode('utf-8'))
                NeWmsg["Age"]= random.randint(14,80)
                #print(f"User: {msg.key().decode('utf-8')}, {msg.value().decode('utf-8')}")
                
                #Produce cycle
                NeWmsg = json.dumps(NeWmsg).encode('utf-8')
                producer.produce("newUsers", key=msg.key(), value= NeWmsg, on_delivery=send_Callback)
                # Wait up to 1 second for events.
                producer.poll(1.0)

    except KeyboardInterrupt:
        print("stopped")
    finally:
        consumer.close()
        producer.flush()


def shutdown():
    running = False


if __name__ == "__main__":
    topic = ["users"]
    basic_consume_loop(consumer,topic)
    shutdown()
