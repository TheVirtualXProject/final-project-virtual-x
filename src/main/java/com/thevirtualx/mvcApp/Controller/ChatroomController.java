package com.thevirtualx.mvcApp.Controller;

import com.thevirtualx.mvcApp.Storage.ChatroomStorage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

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



}
