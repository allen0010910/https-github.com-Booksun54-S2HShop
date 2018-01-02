package main.com.ssh.shop.service;

import main.com.ssh.shop.entity.Whlist;

import java.util.List;

public interface WhlistService extends BaseService<Whlist> {

    //分页查询
    public List<Whlist> queryToWhlist(int wno, int page, int size);

    public List<Whlist> searchbyname(String name, int wno, int page, int size);

    //根据关键字查询总记录数
    public Long getCountAll(int wno);

    public void deleteWhlist(int id);

    //销售或者订单类更新仓库库存数量
    public void updateWlBytype(int type, int num, int wlno);

}
