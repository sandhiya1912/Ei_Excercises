package exercise_1.Creational.Factory;

import exercise_1.Creational.Factory.factory.HomeApplianceFactory;
import exercise_1.Creational.Factory.product.HomeAppliance;

public class Client {
    private HomeAppliance appliance;

    public Client(HomeApplianceFactory applianceFactory){
        this.appliance = applianceFactory.createAppliance();
    }

    public HomeAppliance getAppliance(){
        return appliance;
    }
}
