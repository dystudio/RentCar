/**
 *  Author: HuangWen
 *  Date: 2021-11
 */

package huang.wen.manage;

import huang.wen.cars.Bus;
import huang.wen.cars.Car;
import huang.wen.cars.MotoVehicle;
import huang.wen.cars.Truck;

public class VehicleFactory {
    MotoVehicle getVehicleByType(String type) {
        MotoVehicle temp = null;
        switch (type) {
            case "轿车":
                temp = new Car();
                break;
            case "客车":
                temp = new Bus();
                break;
            case "货车":
                temp = new Truck();
                break;
        }
        return temp;
    }
}
