package org.revo;

import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.ChannelInterceptorAdapter;

/**
 * Created by ashraf on 8/1/2015.
 */
public class MyChannelInterceptor extends ChannelInterceptorAdapter {


    @Override
    public Message<?> preSend(Message<?> message, MessageChannel channel) {
        System.out.println(message);
        return super.preSend(message, channel);
    }
}
