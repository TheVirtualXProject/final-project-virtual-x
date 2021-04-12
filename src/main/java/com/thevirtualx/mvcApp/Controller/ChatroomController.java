package com.thevirtualx.mvcApp.Controller;

import com.thevirtualx.mvcApp.Storage.ChatroomStorage;
import org.springframework.stereotype.Controller;

@Controller
public class ChatroomController {

    private ChatroomStorage chatroomStorage;

    public ChatroomController (ChatroomStorage chatroomStorage) {
        this.chatroomStorage = chatroomStorage;
    }
}
