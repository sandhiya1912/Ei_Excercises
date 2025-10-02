package exercise_1.Creational.Factory.factory;

import exercise_1.Creational.Factory.product.HomeAppliance;
import exercise_1.Creational.Factory.product.WashingMachine;

public class WashineMachineFactory implements HomeApplianceFactory {
    public HomeAppliance createAppliance() {
        return new WashingMachine();
    }
}
