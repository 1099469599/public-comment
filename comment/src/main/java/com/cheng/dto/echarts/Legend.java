package com.cheng.dto.echarts;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cheng on 2017/7/22.
 */
public class Legend {

    private List<String> data;

    public Legend() {
        this.data = new ArrayList<>();
    }

    public List<String> getData() {
        return data;
    }

    public void setData(List<String> data) {
        this.data = data;
    }
}
