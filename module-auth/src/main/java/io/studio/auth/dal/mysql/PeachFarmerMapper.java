package io.studio.auth.dal.mysql;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.studio.auth.dal.dataobject.PeachFarmerDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Date:2023/12/4 17:43
 *
 * @Author:poboking
 */
@Mapper
public interface PeachFarmerMapper extends BaseMapper<PeachFarmerDO> {
    List<Integer> findAllCropArea();
    List<Integer> findAllCropCount();
    List<Integer> findAllVillageCropArea();
    List<Integer> findAllCooperationCropArea();
}
