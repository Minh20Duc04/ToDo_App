package com.Github.ToDoApp.Config;

import com.Github.ToDoApp.Model.TodoItem;
import com.Github.ToDoApp.Repository.TodoItemRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TodoItemDataLoader implements CommandLineRunner {

    private final Logger logger = LoggerFactory.getLogger(TodoItemDataLoader.class);

    @Autowired
    private TodoItemRepository todoItemRepository;

    @Override
    public void run(String... args) throws Exception { //mac dinh se kiem tra xem neu khong co doi tuong Todo nao thi se tao ra 2 doi tuong mac dinh
        loadSeedData();
    }

    public void loadSeedData()
    {
        if(todoItemRepository.count() == 0)
        {
            TodoItem todoItem = new TodoItem("get the milk");
            TodoItem todoItem1 = new TodoItem("rake the leaves");
            todoItemRepository.save(todoItem);
            todoItemRepository.save(todoItem1);
        }
        logger.info("Number of TodoItems: {}", todoItemRepository.count());
    }











}
