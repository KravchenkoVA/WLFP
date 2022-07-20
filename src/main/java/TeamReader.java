import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TeamReader {

    public List<String> getTeamFromFile(String filePath) throws IOException {
        List<String> teams = new ArrayList<>();
        Path path = Paths.get(filePath);
        Scanner scanner = new Scanner(path);
        scanner.useDelimiter(System.getProperty("line.separator"));
        while (scanner.hasNext()) {
            teams.add(scanner.nextLine());
        }
        scanner.close();
        return teams;
    }

    public List<TeamDTO> createTeamList(List<String> teamString) {
        List<TeamDTO> teams = new ArrayList<>();
        List<String> arg = teamString.stream().peek(e -> e.split(" ")).collect(Collectors.toList());
        TeamDTO team = new TeamDTO(arg);
        teams.add(team);
        return teams;
    }

    public void createWiki(List<TeamDTO> teamList) throws IOException {
        WikiMaker wikiMaker = new WikiMaker();
        PrintWriter writer = new PrintWriter(new FileWriter("TeamsWiki.txt", false));
        writer.print(wikiMaker.before);
        for (int i = 0; i < teamList.size(); i++) {
            writer.print(wikiMaker.makeWikiTeam(i, teamList.get(i)));
        }
        writer.print(wikiMaker.after);
        writer.close();
    }
}