package com.priya.service.imp;

import com.priya.exception.UserException;
import com.priya.model.User;
import com.priya.repository.UserRepository;
import com.priya.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceimpl implements UserService {

    private final UserRepository userRepository ;

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUserById(Long id) throws UserException {
        Optional<User> opt = userRepository.findById(id);
        if(opt.isPresent()){
            return opt.get();
        }
        throw new UserException("User not found");
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void deleteUser(Long id) throws UserException {
        Optional<User> opt = userRepository.findById(id);
        if(opt.isEmpty()){
            throw new UserException("User not exist with id: " + id);
        }
        userRepository.deleteById(id);
    }

    @Override
    public User updateUser(Long id, User user) throws UserException {
        Optional<User> opt = userRepository.findById(id);
        if(opt.isEmpty()){
            throw new UserException("User not found with id: " + id);
        }
        User existingUser = opt.get();

        existingUser.setFullName(user.getFullName());
        existingUser.setEmail(user.getEmail());
        existingUser.setRole(user.getRole());
        existingUser.setUsername(user.getUsername());

        return userRepository.save(existingUser);
    }
}
