package ${packageName}.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import ${packageName}.dao.${className}Dao;
import ${packageName}.entity.${className};
import ${packageName}.service.${className}Service;
import com.alexgaoyh.common.dao.BaseDao;
import com.alexgaoyh.common.service.impl.BaseServiceImpl;

/**
 * 
 * @desc ${entityNameCN}service接口实现类
 *
 * @author ${author}
 * @${date}
 */
@Service
public class ${className}ServiceImpl extends BaseServiceImpl<${className}> implements ${className}Service {

	@Override
	@Resource(name ="${springName}DaoImpl")
	public void setBaseDao(BaseDao<${className}> dao) {
		this.baseDao =  dao;
	}
	
	private ${className}Dao getDao(){
		return (${className}Dao) this.baseDao ;
	}
	


}
