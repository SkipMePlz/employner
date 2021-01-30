package anton.skipmeplz.employner.controller;

import anton.skipmeplz.employner.entities.Person;
import anton.skipmeplz.employner.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {

    private PersonService personService;
    @Autowired
    public void setPersonService(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/index")
    public String homePage(){
        return "index";
    }
    @GetMapping("/people")
    public String peoplePage(Model model){
       List<Person> allPeople = personService.getAllPeople();
        model.addAttribute("people",allPeople);
        return "people";
    }
    @GetMapping("/detail/{id}")
    public String detailsPage(Model model, @PathVariable("id") int id){
        Person selectedPerson = personService.getPersonById(id);
        model.addAttribute("selectedPerson",selectedPerson);
        return "detail";
    }
    @GetMapping("/people/delete/{id}")
    public String deletePage(@PathVariable("id") int id){
        personService.deletePersonById(id);
        return "redirect:/people";
    }
    @GetMapping("/new")
    public String newPerson(Model model){
        model.addAttribute("person",new Person());
        return "new";
    }
    @PostMapping("/new")
    public String create(@ModelAttribute("person") @Valid Person person,
    BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "/new";
        }
        personService.createNewPerson(person);
        return "redirect:/people";

    }


}
