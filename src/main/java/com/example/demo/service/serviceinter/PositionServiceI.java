package com.example.demo.service.serviceinter;

import com.example.demo.eneity.Position;
import org.springframework.data.domain.Page;

import java.util.List;

public interface PositionServiceI {
    Position getOnePosition(Long positionNum);

    List<Position> positionList();

    Page<Position> positionPageList(Long index);

    String positionDelete(Position position);
}
