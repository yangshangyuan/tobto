package com.czxy.merchant.service;

import com.czxy.tobto.domain.MDemo;
import com.czxy.tobto.domain.TMerchant;
import com.czxy.utils.DataGridResult;

public interface MDemoService {
    public DataGridResult findPage(TMerchant tMerchant,String dName, Integer page, Integer rows);

    public void up(String str);

    public void load(String str);

   public void updataAll(MDemo mDemo);

   public void add(MDemo mDemo);
}
