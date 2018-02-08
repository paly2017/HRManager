package com.example.demo.service.impl;

import com.example.demo.eneity.Position;
import com.example.demo.operational.IPositionOper;
import com.example.demo.service.serviceinter.PositionServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionServiceImpl implements PositionServiceI {
    @Autowired
    private IPositionOper iPositionOper;
    @Override
    public Position getOnePosition(Long positionNum) {
        Position position = iPositionOper.findByPositionNumber(positionNum);
        if (null==position)return null;
        return position;
    }

    /***
     * 职位全查
     * @return
     */
    public List<Position> positionList(){
        return iPositionOper.findAll();
    }
}
