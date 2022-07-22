package team;

import lombok.Data;
import player.PlayerDTO;

import java.util.List;

@Data
public class GameDTO {
    private String teamA;
    private String teamB;
    private String goalA;
    private String goalB;
    private List<PlayerDTO> playersA;
    private List<PlayerDTO> playersB;
}