package com.example.demo.service.impl;

import com.example.demo.eneity.Lea;
import com.example.demo.operational.IDepartmentOper;
import com.example.demo.operational.ILeaOper;
import com.example.demo.service.serviceinter.LeaServiceI;
import org.springframework.beans.factory.annotation.Autowired;
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
}
