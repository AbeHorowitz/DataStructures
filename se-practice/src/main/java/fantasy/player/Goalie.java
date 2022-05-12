package fantasy.player;

import java.util.HashMap;

public class Goalie implements Player{
    private String name;
    private int wins;
    private int goalsAgainst;
    private int saves;
    private NHLTeam team;
    private Position position;
    private HashMap<String, Integer> totalStats;

    protected Goalie(String name, NHLTeam team, Position position){
        this.name = name;
        this.team = team;
        this.position = position;
        this.wins = 0;
        this.goalsAgainst = 0;
        this.saves = 0;
        this.totalStats = new HashMap<>() {{
            put("wins", 0);
            put("goalsAgainst", 0);
            put("saves", 0);
        }};
    }

    @Override
    public String getName(){
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
            case "wins":
                this.wins = num;
                this.totalStats.replace(stat, this.totalStats.get(stat) + num);
                break;
            case "goalsAgainst":
                this.goalsAgainst = num;
                this.totalStats.replace(stat, this.totalStats.get(stat) + num);
                break;
            case "saves":
                this.saves = num;
                this.totalStats.replace(stat, this.totalStats.get(stat) + num);
                break;
        }
    }

    public int getWins() {
        return this.wins;
    }

    public int getGoalsAgainst() {
        return this.goalsAgainst;
    }

    public int getSaves() {
        return this.saves;
    }

    @Override
    public double getDailyFantasyPoints() {
        int wins = this.getWins();
        int goalsAgainst = this.getGoalsAgainst();
        int saves = this.getSaves();
        return (wins * 3) + (goalsAgainst * -1) + (saves * 0.2);
    }

    @Override
    public double getCumulativeFantasyPoints() {
        double points = 0;
        for (String stat : this.totalStats.keySet()) {
            switch (stat) {
                case "wins":
                    points += 3 * this.totalStats.get(stat);
                    break;
                case "goalsAgainst":
                    points -= this.totalStats.get(stat);
                    break;
                case "saves":
                    points += 0.2 * this.totalStats.get(stat);
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
