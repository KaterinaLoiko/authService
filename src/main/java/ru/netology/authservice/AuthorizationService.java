package ru.netology.authservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ru.netology.authservice.errors.InvalidCredentials;
import ru.netology.authservice.errors.UnauthorizedUser;

import java.util.List;

@Service
public class AuthorizationService {

    @Autowired
    UserRepository userRepository;

    List<Authorities> getAuthorities(String user, String password) {
        try {
            if (isEmpty(user) || isEmpty(password)) {
                throw new InvalidCredentials("User name or password is empty");
            }
            List<Authorities> userAuthorities = userRepository.getUserAuthorities(user, password);
            if (isEmpty(userAuthorities)) {
                throw new UnauthorizedUser("Unknown user " + user);
            }
            return userAuthorities;
        } catch (UnauthorizedUser ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage());
        } catch (InvalidCredentials invalidCredentialsEx) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, invalidCredentialsEx.getMessage());
        }
    }

    private boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

    private boolean isEmpty(List<?> str) {
        return str == null || str.isEmpty();
    }
}
