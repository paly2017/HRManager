package com.example.demo.service.serviceinter;

import com.example.demo.eneity.Position;

import java.util.List;

public interface PositionServiceI {
    Position getOnePosition(Long positionNum);

    List<Position> positionList();
}
