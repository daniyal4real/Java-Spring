package kz.aitu.project.service;


import kz.aitu.project.entity.Authorization;
import kz.aitu.project.repository.AuthorizationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class AuthorizationService {

    private final AuthorizationRepository authorizationRepository;

    @Transactional
    public Authorization login(Authorization authorization) throws Exception {
        Authorization authorizationRequest = authorizationRepository.findByLoginAndPassword(authorization.getLogin(), authorization.getPassword());
        if (authorizationRequest == null){
            throw new Exception();
        }
        String token = UUID.randomUUID().toString();
        authorizationRequest.setToken(token);
        return authorizationRepository.save(authorizationRequest);
    }

    public Authorization getAuthByToken(String token) {
        return authorizationRepository.findByToken(token);
    }

    public Authorization loginFactory(Authorization authorization) throws Exception {
        Authorization authorizationRequest = authorizationRepository.findByLoginAndPassword(authorization.getLogin(), authorization.getPassword());
        if(authorizationRequest == null || !((authorization.getLogin().equals("admin"))&&(authorization.getPassword().equals("admin")))){
            throw new Exception();
        }
        String token = UUID.randomUUID().toString();
        authorizationRequest.setToken(token);
        return authorizationRepository.save(authorizationRequest);
    }
}
