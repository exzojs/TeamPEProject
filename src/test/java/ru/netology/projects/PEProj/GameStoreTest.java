package ru.netology.projects.PEProj;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class GameStoreTest {
    GameStore store = new GameStore();

    @Test
    public void shouldAddGame() {

        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        assertTrue(store.containsGame(game));
    }

    @Test
    public void shouldContainsGameIfOneInList() {
        Game game1 = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        assertTrue(store.containsGame(game1));
    }
    @Test
    public void shouldContainsTwoGame() {
        Game game1 = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game game2 = store.publishGame("Болван", "Аркады");
        assertTrue(store.containsGame(game2));
    }
    @Test
    public void shouldAddPlayTime() {

        store.addPlayTime("player1", 4);

        int expected = 4;
        int actual = store.getSumPlayedTime();

        assertEquals(expected, actual);
    }
    @Test
    public void shouldGetSumPlayedTime() {
        store.addPlayTime("player1", 4);
        store.addPlayTime("player1", 1);
        int expected = 5;
        int actual = store.getSumPlayedTime();
        assertEquals(expected, actual);
    }
    @Test
    public void shouldGetMostIfNobody() {
        assertEquals(null, store.getMostPlayer());
    }
    @Test
    public void shouldGetMostIfTwoPlayers() {
        store.addPlayTime("player1", 0);
        store.addPlayTime("player2", 1);
        assertEquals("player2", store.getMostPlayer());
    }
    @Test
    public void shouldGetMostIfThreePlayers() {
        store.addPlayTime("player1", 4);
        store.addPlayTime("player2", 2);
        store.addPlayTime("player3", 12);
        assertEquals("player3", store.getMostPlayer());
    }
}
