package king;

public class King {

    public long getKingMoves(int position){
       long kingPosition = 1l << position;
       long noA = 0xfefefefefefefefel;
       long noB = 0x7f7f7f7f7f7f7f7fl;
       long kingPositionA = noA & kingPosition;
       long kingPositionB = noB & kingPosition;
       long mask = (kingPositionA << 7) | (kingPosition << 8) | (kingPositionB << 9) |
                   (kingPositionA >> 1)                       | (kingPositionB << 1) |
                   (kingPositionA >> 9) | (kingPosition >> 8) | (kingPositionB >> 7);
       return mask;
    }
}
