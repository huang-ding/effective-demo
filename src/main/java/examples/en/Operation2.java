package examples.en;

/**
 * @author huangding
 * @date 2020/4/8 20:27
 */
public enum Operation2 implements BaseEnumInterface {

    /**
     *
     */
    EXP("^") {
        public int val() {
            return 1;
        }
    },
    REMAINDER("%") {
        public int val() {
            return 2;
        }
    },
    ;

    private final String symbol;

    Operation2(String symbol) {
        this.symbol = symbol;
    }

    public static void main(String[] args) {
        int i = 0;
        int j = 1;
        for (String arg : args) {
            System.out.println(arg);
        }
        System.out.println(test(Operation2.EXP));
        System.out.println(test(Operation2.REMAINDER));
        System.out.println(test(Operation.ADD));

    }

    private static <T extends Enum<T> & BaseEnumInterface> int test(T opSet) {
        return opSet.val();
    }


}
