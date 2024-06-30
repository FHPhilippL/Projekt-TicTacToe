package game;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    @Test
    void assert_that_getField_returns_the_current_field(){
        //Arrange
        Board b = new Board();
        String[][] s = {{" ", "X", "O"}, {"X", "O", "X"}, {"O", " ", " "}};

        //Act
        b.setFieldTest();

        //Assert
        assertArrayEquals(s, b.getField());
    }

    @Test
    void assert_that_getMoveCounter_returns_the_current_moveCounter(){
        //Arrange
        Board b = new Board();

        //Act

        //Assert
        assertEquals(0, b.getMoveCounter());
    }

    @Test
    void assert_that_printGameBoard_works_properly(){
        //Arrange
        Board b1 = new Board();
        Board b2 = new Board();
        String s1 = " | | \n-----\n | | \n-----\n | | ";
        String s2 = " |X|O\n-----\nX|O|X\n-----\nO| | ";

        //Act
        b2.setFieldTest();

        //Assert
        assertEquals(s1, b1.printGameBoard());
        assertEquals(s2, b2.printGameBoard());
    }
}