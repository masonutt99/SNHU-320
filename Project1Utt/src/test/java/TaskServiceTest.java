import org.example.Task;
import org.example.TaskService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class TaskServiceTest {

    protected String taskId, taskName, description;
    protected String taskId1, taskName1, description1;
    protected String failTaskId, failTaskName, failDescription;

    protected String init;

    @BeforeEach
    void setUp() {
        taskId = "masonutt10";
        taskName = "MasonsTask";
        description = "A task that Mason needs";

        taskId1 = "masonutt11";
        taskName1 = "MasonOtherTask";
        description1 = "Another task that Mason needs";

        failTaskId = "masonmason111";
        failTaskName = "reallyreallylongtaskname";
        failDescription = "This description is utter nonsense other than the fact that it is beyond 50 chars";

        init = "init";
    }

    @Test
    void addTaskTest() throws Exception {                                //adds a single task
        TaskService taskService = new TaskService();
        Task task = new Task();
        taskService.addTask(task);
        assertAll("tests Adding empty task to the list",
                ()
                        -> assertNotNull(taskService.getList().get(0).getTaskID()),
                ()
                        -> assertEquals(init, taskService.getList().get(0).getTaskID()),
                ()
                        -> assertEquals(init, taskService.getList().get(0).getTaskName()),
                ()
                        -> assertEquals(init, taskService.getList().get(0).getTaskDescription()));
    }

    @Test
    void addTaskTest2() throws Exception {          //adds tasks
        TaskService taskService = new TaskService();
        Task task = new Task(taskId, taskName, description);
        Task badTask = new Task(taskId, taskName1, description1);
        Task task2 = new Task(taskId1, taskName1, description1);
        taskService.addTask(task);
        taskService.addTask(task2);
        assertAll("tests Adding full task to the list",
                ()
                        -> assertNotNull(taskService.getList().get(0).getTaskID()),
                ()
                        -> assertEquals(taskId, taskService.getList().get(0).getTaskID()),
                ()
                        -> assertEquals(taskName, taskService.getList().get(0).getTaskName()),
                ()
                        -> assertEquals(description, taskService.getList().get(0).getTaskDescription()),
                ()
                        -> assertThrows(Exception.class,
                        ()
                                -> taskService.addTask(badTask)),      //cant add a taskID that already exists
                ()
                        -> assertNotNull(taskService.getList().get(1).getTaskID()),
                ()
                        -> assertEquals(taskId1, taskService.getList().get(1).getTaskID()),
                ()
                        -> assertEquals(taskName1, taskService.getList().get(1).getTaskName()),
                ()
                        -> assertEquals(description1, taskService.getList().get(1).getTaskDescription()));
    }


    @Test
    void deleteTaskTest() throws Exception {
        TaskService taskService = new TaskService();
        Task task = new Task(taskId, taskName, description);
        Task task1 = new Task(taskId1, taskName1, description1);
        Task task2 = new Task();
        taskService.addTask(task);
        taskService.addTask(task1);
        taskService.addTask(task2);
        taskService.deleteTask(taskId1);
        assertAll("tests deleting task from the list",
                ()
                        -> assertEquals(init, taskService.getList().get(1).getTaskID()),
                ()
                        -> assertEquals(init, taskService.getList().get(1).getTaskName()),
                ()
                        -> assertEquals(init, taskService.getList().get(1).getTaskDescription()));
    }

    @Test
    void deleteTaskTestNoID() throws Exception {
        TaskService taskService = new TaskService();
        Task task = new Task(taskId, taskName, description);
        taskService.addTask(task);
        assertAll("tests deleting task from the list that doesn't match ID",
                ()
                        -> assertThrows(Exception.class,
                        ()
                                -> taskService.deleteTask(taskId1)));
    }

    @Test
    void updateTaskNameTest() throws Exception {
        TaskService taskService = new TaskService();
        Task task = new Task(taskId, taskName, description);
        taskService.addTask(task);
        taskService.updateTaskName(taskId, taskName1);
        assertAll("test updating task name",
                ()
                        ->assertEquals(taskName1, taskService.getList().get(0).getTaskName()),
                ()
                        ->assertThrows(Exception.class,
                        ()
                                ->taskService.updateTaskName(taskId1, taskName1)),
                ()
                        ->assertThrows(IllegalArgumentException.class,
                        ()
                                ->taskService.updateTaskName(taskId, null)));
    }
    @Test
    void updateTaskDescriptionTest() throws Exception {
        TaskService taskService = new TaskService();
        Task task = new Task(taskId, taskName, description);
        taskService.addTask(task);
        taskService.updateTaskDesc(taskId, description1);
        assertAll("test updating task description",
                ()
                        ->assertEquals(description1, taskService.getList().get(0).getTaskDescription()),
                ()
                        ->assertThrows(Exception.class,
                        ()
                                ->taskService.updateTaskDesc(taskId1, description1)),
                ()
                        ->assertThrows(IllegalArgumentException.class,
                        ()
                                ->taskService.updateTaskDesc(taskId, null)));
    }


}
