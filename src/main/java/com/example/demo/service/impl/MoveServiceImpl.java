package com.example.demo.service.impl;

import com.example.demo.eneity.Department;
import com.example.demo.eneity.Move;
import com.example.demo.eneity.MoveInfo;
import com.example.demo.operational.IDepartmentOper;
import com.example.demo.operational.IMoveOper;
import com.example.demo.service.serviceinter.MoveServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class MoveServiceImpl implements MoveServiceI {
    @Autowired
    private IMoveOper iMoveOper;
    @Autowired
    private IDepartmentOper iDepartmentOper;

    /***
     * 查询所有员工调动记录
     * @return
     */
    @Override
    public List<Move> moveListService() {
        return iMoveOper.findAll();
    }

    /***
     * 调动记录及部门信息
     * @return
     */
    public List<MoveInfo> moveInfos(){
        List<MoveInfo> moveInfoList = new ArrayList<>();
        List<Move> moveList = moveListService();
        for (Move move: moveList){
            Department beforedepartment = iDepartmentOper.findByDepartmentNumber(move.getBefore());
            Department afterdepartment = iDepartmentOper.findByDepartmentNumber(move.getAfter());
            moveInfoList.add(new MoveInfo(move,beforedepartment,afterdepartment));
        }
        return moveInfoList;
    }
}
