package rxt.bsb.rest.web;

import com.github.pagehelper.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rxt.bsb.rest.common.Enums.ResultCode;
import rxt.bsb.rest.common.page.PageInfo;
import rxt.bsb.rest.po.Permiss;
import rxt.bsb.rest.po.Role;
import rxt.bsb.rest.service.PermissService;
import rxt.bsb.rest.service.RoleService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@RestController
@RequestMapping("/role")
public class RoleController {


	private final static Logger logger = LoggerFactory.getLogger(RoleController.class);

	@Autowired
	private RoleService roleService;
	@Autowired
	private PermissService permissService;


	/**
	 * 角色数据分页查询
	 * @param request
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	@GetMapping( value = "page")
	Object queryRolePage(HttpServletRequest request, @RequestParam(name = "pageNo" ,defaultValue = "1") int pageNo , @RequestParam(name = "pageSize" ,defaultValue = "10")int pageSize ){
		Page<Role> page = roleService.queryRolePage(pageNo,pageSize);
		PageInfo<Role> pageInfo=  new PageInfo<>(page);
		return pageInfo;
	}


	/**
	 * 获取角色集合
	 * @param request
	 * @return
	 */
	@GetMapping( value = "list" )
	Object queryRoleList(HttpServletRequest request ){
		return roleService.roleList();

	}


	/**
	 * 保存角色
	 * @param r
	 * @return
	 */
	@PostMapping( value = "save" )
	public Object  saveRoler(Role r) {
		return roleService.saveRole( r) == 1 ? ResultCode.SUCCESS : ResultCode.ERROR;

	}

	/**
	 * 更新
	 * @param r
	 * @return
	 */
	@PostMapping( value = "update" )
	public  Object updateRole(Role r ) {
		return roleService.updateRole( r) == 1 ? ResultCode.SUCCESS : ResultCode.ERROR;

	}

	/**
	 * 删除
	 * @param r
	 * @return
	 */
	@DeleteMapping( value = "rm/{id}" )
	public  Object rmRole(Role r ) {
		return roleService.rmRole( r )  == 1 ? ResultCode.SUCCESS : ResultCode.ERROR;
	}

	/**
	 * 查询菜单集合
	 * @param request
	 * @return
	 */
	@GetMapping( value = "/permiss" )
	public Object cacheOfList(HttpServletRequest request){
		List<Permiss> permAll = permissService.queryPermissList();
		return  permAll;
	}


	/**
	 * 添加菜单信息
	 * @param request
	 * @param pdata
	 * @return
	 */
	@PostMapping( value = "/permiss/save")
	public Object save(HttpServletRequest request,  String  pdata){
		return  permissService.save( pdata );
	}


}
