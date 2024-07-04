package game.entities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    @Test
    void assert_that_getField_returns_the_current_field(){
        //Arrange
        Board b = new Board();
        String[][] s = {{" ", "X", "O"}, {"X", "O", "X"}, {" ", " ", " "}};

        //Act
        b.addSymbol("X", 1, 2);
        b.addSymbol("X", 2, 3);
        b.addSymbol("X", 2, 1);
        b.addSymbol("O", 1, 3);
        b.addSymbol("O", 2, 2);

        //Assert
        assertArrayEquals(s, b.getField());
    }

    @Test
    void assert_that_getField_only_returns_the_correct_field(){
        //Arrange
        Board b = new Board();
        String[][] s = {{" ", "X", "O"}, {"X", "O", "X"}, {"X", " ", " "}};

        //Act
        b.addSymbol("X", 1, 2);
        b.addSymbol("X", 2, 3);
        b.addSymbol("X", 2, 1);
        b.addSymbol("O", 1, 3);
        b.addSymbol("O", 2, 2);

        //Assert
        assertNotEquals(s, b.getField());
    }

    @Test
    void assert_that_getMoveCounter_returns_the_current_moveCounter(){
        //Arrange
        Board b = new Board();

        //Act
        b.addSymbol("X", 1, 1);

        //Assert
        assertEquals(1, b.getMoveCounter());
    }

    @Test
    void assert_that_getMoveCounter_only_returns_the_correct_moveCounter(){
        //Arrange
        Board b = new Board();

        //Act
        b.addSymbol("X", 1, 1);

        //Assert
        assertNotEquals(0, b.getMoveCounter());
    }

    @Test
    void assert_that_reset_returns_the_Board_to_the_beginning_Values(){
        //Arrange
        Board b = new Board();

        //Act
        b.addSymbol("X", 1, 1);
        b.reset();

        //Assert
        assertArrayEquals(new Board().getField(), b.getField());
    }

    @Test
    void assert_that_reset_does_not_leave_a_Position_filled(){
        //Arrange
        Board b1 = new Board();
        Board b2 = new Board();

        //Act
        b1.addSymbol("X", 1, 1);
        b2.addSymbol("X", 1, 1);
        b1.reset();

        //Assert
        assertNotEquals(b2.getField(), b1.getField());
    }

    @Test
    void assert_that_addSymbol_adds_when_Position_empty(){
        //Arrange
        Board b = new Board();

        //Act
        b.addSymbol("X", 1, 2);
        b.addSymbol("X", 2, 3);
        b.addSymbol("X", 2, 1);
        b.addSymbol("O", 1, 3);
        b.addSymbol("O", 2, 2);

        //Assert
        assertTrue(b.addSymbol("X", 1, 1));
    }

    @Test
    void assert_that_addSymbol_does_not_add_when_Position_not_empty(){
        //Arrange
        Board b = new Board();

        //Act
        b.addSymbol("X", 1, 2);
        b.addSymbol("X", 2, 3);
        b.addSymbol("X", 2, 1);
        b.addSymbol("O", 1, 3);
        b.addSymbol("O", 2, 2);

        //Assert
        assertFalse(b.addSymbol("X", 1,2));
    }

    @Test
    void assert_that_addSymbol_only_adds_between_1_and_3(){
        //Arrange
        Board b = new Board();

        //Act
        b.addSymbol("X", 1, 2);
        b.addSymbol("X", 2, 3);
        b.addSymbol("X", 2, 1);
        b.addSymbol("O", 1, 3);
        b.addSymbol("O", 2, 2);

        //Assert
        assertFalse(b.addSymbol("X", 4, 3));
        assertFalse(b.addSymbol("X", 0, 2));
        assertFalse(b.addSymbol("O", 2, 4));
        assertFalse(b.addSymbol("O", 3, 0));
    }

    @Test
    void assert_that_checkForWin_checks_correctly_horizontally(){
        //Arrange
        Board b1 = new Board();
        Board b2 = new Board();
        Board b3 = new Board();

        //Act
        b1.addSymbol("X", 1, 1);
        b1.addSymbol("X", 1, 2);
        b1.addSymbol("X", 1, 3);

        b2.addSymbol("X", 2, 1);
        b2.addSymbol("X", 2, 2);
        b2.addSymbol("X", 2, 3);

        b3.addSymbol("X", 3, 1);
        b3.addSymbol("X", 3, 2);
        b3.addSymbol("X", 3, 3);

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
        b1.addSymbol("X", 1, 1);
        b1.addSymbol("X", 2, 1);
        b1.addSymbol("X", 3, 1);

        b2.addSymbol("X", 1, 2);
        b2.addSymbol("X", 2, 2);
        b2.addSymbol("X", 3, 2);

        b3.addSymbol("X", 1, 3);
        b3.addSymbol("X", 2, 3);
        b3.addSymbol("X", 3, 3);

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


        //Act
        b.addSymbol("O", 3, 1);
        b.addSymbol("O", 1, 3);
        b.addSymbol("O", 2, 2);
        b2.addSymbol("X",1,1);
        b2.addSymbol("X", 2, 2);
        b2.addSymbol("X", 3, 3);

        //Assert
        assertTrue(b.checkForWin("O"));
        assertTrue(b2.checkForWin("X"));
    }

    @Test
    void assert_that_checkForWin_returns_false_when_no_Win(){
        //Arrange
        Board b1 = new Board();

        //Act
        b1.addSymbol("X", 3, 1);
        b1.addSymbol("O", 2, 2);
        b1.addSymbol("X", 1, 1);
        b1.addSymbol("O", 2, 1);
        b1.addSymbol("X", 2, 3);

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
        b2.addSymbol("X", 1, 2);
        b2.addSymbol("X", 2, 3);
        b2.addSymbol("X", 2, 1);
        b2.addSymbol("O", 1, 3);
        b2.addSymbol("O", 2, 2);

        //Assert
        assertEquals(s1, b1.printGameBoard());
        assertEquals(s2, b2.printGameBoard());
    }

    @Test
    void assert_that_printGameBoard_does_not_return_a_wrong_Board(){
        //Arrange
        Board b = new Board();
        String s2 = " |X|O\n-----\nX|O|X\n-----\nX| | ";

        //Act
        b.addSymbol("X", 1, 2);
        b.addSymbol("X", 2, 3);
        b.addSymbol("X", 2, 1);
        b.addSymbol("O", 1, 3);
        b.addSymbol("O", 2, 2);

        //Assert
        assertNotEquals(s2, b.printGameBoard());
    }
}