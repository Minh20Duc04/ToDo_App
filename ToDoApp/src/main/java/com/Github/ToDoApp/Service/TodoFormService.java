package com.Github.ToDoApp.Service;

import com.Github.ToDoApp.Model.TodoItem;
import com.Github.ToDoApp.Repository.TodoItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.Optional;

@Service
public class TodoFormService {
    @Autowired
    private TodoItemRepository todoItemRepository;

    public String showUpdateForm(Long id, Model model) { //Model dùng để chuyển dữ liệu từ controller đến view trong templates
        Optional<TodoItem> todoItemOptional = todoItemRepository.findById(id);
        if(!todoItemOptional.isPresent())
        {
            throw new IllegalArgumentException("TodoItem id: "+id+ "is not found !");
        }
        model.addAttribute("todo", todoItemOptional.get());// Lấy TodoItem từ Optional và thêm nó vào Model với tên thuộc tính là "todo". Điều này giúp view (thường là một trang JSP hoặc Thymeleaf) có thể truy cập và hiển thị dữ liệu của TodoItem.
        return "update-todo-item";
    }

    public String deleteTodoItem(Long id, Model model) {
        Optional<TodoItem> todoItemOptional = todoItemRepository.findById(id);
        if(!todoItemOptional.isPresent())
        {
            throw new IllegalArgumentException("TodoItem id: "+id+ "is not found !");
        }
        todoItemRepository.delete(todoItemOptional.get());
        return "redirect:/";
    }

    public String showCreateForm(TodoItem todoItem) {
        return "add-todo-item";
    }
}
