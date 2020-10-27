package com.service;

public interface ConvertService {

    /**
     * 支持0-9输入
     * @param input
     * @return
     */
    String getConvertFir(int[] input);

    /**
     * 支持0-99输入
     * @param input
     * @return
     */
    String getConvertSec(int[] input);
}
