import org.example.Task;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TaskTest {
    protected String taskId, taskName, description;
    protected String failTaskId, failTaskName, failDescription;

    @BeforeEach
    void setUp() {
        taskId = "masonutt10";
        taskName = "MasonTask";
        description = "A task that Mason needs";

        failTaskId = "masonmason111";
        failTaskName = "reallyreallylongtaskname";
        failDescription = "This description is utter nonsense other than the fact that it is beyond 50 chars";
    }

    @Test
    void taskTest() {
        Task task = new Task();
        assertAll("empty constructor",
                ()
                        -> assertNotNull(task.getTaskID()),
                ()
                        -> assertNotNull(task.getTaskName()),
                ()
                        -> assertNotNull(task.getTaskDescription()));
    }

    @Test
    void taskTest2() {
        Task task = new Task(taskId, taskName, description);
        assertAll("constructor all params",
                ()
                        -> assertEquals(taskId, task.getTaskID()),
                ()
                        -> assertEquals(taskName, task.getTaskName()),
                ()
                        -> assertEquals(description, task.getTaskDescription()));
    }

    @Test
    void setTaskIdTest(){
        Task task = new Task();
        task.setTaskID(taskId);
        assertAll("test set task ID",
                ()
                        -> assertEquals(taskId, task.getTaskID()),
                ()
                        -> assertThrows(IllegalArgumentException.class,
                        ()
                                ->task.setTaskID(failTaskId)),     //cant be longer than 10
                ()
                        -> assertThrows(IllegalArgumentException.class,
                        ()
                                ->task.setTaskID(null)));             //cant be null

    }

    @Test
    void setTaskNameTest(){
        Task task = new Task();
        task.setTaskName(taskName);
        assertAll("test set task name",
                ()
                        -> assertEquals(taskName, task.getTaskName()),
                ()
                        -> assertThrows(IllegalArgumentException.class,
                        ()
                                ->task.setTaskName(failTaskName)),     //cant be longer than 10
                ()
                        -> assertThrows(IllegalArgumentException.class,
                        ()
                                ->task.setTaskName(null)));             //cant be null

    }

    @Test
    void setTaskDescTest(){
        Task task = new Task();
        task.setTaskDescription(description);
        assertAll("test set task description",
                ()
                        -> assertEquals(description, task.getTaskDescription()),
                ()
                        -> assertThrows(IllegalArgumentException.class,
                        ()
                                ->task.setTaskDescription(failDescription)),     //cant be longer than 10
                ()
                        -> assertThrows(IllegalArgumentException.class,
                        ()
                                ->task.setTaskDescription(null)));             //cant be null

    }

}
