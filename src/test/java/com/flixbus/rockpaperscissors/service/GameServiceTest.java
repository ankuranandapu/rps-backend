package com.flixbus.rockpaperscissors.service;

import com.flixbus.rockpaperscissors.model.GameResponse;
import com.flixbus.rockpaperscissors.model.GameResult;
import com.flixbus.rockpaperscissors.model.Gesture;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(value = MockitoExtension.class)
class GameServiceTest {

    @Mock
    RandomGestureService randomGestureService;

    @InjectMocks
    GameService gameService;

    @Test
    void testCalculatePlayerGameResult_whenPlayerChooseRockAndComputerChooseRock_itsTie() {
        //GIVEN

        when(randomGestureService.getRandomGesture()).thenReturn(Gesture.ROCK);
        //WHEN
        final GameResponse actual = gameService.calculateGameResult(Gesture.ROCK);

        //THEN
        assertEquals(GameResult.TIE, actual.getResult());
    }

    @Test
    void testCalculatePlayerGameResult_whenPlayerChooseRockAndComputerChoosePaper_computerWins() {
        //GIVEN

        when(randomGestureService.getRandomGesture()).thenReturn(Gesture.PAPER);
        //WHEN
        final GameResponse actual = gameService.calculateGameResult(Gesture.ROCK);

        //THEN
        assertEquals(GameResult.PLAYER2, actual.getResult());
    }

    @Test
    void testCalculatePlayerGameResult_whenPlayerChooseRockAndComputerChooseScissors_computerWins() {
        //GIVEN

        when(randomGestureService.getRandomGesture()).thenReturn(Gesture.SCISSORS);
        //WHEN
        final GameResponse actual = gameService.calculateGameResult(Gesture.ROCK);

        //THEN
        assertEquals(GameResult.PLAYER1, actual.getResult());
    }

    @Test
    void testCalculatePlayerGameResult_whenPlayerChooseScissorsAndComputerChooseScissors_itsTie() {
        //GIVEN

        when(randomGestureService.getRandomGesture()).thenReturn(Gesture.SCISSORS);
        //WHEN
        final GameResponse actual = gameService.calculateGameResult(Gesture.SCISSORS);

        //THEN
        assertEquals(GameResult.TIE, actual.getResult());
    }

    @Test
    void testCalculatePlayerGameResult_whenPlayerChooseScissorsAndComputerChooseRock_computerWins() {
        //GIVEN

        when(randomGestureService.getRandomGesture()).thenReturn(Gesture.ROCK);
        //WHEN
        final GameResponse actual = gameService.calculateGameResult(Gesture.SCISSORS);

        //THEN
        assertEquals(GameResult.PLAYER2, actual.getResult());
    }

    @Test
    void testCalculatePlayerGameResult_whenPlayerChooseScissorsAndComputerChoosePaper_playerWins() {
        //GIVEN

        when(randomGestureService.getRandomGesture()).thenReturn(Gesture.PAPER);
        //WHEN
        final GameResponse actual = gameService.calculateGameResult(Gesture.SCISSORS);

        //THEN
        assertEquals(GameResult.PLAYER1, actual.getResult());
    }

    @Test
    void testCalculatePlayerGameResult_whenPlayerChoosePaperAndComputerChooseScissors_computerWins() {
        //GIVEN

        when(randomGestureService.getRandomGesture()).thenReturn(Gesture.SCISSORS);
        //WHEN
        final GameResponse actual = gameService.calculateGameResult(Gesture.PAPER);

        //THEN
        assertEquals(GameResult.PLAYER2, actual.getResult());
    }

    @Test
    void testCalculatePlayerGameResult_whenPlayerChoosePaperAndComputerChooseRock_playerWins() {
        //GIVEN

        when(randomGestureService.getRandomGesture()).thenReturn(Gesture.ROCK);
        //WHEN
        final GameResponse actual = gameService.calculateGameResult(Gesture.PAPER);

        //THEN
        assertEquals(GameResult.PLAYER1, actual.getResult());
    }

    @Test
    void testCalculatePlayerGameResult_whenPlayerChoosePaperAndComputerChoosePaper_itsTie() {
        //GIVEN

        when(randomGestureService.getRandomGesture()).thenReturn(Gesture.PAPER);
        //WHEN
        final GameResponse actual = gameService.calculateGameResult(Gesture.PAPER);

        //THEN
        assertEquals(GameResult.TIE, actual.getResult());
    }

    @Test
    void testCalculateComputerGameResult_whenComputerChoosesTwoRandomGestures_resultShouldBeReturned() {
        //GIVEN

        when(randomGestureService.getRandomGesture()).thenReturn(Gesture.PAPER);
        when(randomGestureService.getRandomGesture()).thenReturn(Gesture.PAPER);
        //WHEN
        final GameResponse actual = gameService.calculateGameResult();

        //THEN
        assertEquals(GameResult.TIE, actual.getResult());
        verify(randomGestureService, times(2)).getRandomGesture();
    }
}
