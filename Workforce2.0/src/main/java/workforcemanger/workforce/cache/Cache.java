package workforcemanger.workforce.cache;

import workforcemanger.workforce.dto.EmployeeDTO;


import java.util.HashMap;
import java.util.List;

public class Cache {
    private static Cache instance;
    private static HashMap<Integer, EmployeeDTO> cache = new HashMap<>();

    public static synchronized Cache getInstance() {
        if (instance == null) {
            instance = new Cache();
        }
        return instance;
    }
    public static void populateCache(List<EmployeeDTO> employees) {
        try {
            for (EmployeeDTO employee : employees) {
                cache.put(employee.getId(), employee);
            }
        } catch (Exception e) {
            throw new RuntimeException("Error populating cache", e);
        }
    }

    public static EmployeeDTO getFromCache(int id) {
        return cache.get(id);
    }

    public void clearCache() {
        cache.clear();
    }
}
