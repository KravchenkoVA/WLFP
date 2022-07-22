package game;

import player.BetDTO;
import player.PlayerDTO;

import java.util.List;
import java.util.stream.Collectors;

public class ResultCounter {

    public List<PlayerDTO> getPoints(List<PlayerDTO> players, List<BetDTO> results) {
        for (int i = 0; i < players.size(); i++) {
            List<BetDTO> betsByPlayer = players.get(i).getBets();
            for (int j = 0; j < betsByPlayer.size(); j++) {
                int gameNumber = betsByPlayer.get(j).getGameNumber();
                List<String> result = results.stream()
                        .filter(e -> e.getGameNumber().equals(gameNumber))
                        .map(BetDTO::getScore).collect(Collectors.toList());
                BetDTO betDTO = betsByPlayer.get(j);
                if (betsByPlayer.get(j).getScore().equals(result.get(0))) {
                    betDTO.setPoints(2);
                } else {
                    String[] itogi = betsByPlayer.get(j).getScore().split("-");
                    String[] itogi2 = result.get(0).split("-");
                    int partResult = Integer.parseInt(itogi[0]) - Integer.parseInt(itogi[1]);
                    int partResult2 = Integer.parseInt(itogi2[0]) - Integer.parseInt(itogi2[1]);
                    if ((partResult > 0 && partResult2 > 0) || (partResult == 0 && partResult2 == 0) || (partResult < 0 && partResult2 < 0)) {
                        betDTO.setPoints(1);
                    } else betDTO.setPoints(0);
                }
                betsByPlayer.set(j, betDTO);
                PlayerDTO playerDTO = players.get(i);
                playerDTO.setBets(betsByPlayer);
                players.set(i, playerDTO);
            }
        }
        return players;
    }
}