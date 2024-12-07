package org.dromara.web.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.dromara.web.domain.MhzxMenu;
import org.dromara.web.domain.MhzxMenuTitle;

/**
 *
 * @author wuzhi 1289782699@qq.com
 * @className MhzxMenuMapper
 * @description 
 * @date 2024年09月22日 00:04:57
 */
public interface MhzxMenuMapper {
    
    /**
     * 功能描述: 获取主页菜单列表
     *
     * @param titleIds 分组ids
     * @return List<MhzxMenu>
     * @date 2024年09月22日 00:05:30
     */    
    List<MhzxMenu> getMhzxMenus(@Param("titleIds") List<Integer> titleIds);

    /**
     * 功能描述: 获取所有分组
     *
     * @return List<MhzxMenuTitle>
     * @date 2024年09月22日 00:14:16
     */    
    List<MhzxMenuTitle> getList();
}
