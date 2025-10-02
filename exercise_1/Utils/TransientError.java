package exercise_1.Utils;

public final class TransientError {
    public static void SimulateTransientError(String operation) {
        if (Math.random() < 0.1) {
            throw new TransientException("Temporary failure: " + operation + " service unavailable");
        }
    }
}
