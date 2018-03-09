package intromethods;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TodoMain {
    public static void main(String[] args) {
        List<String> deathnote= new ArrayList<>(Arrays.asList("Egyes","Hármas","Hatos"));
        TodoList tl= new TodoList();

        tl.addTodo("Egyes");
        tl.addTodo("Kettes");
        tl.addTodo("Hármas");
        tl.addTodo("Négyes");
        tl.addTodo("Ötös");
        tl.addTodo("Hatos");

        tl.finishTodos("Kettes");
        System.out.println("Befejezendő feladatok:");
        System.out.println(tl.todosToFinish().toString());
        System.out.println("Befejezett feladatok:");
        System.out.println(tl.numberOfFinishedTodos());
        tl.finishTodos("Négyes");
        System.out.println("Befejezendő feladatok:");
        System.out.println(tl.todosToFinish().toString());
        System.out.println("Befejezett feladatok:");
        System.out.println(tl.numberOfFinishedTodos());
        tl.finishAllTodos(deathnote);
        System.out.println("Befejezendő feladatok:");
        System.out.println(tl.todosToFinish().toString());
        System.out.println("Befejezett feladatok:");
        System.out.println(tl.numberOfFinishedTodos());
        System.out.println(tl.toString());
    }
}
