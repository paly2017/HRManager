package com.example.demo.eneity;

public class LeaInfo {
    private Lea lea;
    private History history;

    public LeaInfo() {
    }

    public LeaInfo(Lea lea, History history) {
        this.lea = lea;
        this.history = history;
    }

    public Lea getLea() {
        return lea;
    }

    public void setLea(Lea lea) {
        this.lea = lea;
    }

    public History getHistory() {
        return history;
    }

    public void setHistory(History history) {
        this.history = history;
    }

    @Override
    public String toString() {
        return "LeaInfo{" +
                "lea=" + lea +
                ", history=" + history +
                '}';
    }
}
