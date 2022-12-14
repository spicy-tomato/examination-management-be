package com.example.ems.user.service.crud.memory;

import com.example.ems.user.service.crud.api.UserCrudService;
import com.example.ems.user.entity.User;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@Service
final
class InMemoryUsers implements UserCrudService {
    final Map<String, User> users = new HashMap<>();

    @Override
    public
    User save(final User user) {
        return users.put(user.getId(), user);
    }

    @Override
    public
    Optional<User> find(final String id) {
        return Optional.ofNullable(users.get(id));
    }

    @Override
    public
    Optional<User> findByUsername(final String username) {
        return users.values()
                    .stream()
                    .filter(u -> Objects.equals(username, u.getUsername()))
                    .findFirst();
    }


}
