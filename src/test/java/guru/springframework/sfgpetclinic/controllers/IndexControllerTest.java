package guru.springframework.sfgpetclinic.controllers;

import guru.springframework.sfgpetclinic.ControllerTests;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.*;


import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;


class IndexControllerTest implements ControllerTests {

    IndexController controller;

    @BeforeEach
    void setUp() {
        controller = new IndexController();
    }

    @DisplayName("Test Proper View name is returned for index page")
    @Test
    void index() {
        assertEquals("index", controller.index());
        assertEquals("index", controller.index(), "Wrong View Returned");

        assertEquals("index", controller.index(), () -> "Another Expensive Message " +
                "Make me only if you have to");

        Assertions.assertThat(controller.index()).isEqualTo("index");
    }

    @Test
    @DisplayName("Test exception")
    void oupsHandler() {
        assertThrows( ValueNotFoundException.class, () -> {
            controller.oopsHandler();
        });
    }

    @Disabled("Demo of timeout")
    @Test
    void testTimeOut() {
        assertTimeout(Duration.ofMillis(100), () -> {
            Thread.sleep(5000);
            System.out.println("I got Here");
        });
    }

    @Disabled("Demo of timeout")
    @Test
    void testTimeOutPrempt() {
        assertTimeoutPreemptively(Duration.ofMillis(100), () -> {
            Thread.sleep(5000);
            System.out.println("I got Here Prempt");
        });
    }

    @Test
    void testAssumptionTrue() {
        assumeTrue("GURU".equalsIgnoreCase(System.getenv("GURU_RUNTIME")));
    }

    @Test
    void testAssumptionTrueAssumptionIsTrue() {
        assumeTrue("GURU".equalsIgnoreCase("GURU"));
    }

    @Test
    @EnabledOnOs(OS.MAC)
    void testMeOnMacOs(){

    }

    @EnabledOnOs(OS.WINDOWS)
    @Test
    void testMeOnWindows(){

    }

    @EnabledOnJre(JRE.JAVA_8)
    @Test
    void testMeOnJava8(){

    }

    @EnabledOnJre(JRE.JAVA_11)
    @Test
    void testMeOnJava11(){

    }

    @EnabledIfEnvironmentVariable(named = "USER", matches = "jt")
    @Test
    void testMeIfUserJT(){

    }

    @EnabledIfEnvironmentVariable(named = "USER", matches = "fred")
    @Test
    void testMeIfUserFred(){

    }
}