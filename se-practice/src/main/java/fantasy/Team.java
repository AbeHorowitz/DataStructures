package fantasy;
import fantasy.player.*;
import fantasy.dataBase.*;

public class Team implements Comparable<Team>{
    private String name;
    private double cumulativeTeamPoints;
    private double dailyPoints;
    private int wins;
    private int losses;
    private Trie<Player> playersOnTeam;
    private Set<Player> playerSet;

    public Team(String name, String owner){
        this.name = name;
        this.cumulativeTeamPoints = cumulativeTeamPoints;
        this.dailyPoints = dailyPoints;
        this.wins = 0;
        this.losses = 0;
        this.playersOnTeam = new Trie<Player>();
        this.playerSet = new HashSet<Player>();
    }


    public Set<Player> addPlayer(Player player) {
        if(player.onTeam()){
            throw new IllegalArgumentException(player.getName() + " is on a fantasy team already!");
        }
        this.playerSet.add(player);
        this.playersOnTeam.put(player.getName(), player);
        return this.playerSet;
    };
    public Set<Player> dropPlayer(Player player) {
        if(!player.onTeam()){
            throw new IllegalArgumentException(player.getName() + " is not on any fantasy team!");
        }
        this.playerSet.remove(player);
        this.playersOnTeam.put(player.getName(), null);
        return this.playerSet;
    };
    public void updateStats() {

    };

    public Set<Player> getPlayerSet(){
        return this.playerSet;
    }

    public double getCumulativeTeamPoints(){
        return this.cumulativeTeamPoints;
    }

    public int compareTo(Team team){
        if (this.getCumulativeTeamPoints() > team.getCumulativeTeamPoints()){
            return 1;
        }else if (this.getCumulativeTeamPoints() < team.getCumulativeTeamPoints()){
            return -1;
        }else{
            return 0;
        }
    }
}
