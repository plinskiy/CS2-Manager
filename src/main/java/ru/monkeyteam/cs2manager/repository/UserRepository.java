package ru.monkeyteam.cs2manager.repository;

import org.springframework.data.repository.CrudRepository;
import ru.monkeyteam.cs2manager.domain.User;

public interface UserRepository extends CrudRepository<User, Long> { }
