import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Performance {
    private int performanceId;
    private int athleteId;
    private int boulderId;
    private int top;
    private int zone;
    private int attemptTop;
    private int attemptZone;
    private LocalTime startTime;
    private LocalTime endTime;

    public Performance() {
    }

    public Performance(int performanceId, int athleteId, int boulderId, int top, int zone, int attemptTop, int attemptZone, LocalTime startTime, LocalTime endTime) {
        this.performanceId = performanceId;
        this.athleteId = athleteId;
        this.boulderId = boulderId;
        this.top = top;
        this.zone = zone;
        this.attemptTop = attemptTop;
        this.attemptZone = attemptZone;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public int getPerformanceId() {
        return performanceId;
    }

    public int getAthleteId() {
        return athleteId;
    }

    public int getBoulderId() {
        return boulderId;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    @Override
    public String toString() {
        return
                " " + performanceId +
                ", " + athleteId +
                ", " + boulderId +
                ", " + top +
                ", " + zone +
                ", " + attemptTop +
                ", " + attemptZone +
                ", " + startTime +
                ", " + endTime
                ;
    }
}
