package fantasy;

public class TeamManager {
    private HashMap<Team, Team> weeklyMatchups;
    private HashMap<Team, HashSet<Team>> completedMatchups;
    private HashSet<Team> teams;
    private SortedSet<Team> standings;

    public void TeamManager() {
        this.weeklyMatchups = new HashMap<Team, Team>();
        this.completedMatchups = new HashMap<Team, HashSet<Team>>();
        this.teams = new HashSet<Team>();
        this.standings = new TreeSet<Team>();
    }

    /**
     * @param owner
     * Initiates team with owner
     */
    public Team createTeam(String owner, String teamName) {
        Team newTeam = new Team(teamName, owner);
        this.teams.add(newTeam);
        this.completedMatchups.put(newTeam, new HashSet<Team>());
        this.standings.add(newTeam);
        return newTeam;
    }

    /**
     * @param team
     * @param player
     * calls Team.addPlayer() to add player to fantasy team
     */
    public Set<Player> addPlayerToTeam(Team team, Player player) {
        return team.addPlayer(player);
    }

    /**
     * @param team
     * @param player
     * calls Team.dropPlayer() to drop player from fantasy team
     */
    public Set<Player> dropPlayer(Team team, Player player){
        return team.dropPlayer(player);
    }

    /**
     *
     * @param teamOne first team of
     * @param playersFromTeamOne HashSet of players to trade from first team to second team
     * @param teamTwo second team in transaction
     * @param playersFromTeamTwo HashSet of players to trade from second team to first team
     * drops and adds players as appropriate
     * do nothing if either team is null
     * players can be null for purposes of trading draft picks, but this must be checked
     */
    public void trade(Team teamOne, HashSet<Player> playersFromTeamOne, Team teamTwo, HashSet<Player> playersFromTeamTwo){
        if (teamOne.getPlayerSet() == null || teamTwo.getPlayerSet() == null){
            return;
        }
        for(Player player : playersFromTeamOne){
            teamOne.dropPlayer(player);
            teamTwo.addPlayer(player);
        }
        for(Player player : playersFromTeamTwo){
            teamTwo.dropPlayer(player);
            teamOne.addPlayer(player);
        }

    }

    /**
     * @return a SortedSet of the teams in the league ranked by "points" - two per win & one per tie
     */
    public SortedSet<Team> getStandings(){
        return this.standings;
    }

    /**
     * Set up matchups for each team in this.weeklyMatchup
     * based off of previous matchups completed for each time
     */
    public void setMatchups(){
        
    }

    /**
     * Hand control over to command line for draft
     * Include UI / instructions for drafters with commands they can provide
     * e.g. 'Create team', 'Draft Player', ('Trade pick')
     * Call createTeam, addPlayer, and Trade as necessary
     */
    public void initiateDraftToCommandLine(){}

}
