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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/resource")
public class ResourceController extends BaseController {
    
    @Autowired
    private ResourceService resourceService;
    
    
    @ResponseBody
    @RequestMapping(value = "/tree/{pid}")
    public Object tree(@PathVariable Long pid) {
        List<Resource> resourceList = resourceService.findByPid(pid);

        Map<String, TreeVO> tree = new HashMap<String, TreeVO>();
        
        for (Resource resource : resourceList) {
            TreeVO treeVO = new TreeVO();
            treeVO.setName(resource.getResourceName());
            treeVO.setType("folder");
            treeVO.setId(resource.getId());
            tree.put(resource.getId().toString(), treeVO);
        }
        return tree;
    }
}
