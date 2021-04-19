package com.thevirtualx.mvcApp.Controller;

import com.thevirtualx.mvcApp.Entity.Account;
import com.thevirtualx.mvcApp.Entity.Chatroom;
import com.thevirtualx.mvcApp.Storage.AccountStorage;
import com.thevirtualx.mvcApp.Storage.ChatroomStorage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;

@Controller
public class ChatroomController {

    private ChatroomStorage chatroomStorage;
    private AccountStorage accountStorage;

    public ChatroomController (ChatroomStorage chatroomStorage, AccountStorage accountStorage) {
        this.chatroomStorage = chatroomStorage;
        this.accountStorage = accountStorage;
    }


    @GetMapping("/chat")
    public String displayChatroomPage() {
        return  "chatRoom";
    }

    @PostMapping("/chat/addChat")
    public String createNewChatroom(String chatName, int maxSize, Principal principal, String desc) {
        Account author = accountStorage.retrieveAccountByUsername(principal.getName());
        Chatroom newChat = new Chatroom(chatName, author.getRealName(), maxSize, desc);
        newChat.addAccount(author);
        chatroomStorage.addChatroom(newChat);
        return "redirect:/chat/" + newChat.getId();
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


    @PostMapping("/chat/{id}/join-chatroom")
    public String joinChatroom(@PathVariable Long id, Principal principal) {
        Chatroom chatroom = chatroomStorage.retrieveChatroomById(id);
        Account account = accountStorage.retrieveAccountByUsername(principal.getName());
        if(!chatroom.getAccounts().contains(account)) {
            chatroom.addAccount(account);
            chatroomStorage.addChatroom(chatroom);
        }

        return "redirect:/api/chatrooms/" + chatroom.getId() + "/url";

    }




}
