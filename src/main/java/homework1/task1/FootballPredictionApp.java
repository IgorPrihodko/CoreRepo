package homework1.task1;

public class FootballPredictionApp {

    public static void main(String[] args) {
        FootballPredictionApp footballPrediction = new FootballPredictionApp();
        System.out.println(footballPrediction.predictor(1, 1, 3, 3));
    }

    private int predictor(int goal1, int goal2, int preGoal1, int preGoal2) {
        return  (goal1 == preGoal1) && (goal2 == preGoal2) ? 2 : (goal1 > goal2) && (preGoal1 > preGoal2) ||
                (goal1 < goal2) && (preGoal1 < preGoal2) || (goal1 == goal2) && (preGoal1 == preGoal2) ? 1 : 0;
    }
}
