package com.sutao.atcrowdfunding.manager.mapper;

import com.sutao.atcrowdfunding.bean.TAccountTypeCert;
import com.sutao.atcrowdfunding.bean.TAccountTypeCertExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TAccountTypeCertMapper {
    int countByExample(TAccountTypeCertExample example);

    int deleteByExample(TAccountTypeCertExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TAccountTypeCert record);

    int insertSelective(TAccountTypeCert record);

    List<TAccountTypeCert> selectByExample(TAccountTypeCertExample example);

    TAccountTypeCert selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TAccountTypeCert record, @Param("example") TAccountTypeCertExample example);

    int updateByExample(@Param("record") TAccountTypeCert record, @Param("example") TAccountTypeCertExample example);

    int updateByPrimaryKeySelective(TAccountTypeCert record);

    int updateByPrimaryKey(TAccountTypeCert record);
}