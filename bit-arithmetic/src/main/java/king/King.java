package king;

public class King {

    public long getKingMoves(int position) {
        long kingPosition = 1l << position;
        long noA = 0xfefefefefefefefel;
        long noB = 0x7f7f7f7f7f7f7f7fl;
        long kingPositionA = noA & kingPosition;
        long kingPositionB = noB & kingPosition;
        long mask = (kingPositionA << 7) | (kingPosition << 8) | (kingPositionB << 9) |
                (kingPositionA >> 1) | (kingPositionB << 1) |
                (kingPositionA >> 9) | (kingPosition >> 8) | (kingPositionB >> 7);
        return mask;
    }
//100000000000000000000000000000000000000000000000000000000
//1000000001000000000000000000000000000000000000000000000000
//100000000100000000100000000100000000000000000000000000000000
    public long getHorseMovies(int position) {
        getElefantMovies(36);
        long horsePosition = 1l << position;
        long noAB = 0xfcfcfcfcfcfcfcfcl;
        long noGH = 0x3f3f3f3f3f3f3f3fl;
        long horsePositionA = noAB & horsePosition;
        long horsePositionB = noGH & horsePosition;
        long mask = (horsePositionA << 15) | (horsePositionB << 17) |
                (horsePositionA << 6) | (horsePositionA >> 10) | (horsePositionB << 10) | (horsePositionB >> 6) |
                (horsePositionA >> 17) | (horsePositionB >> 15);
        getRookMovies(27);
        return mask;
    }

    //ладья
    public long getRookMovies(int position) {

        /*
        вычисляем координаты осей
         */
        int moveX = position % 8;
        int moveY = position / 8;
        //.....
        long x = 0xffl;
        /*
        .
        .
        .
        .

         */
        long y = 0x101010101010101l;
        //сдвигаем
        //(moveX куда нужно сдвинуть по оси x.
        //умножаем на 8, тк каждый "этаж" по вертикали в 8 раз больше предыдущего)
        //moveY
        return ((x << moveX * 8) ^ y << moveY);
    }


    public long getElefantMovies(int position) {
        long elefantPosition = 1l << position;

        int moveX = position % 8;
        int moveY = position / 8;

        System.out.println(moveX + " moveX " + moveY + " moveY");

        long xy = 0x8040201008040201l;
        long yx = 0x102040810204080l;

        //нужна верхняя и нижняя маски
        long maskA = 0xc0e0f0f8fcfeffffl;
        long maskB2 = 0xff7f3f1f0f070301l;
        long maskA2 = 0x80c0e0f0f8fcfeffl;
        long maskB = 0x3070f1f3f7fffffl;

        long x = 0;
        long y = 0;
        if ((elefantPosition & maskA2) != 0) {
            System.out.println("maskA2");
            if (moveX == moveY) {
                 x  = maskA & xy;
                System.out.println(x + " xczxczx");
                if(moveY <= 3){
                    System.out.println((maskB & yx) + " maskB & yx " + (4 - moveY) + " 4 - moveY");
                    y = maskB & yx >> 4 - moveY;
                }else {
                    System.out.println((maskB & yx) + " maskB & yx " + (4 - moveY) + " 4 - moveY");
                    y = maskB & yx << 7 - moveY;
                }
                System.out.println((x ^ y) + " dddddddddd" + "x " + x + " y" + y);
            }
        } else if ((elefantPosition & maskB2) != 0) {
            System.out.println("maskB2");
        }

        return 0;
    }

    public int popCount(long mask) {
        int count = 0;
        while (mask > 0) {
            count++;
            mask &= mask - 1;
        }
        return count;
    }

}
