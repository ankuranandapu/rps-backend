package com.flixbus.rockpaperscissors.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;

@Builder
@Getter
public class GameResponse {

    @NotNull
    @ApiModelProperty(value = "Choice of shape by the first Player", dataType = "Enum", example = "ROCK", required = true)
    private final Gesture playerOneChoice;

    @NotNull
    @ApiModelProperty(value = "Choice of shape by the second Player", dataType = "Enum", example = "ROCK", required = true)
    private final Gesture playerTwoChoice;

    @ApiModelProperty(value = "Result of the game", dataType = "Enum", example = "TIE")
    private final GameResult result;
}
