package com.thevirtualx.mvcApp.Storage;
import com.thevirtualx.mvcApp.Entity.Chatroom;
import com.thevirtualx.mvcApp.Repo.ChatroomRepository;
import org.springframework.stereotype.Service;

@Service
public class ChatroomStorage {
    private ChatroomRepository chatroomRepo;
    public ChatroomStorage (ChatroomRepository chatroomRepo){
        this.chatroomRepo = chatroomRepo;
    }
    public void addChatroom(Chatroom chatroomToAdd) {
        chatroomRepo.save(chatroomToAdd);
    }
    public Chatroom retrieveChatroomById(Long id) { return chatroomRepo.findById(id).get();}

    public Iterable<Chatroom> retrieveAll(){
        return chatroomRepo.findAll();
    }
    public void deleteChatroomById(Long id) {chatroomRepo.deleteById(id);}
}
