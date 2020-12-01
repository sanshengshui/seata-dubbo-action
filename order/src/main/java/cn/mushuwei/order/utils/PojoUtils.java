package cn.mushuwei.order.utils;

import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author jamesmsw
 * @date 2020/12/1 9:10 下午
 */
@Slf4j
public class PojoUtils {

    public static <T> T copyProperties(Object source, Class<T> clazz) {
        if (source == null) {
            return null;
        }
        T target;
        try {
            target = clazz.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException("通过反射创建对象失败");
        }
        BeanUtils.copyProperties(source, target);
        return target;
    }

    public static <T> List<T> convertList(List<?> source, Class<T> clazz) {
        if (source == null || source.isEmpty()) {
            return Lists.newArrayList();
        }
        return source.stream().map(s -> copyProperties(s, clazz)).collect(Collectors.toList());
    }
}
