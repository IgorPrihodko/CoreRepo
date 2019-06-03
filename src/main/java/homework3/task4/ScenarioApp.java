package homework3.task4;

public class ScenarioApp {

    public static void main(String[] args) {
        String[] role = {"Городничий", "Аммос Федорович", "NoReplic", "Артемий Филиппович", "Лука Лукич"};
        String[] text = {"Городничий: Я пригласил вас, господа, с тем," +
                " чтобы сообщить вам пренеприятное известие: к нам едет ревизор.",
                "Аммос Федорович: Как ревизор?", "Артемий Филиппович: Как ревизор?",
                "Городничий: Ревизор из Петербурга, инкогнито. И еще с секретным предписаньем.",
                "Аммос Федорович: Вот те на!", "Артемий Филиппович: Вот не было заботы, так подай!",
                "Лука Лукич: Господи боже! еще и с секретным предписаньем!"};
        ScenarioApp scenario = new ScenarioApp();
        System.out.println(scenario.printTextPerRole(role, text));

    }

    private String printTextPerRole(String[] roles, String[] textLines) {

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < roles.length; i++) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(roles[i]).append(":" + "\n");
            for (int j = 0; j < textLines.length; j++) {
                if (textLines[j].substring(0, (textLines[j].indexOf(':'))).equalsIgnoreCase(roles[i])) {
                    stringBuffer.append(j + 1).append(')')
                            .append(textLines[j].substring(textLines[j].indexOf(':') + 1) + "\n");
                }
            }
            stringBuilder.append(stringBuffer).append("\n");
        }
        return stringBuilder.toString();
    }
}
