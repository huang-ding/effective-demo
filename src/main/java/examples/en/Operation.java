package examples.en;

import java.util.HashMap;
import java.util.Map;

/**
 * 使用枚举做一些普通的运算
 * <p>枚举和单列更配哦</p>
 *
 * @author huangding
 * @date 2020/4/7 21:38
 */
public enum Operation implements BaseEnumInterface {


    /**
     * 加
     */
    ADD("+") {
        public int val() {
            return 1;
        }

        @Override
        double apply(double x, double y) {
            return x + y;
        }
    },
    /**
     * 减法
     */
    SUB("-") {
        public int val() {
            return 2;
        }

        @Override
        double apply(double x, double y) {
            return x - y;
        }
    },
    /**
     * 乘法
     */
    MULTIPLY("*") {
        public int val() {
            return 3;
        }

        @Override
        double apply(double x, double y) {
            return x * y;
        }
    },
    /**
     * 除法
     */
    DIVIDE("/") {
        public int val() {
            return 4;
        }

        @Override
        double apply(double x, double y) {
            return x / y;
        }
    };

    abstract double apply(double x, double y);

    private final String symbol;

    Operation(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return symbol;
    }

    /**
     * 定义map 存储
     */
    private static final Map<String, Operation> OPERATION_MAP = new HashMap<String, Operation>(
        values().length);

    static {
        //使用静态块初始化
        for (Operation value : values()) {
            OPERATION_MAP.put(value.toString(), value);
        }
    }

    /**
     * 通过名字获取对应算法
     */
    public static Operation formString(String symbol) {
        return OPERATION_MAP.get(symbol);
    }

    static class Test {

        public static void main(String[] args) {
            System.out.println(Operation.ADD.apply(1, 2));
            System.out.println(Operation.formString("+").apply(1, 2));

        }
    }
}
