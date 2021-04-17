package com.thevirtualx.mvcApp.Controller;

import com.thevirtualx.mvcApp.Entity.Chatroom;
import com.thevirtualx.mvcApp.Storage.ChatroomStorage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.security.Principal;

@Controller
public class ChatroomController {

    private ChatroomStorage chatroomStorage;

    public ChatroomController (ChatroomStorage chatroomStorage) {
        this.chatroomStorage = chatroomStorage;
    }


    @GetMapping("/chat")
    public String displayChatroomPage() {
        return  "chatRoom";
    }

    @GetMapping("/chat/{chatId}")
    public String displaySingleChatroom(@PathVariable Long chatId, Model model, Principal principal) {
        String kiwiIRC = "https://kiwiirc.com/client/irc.kiwiirc.com/?nick=";
        Chatroom chatroom = chatroomStorage.retrieveChatroomById(chatId);
        kiwiIRC += principal.getName() + "?#";
        kiwiIRC += chatroom.getChannelName();

        model.addAttribute("src", kiwiIRC);
        model.addAttribute("channelName", chatroom.getChannelName());

        return "singleChatroom";
    }



}
