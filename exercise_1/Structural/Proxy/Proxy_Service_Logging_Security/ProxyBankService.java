package exercise_1.Structural.Proxy.Proxy_Service_Logging_Security;

import exercise_1.Structural.Proxy.Real_Service.BankService;
import exercise_1.Structural.Proxy.Real_Service.RealBankService;
import exercise_1.Structural.Proxy.model.UserBank;

import exercise_1.Utils.AppLogger;
import java.util.logging.Logger;

public class ProxyBankService implements BankService {
    private final RealBankService realService;
    Logger logger = AppLogger.getLogger();

    public ProxyBankService(RealBankService realService) {
        this.realService = realService;
    }

    private void authenticate(int userId, String pin) {
        UserBank user = realService.getUser(userId);
        if (!user.getPin().equals(pin)) {
            throw new SecurityException("Invalid PIN for user: " + userId);
        }
    }

    @Override
    public void deposit(int userId, String pin, double amount) {
        logger.info("Deposit request: userId=" + userId + ", Amount=" + amount);
        try {
            authenticate(userId, pin);
            realService.deposit(userId, pin, amount);
            logger.info("Deposit successful for userId=" + userId);
        } catch (Exception e) {
            logger.severe("Deposit failed for userId=" + userId + " → " + e.getMessage());
            throw e;
        }
    }

    @Override
    public void withdraw(int userId, String pin, double amount) {
        logger.info("Withdraw request: userId=" + userId + ", Amount=" + amount);
        try {
            authenticate(userId, pin);
            realService.withdraw(userId, pin, amount);
            logger.info("Withdraw successful for userId=" + userId);
        } catch (Exception e) {
            logger.severe("Withdraw failed for userId=" + userId + " → " + e.getMessage());
            throw e;
        }
    }
}
