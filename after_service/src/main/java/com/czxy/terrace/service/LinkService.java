package com.czxy.terrace.service;


import com.czxy.tobto.domain.TFinds;
import com.czxy.utils.vo.DataGridResultInfo;

public interface LinkService {


    public DataGridResultInfo findAllTFinds(String fName,Integer page, Integer rows);

    public int addLink(TFinds tFinds);

    public void update(TFinds tFinds);

    public void deleted(int i);


    public void syncLink(TFinds tFinds);
}
