package com.czxy.utils.vo;

import java.util.ArrayList;
import java.util.List;

/**
 * 数据查询列表结果
 */
public class DataGridResultInfo implements ProcessResult {

    public DataGridResultInfo() {
    }


    public DataGridResultInfo(long total, List<?> rows) {
        super();
        this.total = total;
        this.rows = rows;
    }


    //总条数
    private long total;

    //结果集
    private List<?> rows = new ArrayList<>();

    //总计告诉footer
    private List<?> footer = new ArrayList<>();


    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<?> getRows() {
        return rows;
    }

    public void setRows(List<?> rows) {
        this.rows = rows;
    }

    public List<?> getFooter() {
        return footer;
    }

    public void setFooter(List<?> footer) {
        this.footer = footer;
    }

    @Override
    public String toString() {
        return "DataGridResultInfo{" +
                "total=" + total +
                ", rows=" + rows +
                ", footer=" + footer +
                '}';
    }
}
