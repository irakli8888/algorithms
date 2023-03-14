package calculator;

public class StepsOfChessPiecesCalculatorImpl implements StepsOfChessPiecesCalculator {

    /**
     * @param position ������� �� �������� ����� (A1 - 0, H8 - 63)
     * @return ����� (����� �����) ��������������� ��������� ����� �� ��������� �����
     */
    @Override
    public long getKingMoves(int position) {
        long kingPosition = 1l << position;
        long noA = 0xfefefefefefefefel;
        long noB = 0x7f7f7f7f7f7f7f7fl;
        long kingPositionA = noA & kingPosition;
        long kingPositionB = noB & kingPosition;
        long mask = (kingPositionA << 7) | (kingPosition << 8) | (kingPositionB << 9) |
                (kingPositionA >> 1) | (kingPositionB << 1) |
                (kingPositionA >> 9) | (kingPosition >> 8) | (kingPositionB >> 7);
        System.out.println(popCount(mask) + " - number of moves for the king");
        return mask;
    }

    /**
     * @param position ������� �� �������� ����� (A1 - 0, H8 - 63)
     * @return ����� (����� �����) ��������������� ��������� ����� �� ��������� �����
     */
    @Override
    public long getHorseMovies(int position) {
        long horsePosition = 1l << position;
        long noAB = 0xfcfcfcfcfcfcfcfcl;
        long noGH = 0x3f3f3f3f3f3f3f3fl;
        long horsePositionA = noAB & horsePosition;
        long horsePositionB = noGH & horsePosition;
        long mask = (horsePositionA << 15) | (horsePositionB << 17) |
                (horsePositionA << 6) | (horsePositionA >> 10) | (horsePositionB << 10) | (horsePositionB >> 6) |
                (horsePositionA >> 17) | (horsePositionB >> 15);
        System.out.println(popCount(mask) + " - number of moves for the horse");
        return mask;
    }

    /**
     * @param position ������� �� �������� ����� (A1 - 0, H8 - 63)
     * @return ����� (����� �����) ��������������� ��������� ����� �� ��������� �����
     */
    //�����
    @Override
    public long getRookMovies(int position) {

        /*
        ��������� ���������� ����
         */
        int moveX = position % 8;
        int moveY = position / 8;
        System.out.println(moveX + " moveX " + moveY + " moveY");
        //.....
        long x = 0xffl;
        /*
        .
        .
        .
        .

         */
        long y = 0x101010101010101l;
        //��������
        //(moveX ���� ����� �������� �� ��� x.
        //�������� �� 8, �� ������ "����" �� ��������� � 8 ��� ������ �����������)
        //moveY
        long mask = ((x << (moveY * 8)) ^ (y << moveX));
        System.out.println(popCount(mask) + " - number of moves for the rook");
        return mask;
    }

    /**
     * @param position ������� �� �������� ����� (A1 - 0, H8 - 63)
     * @return ����� (����� �����) ��������������� ��������� ����� �� ��������� �����
     */
    @Override
    //���� ������ �� ������ ��������� (x-0, y-0; ...; x-7, y-7;)
    //long xy = 0x8040201008040201l;
    public long getElephantMovies(int position) {
        long elephantPosition = 1l << position;

        int moveX = position % 8;
        int moveY = position / 8;

        //��������� (x-0, y-0; ...; x-7, y-7;)
        long xy = 0x8040201008040201l;
        //��������� (x-0, y-7; ...; x-7, y-0)
        long yx = 0x102040810204080l;

        //����� ������� � ������ �����
        //����� ���
        long maskNoABottom = 0xc0e0f0f8fcfeffffl;
        long maskNoATop =0xffff7f3f1f0f0703l;
        long maskABottom = 0x80c0e0f0f8fcfeffl;
        long maskATop = 0xff7f3f1f0f070301l;


        long maskNoBBottom = 0x3070f1f3f7fffffl;
        long maskNoBTop = 0xfffffefcf8f0e0c0l;
        long maskBBottom = 0x103070f1f3f7fl;
        long maskBTop = 0xfefcf8f0e0c08000l;


        long x = 0;
        long y = 0;
        if ((elephantPosition & maskABottom) != 0) {
            //���� ����� �� ������� ��������� (xy)
            if (moveX == moveY) {
                //����������� �����
                x = maskNoABottom & xy;
                if (moveY > 3) {
                    int mov = (moveX % 7) == 0 ? moveY : (moveX % 7) - 3;
                    y = maskBTop & (yx << mov);
                } else {
                    int mov = Math.abs(moveX - 7) - moveX;
                    y = maskBBottom & (yx >> mov);
                }
                long mask = x ^ y;
                System.out.println(popCount(mask) + " - number of moves for the elephant");
                return mask;
            }
        }
        return 0;
    }

    /**
     * ������� ��������� ��� (���������� ������� ��������� �����)
     * @param mask ����� �����
     * @return ������� ��������� �����
     */
    @Override
    public int popCount(long mask) {
        int count = 0;
        while (mask > 0) {
            count++;
            mask &= mask - 1;
        }
        return count;
    }

}
