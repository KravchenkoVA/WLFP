package player;

import lombok.Data;

import java.util.List;
@Data
public class PlayerDTO {

    private String name;
    private List<BetDTO> bets;
    private Integer points;
}