# java-example



exchange distribute message to queue: phân phối message vào queue 
based on message routing key : dựa trên routing key
exchange : fanout, direct, topic
	
fanout: Multiple queues for single message: nhiều queues cho 1 message
        Broadcast to all queues bound to it : phát cho tất cả queue nó liết kết
	
direct: send to selective queue: Gửi đến hàng đợi chọn lọc (sử dụng điều kiện để distribute message to queue)
        based on routing key: dựa trên routing key
        message can be discarded:  tin nhắn có thể bị loại bỏ
