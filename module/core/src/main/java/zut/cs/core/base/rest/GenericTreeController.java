package zut.cs.core.base.rest;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.web.bind.annotation.*;
import zut.cs.core.base.domain.BaseTreeEntity;
import zut.cs.core.base.service.GenericTreeManager;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

@NoRepositoryBean
@RestController
public abstract class GenericTreeController<T extends BaseTreeEntity<T>, PK extends Serializable, M extends GenericTreeManager<T, PK>>
		extends GenericController<T, PK, M> {

	protected M treeManager;

	/**
	 * 得到树结构;
	 *
	 * @paramrequest
	 * @paramresponse
	 * @return
	 */

	@GetMapping("/getChildren/{id}")
	public List<T> getChildren(@PathVariable PK id) {
		List<T> result = this.treeManager.getChildren(id);
		return result;
	}

	/**
	 * 得到树结构;
	 *
	 * @paramrequest
	 * @paramresponse
	 * @return
	 */
	@GetMapping("/getTree/{id}")
	public List<T> getTree(@PathVariable PK id) {
		List<T> result = null;
		if (id == null) {
			result = this.treeManager.getRoot();
		} else {
			T node = this.treeManager.findById(id);
			result = node.getChildren();
		}
		return result;
	}
	@Override
	@DeleteMapping("/{id}")
	public void delete(@PathVariable PK id) throws IOException {
		T t=this.treeManager.findById(id);
		if(t.getChildren().size()>0)
			return ;
			this.treeManager.delete(id);
	}
	@PostMapping("/addChild/{id}")
	public void addChild(@PathVariable PK id,@RequestBody T t)
	{
		this.treeManager.addChild(id,t);
	}
	@PutMapping("updateChild/{id}")
	public void updateChild(@PathVariable PK id,@RequestBody T t){
		this.treeManager.updateChild(id,t);
	}
}
