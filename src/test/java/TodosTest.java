import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Test;

public class TodosTest {
    @Test
    public void shouldAddThreeTasksOfDifferentType() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void searchQueryAllTask() {

        SimpleTask simpleTask = new SimpleTask(5, "Задача");

        String[] subtasks = {"Задача", "План", "Отдых"};
        Epic epic = new Epic(55, subtasks);
        Meeting meeting = new Meeting(
                555,
                "Задача",
                "План",
                "Вчера"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);


        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.search("Задача");

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test

    public void searchQueryPartTask() {

        SimpleTask simpleTask = new SimpleTask(5, "Задача");

        String[] subtasks = {"План", "Отдых"};
        Epic epic = new Epic(55, subtasks);
        Meeting meeting = new Meeting(
                555,
                "Задача",
                "План",
                "Вчера"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);


        Task[] expected = {simpleTask, meeting};
        Task[] actual = todos.search("Задача");

        Assertions.assertArrayEquals(expected, actual);


    }

    @Test
    public void searchQueryNoTask(){
        SimpleTask simpleTask = new SimpleTask(5, "Задача");

        String[] subtasks = {"План", "Отдых"};
        Epic epic = new Epic(55, subtasks);
        Meeting meeting = new Meeting(
                555,
                "Задача",
                "План",
                "Вчера"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);


        Task[] expected = {};
        Task[] actual = todos.search("Хлеб");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void SimpletaskMatchesQuery(){

        SimpleTask simpleTask = new SimpleTask(5, "Задача");
        simpleTask.matches("Задача");

        boolean actual = simpleTask.matches("Задача");
        Assertions.assertTrue(actual);


    }
    @Test

    public void SimpletaskMatchesNoQuery(){

        SimpleTask simpleTask = new SimpleTask(5, "Задача");
        simpleTask.matches("План");

        boolean actual = simpleTask.matches("План");
        Assertions.assertFalse(actual);
    }

   @Test
    public void EpicMatchesQuery(){

        String[] subtasks = {"Задача", "Отдых"};
        Epic epic = new Epic(55, subtasks);
        epic.matches("Задача");

        boolean actual = epic.matches("Задача");
        Assertions.assertTrue(actual);

    }
    @Test
    public void EpicMatchesNoQuery(){

        String[] subtasks = {"Задача", "Отдых"};
        Epic epic = new Epic(55, subtasks);
        epic.matches("План");

        boolean actual = epic.matches("План");
        Assertions.assertFalse(actual);

    }

    @Test

    public void MeetMatchesQuery(){

        Meeting meeting = new Meeting(
                555,
                "План",
                "План",
                "Вчера"
        );

        meeting.matches("План");

        boolean actual = meeting.matches("План");
        Assertions.assertTrue(actual);

    }

    @Test

    public void MeetMatchesQuery1(){

        Meeting meeting = new Meeting(
                555,
                "Задача",
                "План",
                "Вчера"
        );

        meeting.matches("План");

        boolean actual = meeting.matches("План");
        Assertions.assertTrue(actual);

    }
    @Test

    public void MeetMatchesQuery2(){

        Meeting meeting = new Meeting(
                555,
                "План",
                "Задача",
                "Вчера"
        );

        meeting.matches("План");

        boolean actual = meeting.matches("План");
        Assertions.assertTrue(actual);

    }
    @Test

    public void MeetMatchesNoQuery(){

        Meeting meeting = new Meeting(
                555,
                "План",
                "Задача",
                "Вчера"
        );

        meeting.matches("Отдых");

        boolean actual = meeting.matches("Отдых");
        Assertions.assertFalse(actual);

    }






}
