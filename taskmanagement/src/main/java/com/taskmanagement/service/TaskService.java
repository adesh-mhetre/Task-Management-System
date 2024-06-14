package com.taskmanagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taskmanagement.entity.Tasks;
import com.taskmanagement.entity.User;
import com.taskmanagement.repository.TaskRepository;
import com.taskmanagement.repository.UserRepository;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepo;

    @Autowired
    private UserRepository userRepo;

    public List<Tasks> getAllTasks() {
        return taskRepo.findAll();
    }

    /**
     * @param id
     * @param task
     * @return
     */
    public Tasks postTask(Long id, Tasks task) {
        try {
            System.out.println("in post tasks");
        
            Tasks savedTask = taskRepo.save(task);

            User user = userRepo.findById(id).orElseThrow(); // Adjust this based on your User entity
            
            user.getTasks().add(savedTask);
            System.out.println(user.getTasks());
            userRepo.save(user);
            return savedTask;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // public Tasks postTask(Long userId, Tasks task) {
    //     try {
    //         User user = userRepo.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
    //         task.setUser(user); // Ensure the user is set here
    //         return taskRepo.save(task); // Save the task with the user set
    //     } catch (Exception e) {
    //         e.printStackTrace();
    //         return null;
    //     }
    // }


    public List<Tasks> getTaskById(Long id) {

        try {
            Optional<User> obj = userRepo.findById(id);
            User user = obj.get();
            return user.getTasks();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        // return taskRepo.findById(id).orElse(null);
    }

    public Tasks getTaskByUserIdAndTaskId(Long UserId,Long taskId) {

        try {
            Optional<User> obj = userRepo.findById(UserId);
            User user = obj.get();
            List<Tasks> list = user.getTasks();
            for(Tasks T:list)
            {
                if(T.getId()==taskId)
                {
                    return T;
                }
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        // return taskRepo.findById(id).orElse(null);
    }

    public List<Tasks> deleteTask(Long userId, Long taskId) {
        try {
            Optional<User> userOptional = userRepo.findById(userId);
            if (userOptional.isPresent()) {
                User user = userOptional.get();
                List<Tasks> tasks = user.getTasks();
                tasks.removeIf(t -> t.getId().equals(taskId));
                userRepo.save(user);
                // Save the user to update the task association
                taskRepo.deleteById(taskId);
            }
            List<Tasks> list = userOptional.get().getTasks();
            return list;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Tasks> updateTask(Long userId, Long taskId, Tasks updatedTask) {
        try {
            Optional<User> userOptional = userRepo.findById(userId);
            if (userOptional.isPresent()) {
                User user = userOptional.get();
                List<Tasks> userTasks = user.getTasks();

                // Find the task in the user's task list
                Optional<Tasks> taskOptional = userTasks.stream().filter(t -> t.getId().equals(taskId)).findFirst();

                if (taskOptional.isPresent()) {
                    Tasks existingTask = taskOptional.get();
                    existingTask.setName(updatedTask.getName());
                    existingTask.setStatus(updatedTask.getStatus());
                    existingTask.setImportance(updatedTask.getImportance());

                    // Save the updated task in the tasks table
                    // Tasks savedTask = taskRepo.save(existingTask);

                    // Save the user to update the task in the user's task list
                    userRepo.save(user);
                    return userOptional.get().getTasks();

                } else {
                    return null;
                }
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // public Tasks updateTask(Long id, Tasks task) {
    // Optional<Tasks> optionalTask = taskRepo.findById(id);
    // if (optionalTask.isPresent()) {
    // Tasks existingTask = optionalTask.get();
    // existingTask.setName(task.getName());
    // existingTask.setStatus(task.getStatus());
    // existingTask.setImportance(task.getImportance());
    // return taskRepo.save(existingTask);
    // }
    // return null;
    // }
}
