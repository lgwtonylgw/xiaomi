package cn.tedu.xiaomi.vo;

import java.io.Serializable;

/**
 * Created on 2019/6/10 18:50
 *
 * @author Tony
 * @projectName xiaomi
 */
public class CartVO implements Serializable {
    private static final long serialVersionUID = 5572984205499835246L;
    private  Integer cid;
    private  Long gid;
    private  String image;
    private Integer num;
    private  Long price;
    private  String title;

    @Override
    public String toString() {
        return "CartVO{" +
                "cid=" + cid +
                ", gid=" + gid +
                ", image='" + image + '\'' +
                ", num=" + num +
                ", price=" + price +
                ", title='" + title + '\'' +
                '}';
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Long getGid() {
        return gid;
    }

    public void setGid(Long gid) {
        this.gid = gid;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
