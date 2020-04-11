package examples.overload;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * 测试重载的危险性
 *
 * @author huangding
 * @date 2020/4/8 21:52
 */
public class SetList {

    public static void main(String[] args) {
        Set<Integer> set = new TreeSet<Integer>();
        List<Integer> list = new ArrayList<Integer>();
        for (int i = -3; i < 3; i++) {
            set.add(i);
            list.add(i);
        }

        for (int i = 0; i < 3; i++) {
            //删除元素
            set.remove(i);
            //删除下标 混乱行为
//            list.remove(i);
            // 删除元素
            list.remove((Integer) i);
        }
        System.out.println(set + "---" + list);
    }
}
