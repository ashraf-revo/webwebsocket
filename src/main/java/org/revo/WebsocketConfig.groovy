package org.revo

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.messaging.simp.config.ChannelRegistration
import org.springframework.messaging.simp.config.MessageBrokerRegistry
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker
import org.springframework.web.socket.config.annotation.StompEndpointRegistry

/**
 * Created by revo on 4/26/16.
 */
@Configuration
@EnableWebSocketMessageBroker
class WebsocketConfig extends AbstractWebSocketMessageBrokerConfigurer {
    @Bean
    public MyChannelInterceptor myChannelInterceptor() {
        return new MyChannelInterceptor();
    }

    @Override
    public void configureClientInboundChannel(ChannelRegistration registration) {
        registration.setInterceptors(myChannelInterceptor());
    }

    @Override
    void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/hello").withSockJS()
    }

    @Override
    void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.setApplicationDestinationPrefixes("/app")
        registry.setUserDestinationPrefix("/topic")
    }
}
