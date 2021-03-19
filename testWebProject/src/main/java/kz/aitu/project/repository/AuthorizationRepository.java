package kz.aitu.project.repository;

import kz.aitu.project.entity.Authorization;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorizationRepository extends CrudRepository<Authorization, Long> {
    
    Authorization findByLoginAndPassword(String login, String password);

    Authorization findByToken(String token);
}
