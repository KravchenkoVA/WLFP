import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class TeamDTO {

    private String logotype;

    private String name;

    private int game;

    private int win;
    private int draw;
    private int lose;
    private int goalsScored;
    private int goalsConceded;
    private int points;
    private String form;

    //TODO: Убрать костыль на парсинг имени, подумать, как сделать это красиво
    public TeamDTO(List<String> strings) {
        int nameCountWord = strings.size() - 7;
        String s = new String();
        for (int i = 0; i < nameCountWord; i++) {
            s += strings.get(i) + " ";
        }
        this.setName(s);
        this.setGame(Integer.parseInt(strings.get(nameCountWord)));
        this.setWin(Integer.parseInt(strings.get(nameCountWord + 1)));
        this.setDraw(Integer.parseInt(strings.get(nameCountWord + 2)));
        this.setLose(Integer.parseInt(strings.get(nameCountWord + 3)));
        this.setGoalsScored(Integer.parseInt(strings.get(nameCountWord + 4).split("-")[0]));
        this.setGoalsConceded(Integer.parseInt(strings.get(nameCountWord + 4).split("-")[1]));
        this.setPoints(Integer.parseInt(strings.get(nameCountWord + 5)));
        this.setForm(strings.get(nameCountWord + 6));
    }

    @Override
    public String toString() {
        return name + " " + game + " " + win + " " + draw + " " + lose +
                " " + goalsScored + "-" + goalsConceded + " " + points + " " + form;
    }

}