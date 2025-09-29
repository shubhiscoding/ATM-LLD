import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CashDispenser {
    private Map<Integer, Integer> availableNotes;

    public CashDispenser(Map<Integer, Integer> initialNotes) {
        this.availableNotes = new HashMap<>(initialNotes);
    }

    public Map<Integer, Integer> dispense(int amount) throws Exception {
        Map<Integer, Integer> result = new HashMap<>();
        int remaining = amount;

        List<Integer> denominations = new ArrayList<>(availableNotes.keySet());
        denominations.sort(Collections.reverseOrder());

        for (int denom : denominations) {
            int count = Math.min(remaining / denom, availableNotes.get(denom));
            if (count > 0) {
                result.put(denom, count);
                remaining -= denom * count;
            }
        }

        if (remaining != 0) {
            throw new Exception("Cannot dispense amount with available notes");
        }

        // Deduct from inventory
        for (var entry : result.entrySet()) {
            availableNotes.put(entry.getKey(), availableNotes.get(entry.getKey()) - entry.getValue());
        }

        return result;
    }
}
