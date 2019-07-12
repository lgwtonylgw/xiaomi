package cn.tedu.xiaomi.service;

import cn.tedu.xiaomi.entity.Address;
import cn.tedu.xiaomi.service.ex.*;

import java.util.List;

/**
 * Created on 2019/6/9 17:11
 *
 * @author Tony
 * @projectName xiaomi
 */
public interface IAddressService {
    List<Address> getByUid(Integer uid);
    Address getByAid(Integer aid);

    void delete(Integer aid, Integer uid, String username) throws UpdateException,
            AddressNotFoundException , DeleteException, AccessDeniedException;

    void setDefault(Integer aid, Integer uid, String username)
            throws AddressNotFoundException ,UpdateException,AccessDeniedException;

    void addnew(Address address, String username) throws InsertException;
}
