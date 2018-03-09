public enum SeatHeater {
    OFF{SeatHeater next(){return SeatHeater.LEVEL3;}},
    LEVEL3{SeatHeater next(){return SeatHeater.LEVEL2;}},
    LEVEL2{SeatHeater next(){return SeatHeater.LEVEL1;}},
    LEVEL1{SeatHeater next(){return SeatHeater.OFF;}};
    abstract SeatHeater next();
}
