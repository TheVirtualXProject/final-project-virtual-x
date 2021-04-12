package com.thevirtualx.mvcApp.Repo;

import com.thevirtualx.mvcApp.Entity.Game;
import org.springframework.data.repository.CrudRepository;

public interface GameRepository extends CrudRepository <Game, Long> {
}
