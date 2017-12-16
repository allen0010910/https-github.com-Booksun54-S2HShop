package main.com.ssh.shop.service;

import main.com.ssh.shop.entity.Provider;

import java.util.List;

public interface ProviderService extends BaseService<Provider> {

    //查询供应商名称
    public List<Provider> queryToProvider(String name, int page, int size);//实现分页

    //根据关键字查询总记录数
    public Long getCount(String type);

    public void deleteProvider(int pno);

}
