package novikava.service.impl;

import novikava.entity.AcademicDegreeEntity;
import novikava.entity.TeacherEntity;
import novikava.entity.UsersEntity;
import novikava.repository.AcademicDegreeRepository;
import novikava.repository.UsersRepository;
import novikava.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UsersRepository usersRepository;


    @Override
    public UsersEntity findByEmail(String email) {
        return usersRepository.findByEmail(email);
    }

    @Override
    public UsersEntity findUserById(Integer id) {
        return usersRepository.findUsersById(id);
    }

    //    @Override
//    public Optional<UsersEntity> findByUsername(String username) {
//        return usersRepository.findByUsername(username);
//    }
//
    @Override
    public List<UsersEntity> findAll() {
        return usersRepository.findAll();
    }

    @Override
    public Boolean existsByEmail(String email) {
        return usersRepository.existsByEmail(email);
    }

    @Override
    public UsersEntity save(UsersEntity usersEntity) {
        return usersRepository.save(usersEntity);
    }

    @Override
    public void delete(UsersEntity usersEntity) {
        usersRepository.delete(usersEntity);
    }

    @Override
    public void deleteById(Integer id) {
        usersRepository.deleteById(id);
    }
}
