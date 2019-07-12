package cn.tedu.xiaomi.service.impl;

import cn.tedu.xiaomi.entity.District;
import cn.tedu.xiaomi.mapper.DistrictMapper;
import cn.tedu.xiaomi.service.IDistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created on 2019/6/10 9:49
 *
 * @author Tony
 * @projectName xiaomi
 */
@Service
public class DistrictServiceImpl implements IDistrictService {
    @Autowired
    private DistrictMapper mapper;
    @Override
    public List<District> getByParent(String parent) {
        return findByParent(parent);
    }


    @Override
    public District getByCode(String code) {
        return findByCode(code);
    }




    //--------------------------------------------私有方法
    private List<District> findByParent(String parent) {
        return mapper.findByParent(parent);
    }
    private District findByCode(String code) {
        return  mapper.findByCode(code);
    }
}
