package com.Github.ToDoApp.Service;

import com.Github.ToDoApp.Controller.TodoItemController;
import com.Github.ToDoApp.Model.TodoItem;
import com.Github.ToDoApp.Repository.TodoItemRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;

import java.time.Instant;
import java.time.ZoneId;

@Service
public class TodoItemService {

    @Autowired
    private TodoItemRepository todoItemRepository;

    private final Logger logger = LoggerFactory.getLogger(TodoItemService.class);


    public ModelAndView displayTodoItemList() {
        logger.info("request to GET index");
        ModelAndView modelAndView = new ModelAndView("index"); //tiep nhan th index.hmtl o duoi de lam View
        modelAndView.addObject("todoItems",todoItemRepository.findAll());
        modelAndView.addObject("today", Instant.now().atZone(ZoneId.systemDefault()).toLocalDate().getDayOfWeek());
        return modelAndView;
    }

    public String updateTodoItem(Long id, TodoItem todoItem, BindingResult result, Model model) {
        if(result.hasErrors())
        {
            todoItem.setId(id);
            return "update-todo-item";
        }
        todoItem.setModifiedDate(Instant.now());
        todoItemRepository.save(todoItem);
        return "redirect:/"; // tra ve url / -> nghia la tra ve trang index
                             //redirect la 1 tu khoa chu ko phai String
    }

    public String createTodoItem(TodoItem todoItem, BindingResult result, Model model) {
        if(result.hasErrors())
        {
            return "add-todo-item";
        }
        todoItem.setCreatedDate(Instant.now());
        todoItem.setModifiedDate(Instant.now());
        todoItemRepository.save(todoItem);
        return "redirect:/";
    }
}
