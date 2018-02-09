package com.example.demo.service.serviceinter;

import com.example.demo.eneity.Move;
import com.example.demo.eneity.MoveInfo;

import java.util.List;

public interface MoveServiceI {

    List<Move> moveListService();

    /**
     * 调动记录及部门信息
     * @return
     */
    List<MoveInfo> moveInfos();
}
