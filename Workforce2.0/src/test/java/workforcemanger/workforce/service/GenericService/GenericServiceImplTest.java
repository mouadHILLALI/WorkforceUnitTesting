package workforcemanger.workforce.service.GenericService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GenericServiceImplTest {

    @BeforeEach
    void setUp() {
        System.out.println("Inside setUp method");
    }

    @Test
    void exampleTest() {
        assertEquals(1, 1, "Values should be equal");
    }
}
