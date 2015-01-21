package cn.yaofeng.finneen.system.resource.controller;

/**
 * Created by Finneen on 2015/1/20.
 */

import cn.yaofeng.finneen.core.controller.BaseController;
import cn.yaofeng.finneen.system.resource.entity.Resource;
import cn.yaofeng.finneen.system.resource.service.ResourceService;
import cn.yaofeng.finneen.system.resource.vo.TreeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Controller
@RequestMapping(value = "/resource")
public class ResourceController extends BaseController {
    
    @Autowired
    private ResourceService resourceService;
    
    
    @ResponseBody
    @RequestMapping(value = "/tree")
    public Object tree(HttpServletRequest request) {
        String pid_str = request.getParameter("pid");
        Long pid = Long.parseLong(pid_str);
        List<Resource> resourceList = resourceService.findAll();
        
        List<TreeVO> treeVOs = new ArrayList<TreeVO>();
        
        for (Resource resource : resourceList) {
            treeVOs.add(coverToTree(resource));
        }

        return treeVOs;
    }
    
    public TreeVO coverToTree(Resource resource) {        
        TreeVO treeVO = new TreeVO();
        treeVO.setId(resource.getId());
        treeVO.setName(resource.getResourceName());
        if (resource.getParent() != null) {
            treeVO.setPid(resource.getParent().getId());
        } else {
            treeVO.setParent(true);
            treeVO.setOpen(true);
        }
        return treeVO;
    }
    

}
