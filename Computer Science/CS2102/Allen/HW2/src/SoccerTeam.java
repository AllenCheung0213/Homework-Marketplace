/**
 * Represents a Soccer Team
 * @author acheung && trstecko
 */


public class SoccerTeam implements IContestant{
String name;
String color;
boolean ritual;
int wins;
int losses;
    public SoccerTeam(String name, String color, boolean ritual, int wins, int losses) {
    this.name=name;
    this.color=color;
    this.ritual=ritual;
    this.wins=wins;
    this.losses=losses;
    }

    public boolean expectToBeat(SoccerTeam team2){
        if(!team2.ritual && this.ritual){
            return true;
        }else if(team2.ritual==this.ritual){
            return ((this.wins-this.losses)>(team2.wins-team2.losses));
        }else{
            return false;
        }
    }
}
