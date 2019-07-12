package cn.tedu.xiaomi.vo;

import cn.tedu.xiaomi.entity.OrderItem;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created on 2019/6/11 15:09
 *
 * @author Tony
 * @projectName xiaomi
 */
public class OrderVO implements Serializable {
    private static final long serialVersionUID = -5922706760099455037L;
    private Integer oid;
    private Integer uid;
    private String name;
    private String phone;
    private String address;
    private Long totalPrice;
    private Integer state;
    private Date orderTime;
    private Date payTime;
    private List<OrderItem> orderItems;

    @Override
    public String toString() {
        return "OrderVO{" +
                "oid=" + oid +
                ", uid=" + uid +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", totalPrice=" + totalPrice +
                ", state=" + state +
                ", orderTime=" + orderTime +
                ", payTime=" + payTime +
                ", orderItems=" + orderItems +
                '}';
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getOid() {
        return oid;
    }

    public void setOid(Integer oid) {
        this.oid = oid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Long totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }
}
