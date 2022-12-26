package ru.vlsu.ispi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.vlsu.ispi.beans.Group;
import ru.vlsu.ispi.dao.DAOGroups;

@Controller
public class MainController {

    @Autowired
    private DAOGroups groups;

    @GetMapping("/hello/{id}")
    public String handle(@PathVariable int id, @RequestParam(required = false, name = "petId") Integer petId, Model model) {
        /*System.out.println("id: " + id);
        System.out.println("PetId: " + petId);

        model.addAttribute("message", "Hello World!");

        Group group = new Group();
        model.addAttribute(group);
        DAOGroups daoGroups = new DAOGroups();
        List<Group> groupList;

        groupList = daoGroups.getGroups();

        model.addAttribute(groupList);*/
        return "index";
    }

    @GetMapping("/group")
    public String groupForm(Model model, @RequestParam(required = false, name = "id") Integer id) {
        if (id == null) {
            model.addAttribute("isCreate", true);
            model.addAttribute("group", new Group());
        } else {
            model.addAttribute("isCreate", false);
            model.addAttribute("group", groups.getGroupById(id));
        }

        return "group";
    }

    @PostMapping("/group")
    public String groupSubmit(@ModelAttribute Group group, Model model) {

        System.out.println(group);
        //List<Group> groupList;
        //System.out.println(group.toString());
        if (!groups.isExists(group)) {
            groups.createGroup(group);
        } else {
            groups.updateGroup(group);
        }

        //groupList = groups.getGroups();

        //System.out.println("Groups: " + groupList.size());
        model.addAttribute(groups.getGroups());

        //model.addAttribute(groupList);

        return "groups";

    }

    @GetMapping("/group/{id}")
    public String deleteGroup(@PathVariable int id, Model model) {
        System.out.println("id: " + id);
        //List<Group> groupList;
        groups.deleteGroup(id);
        //groupList = groups.getGroups();

        //System.out.println("Groups: " + groupList.size());
        model.addAttribute(groups.getGroups());
        //model.addAttribute(groupList);

        return "groups";
    }
}
