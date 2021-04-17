package com.thevirtualx.mvcApp.Storage;

import com.thevirtualx.mvcApp.Entity.Challenge;
import com.thevirtualx.mvcApp.Repo.ChallengeRepository;
import org.springframework.stereotype.Service;

@Service
public class ChallengeStorage {
    private ChallengeRepository challengeRepo;
    public ChallengeStorage (ChallengeRepository challengeRepo) {
        this.challengeRepo = challengeRepo;
    }
    public void addChallenge(Challenge challengeToAdd) {challengeRepo.save(challengeToAdd);}
    public Challenge retrieveChallengeById(Long id) {return challengeRepo.findById(id).get();}
    public void deleteChallengeById(Long id) {challengeRepo.deleteById(id);}
    public Iterable<Challenge> getAllChallenges() {
        return challengeRepo.findAll();
    }
}
