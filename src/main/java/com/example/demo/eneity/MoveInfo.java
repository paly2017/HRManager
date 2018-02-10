package com.example.demo.eneity;

public class MoveInfo {
    private Move move;
    private Department beforeDepartment;
    private Department afterDepartment;
    public MoveInfo() {
    }

    public MoveInfo(Move move, Department beforeDepartment, Department afterDepartment) {
        this.move = move;
        this.beforeDepartment = beforeDepartment;
        this.afterDepartment = afterDepartment;
    }

    public Move getMove() {
        return move;
    }

    public void setMove(Move move) {
        this.move = move;
    }

    public Department getBeforeDepartment() {
        return beforeDepartment;
    }

    public void setBeforeDepartment(Department beforeDepartment) {
        this.beforeDepartment = beforeDepartment;
    }

    public Department getAfterDepartment() {
        return afterDepartment;
    }

    public void setAfterDepartment(Department afterDepartment) {
        this.afterDepartment = afterDepartment;
    }

    @Override
    public String toString() {
        return "MoveInfo{" +
                "move=" + move +
                ", beforeDepartment=" + beforeDepartment +
                ", afterDepartment=" + afterDepartment +
                '}';
    }
}
