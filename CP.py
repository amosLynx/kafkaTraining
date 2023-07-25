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

SINK_TOPIC = "newUsers"
SOURCE_TOPIC = ["users"]

#Handle producer Errors
def send_Callback(err,msg):
    if err is not None:
        print(f"message delivery failed {err}")
    else:
         print(f"{msg.topic()}, {msg.key()}, {msg.value()}")

def basic_consume_loop(consumer):
    try:
        consumer.subscribe(SOURCE_TOPIC)

        while True:
            msg = consumer.poll(timeout=1.0) #keep polling for new messages

            if msg is None:
                continue #skip iteration if message is empty
    
            if msg.error():
                if msg.error().code() == KafkaError._PARTITION_EOF:
                    # End of partition event
                    print('%% %s [%d] reached end at offset %d\n' %
                                     (msg.topic(), msg.partition(), msg.offset()))
                    continue #skip this iteration in case of error

                elif msg.error():
                    raise KafkaException(msg.error()) #raise exception and exit
                    
            #Consume cyle

            #get message value and add age 
            newMsg = json.loads(msg.value().decode('utf-8'))
            newMsg["Age"]= random.randint(14,80)
            
            #Produce cycle
            newMsg = json.dumps(newMsg).encode('utf-8')
            producer.produce(SINK_TOPIC, key=msg.key(), value= newMsg, on_delivery=send_Callback)
            # Wait up to 1 second for events.
            producer.poll(1.0)

    except KeyboardInterrupt:
        print("stopped")
    finally:
        consumer.close()
        producer.flush()


if __name__ == "__main__":
    basic_consume_loop(consumer)
