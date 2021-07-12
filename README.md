# Rabbitmq



Exchange : exchange distribute message to queue (phân phối message vào queue), based on message routing key (dựa trên routing key), exchange type: fanout, direct, topic
	
Fanout: Multiple queues for single message (nhiều queues cho 1 message), Broadcast to all queues bound to it (phát cho tất cả queue nó liết kết)

	
Direct: send to selective queue:( Gửi đến hàng đợi chọn lọc (sử dụng routing key để distribute message to queue)), based on routing key (dựa trên routing key),  message can be discarded (tin nhắn có thể bị loại bỏ)
       
Topic: phụ thuộc vào routing pattern. 1 cái routing pattern (*. , # , ...) được binding với topic exchange và topic exchange bind queue nào đó, thì khi publish 1 message lên thì routing key phụ thuộc vào routing pattern. Ví dụ: routing pattern là “agreements.eu.berlin.#” matches với bất cứ routing keys bắt đầu với “agreements.eu.berlin”
