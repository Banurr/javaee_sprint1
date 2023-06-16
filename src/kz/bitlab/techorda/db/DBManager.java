package kz.bitlab.techorda.db;

import java.util.ArrayList;
import java.util.Objects;

public class DBManager
 {

     private static final ArrayList<Task> tasks = new ArrayList<>();
     private static Long id = 3L;

     static
     {
         tasks.add(new Task(1L,"Выучить английский",
                 "Записаться на курсы английского языка и смотреть фильмы на английском",
                 "23/04/2024","Да"));
         tasks.add(new Task(2L,"Записаться в спортзал",
                 "Найти хороший спортзал через 1FIT и купить футболку для спорта",
                 "12/11/2025","Нет"));
     }



     public static void addTask(Task t)
     {
         t.setId(id);
         tasks.add(t);
         id++;
     }
     public static ArrayList<Task> allTasks()
     {
         return tasks;
     }


     public static Task getTask(Long id)
     {
         for(Task i : tasks)
         {
             if(Objects.equals(i.getId(), id))
             {
                 return i;
             }
         }
         return null;
     }
     public static void deleteTask(Long id)
     {
         tasks.removeIf(i -> Objects.equals(i.getId(), id));
     }

     public static void updateTask(Long id,String name,String description,String date,String condition)
     {
         for(Task i : tasks)
         {
             if(Objects.equals(i.getId(), id))
             {
                 i.setName(name);
                 i.setDescription(description);
                 i.setCondition(condition);
                 i.setDeadlineDate(date);
                 break;
             }
         }
     }
}
