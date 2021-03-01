package com.example.springbootdemo.util.collection;

import org.springframework.util.CollectionUtils;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class CollectionUtil {
    /**
     * 判断两个集合是否有交集
     */
    public static boolean isRetain(Collection<?> collection1,Collection<?> collection2){
        if(CollectionUtils.isEmpty(collection1) || CollectionUtils.isEmpty(collection2)){
            return false;
        }
        Set<?> set = new HashSet<>(collection1);
        for (Object item : collection2) {
            if(set.contains(item)){
                return true;
            }
        }
        return false;
    }

    /**
     * 差集
     */
    public static <T>  Collection<T> subTract(Collection<T> collection1 ,Collection<T> collection2){
        if(CollectionUtils.isEmpty(collection2)){
            return collection1;
        }
        Set<T> set = new HashSet<>(collection1);
        set.removeAll(collection2);
        return set;
    }
}
