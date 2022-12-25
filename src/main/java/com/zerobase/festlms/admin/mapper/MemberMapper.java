package com.zerobase.festlms.admin.mapper;

import com.zerobase.festlms.admin.dto.MemberDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemberMapper {

    List<MemberDto> selectList(MemberDto parameter);

}
