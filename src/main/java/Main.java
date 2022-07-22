import game.ResultCounter;
import player.BetDTO;
import game.GameDTO;
import team.GostReader;
import team.TeamDTO;
import team.TeamReader;

import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        TeamReader teamReader = new TeamReader();
        String teamFile = "src/main/java/files/teams.txt";
        String gostFile = "src/main/java/files/gost";
        String resultFile = "src/main/java/files/result";

        List<TeamDTO> teams = teamReader.createTeamList(teamReader.getTeamFromFile(teamFile));
        teamReader.createWiki(teams);


        GostReader gostReader = new GostReader();
        GameDTO game = gostReader.createGame(gostReader.getFileInfo(gostFile));
        List<BetDTO> result = gostReader.getResult(gostReader.getFileInfo(resultFile));
        ResultCounter resultCounter = new ResultCounter();
        game.setPlayersA(resultCounter.getPoints(game.getPlayersA(),result));
        game.setPlayersB(resultCounter.getPoints(game.getPlayersB(),result));
        System.out.println(game);
    }
}
