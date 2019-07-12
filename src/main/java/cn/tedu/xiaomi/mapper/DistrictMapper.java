package cn.tedu.xiaomi.mapper;

import cn.tedu.xiaomi.entity.District;

import java.util.List;

/**
 * Created on 2019/6/10 9:51
 *
 * @author Tony
 * @projectName xiaomi
 */
public interface DistrictMapper {

    List<District> findByParent(String parent);

    District findByCode(String code);
}
