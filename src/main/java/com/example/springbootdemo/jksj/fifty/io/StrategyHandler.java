package com.example.springbootdemo.jksj.fifty.io;

public interface StrategyHandler<T, R> {
    @SuppressWarnings("rawtypes")
    StrategyHandler DEFAULT = t -> null;

    /**
     * apply strategy
     *
     * @param param
     * @return
     */
    R apply(T param);

}
