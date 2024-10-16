package com.Github.ToDoApp.Controller;

import com.Github.ToDoApp.Model.TodoItem;
import com.Github.ToDoApp.Repository.TodoItemRepository;
import com.Github.ToDoApp.Service.TodoItemService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.time.Instant;
import java.time.ZoneId;

@Controller
public class TodoItemController {

    @Autowired
    private TodoItemService todoItemService;


    @GetMapping("/")
    public ModelAndView index()
    {
        return todoItemService.displayTodoItemList();
    }

    @PostMapping("/todo/{id}")
    public String updateTodoItem(@PathVariable("id") Long id, @Valid TodoItem todoItem, BindingResult result, Model model)
    {
        return todoItemService.updateTodoItem(id, todoItem, result, model);
    }

    @PostMapping("/todo")
    public String createTodoItem(@Valid TodoItem todoItem, BindingResult result, Model model) //model de de phong co phai chuyen huong View hay khong
    {
        return todoItemService.createTodoItem(todoItem,result,model);
    }

}
