package com.javatechie.rabbitmq.demo.publisher;

import com.javatechie.rabbitmq.demo.config.MessagingConfig;
import com.javatechie.rabbitmq.demo.dto.Order;
import com.javatechie.rabbitmq.demo.dto.OrderStatus;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.retry.annotation.Retryable;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@RestController
@RequestMapping("/order/service/")
public class OrderPublisher {

    @Autowired
    private RabbitTemplate template;
    
    @Autowired
    RestTemplate restTemplate;
    
    Logger logger = LoggerFactory.getLogger(OrderPublisher.class);

    @PostMapping("/{restaurantName}")
//    @Retryable(maxAttempts = 3)
    public ResponseEntity<String> bookOrder(@RequestBody Order order, @PathVariable String restaurantName) {
        order.setOrderId(UUID.randomUUID().toString());
        OrderStatus orderStatus = new OrderStatus(order, "PROCESS", "order placed succesfully in " + restaurantName);
        String status = null;
        try {
            status = restTemplateCall(order, restaurantName);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
        if (status != null) {
			logger.info("Your order is received  "+HttpStatus.OK);
			return new ResponseEntity<String>("Your order is received ", HttpStatus.OK);
		}else {
			logger.error("Order Failed service unavailable : ", HttpStatus.INTERNAL_SERVER_ERROR);
			logger.error("Message added to the Backout Queue");
	        template.convertAndSend(MessagingConfig.EXCHANGE, MessagingConfig.ROUTING_KEY, orderStatus);
	        
	        return new ResponseEntity<String>("Order Failed ", HttpStatus.INTERNAL_SERVER_ERROR);  
		}
             
        
    }
    
    @Retryable(maxAttempts = 3)
    public String restTemplateCall(Order order, String restaurantName) {
    	String status = null;
    	int attempt = 1;
    	  status = restTemplate.postForObject("http://localhost:9292/order/"+restaurantName, order, String.class);
    		  logger.info(" call to publisher service  : "+"http://localhost:9292/order/"+restaurantName);
		return status;	
    }
    
	@RabbitListener(queues = MessagingConfig.QUEUE)
    public void consumeMessageFromQueue(OrderStatus orderStatus) {
        System.out.println("Message recieved from Backout-Queue : " + orderStatus);
    }
}
