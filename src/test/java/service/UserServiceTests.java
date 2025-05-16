package service;

import repo.FakeRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class UserServiceTests {

    @Mock
    private FakeRepo fakeRepo;

    @InjectMocks
    private UserServiceImpl userService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAddUser() {
        // Arrange
        String name = "John";
        String surname = "Doe";
        when(fakeRepo.insertUser(anyLong(), eq(name), eq(surname))).thenReturn(name + " added");

        // Act
        String result = userService.addUser(name, surname);

        // Assert
        assertEquals(name + " added", result);
        verify(fakeRepo, times(1)).insertUser(anyLong(), eq(name), eq(surname));
    }

    @Test
    void testRemoveUser() {
        // Arrange
        long id = 123L;
        String name = "John";
        when(fakeRepo.deleteUser(id)).thenReturn(name);

        // Act
        String result = userService.removeUser(id);

        // Assert
        assertEquals(name + " removed", result);
        verify(fakeRepo, times(1)).deleteUser(id);
    }

    @Test
    void testGetUser() {
        // Arrange
        long id = 123L;
        String userInfo = "John Doe";
        when(fakeRepo.findUserById(id)).thenReturn(userInfo);

        // Act
        String result = userService.getUser(id);

        // Assert
        assertEquals("Hello " + userInfo, result);
        verify(fakeRepo, times(1)).findUserById(id);
    }
}
