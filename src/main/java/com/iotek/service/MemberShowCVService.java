package com.iotek.service;

import com.iotek.model.MemberShowCV;

import java.util.List;

public interface MemberShowCVService {
    //投递简历
    boolean saveMemberShowCV(Integer rid,Integer vid);
}
