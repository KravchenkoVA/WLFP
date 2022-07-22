import team.GameDTO;
import team.GostReader;
import team.TeamDTO;
import team.TeamReader;

import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        TeamReader teamReader = new TeamReader();
        String filePath = "src/main/java/files/teams.txt";
        List<TeamDTO> teams = teamReader.createTeamList(teamReader.getTeamFromFile(filePath));
        teamReader.createWiki(teams);

        String filePath2 = "src/main/java/files/gost";
        GostReader gostReader = new GostReader();
        GameDTO game = gostReader.createGame(gostReader.getGostInfo(filePath2));
        System.out.println(game);
    }
}
