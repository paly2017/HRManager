package com.example.demo.service.serviceinter;

import com.example.demo.eneity.Lea;
import com.example.demo.eneity.PageInfo;
import org.springframework.data.domain.Page;

public interface LeaServiceI {

    boolean saveLeaInfo(Lea lea);

    PageInfo<Lea> leavesInfoByName(Lea lea, Long pageNo);
}
