package customhashmap;

import java.util.LinkedList;
import java.util.List;

public class MapBucket {
    private List<KeyValueEntry> entries;

    public MapBucket() {
        if(entries == null) {
            entries = new LinkedList<>();
        }
    }

    public List<KeyValueEntry> getEntries() {
        return entries;
    }

    public void addEntry(KeyValueEntry entry) {
        this.entries.add(entry);
    }

    public void removeEntry(KeyValueEntry entry) {
        this.entries.remove(entry);
    }
}
