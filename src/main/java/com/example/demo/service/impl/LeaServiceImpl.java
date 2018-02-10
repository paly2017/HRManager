package com.example.demo.service.impl;

import com.example.demo.eneity.History;
import com.example.demo.eneity.Lea;
import com.example.demo.eneity.LeaInfo;
import com.example.demo.eneity.PageInfo;
import com.example.demo.operational.IDepartmentOper;
import com.example.demo.operational.IHistoryOper;
import com.example.demo.operational.ILeaOper;
import com.example.demo.service.serviceinter.LeaServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LeaServiceImpl implements LeaServiceI {
    @Autowired
    private ILeaOper iLeaOper;
    @Autowired
    private IDepartmentOper iDepartmentOper;
    @Autowired
    private IHistoryOper iHistoryOper;

    /***
     * 请假申请信息保存
     * @param lea
     * @return
     */
    @Override
    public boolean saveLeaInfo(Lea lea) {
        Lea lea1 = iLeaOper.save(lea);
        if (null!=lea1)return true;
        return false;
    }

    /***
     * 请假信息，分页展示
     * @param lea
     * @param pageNo
     * @return
     */
    @Override
    public PageInfo<Lea> leavesInfoByName(Lea lea, Long pageNo) {
        Sort sort = new Sort(Sort.Direction.DESC,"days");
        Pageable pageable = new PageRequest(Math.toIntExact(pageNo),5,sort);
        Page<Lea> leaPage = iLeaOper.findAll(Example.of(lea),pageable);
        PageInfo<Lea> pageInfo = new PageInfo<Lea>(5L,pageNo+1, (long) leaPage.getTotalElements());
        pageInfo.settPage(leaPage);
        return pageInfo;
    }

    /***
     * 根据条件查询请假记录
     * @param lea
     * @return
     */
    @Override
    public List<Lea> leaList(Lea lea) {
        return  iLeaOper.findAll(Example.of(lea),new Sort(Sort.Direction.ASC,"id"));
    }

    /***
     * 封装请假人员信息
     * @param leas
     * @return
     */
    @Override
    public List<LeaInfo> leaInfos(List<Lea> leas) {
        if (leas==null)return null;
        List<LeaInfo> leaInfos = new ArrayList<>();
        for (Lea lea :leas){
            History history = iHistoryOper.findByEmployeeNumber(lea.getEmployeeNumber());
            leaInfos.add(new LeaInfo(lea,history));
        }
        return leaInfos;
    }

    /***
     * 更新请假记录
     * @param lea
     * @return
     */
    @Override
    public Lea updateLea(Lea lea) {
        if (lea==null)return null;
        return iLeaOper.saveAndFlush(lea);
    }

    /***
     * 根据lea id 返回Lea
     * @param leaId
     * @return
     */
    public Lea getLeaById(Long leaId){
        return iLeaOper.findOne(leaId);
    }

    /***
     * 封装请假记录及请假员工信息
     * @param lea
     * @return
     */
    public LeaInfo getLeaInfo(Lea lea){
        History history = iHistoryOper.findByEmployeeNumber(lea.getEmployeeNumber());
       return new LeaInfo(lea,history);
    }
}
