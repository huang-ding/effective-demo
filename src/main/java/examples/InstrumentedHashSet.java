package examples;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

/**
 * 复合优先于继承
 * <p>测试继承的不确定性</p>
 *
 * @author huangding
 * @date 2020/4/6 17:37
 */
public class InstrumentedHashSet<E> extends HashSet<E> {


    public static void main(String[] args) {
        InstrumentedHashSet<String> instrumentedHashSet = new InstrumentedHashSet<String>();
        instrumentedHashSet.addAll(Arrays.asList("111", "222", "333"));
        //看起来应该是3
        System.out.println(instrumentedHashSet.getAddCount());
        //实际情况好像不太对哦,因为addAll调用了add的方法输出了4，当父类不太了解时 使用继承好像容易出幺蛾子哦


    }

    /**
     * 添加元素的个数
     */

    private int addCount;

    public InstrumentedHashSet() {
        super();
    }

    public InstrumentedHashSet(int initialCapacity, float loadFactor) {
        super(initialCapacity, loadFactor);
    }

    @Override
    public boolean add(E e) {
        addCount++;
        return super.add(e);
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        addCount++;
        return super.addAll(c);
    }

    public int getAddCount() {
        return addCount;
    }


}
