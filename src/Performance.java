public class Performance {
    private int performanceId;
    private int athleteId;
    private int boulderId;
    private int top;
    private int zone;
    private int attemptTop;
    private int attemptZone;
    private String startTime;
    private String endTime;

    public Performance() {
    }

    public Performance(int performanceId, int athleteId, int boulderId, int top, int zone, int attemptTop, int attemptZone, String startTime, String endTime) {
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

    @Override
    public String toString() {
        return "Performance{" +
                "performanceId=" + performanceId +
                ", athleteId=" + athleteId +
                ", boulderId=" + boulderId +
                ", top=" + top +
                ", zone=" + zone +
                ", attemptTop=" + attemptTop +
                ", attemptZone=" + attemptZone +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                '}';
    }
}
