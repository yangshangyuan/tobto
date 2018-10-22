package com.czxy.merchant.service;

import com.czxy.utils.DataGridResult;

public interface MDemoService {
    public DataGridResult findPage(Integer page, Integer rows);

    public void up(String str);

    public void load(String str);
}
