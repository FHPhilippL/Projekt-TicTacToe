package game;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    @Test
    void when_passedVariable_3_or_higher_then_set_size_to_variable() {
        // Arrange
        int size = 4;
        Board board = new Board();

        // Act
        board.setSize(size);

        // Assert
        assertEquals(size, board.getSize());
    }

    @Test
    void when_passedVariable_lower_3_then_set_size_to_3(){
        // Arrange
        int size = 2;
        Board board = new Board();

        // Act
        board.setSize(size);

        // Assert
        assertEquals(3, board.getSize());
    }

    @Test
    void when_used_second_Constructor_create_new_Board(){
        //Arrange
        int size = 4;

        //Act
        Board board = new Board(4);

        //Assert
        assertEquals(4, board.getSize());
        assertEquals(4, board.getField().length);
        assertEquals(4, board.getField()[0].length);
        assertEquals(0, board.getMoveCounter());

    }
}