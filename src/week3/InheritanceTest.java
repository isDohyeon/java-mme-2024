package week3;

public class InheritanceTest {

    public static void main(String[] args) {
        WaterCar car = new WaterCar(5, 3, 2);
        car.shoeCurrentGauge();
    }
}

class GasolineCar {
    private int gasolineGauge;

    public GasolineCar(int gasolineGauge) {
        this.gasolineGauge = gasolineGauge;
    }

    public int getGasolineGauge() {
        return gasolineGauge;
    }
}

class ElectricCar extends GasolineCar {
    private int ElectricGauge;

    public ElectricCar(int gasolineGauge, int electricGauge) {
        super(gasolineGauge);
        ElectricGauge = electricGauge;
    }

    public int getElectricGauge() {
        return ElectricGauge;
    }
}

class WaterCar extends ElectricCar {
    private int waterGauge;

    public WaterCar(int gasolineGauge, int electricGauge, int waterGauge) {
        super(gasolineGauge, electricGauge);
        this.waterGauge = waterGauge;
    }

    public int getWaterGauge() {
        return waterGauge;
    }

    public void shoeCurrentGauge() {
        System.out.println("가솔린 양 : " + getGasolineGauge());
        System.out.println("전기 양 : " + getElectricGauge());
        System.out.println("물 양 : " + getWaterGauge());
    }
}
