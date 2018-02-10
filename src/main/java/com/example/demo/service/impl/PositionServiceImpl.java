package com.example.demo.service.impl;

import com.example.demo.eneity.History;
import com.example.demo.eneity.Position;
import com.example.demo.operational.IHistoryOper;
import com.example.demo.operational.IPositionOper;
import com.example.demo.service.serviceinter.PositionServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionServiceImpl implements PositionServiceI {
    @Autowired
    private IPositionOper iPositionOper;
    @Autowired
    private IHistoryOper iHistoryOper;
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

    /***
     * 职称分页查询
     * @return
     */
    public Page<Position> positionPageList(Long index){
        index=index<1||index==null?1:index;
        Pageable pageable = new PageRequest((int) (index-1),5);
        return iPositionOper.findAll(pageable);
    }

    /***
     * 职称删除
     * @param position
     * @return
     */
    public String positionDelete(Position position){
        Position position1 = iPositionOper.findOne(Example.of(position));
        if (null==position1)return "删除的数据不存在";
        History history = new History();
        history.setPositionNumber(position1.getPositionNumber());
       List<History> historyList = iHistoryOper.findAll(Example.of(history));
       if (null==historyList||historyList.size()==0){
           iPositionOper.delete(position1);
           return "删除成功";
       }
       return "不可以删除!";
    }

    /***
     * 任意条件查询Position
     * @param position
     * @return
     */
    public Position getPostition(Position position){
        return iPositionOper.findOne(Example.of(position));
    }

    /***
     * 查找用户权限，无重复
     * @return
     */
    @Override
    public List<String> getLevel() {
       return iPositionOper.getLevelInfo();
    }

    /***
     * 保存或者更新position
     * @param position
     * @return
     */
    @Override
    public Position svaeAndUpdata(Position position) {
        return iPositionOper.saveAndFlush(position);
    }

    /**
     * 获得最大职称编号
     * @return
     */
    @Override
    public Long getMaxPostitionNumber() {
        return Long.valueOf(iPositionOper.getMaxPositionNumber());
    }
}
