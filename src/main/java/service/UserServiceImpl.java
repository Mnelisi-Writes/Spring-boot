package service;

import repo.FakeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final FakeRepo fakeRepo;

    @Autowired
    public UserServiceImpl(FakeRepo fakeRepo) {
        this.fakeRepo = fakeRepo;
    }

    @Override
    public String addUser(String name, String surname) {
        long id = (long) (Math.random() * 1000); // Simple ID generation
        fakeRepo.insertUser(id, name, surname);
        return name + " added";
    }

    @Override
    public String removeUser(long id) {
        return fakeRepo.deleteUser(id) + " removed";
    }

    @Override
    public String getUser(long id) {
        String user = fakeRepo.findUserById(id);
        return "Hello " + user;
    }
}
