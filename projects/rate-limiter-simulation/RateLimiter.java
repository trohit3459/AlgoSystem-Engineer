import java.time.Instant;
public class RateLimiter {
private final int capacity;
private final int refillRate;
private double tokens;
private long lastRefillTimestamp;

public RateLimiter(int capacity, int refillRate) {
    this.capacity = capacity;
    this.refillRate = refillRate;
    this.tokens = capacity;
    this.lastRefillTimestamp = Instant.now().getEpochSecond();
}

public synchronized boolean allowRequest() {
    refill();
    if (tokens >= 1) {
        tokens -= 1;
        return true;
    }
    return false;
}

private void refill() {
    long now = Instant.now().getEpochSecond();
    long seconds = now - lastRefillTimestamp;
    tokens = Math.min(capacity, tokens + seconds * refillRate);
    lastRefillTimestamp = now;
}
}
