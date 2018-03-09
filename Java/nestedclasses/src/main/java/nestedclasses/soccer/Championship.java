package nestedclasses.soccer;

import java.util.ArrayList;
import java.util.List;

public class Championship {
    private List<TeamStatistics> leagueTable = new ArrayList<>();


    public List<TeamStatistics> getLeagueTable() {
        return leagueTable;
    }

    public void addGame(GameResult result) {
        if (leagueTable.size() == 0) {
            leagueTable.add(new TeamStatistics(result.teamHome));
            leagueTable.add(new TeamStatistics(result.teamGuest));
        } else {
            boolean isHomeTeamExist = false;
            boolean isGuestTeamExist = false;
            for (TeamStatistics member : leagueTable) {
                if (member.getTeamName().equals(result.teamHome)) {
                    isHomeTeamExist = true;
                }
                if (member.getTeamName().equals(result.teamGuest)) {
                    isGuestTeamExist = true;
                }
            }
            if (!isHomeTeamExist) {
                leagueTable.add(new TeamStatistics(result.teamHome));
            }
            if (!isGuestTeamExist) {
                leagueTable.add(new TeamStatistics(result.teamGuest));
            }


        }

        for (TeamStatistics member : leagueTable) {
            if (member.getTeamName().equals(result.teamHome)) {
                member.played(result.goalHome, result.goalGuest);
            }
            if (member.getTeamName().equals(result.teamGuest)) {
                member.played(result.goalGuest, result.goalHome);
            }
        }

    }

    public static class GameResult {
        private String teamHome;
        private String teamGuest;
        private int goalHome;
        private int goalGuest;

        public GameResult(String teamHome, String teamGuest, int goalHome, int goalGuest) {
            this.teamHome = teamHome;
            this.teamGuest = teamGuest;
            this.goalHome = goalHome;
            this.goalGuest = goalGuest;
        }
    }
}
