package zut.cs.core.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import zut.cs.core.base.domain.BaseTreeEntity;

import javax.persistence.*;
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
@NamedQueries({@NamedQuery(name = "Menu.getRoot", query = "select m from Menu m where m.parent is null")})
public class Menu extends BaseTreeEntity<Menu> {
    private String title;
    private String path;
    @JsonIgnore
    @ManyToMany(mappedBy = "menus", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    Set<Group> groups;
}
