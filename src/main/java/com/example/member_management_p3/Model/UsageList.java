package com.example.member_management_p3.Model;

import java.util.List;

public class UsageList {
    private List<Usage> usages;

    public UsageList(List<Usage> usages) {
        this.usages = usages;
    }

    public UsageList() {
    }

    public List<Usage> getUsages() {
        return usages;
    }

    public void setUsages(List<Usage> usages) {
        this.usages = usages;
    }
}
