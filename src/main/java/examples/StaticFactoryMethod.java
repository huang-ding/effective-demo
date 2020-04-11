package examples;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 静态工厂方法的实现
 * <p>1.服务接口<p/>
 * <p>2.服务注册</p>
 * <p>3.服务访问</p>
 * <p>4.服务提供者（可缺省）接口</p>
 * 切忌第一反应就是提供公有的构造器而不优先考虑静态工厂
 *
 * @author huangding
 * @date 2020/4/1 20:43
 */
public class StaticFactoryMethod {

    /**
     * 定义一个服务接口
     */
    public interface Service {

        // ...
        String getName();
    }

    /**
     * 服务提供者接口
     */
    public interface Provider {

        /**
         * 创建服务
         */
        Service newService();
    }


    public static class ProviderA implements Provider {

        public Service newService() {
            return new Service() {
                public String getName() {
                    return "A";
                }
            };
        }
    }

    public static class ProviderB implements Provider {

        public Service newService() {
            return new Service() {
                public String getName() {
                    return "B";
                }
            };
        }
    }


    /**
     * 服务注册和访问
     */
    public static class Services {

        public static void main(String[] args) {
            //测试
            Services.registerProvider("a", new ProviderB());
            Services.registerProvider("b", new ProviderA());
            Service service = Services.newInstance("a");
            String name = service.getName();
            System.out.println(name);

        }

        //保证静态化
        private Services() {
        }

        //定义服务提供者缓存
        private static final Map<String, Provider> PROVIDERS = newConcurrentHashMap();

        private static final String DEF_PROVIDER_NAME = "<def>";

        //定义注册

        /**
         * 默认服务注册
         */
        public static void registerProvider(Provider p) {
            registerProvider(DEF_PROVIDER_NAME, p);
        }

        /**
         * 有名字的服务注册
         */
        public static void registerProvider(String providerName, Provider p) {
            PROVIDERS.put(providerName, p);
        }

        //定义访问

        /**
         * 获取默认实例
         */
        public static Service newInstance() {
            return newInstance(DEF_PROVIDER_NAME);
        }

        /**
         * 获取指定实例
         */
        public static Service newInstance(String name) {
            Provider provider = PROVIDERS.get(name);
            if (null == provider) {
                throw new IllegalArgumentException("no provider " + name + " instance");
            }
            return provider.newService();
        }

    }

    public static <K, V> HashMap<K, V> newHashMap() {
        return new HashMap<K, V>();
    }

    public static <K, V> ConcurrentHashMap<K, V> newConcurrentHashMap() {
        return new ConcurrentHashMap<K, V>();
    }


}
