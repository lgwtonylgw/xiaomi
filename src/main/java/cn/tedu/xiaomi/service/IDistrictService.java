package cn.tedu.xiaomi.service;

import cn.tedu.xiaomi.entity.District;

import java.util.List;

/**
 * Created on 2019/6/10 9:47
 *
 * @author Tony
 * @projectName xiaomi
 */
public interface IDistrictService {
    List<District> getByParent(String parent);

    District getByCode(String cityCode);
}
