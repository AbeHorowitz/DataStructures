package fantasy.player;

import java.util.HashMap;
import java.util.Map;

public class Skater implements Player {
    private String name;
    private int goals;
    private int assists;
    private int plusMinus;
    private NHLTeam team;
    private Position position;
    private Map<String, Integer> totalStats;

    protected Skater(String name, NHLTeam team, Position position) {
        this.name = name;
        this.team = team;
        this.position = position;
        this.goals = 0;
        this.assists = 0;
        this.plusMinus = 0;
        this.totalStats = new HashMap<>() {{
            put("goals", 0);
            put("assists", 0);
            put("plusMinus", 0);
        }};
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public NHLTeam getTeam() {
        return this.team;
    }

    @Override
    public Position getPosition() {
        return this.position;
    }

    @Override
    public void setStats(String stat, int num) {
        switch (stat) {
            case "goals":
                this.goals = num;
                this.totalStats.replace(stat, this.totalStats.get(stat) + num);
                break;
            case "assists":
                this.assists = num;
                this.totalStats.replace(stat, this.totalStats.get(stat) + num);
                break;
            case "plusMinus":
                this.plusMinus = num;
                this.totalStats.replace(stat, this.totalStats.get(stat) + num);
                break;
        }
    }

    public int getGoals() {
        return this.goals;
    }

    public int getAssists() {
        return this.assists;
    }

    public int getPlusMinus() {
        return this.plusMinus;
    }

    @Override
    public double getDailyFantasyPoints() {
        int goals = this.getGoals();
        int assists = this.getAssists();
        int plusMinus = this.getPlusMinus();
        return (goals * 3) + (assists * 2) + plusMinus;
    }

    @Override
    public double getCumulativeFantasyPoints() {
        double points = 0;
        for (String stat : this.totalStats.keySet()) {
            switch (stat) {
                case "goals":
                    points += 3 * this.totalStats.get(stat);
                    break;
                case "assists":
                    points += 2 * this.totalStats.get(stat);
                    break;
                case "plusMinus":
                    points += this.totalStats.get(stat);
                    break;
            }
        }
        return points;
    }

    @Override
    public boolean onTeam() {
        return false;
    }
}
