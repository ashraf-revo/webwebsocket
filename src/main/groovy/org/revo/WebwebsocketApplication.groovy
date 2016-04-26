package org.revo

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.event.EventListener
import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.messaging.handler.annotation.SendTo
import org.springframework.messaging.simp.SimpMessageHeaderAccessor
import org.springframework.messaging.simp.SimpMessagingTemplate
import org.springframework.stereotype.Component
import org.springframework.stereotype.Controller
import org.springframework.web.socket.messaging.SessionConnectEvent

@SpringBootApplication
class WebwebsocketApplication {

    static void main(String[] args) {
        SpringApplication.run WebwebsocketApplication, args
    }
}

@Controller
class Main {
    @Autowired
    SimpMessagingTemplate template

    @MessageMapping("/hello")
    void message(Message message) {
        println message.content
    }
}

class Message {
    String content
}

