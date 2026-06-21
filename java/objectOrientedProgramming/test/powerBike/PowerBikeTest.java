package powerBike;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PowerBikeTest {

    private PowerBike bike;

    @BeforeEach
    void setUp() {
        bike = new PowerBike();
    }

    @Test
    void bikeIsOff_ITurnItOn_ItIsOn() {
        bike.turnOn();
        assertTrue(bike.isOn());
    }

    @Test
    void bikeIsOn_ITurnItOff_ItIsOf() {
        bike.turnOn();
        bike.turnOff();
        assertFalse(bike.isOn());
    }

    @Test
    void bikeIsOn_SpeedStartsAtZero_SpeedIsZero(){
        bike.turnOn();
        assertEquals(0, bike.getBikeSpeed());
    }

    @Test
    void bikeIsOn_GearStartsAtOne_GearIsone() {
        bike.turnOn();
        assertEquals(1, bike.getGear());
    }

    @Test
    void bikeisOn_accelerateInGearOne_SpeedIncreasesByOne() {
        bike.turnOn();
        bike.accelerate();

        assertEquals(1, bike.getBikeSpeed());
    }

    @Test
    void bikeisOn_accelerateInGearTwo_SpeedIncreasesByTwo() {
        bike.turnOn();

        for (int index = 1; index < 22; index++) {
            bike.accelerate();
        }
        assertEquals(21, bike.getBikeSpeed());

        assertEquals(2, bike.getGear());
    }

    @Test
    void bikeisOn_accelerateInGearThree_SpeedIncreasesByThree() {
        bike.turnOn();

        for (int index = 1; index < 27; index++) {
            bike.accelerate();
        }
        assertEquals(31, bike.getBikeSpeed());

        assertEquals(3, bike.getGear());
    }

    @Test
    void bikeisOn_accelerateInGearfour_SpeedIncreasesByFour() {
        bike.turnOn();

        for (int index = 1; index < 31; index++) {
            bike.accelerate();
        }
        assertEquals(43, bike.getBikeSpeed());
        assertEquals(4, bike.getGear());
    }



    @Test
    void bikeIsOn_DecelerateInGearOne_SpeedDecreasesByOne() {
        bike.turnOn();
        bike.accelerate();

        bike.decelerate();

        assertEquals(0, bike.getBikeSpeed());
    }

    @Test
    void bikeIsOn_DecelerateInGearTwo_SpeedDecreasesByTwo() {
        bike.turnOn();

        for (int index = 1; index < 23; index++) {
            bike.accelerate();
        }

        bike.decelerate();

        assertEquals(21, bike.getBikeSpeed());

        assertEquals(2, bike.getGear());
    }

    @Test
    void bikeisOn_DecelerateInGearThree_SpeedDecreasesByThree() {
        bike.turnOn();

        for (int index = 1; index < 28; index++) {
            bike.accelerate();
        }
        bike.decelerate();
        assertEquals(31, bike.getBikeSpeed());

        assertEquals(3, bike.getGear());
    }


    @Test
    void bikeisOn_DecelerateInGearfour_SpeedDecreasesByFour() {
        bike.turnOn();

        for (int index = 1; index < 32; index++) {
            bike.accelerate();
        }
        bike.decelerate();
        assertEquals(43, bike.getBikeSpeed());
        assertEquals(4, bike.getGear());
    }


    @Test
    void bikeIsOn_SpeedNeverGoesBelowZero_SpeedRemainsZero() {
        bike.turnOn();
        bike.decelerate();

        assertEquals(0, bike.getBikeSpeed());
    }


}