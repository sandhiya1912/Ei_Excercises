package exercise_1.Structural.Proxy.Real_Service;

public interface BankService {
    void deposit(int userId, String pin, double amount);
    void withdraw(int userId, String pin, double amount);
}
