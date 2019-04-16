package zut.cs.core.domain;

import lombok.*;
import zut.cs.core.base.domain.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import java.util.Set;

/**
 * @author:caochaoqiang
 * @date:2018/11/18
 * @email:1959724905@qq.com
 * @description:
 */
@Entity
@Getter
@Setter
public class Element extends BaseEntity {
    private String name;
    private String code;
    private String method;
    private String type;
    @ManyToMany
    @JoinColumn(name = "menu_id")
    Set<Menu> menus;
}
