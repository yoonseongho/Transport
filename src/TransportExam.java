public class TransportExam {
    public static void main(String[] args) {
        Car c1 = new Car("디젤", 5);
        Car c2 = new Car("가스", 110);

        c1.refuel();
        c2.refuel();
        c1.speedDown();
        c2.speedUp();

        Airplane a1 = new Airplane("보잉 747", 10000, 1000);
        Airplane a2 = new Airplane("에이버스 390", 20000, 5000);
        Airplane a3 = new Airplane("보잉 707", 10000, 5000);

        a1.refuel();;
        a2.refuel();
        a3.refuel();
        System.out.println(a1.airplaneName + "의 비행시간은 " + a1.flightTime() + " 입니다.");
        System.out.println(a2.airplaneName + "의 비행시간은 " + a2.flightTime() + " 입니다.");
        a1.speedDown();
        a2.speedUp();
    }
}

abstract class Transport {
    abstract void refuel();
    abstract void speedUp();
    abstract void speedDown();
}

class  Car extends Transport {
    String oilType;
    int speed;

    public Car(String oilType, int speed) {
        this.oilType = oilType;
        this.speed = speed;
    }
    @Override
    void refuel() {
        switch (oilType) {
            case "디젤":
                System.out.println("디젤을 주유합니다.");
                break;
            case "가스":
                System.out.println("가스를 주유합니다.");
                break;
            case "전기":
                System.out.println("전기를 충전합니다.");
                break;
            case "태양열":
                System.out.println("태양열을 사용합니다.");
                break;
            default:
                System.out.println("휘발유를 주유합니다.");
        }
    }

    @Override
    void speedUp() {
        speed += 10;
        if(speed > 110) {
            System.out.println("속력위반 범칙금 10만원 부과합니다.");
            speed = 10;
        }
    }

    @Override
    void speedDown() {
        speed -= 10;
        if (speed < 0) {
            System.out.println("차가 멈췄습니다.");
            speed = 10;
        }
    }
}

class Airplane extends Transport {
    String airplaneName;
    double distance;
    double speed;
    static double totalJetFuel = 1500;
    double jetFuel;

    public Airplane(String airplaneName, double distance, double speed) {
        this.airplaneName = airplaneName;
        this.distance = distance;
        this.speed = speed;
        this.jetFuel = distance / 20;
    }

    void refuel() {
        if (jetFuel <= totalJetFuel) {
            totalJetFuel -= jetFuel;
            System.out.println("항공유 " + jetFuel + "L를 주유합니다.");
        } else {
            System.out.println("항공유가 부족하여 주유할 수 없습니다.");
        }
    }

    void speedUp() {
        speed += 1000;
        if (speed > 5500) {
            System.out.println("비행속도는 5500km를 넘을 수 없습니다.");
            speed = 5500;
        }
    }

    void speedDown() {
        speed -= 1000;
        if (speed < 0) {
            System.out.println("비행기가 멈췄습니다.");
            speed = 10;
        }
    }

    public double flightTime() {
        return distance / speed;
    }
}