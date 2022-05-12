package fantasy.player;

import fantasy.Team;

public interface Player {
    String getName();
    NHLTeam getTeam();
    Position getPosition();
    void setStats(String stat, int num);
    double getDailyFantasyPoints();
    double getCumulativeFantasyPoints();
}
