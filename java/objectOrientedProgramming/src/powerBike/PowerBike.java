package powerBike;

public class PowerBike {

    private boolean isOn;
    private int bikeSpeed;

    public void turnOn() {
        isOn = true;
        bikeSpeed = 0;
    }

    public void turnOff() {
        isOn = false;
    }

    public boolean isOn() {
        return isOn;
    }

    public int getBikeSpeed() {
        return bikeSpeed;
    }


    public int getGear() {
        if (bikeSpeed <= 20) return 1;
        if (bikeSpeed <= 30) return 2;
        if (bikeSpeed <= 40) return 3;
        return 4;
    }

    public void accelerate() {
        if (isOn);

        bikeSpeed = bikeSpeed + getGear();
    }

    public void decelerate() {
        if (isOn);

        bikeSpeed = bikeSpeed - getGear();

        if (bikeSpeed < 0) {
            bikeSpeed = 0;
        }
    }
}