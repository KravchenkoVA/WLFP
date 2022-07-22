package team;

import player.BetDTO;
import player.PlayerDTO;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class GostReader {

    public List<String> getGostInfo(String filePath) throws IOException {
        List<String> data = new ArrayList<>();
        Path path = Paths.get(filePath);
        Scanner scanner = new Scanner(path);
        scanner.useDelimiter(System.getProperty("line.separator"));
        while (scanner.hasNext()) {
            data.add(scanner.nextLine());
        }
        scanner.close();
        return data;
    }

    public GameDTO createGame(List<String> gostInfo) {
        List<String> names = Arrays.asList(gostInfo.get(0).replace(" ", "").split("-"));
        gostInfo.set(0, "");

        GameDTO game = new GameDTO();
        game.setTeamA(names.get(0));
        game.setTeamB(names.get(1));
        List<List<PlayerDTO>> teams = getTeams(gostInfo);
        game.setPlayersA(teams.get(0));
        game.setPlayersA(teams.get(1));
        return game;
    }

    public List<List<PlayerDTO>> getTeams(List<String> gostInfo){
        List<List<PlayerDTO>> teams = new ArrayList<>();
        List<Integer> position = new ArrayList<>();
        Integer spliter = 0;
        for (int i = 0; i < gostInfo.size(); i++) {
            if (((gostInfo.get(i).equals(""))) || (gostInfo.get(i).contains("="))) {
                position.add(i);
                if((gostInfo.get(i).contains("="))) {
                    spliter = i;
                }
            }
        }
        position = position.stream().distinct().collect(Collectors.toList());
        position.add(position.get(position.size()-1)+4);

        int breakPosition = 0;
        for (int i = 0; i < position.size(); i++) {
            if (position.get(i)==spliter){
                breakPosition = i;
                break;
            }
        }
        List<PlayerDTO> teamA = new ArrayList<>();
        List<PlayerDTO> teamB = new ArrayList<>();
        for (int i = 0; i < breakPosition; i++) {
            teamA.add(playerMaker(gostInfo, position, i));
        }
        for (int i = breakPosition; i < position.size()-1; i++) {
            teamB.add(playerMaker(gostInfo, position, i));
        }
        teams.add(teamA);
        teams.add(teamB);
        return teams;
    }

    private PlayerDTO playerMaker(List<String> gostInfo, List<Integer> position, int i){
        List<String> data = gostInfo.subList(position.get(i) + 1, position.get(i + 1));
        PlayerDTO player = new PlayerDTO();
        List<BetDTO> bets = new ArrayList<>();
        for (int j = 1; j < data.size(); j++) {
            BetDTO bet = new BetDTO();
            bet.setGameNumber(Integer.parseInt(data.get(j).substring(0,1)));
            String[] del = data.get(j).split(" ");
            bet.setScore(del[1]);
            bets.add(bet);
            player.setName(data.get(0));
            player.setBets(bets);
        }
        return player;
    }
}