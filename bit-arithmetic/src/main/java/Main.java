import calculator.StepsOfChessPiecesCalculator;
import calculator.StepsOfChessPiecesCalculatorImpl;

public class Main {
    public static void main(String[] args) {
        StepsOfChessPiecesCalculator stepsOfChessPiecesCalculatorImpl = new StepsOfChessPiecesCalculatorImpl();
        System.out.println(stepsOfChessPiecesCalculatorImpl.getKingMoves(7));
        System.out.println(stepsOfChessPiecesCalculatorImpl.getHorseMovies(35));
        System.out.println(stepsOfChessPiecesCalculatorImpl.getRookMovies(60));
        System.out.println(stepsOfChessPiecesCalculatorImpl.getElephantMovies(27));

    }
}
