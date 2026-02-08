package com.mathesh.book_store.util;

import com.mathesh.book_store.entity.Role;
import com.mathesh.book_store.entity.User;
import com.mathesh.book_store.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class DataLoader implements CommandLineRunner {

    private final UserRepository repo;
    private final PasswordEncoder encoder;

    public DataLoader(UserRepository repo, PasswordEncoder encoder) {
        this.repo = repo;
        this.encoder = encoder;
    }

    @Override
    public void run(String... args) {
        // Create ADMIN if not exists
        if (repo.findByUsername("admin").isEmpty()) {
            User admin = new User();
            admin.setUsername("admin");
            admin.setPassword(encoder.encode("admin123"));
            admin.setRoles(Set.of(Role.ROLE_ADMIN));
            repo.save(admin);
            System.out.println(" Admin user created: admin/admin123");
        } else {
            System.out.println(" Admin user already exists");
        }

        // Create normal USER if not exists
        if (repo.findByUsername("user").isEmpty()) {
            User user = new User();
            user.setUsername("user");
            user.setPassword(encoder.encode("user123"));
            user.setRoles(Set.of(Role.ROLE_USER));
            repo.save(user);
            System.out.println(" Normal user created: user/user123");
        } else {
            System.out.println(" Normal user already exists");
        }
    }
}
