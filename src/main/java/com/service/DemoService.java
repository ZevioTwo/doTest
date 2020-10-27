package com.service;

public interface DemoService {

    /**
     * 支持0-9输入
     * @param input
     * @return
     */
    String getTest1(int[] input);

    /**
     * 支持0-99输入
     * @param input
     * @return
     */
    String getTest2(int[] input);
}
