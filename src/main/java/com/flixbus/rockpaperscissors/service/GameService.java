package com.flixbus.rockpaperscissors.service;

import com.flixbus.rockpaperscissors.model.GameResponse;
import com.flixbus.rockpaperscissors.model.GameResult;
import com.flixbus.rockpaperscissors.model.Gesture;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
@RequiredArgsConstructor
public class GameService {

    private final RandomGestureService randomGestureService;

    public GameResponse calculateGameResult(final Gesture selectedGesture) {

        final Gesture randomGesture = randomGestureService.getRandomGesture();
        Assert.isTrue(selectedGesture != null, "Gesture is mandatory");
        return calculateResult(selectedGesture, randomGesture);
    }

    public GameResponse calculateGameResult() {

        final Gesture randomGesture1 = randomGestureService.getRandomGesture();
        final Gesture randomGesture2 = randomGestureService.getRandomGesture();

        return calculateResult(randomGesture1, randomGesture2);
    }

    private GameResponse calculateResult(final Gesture player1, final Gesture player2) {
        final GameResponse.GameResponseBuilder gameResponseBuilder = GameResponse.builder()
                .playerOneChoice(player1)
                .playerTwoChoice(player2);

        if (player1 == player2) {
            return gameResponseBuilder
                    .result(GameResult.TIE).build();
        }

        final GameResult result;
        switch (player1) {
            case ROCK: {
                result = player2 == Gesture.SCISSORS ? GameResult.PLAYER1 : GameResult.PLAYER2;
                break;
            }
            case PAPER: {
                result = player2 == Gesture.ROCK ? GameResult.PLAYER1 : GameResult.PLAYER2;
                break;
            }
            case SCISSORS: {
                result = player2 == Gesture.PAPER ? GameResult.PLAYER1 : GameResult.PLAYER2;
                break;
            }
            default:
                throw new IllegalArgumentException(player1.toString());
        }

        return gameResponseBuilder
                .result(result).build();
    }
}
