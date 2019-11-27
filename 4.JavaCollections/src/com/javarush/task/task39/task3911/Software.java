package com.javarush.task.task39.task3911;

import java.util.*;

public class Software {
    int currentVersion;

    private Map<Integer, String> versionHistoryMap = new LinkedHashMap<>();

    public void addNewVersion(int version, String description) {
        if (version > currentVersion) {
            versionHistoryMap.put(version, description);
            currentVersion = version;
        }
    }

    public int getCurrentVersion() {
        return currentVersion;
    }

    public Map<Integer, String> getVersionHistoryMap() {
        return Collections.unmodifiableMap(versionHistoryMap);
    }

    public boolean rollback(int rollbackVersion) {
        if (rollbackVersion >= currentVersion)
            return false;
        if (versionHistoryMap.containsKey(rollbackVersion)) {
            List<Integer> forDelete = new ArrayList<>();
            for (Integer key : versionHistoryMap.keySet())
                if (key > rollbackVersion)
                    forDelete.add(key);
            for (Integer key : forDelete)
                versionHistoryMap.remove(key);
            currentVersion = rollbackVersion;
            return true;
        }
        return false;
    }
}
