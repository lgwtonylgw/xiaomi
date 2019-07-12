package cn.tedu.xiaomi.service.impl;

import cn.tedu.xiaomi.entity.Address;
import cn.tedu.xiaomi.entity.District;
import cn.tedu.xiaomi.mapper.AddressMapper;
import cn.tedu.xiaomi.service.IAddressService;
import cn.tedu.xiaomi.service.IDistrictService;
import cn.tedu.xiaomi.service.ex.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created on 2019/6/9 19:53
 *
 * @author Tony
 * @projectName xiaomi
 */
@Service
public class AddressService implements IAddressService {
    @Autowired
    private AddressMapper addressMapper;
    @Autowired
    private IDistrictService districtService;
     private static final int MAX_ADDRESS_COUNT=3;

    @Override
    public List<Address> getByUid(Integer uid) {
        return findByUid(uid);
    }
    public Address getByAid(Integer aid){
        return findByAid(aid);
    }

    @Override
    @Transactional
    public void delete(Integer aid, Integer uid, String username)
            throws UpdateException, AddressNotFoundException, DeleteException, AccessDeniedException {
        Address a=findByAid(aid);
        if(a==null){
            throw new AddressNotFoundException("删除收货地址失败，尝试访问的数据不存在！");
        }
        if(a.getUid()!=uid){
            throw new AccessDeniedException("删除收货地址失败，访问被拒绝");
        }
        deleteByAid(aid);
        if(a.getIsDefault()==0){
            return;
        }
        Integer count=countByUid(uid);
        if(count==0){
            return;
        }
        Address lastModified=findLastModified(uid);
        Integer lastModifiedAid=lastModified.getAid();
        Date now= new Date();
        updateDefault(lastModifiedAid,username,now);
    }

    @Override
    @Transactional(rollbackFor = ServiceException.class)
    public void setDefault(Integer aid, Integer uid, String username)
            throws AddressNotFoundException, UpdateException, AccessDeniedException {
        Address a=findByAid(aid);
        if(a==null){
            throw new AddressNotFoundException("删除收货地址失败，尝试访问的数据不存在！");
        }
        if(a.getUid()!=uid){
            throw new AccessDeniedException("删除收货地址失败，访问被拒绝");
        }
        UpdateNonDefault(uid);
        Date now =new Date();
        updateDefault(aid,username,now);
    }

    @Override

    public void addnew(Address address, String username) throws InsertException {
        Integer uid=address.getUid();
        Integer count=countByUid(uid);
        Integer isDefault=count==0?1:0;
        address.setIsDefault(isDefault);
        String district=getDistrict(address.getProvince(),address.getCity(),address.getArea());
        address.setDistrict(district);
        Date now =new Date();
        address.setCreatedTime(now);
        address.setCreatedUser(username);
        address.setModifiedTime(now);
        address.setModifiedUser(username);
        insert(address);
    }



    //---------------------------------------私有方法
    private void insert(Address address) {
        Integer rows=addressMapper.insert(address);
        if(rows!=1){
            throw new InsertException("增加收货地址失败！插入数据时出现未知错误！");
        }
    }

    private String getDistrict(String provinceCode, String cityCode, String areaCode) {
        StringBuilder result=new StringBuilder();
        District province=districtService.getByCode(provinceCode);
        District city=districtService.getByCode(cityCode);
        District area=districtService.getByCode(areaCode);
        if(province!=null){
            result.append(province.getName());
        }
        if(city!=null){
            result.append(city.getName());
        }
        if(area!=null){
            result.append(area.getName());
        }
        return result.toString();
    }

    private Integer countByUid(Integer uid) {
        if(uid==null){
            throw  new IllegalArgumentException();
        }
        return addressMapper.countByUid(uid);
    }

    private void UpdateNonDefault(Integer uid) {
        Integer rows=addressMapper.updateNonDefault(uid);
        if(rows<1){
            throw new UpdateException("设置默认地址失败，更新数据时发生未知错误！");
        }
    }


    private void updateDefault(Integer lastModifiedAid, String username, Date now) {
        Integer rows=addressMapper.updateDefault(lastModifiedAid,username,now);
        if(rows!=1){
            throw new UpdateException("设置默认地址失败，更新数据时发生未知错误！");
        }
    }

    private Address findLastModified(Integer uid) {
        return addressMapper.findLastModified(uid);
    }

    private void deleteByAid(Integer aid) {
        Integer rows=addressMapper.deleteByAid(aid);
        if(rows!=1){
            throw new DeleteException("删除收货地址失败，删除数据时出现未知错误！");
        }
    }
    private Address findByAid(Integer aid) {
        return addressMapper.findByAid(aid);
    }

    private List<Address> findByUid(Integer uid) {
        return addressMapper.findByUid(uid);
    }
}
