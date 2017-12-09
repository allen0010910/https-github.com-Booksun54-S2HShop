package main.com.ssh.shop.action;

import main.com.ssh.shop.entity.Provider;
import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller("providerAction")
@Scope("prototype")
public class ProviderAction extends BaseAction<Provider> {

    private static Logger logger = Logger.getLogger(ProviderAction.class);

    public String toProvider() {

        return "success";
    }
}
