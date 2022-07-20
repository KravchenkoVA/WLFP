import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        TeamReader teamReader = new TeamReader();
        String filePath = "teams.txt";
        List<TeamDTO> teams = teamReader.createTeamList(teamReader.getTeamFromFile(filePath));
        teamReader.createWiki(teams);
    }
}
