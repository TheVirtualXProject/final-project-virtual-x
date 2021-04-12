package com.thevirtualx.mvcApp.Repo;

import com.thevirtualx.mvcApp.Entity.Chatroom;
import org.springframework.data.repository.CrudRepository;

public interface ChatroomRepository extends CrudRepository<Chatroom, Long> {
}
