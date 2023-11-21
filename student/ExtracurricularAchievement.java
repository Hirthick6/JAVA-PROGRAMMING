
package wrk1;

class ExtracurricularAchievement {
    private String activity;
    private int hoursParticipated;

    public ExtracurricularAchievement(String activity, int hoursParticipated) {
        this.activity = activity;
        this.hoursParticipated = hoursParticipated;
    }

    public String getActivity() {
        return activity;
    }

    public int getHoursParticipated() {
        return hoursParticipated;
    }
}
