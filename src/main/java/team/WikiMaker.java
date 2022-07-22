package team;

import java.util.Locale;

public class WikiMaker {

    public String makeWikiTeam(int i, TeamDTO teamDTO) {
        int position = i + 1;
        String delimiter = "|";
        if (position <= 3) {
            delimiter = "!";
        }
        String keyValue =
                "|-" + "\n" +
                        delimiter + position + "\n" +
                        delimiter + getLogotypeByName(teamDTO) + " " + teamDTO.getName() + "\n" +
                        delimiter + " <center>" + teamDTO.getGame() + " </center>" + "\n" +
                        delimiter + " <center>" + teamDTO.getWin() + " </center>" + "\n" +
                        delimiter + " <center>" + teamDTO.getDraw() + " </center>" + "\n" +
                        delimiter + " <center>" + teamDTO.getLose() + " </center>" + "\n" +
                        delimiter + " <center>" + teamDTO.getGoalsScored() + "-" + teamDTO.getGoalsConceded() + " </center>" + "\n" +
                        delimiter + " <center>" + teamDTO.getPoints() + " </center>" + "\n";
        String zone = "|" + "\n";

        if (position <= 2) {
            zone = "! <center>[[photo19012332_456242075|16x16px;nolink|Зона повышения - BL]]</center>" + "\n";
        } else if (position == 3) {
            zone = "| <center>[[photo19012332_457247569|16x16px;nolink|Зона повышения стыки- BL]]</center>" + "\n";
        }
        return keyValue + zone + "|" + formMaker(teamDTO) + "\n";
    }

    public String formMaker(TeamDTO teamDTO) {
        String forms = "";
        String resultFromFile = teamDTO.getForm();
        for (int i = 0; i < resultFromFile.length(); i++) {
            switch (String.valueOf(resultFromFile.charAt(i)).toLowerCase(Locale.ROOT)) {
                case "в":
                    forms = forms + "[[photo-45326351_343464835|16x16px| ]]";
                    break;
                case "н":
                    forms = forms + "[[photo-45326351_343464836|16x16px| ]]";
                    break;
                case "п":
                    forms = forms + "[[photo-45326351_343464838|16x16px| ]]";
                    break;
                default:
                    forms = forms + "";
            }
        }
        return forms;
    }

    public String getLogotypeByName(TeamDTO teamDTO) {
        switch (teamDTO.getName().toLowerCase(Locale.ROOT)) {
            case "neman ":
                return "[[photo-45326351_360413169|16x16px| ]]";
            case "sydney united ":
                return "[[photo467482603_456239648|16x16px| ]]";
            case "barysau ":
                return "[[photo19012332_457247604|16x16px| ]]";
            case "partizan ":
                return "[[photo-45326351_457239588|16x16px| ]]";
            case "incontrol ":
                return "[[photo-45326351_457239400|16x16px| ]]";
            case "new era ":
                return "[[photo19012332_457247602|16x16px| ]]";
            case "darida ":
                return "[[photo-45326351_457239587|16x16px| ]]";
            case "aurora fyi ":
                return "[[photo-45326351_457239586|16x16px| ]]";
            case "magnit ":
                return "[[photo-45326351_456239255|16x16px| ]]";
            case "wolves ":
                return "[[photo19012332_456241837|16x16px| ]]";
            case "torpedo ":
                return "[[photo19012332_457247603|16x16px| ]]";
            default:
                return "";
        }
    }

    String before = "<center>[[photo401345458_456239989|75x20px| ]]</center>\n" +
            "<center>'''ТУРНИРНАЯ ТАБЛИЦА СЕЗОНА 2021/22''' \n" +
            "<gray>'''После 23-го тура'''</gray></center>\n" +
            "\n" +
            "{|noborder;nomargin;nopadding\n" +
            "|~ 0\n" +
            "|-\n" +
            "! №\n" +
            "! КОМАНДА\n" +
            "! <center>И </center>\n" +
            "! <center>В </center>\n" +
            "! <center>Н </center>\n" +
            "! <center>П </center>\n" +
            "! <center> РМ </center>\n" +
            "! <center>O</center>\n" +
            "! " + "\n";
    String after = "|} \n" +
            "<br/><br/>\n" +
            "==Справка==\n" +
            "* '''№''' - позиция, '''И''' - игры, '''В''' - выигрыши, '''Н''' - ничьи, '''П''' - поражения, '''РМ''' - разница мячей, '''О''' - очки \n" +
            "* [[photo-86013010_413627538|75x75px|Выигрыш]], [[photo-86013010_413627540|75x75px|Ничья]], [[photo-86013010_413627539|75x75px|Поражение]] - форма команд \n" +
            "* Сезон состоит из 33 туров, 3-й круг проходит на нейтральных полях. \n" +
            "* '''Чемпион второй лиги Беларуси,''' '''серебряный призер чемпионата второй лиги Беларуси ''' попадают напрямую в высшую лигу Беларуси. '''3-е место чемпионата второй лиги Беларуси'''  играет два стыковых матча (по системе дома/гости) с '''14-м местом чемпионата Беларуси'''. '''Обладатель Кубка Беларуси''' - напрямую в групповой этап Лиги Европы. \n" +
            ":<br/> \n" +
            "\n" +
            "==АРХИВ==\n" +
            "* '''[[Таблица_BNL_20/21|Сезон 2020/21]]''' \n" +
            "* '''[[Таблица_BNL_19/20|Сезон 2019/20]]''' \n" +
            "* '''[[Таблица_BNL_18/19|Сезон 2018/19]]''' \n" +
            "* '''[[page-45326351_52903842|Сезон 2017/18]]''' \n";
}