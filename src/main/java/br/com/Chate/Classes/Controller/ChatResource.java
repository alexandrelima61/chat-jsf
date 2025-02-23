/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.Chate.Classes.Controller;

import br.com.Chate.Classes.Message;
import br.com.Chate.Classes.MessageDecoder;
import br.com.Chate.Classes.MessageEncoder;
import javax.inject.Inject;
import javax.servlet.ServletContext;
import org.primefaces.push.EventBus;
import org.primefaces.push.RemoteEndpoint;
import org.primefaces.push.annotation.OnClose;
import org.primefaces.push.annotation.OnMessage;
import org.primefaces.push.annotation.OnOpen;
import org.primefaces.push.annotation.PathParam;
import org.primefaces.push.annotation.PushEndpoint;
import org.primefaces.push.annotation.Singleton;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@PushEndpoint("/{room}/{user}")
@Singleton
public class ChatResource {

    private final Logger logger = LoggerFactory.getLogger(ChatResource.class);

    @PathParam("room")
    private String room;

    @PathParam("user")
    private String username;

    @Inject
    private ServletContext ctx;

    @OnOpen
    public void onOpen(RemoteEndpoint r, EventBus eventBus) {
        logger.info("OnOpen {}", r);

        eventBus.publish(room + "/*", new Message(String.format("%s Entrou no chat ", username, room), true));
    }

    @OnClose
    public void onClose(RemoteEndpoint r, EventBus eventBus) {
        ChatUsers users = (ChatUsers) ctx.getAttribute("chatUsers");
        users.remove(username);

        eventBus.publish(room + "/*", new Message(String.format("%s Saiu no chat", username), true));

    }

    @OnMessage(decoders = {MessageDecoder.class}, encoders = {MessageEncoder.class})
    public Message onMessage(Message message) {
        return message;
    }
}
