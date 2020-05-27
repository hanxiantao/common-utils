package hxt.utils;


import org.apache.commons.collections.CollectionUtils;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Created by hxt
 * Date 2020/5/28 6:56 上午
 * Description 集合工具类
 */
public class CollectionUtil extends CollectionUtils {

    /**
     * 映射集合的值到列表
     *
     * @param collection
     * @param mapper
     * @param <S>
     * @param <T>
     * @return
     */
    public static <S, T> List<T> mapToList(Collection<S> collection,
                                           Function<S, T> mapper) {
        return collection.stream().map(mapper).collect(Collectors.toList());
    }

    /**
     * 返回满足断言的元素
     *
     * @param collection
     * @param predicate
     * @param <T>
     * @return
     */
    public static <T> List<T> selectToList(Collection<T> collection,
                                           Predicate<T> predicate) {
        return collection.stream().filter(predicate).collect(Collectors.toList());
    }

    /**
     * 映射集合的值到map
     *
     * @param collection
     * @param keyMapper
     * @param valueMapper
     * @param <T>
     * @param <K>
     * @param <V>
     * @return
     */
    public static <T, K, V> Map<K, V> toMap(Collection<T> collection,
                                            Function<T, K> keyMapper,
                                            Function<T, V> valueMapper) {
        return collection.stream().collect(Collectors.toMap(keyMapper, valueMapper, (k1, k2) -> k1));
    }

    /**
     * 分组
     *
     * @param collection
     * @param classifier
     * @param <T>
     * @param <K>
     * @return
     */
    public static <T, K> Map<K, List<T>> groupingBy(Collection<T> collection,
                                                    Function<T, K> classifier) {
        return collection.stream().collect(Collectors.groupingBy(classifier));
    }

}