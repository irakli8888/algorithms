package solver;

//оптимальный алгоритм
public class LuckyTicketsSolverImpl implements LuckyTicketsSolver {

    private int [] startValues = new int[10];
    int sum = 0; //сумма. Рассчитывается для каждого элемента массива valueMas
    int l = 0; //будем в цикле от 0...9 изменять данную переменную, отнимая от суммы чисел N

    //инициализируем первоначальный массив(n=1)(в дальнейшем, наличие числа в этом массиве будет означать,
    // что комбинация возможна)
    public LuckyTicketsSolverImpl() {
        for (int i = 0; i < 10; i++) {
            startValues[i] = i;
        }
    }
    
    @Override
    public long solve(int n){
        int [] valueMas = new int[n*9 + 1];//вычисляем максимальный размер массива для входящего n

        for (int i = 0; i < valueMas.length; i++) {//заполняем массив числовыми значениями комбинаций, возможных для сумм n чисел
            valueMas[i] = resume(n, i);
            sum = 0;//обнуляем счетчик для нового числа
        }

        long result = getResult(valueMas);

        return result;
    }

    @Override
    public int resume(int n, int value) {

        for(int i = 0; i <= 9; i++){
            l = value - i;
            if(n == 1 && checkForCompliance(l)){
                sum ++;
                break;
            }
            if(n == 1)break;

            if(l >= 0) {
                resume(n - 1, l);
            }
        }
        return sum;
    }

    @Override
    public boolean checkForCompliance(int v){
        for (int i = 0; i < startValues.length; i++) {
            if(startValues[i] == v){
                return true;
            }
        }return false;
    }

    @Override
    public long getResult(int[] mas){
        long result = 0;

        for (int i = 0; i < mas.length; i++) {
            result+= Math.pow(mas[i],2);
        }

        return result;
    }
}
