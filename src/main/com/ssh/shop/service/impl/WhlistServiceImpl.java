package main.com.ssh.shop.service.impl;

import main.com.ssh.shop.entity.Whlist;
import main.com.ssh.shop.service.WhlistService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("whlistService")
public class WhlistServiceImpl extends BaseServiceImpl<Whlist> implements WhlistService {

    @Override
    public List<Whlist> queryToWhlist(int wno, int page, int size) {
        return whlistDao.queryToWhlist(wno, page, size);
    }

    @Override
    public List<Whlist> searchbyname(String name, int wno, int page, int size) {
        return whlistDao.searchbyname(name, wno, page, size);
    }

    @Override
    public Long getCountAll(int wno) {
        return whlistDao.getCountAll(wno);
    }

    @Override
    public void deleteWhlist(int id) {
        whlistDao.deleteWhlist(id);
    }
}
