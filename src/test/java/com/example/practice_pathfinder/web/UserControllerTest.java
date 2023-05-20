package com.example.practice_pathfinder.web;

import com.example.practice_pathfinder.model.entity.UserEntity;
import com.example.practice_pathfinder.repository.UserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@SpringBootTest
@AutoConfigureMockMvc
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @AfterEach
    void tearDown() {

        userRepository.deleteAll();
    }

    @Test
    void testOpenRegisterForm() throws Exception {

        mockMvc
                .perform(get("/users/register"))
                .andExpect(status().isOk())
                .andExpect(view().name("register"));
    }

    private static final String TEST_USER_USERNAME = "pesho";
    private static final String TEST_USER_EMAIL = "pesho@example.com";
    private static final int TEST_USER_AGE = 22;

    @Test
    void testRegisterUser() throws Exception {

        mockMvc
                .perform(post("/users/register")
                        .param("username", TEST_USER_USERNAME)
                        .param("fullName", "Pesho Peshov")
                        .param("email", TEST_USER_EMAIL)
                        .param("age", String.valueOf(TEST_USER_AGE))
                        .param("password", "password")
                        .param("confirmPassword", "password")
                        .with(csrf())
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                )
                .andExpect(status().is3xxRedirection());

        Assertions.assertEquals(1, userRepository.count());

        Optional<UserEntity> newlyCreatedUserOpt = userRepository.findByUsername(TEST_USER_USERNAME);

        Assertions.assertTrue(newlyCreatedUserOpt.isPresent());

        UserEntity newlyCreatedUser = newlyCreatedUserOpt.get();

        Assertions.assertEquals(TEST_USER_USERNAME, newlyCreatedUser.getUsername());
        Assertions.assertEquals("Pesho Peshov", newlyCreatedUser.getFullName());
        Assertions.assertEquals(TEST_USER_EMAIL, newlyCreatedUser.getEmail());
        Assertions.assertEquals(TEST_USER_AGE, newlyCreatedUser.getAge());
        Assertions.assertTrue(passwordEncoder.matches("password", newlyCreatedUser.getPassword()));
    }
}