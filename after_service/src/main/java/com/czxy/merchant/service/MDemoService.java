package com.czxy.merchant.service;

import com.czxy.tobto.domain.MDemo;
import com.czxy.utils.DataGridResult;

public interface MDemoService {
    public DataGridResult findPage(String dName,Integer page, Integer rows);

    public void up(String str);

    public void load(String str);

   public void updataAll(MDemo mDemo);

   public void add(MDemo mDemo);
}
