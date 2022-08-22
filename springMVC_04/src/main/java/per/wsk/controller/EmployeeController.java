package per.wsk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import per.wsk.bean.Employee;
import per.wsk.dao.EmployeeDao;

import java.util.Collection;

/**
 * @Author wb_weishaokang
 * @date 2022/1/4 5:56 下午
 * @description
 */
@Controller
public class EmployeeController {

    @Autowired
    private EmployeeDao employeeDao;

    /**
     * 查询所有员工
     * @param model
     * @return
     */
    @RequestMapping(value = "/employee", method = RequestMethod.GET)
    public String getAllEmployee(Model model){
        Collection<Employee> employeeList = employeeDao.getAll();
        model.addAttribute("employeeList", employeeList);
        return "employee_list";
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @RequestMapping(value = "/employee/{id}", method = RequestMethod.DELETE)
    public String deleteEmployee(@PathVariable("id") Integer id){
        employeeDao.delete(id);
        return "redirect:/employee";
    }

    /**
     * 新增
     * @param employee
     * @return
     */
    @RequestMapping(value = "/employee", method = RequestMethod.POST)
    public String addEmployee(Employee employee){
        employeeDao.save(employee);
        return "redirect:/employee";
    }

    /**
     * 查询
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(value = "/employee/{id}", method = RequestMethod.GET)
    public String getEmployeeById(@PathVariable("id") Integer id, Model model){
        Employee employee = employeeDao.get(id);
        model.addAttribute("employee", employee);
        return "employee_update";
    }

    /**
     * 修改
     * @param employee
     * @return
     */
    @RequestMapping(value = "/employee", method = RequestMethod.PUT)
    public String updateEmployee(Employee employee){
        employeeDao.save(employee);
        return "redirect:/employee";
    }

}
