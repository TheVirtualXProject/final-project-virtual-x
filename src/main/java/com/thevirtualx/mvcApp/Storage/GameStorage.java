package com.thevirtualx.mvcApp.Storage;
import com.thevirtualx.mvcApp.Entity.Game;
import com.thevirtualx.mvcApp.Repo.GameRepository;
import org.springframework.stereotype.Service;

@Service
public class GameStorage {
    private GameRepository gameRepo;
    public GameStorage (GameRepository gameRepo){
        this.gameRepo = gameRepo;
    }
    public Game retrieveGameById(Long id) {return gameRepo.findById(id).get();}
    public void addGame(Game gameToAdd) {gameRepo.save(gameToAdd);}
    public void deleteGameById(Long id) {gameRepo.deleteById(id);}
    public Iterable<Game> getAllGames() {
        return gameRepo.findAll();
    }
}
