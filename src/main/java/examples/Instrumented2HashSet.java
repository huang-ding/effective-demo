package examples;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * 使用复合模式 实现部分功能
 * <p>当需要实现部分或扩展部分的时候使用装饰模式进行复合实现</p>
 * @author huangding
 * @date 2020/4/6 18:08
 */
public class Instrumented2HashSet<E> extends ForwardingSet<E> {

    public Instrumented2HashSet(Set<E> s) {
        super(s);
    }

    public static void main(String[] args) {
        Instrumented2HashSet<Integer> integers = new Instrumented2HashSet<Integer>(
            new HashSet<Integer>());
        integers.addAll(Arrays.asList(1, 2, 3));
        //输出1 正确
        System.out.println(integers.getAddCount());
    }

    /**
     * 添加元素的个数
     */

    private int addCount;

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
