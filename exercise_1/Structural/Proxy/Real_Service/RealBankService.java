package exercise_1.Structural.Proxy.Real_Service;

import exercise_1.Structural.Proxy.model.UserBank;
import exercise_1.Utils.AppLogger;
import java.util.*;
import java.util.logging.Logger;

import static exercise_1.Utils.TransientError.SimulateTransientError;


public class RealBankService implements BankService {
    private final Map<Integer, UserBank> users = new HashMap<>();
    Logger logger = AppLogger.getLogger();

    public void addUser(UserBank user) {
        if (user == null) {
            throw new IllegalArgumentException("User cannot be null");
        }
        users.put(user.getId(), user);
    }

    public UserBank getUser(int userId) {
        UserBank user = users.get(userId);
        if (user == null) {
            throw new IllegalArgumentException("User not found with ID: " + userId);
        }
        return user;
    }

    @Override
    public void deposit(int userId, String pin, double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be positive");
        }

        UserBank user = getUser(userId);
        //simulated transient error
        SimulateTransientError("DB connection failed");

        user.setBalance(user.getBalance() + amount);
        logger.info("Deposited " + amount + " to " + user.getName()
                + ", Balance: " + user.getBalance());
    }

    @Override
    public void withdraw(int userId, String pin, double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdraw amount must be positive");
        }

        UserBank user = getUser(userId);

        if (user.getBalance() >= amount) {
            user.setBalance(user.getBalance() - amount);
            logger.info("Withdrawn " + amount + " from " + user.getName()
                    + ", Balance: " + user.getBalance());
        } else {
            throw new IllegalStateException("Insufficient balance for user: " + user.getName());
        }
    }
}
