package com.example.server;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;

@Configuration
@EnableWebSocketMessageBroker



//==============================================================================
//                             WebSocket Server Config
//==============================================================================




public class WebSocket implements WebSocketMessageBrokerConfigurer {


    
    //==============================================================================
    //                            Origin allowed
    //==============================================================================



    @Override public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/ws").setAllowedOrigins("http://localhost:4200")
                            .setAllowedOriginPatterns("http://localhost:4201").withSockJS();
    }


    
//==============================================================================
//                                  Mount Point
//==============================================================================



    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.enableSimpleBroker("/topic");
        registry.setApplicationDestinationPrefixes("/app");
    }
 

    
}