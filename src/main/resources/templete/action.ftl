package ${packageName}.action;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alexgaoyh.common.action.BaseController;
import ${packageName}.entity.${className};
import ${packageName}.service.${className}Service;
import com.alexgaoyh.common.service.BaseService;

/**
 * 
 * @desc ${entityNameCN}action控制类
 *
 * @author ${author}
 * @${date}
 */
@Controller
@RequestMapping(value="${springName}")
public class ${className}Action extends BaseController<${className}> {

	private static final Logger LOGGER = Logger.getLogger(${className}.class);
	
	@Override
	@Resource(name = "${className}ServiceImpl")
	public void setBaseService(BaseService<${className}> baseService) {
		this.baseService = baseService;
	}

}
