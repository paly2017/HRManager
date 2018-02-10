package com.example.demo.service.serviceinter;

import com.example.demo.eneity.Lea;
import com.example.demo.eneity.LeaInfo;
import com.example.demo.eneity.PageInfo;
import org.springframework.data.domain.Page;

import java.util.List;

public interface LeaServiceI {

    boolean saveLeaInfo(Lea lea);

    PageInfo<Lea> leavesInfoByName(Lea lea, Long pageNo);

    List<Lea> leaList(Lea lea);

    List<LeaInfo> leaInfos(List<Lea> leas);

    Lea updateLea(Lea lea);

    Lea getLeaById(Long leaId);

    LeaInfo getLeaInfo(Lea lea);
}
