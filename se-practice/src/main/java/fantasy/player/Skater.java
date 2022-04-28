package fantasy.player;

import java.util.HashMap;
import java.util.Map;

public class Skater implements Player {
    private String name;
    private int goals;
    private int assists;
    private int plusMinus;
    private Team team;
    private Position position;
    private Map<String, Integer> totalStats;

    public Skater(String name, Team team, Position position) {
        this.name = name;
        this.team = team;
        this.position = position;
        this.initializeStats();
    }

    @Override
    public void initializeStats() {
        this.totalStats = new HashMap<>();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Team getTeam() {
        return this.team;
    }

    @Override
    public Position getPosition() {
        return this.position;
    }

    @Override
    public double getDailyFantasyPoints() {
        return 0;
    }

    @Override
    public double getCumulativeFantasyPoints() {
        return 0;
    }
}
