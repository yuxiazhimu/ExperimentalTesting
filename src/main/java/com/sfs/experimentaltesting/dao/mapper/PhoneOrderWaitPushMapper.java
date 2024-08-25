package com.sfs.experimentaltesting.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sfs.experimentaltesting.domin.phoneBill.PhoneOrderWaitPushNew;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface PhoneOrderWaitPushMapper extends BaseMapper<PhoneOrderWaitPushNew> {
    void saveBatch(@Param("phoneOrderWaitPushes") List<PhoneOrderWaitPushNew> phoneOrderWaitPushNews);
    List<Long> selectBatchOfIn(@Param("ids")List<Long> ids);
}
