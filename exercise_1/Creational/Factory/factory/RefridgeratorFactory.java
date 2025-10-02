package exercise_1.Creational.Factory.factory;

import exercise_1.Creational.Factory.product.HomeAppliance;
import exercise_1.Creational.Factory.product.Refridgerator;

import static exercise_1.Utils.TransientError.SimulateTransientError;

public class RefridgeratorFactory implements HomeApplianceFactory {
    public HomeAppliance createAppliance() {
        SimulateTransientError("Service downtime");
        return new Refridgerator();
    }
}
