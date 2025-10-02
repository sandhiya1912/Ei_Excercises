package exercise_1.Creational.Factory.factory;

import exercise_1.Creational.Factory.product.HomeAppliance;
import exercise_1.Creational.Factory.product.Microwave;

public class MicrowaveFactory implements HomeApplianceFactory {
    public HomeAppliance createAppliance(){
        return new Microwave();
    }
}
