import java.time.LocalTime;
import java.util.Random;

public class Athlete {
    private int atheleteId;

    public Athlete(int atheleteId) {
        this.atheleteId = atheleteId;
    }

    public int getAthleteId() {
        return atheleteId;
    }

    @Override
    public String toString() {
        return "Athlete{" +
                "athleteId=" + atheleteId +
                '}';
    }

    private int randomInt(int min, int max){
        Random rn = new Random();
        int roll = rn.nextInt(max - min +1) + min;
        return roll;
    }

    public Performance createPerformance(int performanceId, int boulderId, int athleteId, LocalTime startTime, LocalTime endTime) {
        int top = randomInt(0,1);
        int zone;
        int attemptTop = 0;
        int attemptZone = 0;
        if (top == 1) {
            zone = 1;
            attemptTop = randomInt(1,10);
        } else {
            zone = randomInt(0,1);
        }
        if (zone == 1) {
            attemptZone = randomInt(1,10);
        }
        Performance performance = new Performance(performanceId, boulderId, athleteId, top, zone, attemptTop, attemptZone,startTime,endTime);
        return performance;
    }
}
