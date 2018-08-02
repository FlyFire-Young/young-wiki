package org.young.wiki.entity;

import com.alibaba.fastjson.annotation.JSONField;

import javax.persistence.*;

/**
 * User: Young
 * Date: 2018/8/2 0002
 * Time: 16:41
 * To change this template use File | Settings | File Templates.
 * Description:
 */
@Entity
public class YBook extends AbstractEntity {

    /**
     * 应用所属用户
     */
    @JSONField(serialize = false)
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "user_id")
    private User user;

    /**
     * 书名
     */
    private String name;

    /**
     * 唯一标识
     */
    @Column(nullable = false, unique = true)
    private String bkey;

    /**
     * 描述
     */
    private String memo;

    /**
     * 标签
     */
    private String btag;

    /**
     * 是否导出
     */
    private boolean bexport;

    /**
     * 是否分享
     */
    private boolean bshare;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBkey() {
        return bkey;
    }

    public void setBkey(String bkey) {
        this.bkey = bkey;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getBtag() {
        return btag;
    }

    public void setBtag(String btag) {
        this.btag = btag;
    }

    public boolean isBexport() {
        return bexport;
    }

    public void setBexport(boolean bexport) {
        this.bexport = bexport;
    }

    public boolean isBshare() {
        return bshare;
    }

    public void setBshare(boolean bshare) {
        this.bshare = bshare;
    }
}
