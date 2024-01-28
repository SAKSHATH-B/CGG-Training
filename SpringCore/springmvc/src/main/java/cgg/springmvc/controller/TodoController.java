package cgg.springmvc.controller;

import cgg.springmvc.dao.TodoDao;
import cgg.springmvc.entities.Todo;
import jakarta.servlet.ServletContext;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TodoController {

  // @Autowired
  // ServletContext context;

  @Autowired
  TodoDao todoDao;

  @RequestMapping("/todohome")
  public String home(Model m) {
    m.addAttribute("page", "home");
    List<Todo> allTodos = todoDao.getAll();
    m.addAttribute("todos", allTodos);

    return "todohome";
  }

  @RequestMapping("/add")
  public String addTodo(Model m) {
    Todo todo = new Todo();
    m.addAttribute("page", "add");
    m.addAttribute("todo", todo);
    return "todohome";
  }

  @RequestMapping(path = "/saveTodo", method = RequestMethod.POST)
  public String saveTodo(@ModelAttribute("todo") Todo t, Model m) {
    t.setTodoDate(new Date());
    System.out.println(t);
    List<Todo> list = new ArrayList<>();
    list.add(t);
    todoDao.save(t);
    m.addAttribute("msg", "Added Successfully...");
    return "todohome";
  }

  @PostMapping("/deleteTodo")
  public String delete(@RequestParam("todoId") int todoId) {
    todoDao.deleteTodo(todoId);
    return "redirect:/todohome";
  }
}
