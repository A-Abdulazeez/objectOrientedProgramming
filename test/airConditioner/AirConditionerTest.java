package airConditioner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AirConditionerTest {

    private AirConditioner newAirConditioner;

    @BeforeEach
    public void setUp() {
        newAirConditioner = new AirConditioner();
    }

    @Test
    public void AcIsOff_turnOnAc_AcIsOn() {
        newAirConditioner.turnOn();

        assertTrue(newAirConditioner.isOn());
    }

    @Test
    public void AcisOn_turnOffAc_AcIsOff() {
        newAirConditioner.turnOn();
        newAirConditioner.turnOff();

        assertFalse(newAirConditioner.isOn());
    }

    @Test
    public void turnOnAc_TemperatureStartsAt16_TemperatureIs16() {
        newAirConditioner.turnOn();

        assertEquals(16, newAirConditioner.getTemperature());
    }

    @Test
    public void acIsOn_IncreaseTemperature_TemperatureBecomes17() {
        newAirConditioner.turnOn();

        newAirConditioner.increaseTemperature();

        assertEquals(17, newAirConditioner.getTemperature());
    }

    @Test
    public void turnOnAc_IncreaseTemperatureAbove30_TemperatureRemains30(){
        newAirConditioner.turnOn();
        newAirConditioner.increaseTemperature();
        newAirConditioner.increaseTemperature();
        newAirConditioner.increaseTemperature();
        newAirConditioner.increaseTemperature();
        newAirConditioner.increaseTemperature();
        newAirConditioner.increaseTemperature();
        newAirConditioner.increaseTemperature();
        newAirConditioner.increaseTemperature();
        newAirConditioner.increaseTemperature();
        newAirConditioner.increaseTemperature();
        newAirConditioner.increaseTemperature();
        newAirConditioner.increaseTemperature();
        newAirConditioner.increaseTemperature();
        newAirConditioner.increaseTemperature();
        newAirConditioner.increaseTemperature();
        newAirConditioner.increaseTemperature();
        assertEquals(30, newAirConditioner.getTemperature());
    }


    @Test
    public void turnOnAc_DecreaseTemperatureBelow16_TemperatureRemains16() {
        newAirConditioner.turnOn();

        newAirConditioner.decreaseTemperature();

        assertEquals(16, newAirConditioner.getTemperature());
    }


    @Test
    public void whenAcIsOff_IncreaseTemperatureDoesNothing() {
        newAirConditioner.increaseTemperature();

        assertEquals(0, newAirConditioner.getTemperature());
    }

    @Test
    public void whenAcIsOff_DecreaseTemperatureDoesNothing() {
        newAirConditioner.decreaseTemperature();

        assertEquals(0, newAirConditioner.getTemperature());
    }
}