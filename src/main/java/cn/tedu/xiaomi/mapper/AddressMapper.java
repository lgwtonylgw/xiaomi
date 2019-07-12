package cn.tedu.xiaomi.mapper;

import cn.tedu.xiaomi.entity.Address;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * Created on 2019/6/9 19:54
 *
 * @author Tony
 * @projectName xiaomi
 */
public interface AddressMapper {
    List<Address> findByUid(Integer uid);

    Address findByAid(Integer aid);

    Integer deleteByAid(Integer aid);

    Address findLastModified(Integer uid);

    Integer updateDefault(@Param("aid") Integer aid,
                          @Param("modifiedUser") String modifiedUser,
                          @Param("modifiedTime") Date ModifiedTime);

    Integer updateNonDefault(Integer uid);

    Integer countByUid(Integer uid);

    Integer insert(Address address);
}
