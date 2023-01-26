public class Boulder {

    private int boulderId;

    public Boulder(int boulderId) {
        this.boulderId = boulderId;
    }

    public int getBoulderId() {
        return boulderId;
    }

    @Override
    public String toString() {
        return "Boulder{" +
                "boulderId=" + boulderId +
                '}';
    }
}
