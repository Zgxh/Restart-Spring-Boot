package com.zgxh.service.impl;

import com.zgxh.service.Calculator;
import org.springframework.stereotype.Service;

/**
 * @author Yu Yang
 * @create 2020-06-10 23:52
 */
@Service
public class MyCalculator implements Calculator {
    @Override
    public int add(int i, int j) {
        return i + j;
    }

    @Override
    public int sub(int i, int j) {
        return i - j;
    }

    @Override
    public int mul(int i, int j) {
        return i * j;
    }

    @Override
    public int div(int i, int j) {
        return i / j;
    }
}
