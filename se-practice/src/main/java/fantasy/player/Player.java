package fantasy.player;

public interface Player {
    void initializeStats();
    String getName();
    Team getTeam();
    Position getPosition();
    double getDailyFantasyPoints();
    double getCumulativeFantasyPoints();
}
