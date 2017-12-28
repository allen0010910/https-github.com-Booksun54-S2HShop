package main.com.ssh.shop.action;


import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.util.logging.LoggerFactory;
import main.com.ssh.shop.entity.FileImage;
import main.com.ssh.shop.service.*;
import main.com.ssh.shop.util.FileUpload;
import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;


import javax.annotation.Resource;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

@Controller("baseAction")
@Scope("prototype")
public class BaseAction<T> extends ActionSupport implements RequestAware, SessionAware, ApplicationAware, ModelDriven<T> {

    //service对象
    @Resource
    protected UserService userService;
    @Resource
    protected MenuService menuService;
    @Resource
    protected ProviderService providerService;
    @Resource
    protected WarehouseService warehouseService;
    @Resource
    protected GoodsService goodsService;
    @Resource
    protected WhlistService whlistService;
    @Resource
    protected StockService stockService;


    //封装了图片信息的类
    protected FileImage fileImage;


    //上传文件工具类
    @Resource
    protected FileUpload fileUpload;

    public FileUpload getFileUpload() {
        return fileUpload;
    }

    public void setFileUpload(FileUpload fileUpload) {
        this.fileUpload = fileUpload;
    }

    public FileImage getFileImage() {
        return fileImage;
    }

    public void setFileImage(FileImage fileImage) {
        this.fileImage = fileImage;
    }


    //page和rows和分页有关，pageMap存放查询的数据，然后打包成json格式用的
    //page和rows实现get和set方法，pageMap只需要实现get方法即可，因为pageMap不是接收前台参数的，是让struts获取的
    protected Integer page;
    protected Integer rows;
    protected Map<String, Object> pageMap = null;//让不同的Action自己去实现

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }

    public Map<String, Object> getPageMap() {
        return pageMap;
    }

    public void setPageMap(Map<String, Object> pageMap) {
        this.pageMap = pageMap;
    }

    protected Map<String, Object> request;
    protected Map<String, Object> session;
    protected Map<String, Object> application;

    protected T model;

    public List<T> getJsonList() {
        return jsonList;
    }

    //用来装有将要被打包成json格式返回给前台的数据，下面要实现get方法
    protected List<T> jsonList = null;

    @Override
    public void setApplication(Map<String, Object> application) {
        this.application = application;
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }

    @Override
    public void setRequest(Map<String, Object> request) {
        this.request = request;
    }


    @Override
    public T getModel() { //这里通过解析传进来的T来new一个对应的instance
        ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
        Class clazz = (Class) type.getActualTypeArguments()[0];
        try {
            model = (T) clazz.newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return model;
    }
}