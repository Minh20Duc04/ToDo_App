package com.Github.ToDoApp.Controller;

import com.Github.ToDoApp.Model.TodoItem;
import com.Github.ToDoApp.Repository.TodoItemRepository;
import com.Github.ToDoApp.Service.TodoFormService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class TodoFormController { // nay la trang nam o sau trang index

    @Autowired
    private TodoFormService todoFormService;

    private final Logger logger = LoggerFactory.getLogger(TodoFormController.class);

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") Long id, Model model)
    {
        return todoFormService.showUpdateForm(id, model);
    }

    @GetMapping("/delete/{id}")
    public String deleteTodoItem(@PathVariable("id") Long id, Model model)
    {
        return todoFormService.deleteTodoItem(id, model);
    }

    @GetMapping("/create-todo")
    public String showCreateForm(TodoItem todoItem)
    {
        return todoFormService.showCreateForm(todoItem);
    }













}
