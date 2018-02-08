package com.example.demo.service.impl;

import com.example.demo.eneity.Lea;
import com.example.demo.eneity.PageInfo;
import com.example.demo.operational.IDepartmentOper;
import com.example.demo.operational.ILeaOper;
import com.example.demo.service.serviceinter.LeaServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

@Service
public class LeaServiceImpl implements LeaServiceI {
    @Autowired
    private ILeaOper iLeaOper;
    @Autowired
    private IDepartmentOper iDepartmentOper;

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
}
