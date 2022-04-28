package fantasy.player;

import java.util.HashMap;

public class Goalie implements Player{
    private String name;
    private Team team;
    private Position position;
    private HashMap<String, Integer> dailyStats;
    private HashMap<String, Integer> totalStats;
    private int dailyFantasyPoints;
    private double totalFantasyPoints;

    protected Goalie(String name, Team team, Position position){
        this.name = name;
        this.team = team;
        this.position = position;
        this.initializeStats();
    }

    @Override
    public void initializeStats() {
        this.dailyStats.put("Wins", 0);
        this.dailyStats.put("Saves", 0);
        this.dailyStats.put("Shutouts", 0);
        this.totalStats.put("Wins", 0);
        this.totalStats.put("Saves", 0);
        this.totalStats.put("Shutouts", 0);
        this.dailyFantasyPoints = 0;
        this.totalFantasyPoints = 0;
    }

    @Override
    public String getName(){
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
        return this.dailyFantasyPoints;
    }

    @Override
    public double getCumulativeFantasyPoints() {
        return this.totalFantasyPoints;
    }
}
