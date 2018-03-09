package nestedclasses.thermo;

public class Thermometer {
    private String room;
    private int temp;
    private ThermometerObserver observer;

    public Thermometer(String room, int temp) {
        this.room = room;
        this.temp = temp;
        this.observer = null;
    }

    public String getRoom() {
        return room;
    }

    public int getTemp() {
        return temp;
    }

    public ThermometerObserver getObserver() {
        return observer;
    }

    public void setThermometerObserver(ThermometerObserver observer) {
        this.observer = observer;

    }

    public void onTemperatureChanged() {
        if (this.getObserver() != null) {
            observer.handleTemperatureChange(temp, room);
        }
    }

    public void setTemperature(int temp) {
        this.temp = temp;
        onTemperatureChanged();
    }


}
