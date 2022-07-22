package team;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

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

    public List<TeamDTO> createTeamList(List<String> teamStringList) {
        List<TeamDTO> teams = new ArrayList<>();
        for (String teamString : teamStringList) {
            TeamDTO team = new TeamDTO(Arrays.asList(teamString.split(" ")));
            teams.add(team);
        }
        return teams;
    }

    public void createWiki(List<TeamDTO> teamList) throws IOException {
        WikiMaker wikiMaker = new WikiMaker();
        PrintWriter writer = new PrintWriter(new FileWriter("src/main/java/files/TeamsWiki.txt", false));
        writer.print(wikiMaker.before);
        for (int i = 0; i < teamList.size(); i++) {
            writer.print(wikiMaker.makeWikiTeam(i, teamList.get(i)));
        }
        writer.print(wikiMaker.after);
        writer.close();
    }
}