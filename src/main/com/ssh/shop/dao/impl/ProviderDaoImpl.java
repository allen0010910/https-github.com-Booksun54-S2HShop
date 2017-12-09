package main.com.ssh.shop.dao.impl;

import main.com.ssh.shop.dao.ProviderDao;
import main.com.ssh.shop.entity.Provider;
import org.springframework.stereotype.Repository;

@Repository("providerDao")
public class ProviderDaoImpl extends BaseDaoImpl<Provider> implements ProviderDao {
}
