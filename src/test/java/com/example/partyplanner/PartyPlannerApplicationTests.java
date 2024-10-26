package com.example.partyplanner;

import com.example.partyplanner.model.User;
import com.example.partyplanner.repository.UserRepository;
import com.example.partyplanner.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PartyPlannerApplicationTests {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    private User testUser;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        testUser = new User();
        testUser.setId(1L); // This line requires the setId method to be defined in User
        testUser.setFullName("John Doe");
        testUser.setEmail("john.doe@example.com");
        testUser.setPhoneNumber("1234567890");
    }

    @Test
    void testCreateUser() {
        when(userRepository.save(testUser)).thenReturn(testUser);
        User createdUser = userService.createUser(testUser);
        assertEquals(testUser.getFullName(), createdUser.getFullName());
        verify(userRepository, times(1)).save(testUser);
    }

    @Test
    void testFindUserById() {
        when(userRepository.findById(1L)).thenReturn(Optional.of(testUser));
        User foundUser = userService.findById(1L);
        assertEquals(testUser.getFullName(), foundUser.getFullName());
        verify(userRepository, times(1)).findById(1L);
    }

    @Test
    void testUserNotFound() {
        when(userRepository.findById(1L)).thenReturn(Optional.empty());
        assertThrows(RuntimeException.class, () -> userService.findById(1L));
        verify(userRepository, times(1)).findById(1L);
    }
}
