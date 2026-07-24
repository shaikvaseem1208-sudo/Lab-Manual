import java.util.HashMap;
import java.util.Map;
class UndergroundSystem {
    private static class CheckInInfo {
        String stationName;
        int time;
        CheckInInfo(String stationName, int time) {
            this.stationName = stationName;
            this.time = time;
        }
    }
    private static class JourneyData {
        double totalTime;
        int tripCount;
        JourneyData(double totalTime, int tripCount) {
            this.totalTime = totalTime;
            this.tripCount = tripCount;
        }
    }
    private final Map<Integer, CheckInInfo> checkIns;
    private final Map<String, JourneyData> journeyStats;
    public UndergroundSystem() {
        checkIns = new HashMap<>();
        journeyStats = new HashMap<>();
    }
    public void checkIn(int id, String stationName, int t) {
        checkIns.put(id, new CheckInInfo(stationName, t));
    }
    public void checkOut(int id, String stationName, int t) {
        CheckInInfo info = checkIns.remove(id);
        String routeKey = info.stationName + "->" + stationName;
        double travelTime = t - info.time;
        JourneyData stats = journeyStats.getOrDefault(routeKey, new JourneyData(0.0, 0));
        stats.totalTime += travelTime;
        stats.tripCount += 1;
        journeyStats.put(routeKey, stats);
    }
    public double getAverageTime(String startStation, String endStation) {
        String routeKey = startStation + "->" + endStation;
        JourneyData stats = journeyStats.get(routeKey);
        return stats.totalTime / stats.tripCount;
    }
}

