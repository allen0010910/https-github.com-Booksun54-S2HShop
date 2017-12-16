package main.com.ssh.shop.service.impl;

import main.com.ssh.shop.entity.Provider;
import main.com.ssh.shop.service.ProviderService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("providerService")
public class ProviderServiceImpl extends BaseServiceImpl<Provider> implements ProviderService {


    @Override
    public List<Provider> queryToProvider(String name, int page, int size) {

        return providerDao.queryToProvider(name, page, size);
    }

    @Override
    public Long getCount(String pname) {
        return providerDao.getCount(pname);
    }

    @Override
    public void deleteProvider(int pno) {
        providerDao.deleteProvider(pno);
    }
}
