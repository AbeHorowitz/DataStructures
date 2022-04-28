package fantasy.player;

import fantasy.Team;

public interface Player {
    void initializeStats();
    String getName();
    NHLTeam getTeam();
    Position getPosition();
    double getDailyFantasyPoints();
    double getCumulativeFantasyPoints();
}
