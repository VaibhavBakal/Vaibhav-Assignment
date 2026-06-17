package Task3;

import java.beans.Statement;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class BankStatementBatchProcessor {

    // FIX: AtomicInteger provides thread-safe atomic increment operations
    private final AtomicInteger processedCount = new AtomicInteger(0);

    public void process(List<Statement> records)
            throws InterruptedException {

        ExecutorService executor = Executors.newFixedThreadPool(10);

        for (Statement record : records) {
            executor.submit(() -> {
                processRecord(record);

                // FIX: Atomic increment prevents lost updates
                processedCount.incrementAndGet();
            });
        }

        executor.shutdown();
        executor.awaitTermination(5, TimeUnit.MINUTES);
    }

    public int getProcessedCount() {
        return processedCount.get();
    }

    private void processRecord(Statement record) {
        
    }
}