package ru.job4j.chess.firuges.black;

import org.junit.jupiter.api.Test;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BishopBlackTest {

    @Test
    void whenCreatePositionEqStart() {
        Cell start = Cell.B8;
        Figure bshBlack = new BishopBlack(start);
        assertThat(bshBlack.position()).isEqualTo(start);
    }

    @Test
    void whenDestD6ThenPosSameD6() {
        Figure bshBlack = new BishopBlack(Cell.B8);
        Figure newBsh = bshBlack.copy(Cell.D6);
        Cell expectedPos = Cell.D6;
        assertThat(expectedPos).isEqualTo(newBsh.position());
    }

    @Test
    void whenC1toG5way() {
        Figure bshBlack = new BishopBlack(Cell.C1);
        Cell[] res = bshBlack.way(Cell.G5);
        Cell[] expected = new Cell[]{Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        assertThat(res).isEqualTo(expected);
    }

    @Test
    void whenC1toD3ThenException() {
        Figure bshBlack = new BishopBlack(Cell.C1);
        ImpossibleMoveException exception = assertThrows(
                ImpossibleMoveException.class,
                () -> {
                    Cell[] steps = bshBlack.way(Cell.D3);
                });
        assertThat(exception.getMessage()).isEqualTo("Could not way by diagonal from C1 to D3");
    }
}