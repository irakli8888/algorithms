package calculator;

public interface StepsOfChessPiecesCalculator {
    long getKingMoves(int position);

    long getHorseMovies(int position);

    //ладья
    long getRookMovies(int position);

    long getElephantMovies(int position);

    int popCount(long mask);
}
