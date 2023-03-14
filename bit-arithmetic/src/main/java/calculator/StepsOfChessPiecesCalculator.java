package calculator;

public interface StepsOfChessPiecesCalculator {
    long getKingMoves(int position);

    long getHorseMovies(int position);

    //�����
    long getRookMovies(int position);

    long getElephantMovies(int position);

    int popCount(long mask);
}
