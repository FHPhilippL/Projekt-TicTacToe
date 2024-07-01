package game;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    @Test
    void assert_that_getField_returns_the_current_field(){
        //Arrange
        Board b = new Board();
        String[][] s = {{" ", "X", "O"}, {"X", "O", "X"}, {" ", " ", " "}};

        //Act
        b.setFieldTest();

        //Assert
        assertArrayEquals(s, b.getField());
    }

    @Test
    void assert_that_getMoveCounter_returns_the_current_moveCounter(){
        //Arrange
        Board b = new Board();

        //Assert
        assertEquals(0, b.getMoveCounter());
    }

    @Test
    void assert_that_addSymbol_only_adds_when_Position_empty(){
        //Arrange
        Board b = new Board();
        b.setFieldTest();

        //Assert
        assertTrue(b.addSymbol("X", 0, 0));
        assertEquals(1, b.getMoveCounter());
        assertFalse(b.addSymbol("O", 1, 1));
    }

    @Test
    void assert_that_addSymbol_only_adds_between_0_and_1(){
        //Arrange
        Board b = new Board();
        b.setFieldTest();

        //Assert
        assertFalse(b.addSymbol("X", 3, 2));
        assertFalse(b.addSymbol("X", -1, 1));
        assertFalse(b.addSymbol("O", 1, 3));
        assertFalse(b.addSymbol("O", 2, -1));
    }

    @Test
    void assert_that_checkForWin_checks_correctly_horizontally(){
        //Arrange
        Board b1 = new Board();
        Board b2 = new Board();
        Board b3 = new Board();

        //Act
        b1.addSymbol("X", 0, 0);
        b1.addSymbol("X", 0, 1);
        b1.addSymbol("X", 0, 2);

        b2.addSymbol("X", 1, 0);
        b2.addSymbol("X", 1, 1);
        b2.addSymbol("X", 1, 2);

        b3.addSymbol("X", 2, 0);
        b3.addSymbol("X", 2, 1);
        b3.addSymbol("X", 2, 2);

        //Assert
        assertTrue(b1.checkForWin("X"));
        assertTrue(b2.checkForWin("X"));
        assertTrue(b3.checkForWin("X"));
    }

    @Test
    void assert_that_checkForWin_checks_correctly_vertically(){
        //Arrange
        Board b1 = new Board();
        Board b2 = new Board();
        Board b3 = new Board();

        //Act
        b1.addSymbol("X", 0, 0);
        b1.addSymbol("X", 1, 0);
        b1.addSymbol("X", 2, 0);

        b2.addSymbol("X", 0, 1);
        b2.addSymbol("X", 1, 1);
        b2.addSymbol("X", 2, 1);

        b3.addSymbol("X", 0, 2);
        b3.addSymbol("X", 1, 2);
        b3.addSymbol("X", 2, 2);

        //Assert
        assertTrue(b1.checkForWin("X"));
        assertTrue(b2.checkForWin("X"));
        assertTrue(b3.checkForWin("X"));
    }

    @Test
    void assert_that_checkForWin_checks_correctly_diagonally(){
        //Arrange
        Board b = new Board();
        Board b2 = new Board();
        b.setFieldTest();

        //Act
        b.addSymbol("O", 2, 0);
        b2.addSymbol("X",0,0);
        b2.addSymbol("X", 1, 1);
        b2.addSymbol("X", 2, 2);

        //Assert
        assertTrue(b.checkForWin("O"));
        assertTrue(b2.checkForWin("X"));
    }

    @Test
    void assert_that_checkForWin_returns_false_when_no_Win(){
        //Arrange
        Board b1 = new Board();

        //Act
        b1.addSymbol("X", 2, 0);
        b1.addSymbol("O", 1, 1);
        b1.addSymbol("X", 0, 0);
        b1.addSymbol("O", 1, 0);
        b1.addSymbol("X", 1, 2);

        //Assert
        assertFalse(b1.checkForWin("X"));
    }

    @Test
    void assert_that_printGameBoard_works_properly(){
        //Arrange
        Board b1 = new Board();
        Board b2 = new Board();
        String s1 = " | | \n-----\n | | \n-----\n | | ";
        String s2 = " |X|O\n-----\nX|O|X\n-----\n | | ";

        //Act
        b2.setFieldTest();

        //Assert
        assertEquals(s1, b1.printGameBoard());
        assertEquals(s2, b2.printGameBoard());
    }
}