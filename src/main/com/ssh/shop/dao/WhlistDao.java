package main.com.ssh.shop.dao;

import main.com.ssh.shop.entity.Whlist;

import java.util.List;

public interface WhlistDao extends BaseDao<Whlist> {

    //分页查询
    public List<Whlist> queryToWhlist(int wno, int page, int size);

    public List<Whlist> searchbyname(String name, int wno, int page, int size);

    public void deleteWhlist(int id);

    //根据关键字查询总记录数
    public Long getCountAll(int wno);
}
