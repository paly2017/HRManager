package com.example.demo.controls;

import com.example.demo.eneity.Department;
import com.example.demo.eneity.Position;
import com.example.demo.service.impl.DepartmentImpl;
import com.example.demo.service.impl.PositionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DepartmentMagControl {
    @Autowired
    private DepartmentImpl departmentService;
    @Autowired
    private PositionServiceImpl positionService;

    /***
     * 部门信息分页显示
     * @param model
     * @param index
     * @return
     */
    @RequestMapping("department/list")
    public String departmentList(Model model, @RequestParam("pageindex")Long index){
        model.addAttribute("deplist",departmentService.departmentPage(index));
        return "department_list";
    }

    /***
     * 删除部门
     * @param id
     * @return
     */
    @ResponseBody
    @PostMapping("department/delete")
    public String departmentDelete(@RequestParam("depId") Long id){
        if (id==null)return "数据为空";
        return departmentService.deleteById(id);
    }

    /***
     * 跳转至部门信息更新页面
     * @param id
     * @return
     */
    @RequestMapping("department/updata")
    public String todepartmentUpdata(@RequestParam("depId")Long id,Model model ){
        if (id==null)return null;
        Department department = new Department();
        department.setId(id);
        department = departmentService.getDepartment(department);
        model.addAttribute("dep",department);
        return "department_update";
    }

    /***
     * 部门信息更新和增加
     * @param number
     * @param name
     * @param telephone
     * @param address
     * @param notes
     * @param model
     * @return
     */
    @RequestMapping("department/doupdata")
    public String dodepartmentUpdata(@RequestParam("departmentNumber")Long number,
                                     @RequestParam("name")String name,
                                     @RequestParam("telephone")String telephone,
                                     @RequestParam("address")String address,
                                     @RequestParam("notes")String notes,
                                     Model model){
        Department department = departmentService.getDepartment(number);
        if (department==null){
            department =new Department();
        }
        department.setDepartmentNumber(number);
        department.setAddress(address);
        department.setName(name);
        department.setNotes(notes);
        department.setTelephone(telephone);
        if (department.getId()==null){
            department = departmentService.saveAanUpdataDepartment(department);
            model.addAttribute("number",department.getDepartmentNumber()+1);
            return "department_add";
        }else {
            department = departmentService.saveAanUpdataDepartment(department);
            model.addAttribute("dep",department);
            return "department_update";
        }
    }

    /***
     * 跳转至部门增加页面
     * @param model
     * @return
     */
    @RequestMapping("department/goadd")
    public String goDepartmentAdd(Model model){
        model.addAttribute("number",departmentService.MaxDepartmentNumber()+1);
        return "department_add";
    }

    /**********************************************************************************/
    /***
     * 职称分页查询
     * @param index
     * @param model
     * @return
     */
    @RequestMapping("position/pagelinst")
    public String positionPage(@RequestParam("pageindex")Long index,Model model){
        Page<Position> positions =positionService.positionPageList(index);
        if (positions!=null){
            model.addAttribute("pages",positions);
        }
        return "position_list";
    }
    @ResponseBody
    @PostMapping("position/delete")
    public String positionDelete(@RequestParam("posId")Long id){
        Position position = new Position();
        position.setId(id);
        return positionService.positionDelete(position);
    }
}
