package com.flixbus.rockpaperscissors.contoller;

import com.flixbus.rockpaperscissors.model.GameResponse;
import com.flixbus.rockpaperscissors.model.Gesture;
import com.flixbus.rockpaperscissors.service.GameService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/v1/games")
@RequiredArgsConstructor
@CrossOrigin
public class GameController {

    private final GameService gameService;

    @GetMapping(value = "/player")
    @ApiOperation(value = "Calculate result of the game (player vs computer) and return the result")
    public ResponseEntity<GameResponse> calculateResult(@ApiParam(value = "PlayerGesture", required = true) @RequestParam(value = "playerGesture") Gesture gesture) {
        final GameResponse result = gameService.calculateGameResult(gesture);
        return ResponseEntity.ok(result);
    }

    @GetMapping(value = "/computer")
    @ApiOperation(value = "Calculate result of the game (computer vs computer) and return the result")
    public ResponseEntity<GameResponse> calculateResultComputer() {
        final GameResponse result = gameService.calculateGameResult();
        return ResponseEntity.ok(result);
    }
}
