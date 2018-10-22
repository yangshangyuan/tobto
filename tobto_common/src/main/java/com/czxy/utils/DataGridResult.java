package com.czxy.utils;

import java.util.List;

public class DataGridResult {

    private Long total;
    private List rows;

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List getRows() {
        return rows;
    }

    public void setRows(List rows) {
        this.rows = rows;
    }

    public DataGridResult(Long total, List rows) {
        this.total = total;
        this.rows = rows;
    }

    public DataGridResult() {
    }
}
