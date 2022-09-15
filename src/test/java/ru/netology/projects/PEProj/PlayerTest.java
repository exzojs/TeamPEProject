package ru.netology.projects.PEProj;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PlayerTest {

    @Test
    public void shouldSumGenreIfOneGame() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        Player player = new Player("Petya");
        player.installGame(game);
        player.play(game, 3);

        int expected = 3;
        int actual = player.sumGenre(game.getGenre());
        assertEquals(expected, actual);
    }

    @Test
    public void shouldSumGenreIfTwoGame() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game game2 = store.publishGame("Ligue of Legends", "MOBA");
        Game game3 = store.publishGame("Dota 2", "MOBA");

        Player player = new Player("Petya");
        player.installGame(game);
        player.installGame(game2);
        player.installGame(game3);

        player.play(game, 3);
        player.play(game2,50);
        player.play(game3,100);

        int expected = 150;
        int actual = player.sumGenre("MOBA");
        assertEquals(expected, actual);
    }

    @Test

    public void shouldThrowRuntimeException() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        Player player = new Player("Petya");
        player.play(game,3);

        assertThrows(RuntimeException.class, () -> {
            player.play(game, 3);
        });
    }

    @Test

    public void shouldMostPlayerByGenre() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game game2 = store.publishGame("Ligue of Legends", "MOBA");
        Game game3 = store.publishGame("Dota 2", "MOBA");

        Player player = new Player("Petya");
        player.installGame(game);
        player.installGame(game2);
        player.installGame(game3);

        player.play(game, 3);
        player.play(game2,50);
        player.play(game3,100);

        Game expected = game3;
        Game actual = player.mostPlayerByGenre("MOBA");

        Assertions.assertEquals(expected, actual);

    }


    // другие ваши тесты
}
