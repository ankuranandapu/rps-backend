package com.flixbus.rockpaperscissors.service;

import com.flixbus.rockpaperscissors.model.Gesture;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class RandomGestureServiceTest {

    @Test
    void getRandomGesture() {
        //GIVEN

        //WHEN
        final Gesture actual = new RandomGestureService().getRandomGesture();

        //THEN
        assertNotNull(actual);
    }
}
