package game;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @Test
    void assert_that_a_new_Play_is_created_successfully(){
        //Arrange
        Player p = new Player("Philipp", "P");

        //Assert
        assertEquals("Philipp", p.getName());
        assertEquals("P", p.getSymbol());
    }

    @Test
    void assert_that_set_Symbol_does_not_set_when_null_empty_or_blank(){
        //Arrange
        IllegalArgumentException exception1 = assertThrows(IllegalArgumentException.class, () ->
                new Player("Philipp", null));

        IllegalArgumentException exception2 = assertThrows(IllegalArgumentException.class, () ->
                new Player("Philipp", ""));

        IllegalArgumentException exception3 = assertThrows(IllegalArgumentException.class, () ->
                new Player("Philipp", "     "));

        //Assert
        assertEquals("The Symbol can neither be null, empty or blank", exception1.getMessage());
        assertEquals("The Symbol can neither be null, empty or blank", exception2.getMessage());
        assertEquals("The Symbol can neither be null, empty or blank", exception3.getMessage());
    }

    @Test
    void assert_that_Symbol_is_only_one_Character_long(){
        //Arrange
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                new Player("Philipp", "AB"));

        //Assert
        assertEquals("The Symbol can only consist of 1 Character", exception.getMessage());
    }

    @Test
    void assert_that_Symbols_are_always_UpperCase(){
        //Arrange
        Player p = new Player("Philipp", "p");

        //Assert
        assertEquals("P", p.getSymbol());
    }

}