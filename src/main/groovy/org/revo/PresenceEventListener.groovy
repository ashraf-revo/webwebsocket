package org.revo

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.event.EventListener
import org.springframework.messaging.simp.SimpMessagingTemplate
import org.springframework.stereotype.Component
import org.springframework.web.socket.messaging.SessionConnectEvent
import org.springframework.web.socket.messaging.SessionSubscribeEvent

/**
 * Created by revo on 4/24/16.
 */
@Component
class PresenceEventListener {
    @Autowired
    SimpMessagingTemplate simpMessagingTemplate

    @EventListener
    private void Connect(SessionConnectEvent event) {
        println event.message
    }


    @EventListener
    private void Subscribe(SessionSubscribeEvent event) {
    }
}
