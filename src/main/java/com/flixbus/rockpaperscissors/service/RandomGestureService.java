package com.flixbus.rockpaperscissors.service;

import com.flixbus.rockpaperscissors.model.Gesture;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class RandomGestureService {

    private static final List<Gesture> VALUES = List.of(Gesture.values());
    private static final Random RANDOM_VALUE = new Random();

    Gesture getRandomGesture() {
        return VALUES.get(RANDOM_VALUE.nextInt(VALUES.size()));
    }
}
