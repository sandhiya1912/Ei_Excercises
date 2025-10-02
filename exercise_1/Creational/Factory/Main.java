package exercise_1.Creational.Factory;

import exercise_1.Creational.Factory.factory.HomeApplianceFactory;
import exercise_1.Creational.Factory.factory.MicrowaveFactory;
import exercise_1.Creational.Factory.factory.RefridgeratorFactory;
import exercise_1.Creational.Factory.factory.WashineMachineFactory;
import exercise_1.Creational.Factory.product.HomeAppliance;
import exercise_1.Utils.TransientException;
import exercise_1.Utils.AppLogger;

import java.util.logging.Logger;

public class Main {
    private static final Logger logger = AppLogger.getLogger();

    public static void main(String[] args) throws InterruptedException {
        HomeApplianceFactory washineMachineFactory = new WashineMachineFactory();
        HomeApplianceFactory microwaveFactory = new MicrowaveFactory();
        HomeApplianceFactory refridgeratorFactory = new RefridgeratorFactory();

        try {
            Client washinMachineClient = new Client(washineMachineFactory);
            HomeAppliance washinemachine = washinMachineClient.getAppliance();
            washinemachine.turnOn();
            washinemachine.turnOff();

            Client refridgeratorClient = new Client(refridgeratorFactory);
            HomeAppliance refridgerator = refridgeratorClient.getAppliance();
            refridgerator.turnOn();
            refridgerator.turnOff();

            Client microWaveClient = new Client(microwaveFactory);
            HomeAppliance microwave = microWaveClient.getAppliance();
            microwave.turnOn();
            microwave.turnOff();

        } catch (TransientException e) {
            logger.warning("Transient error occurred: " + e.getMessage());
            Thread.sleep(2000);
            System.out.println("Retry after some time...");
        }
    }
}
