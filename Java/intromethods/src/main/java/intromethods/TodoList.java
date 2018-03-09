package intromethods;

import java.util.ArrayList;
import java.util.List;

public class TodoList {
    List<Todo> todos=new ArrayList<>();

    public void addTodo(String caption){
        todos.add(new Todo(caption));
    }

    public void finishTodos(String caption){
        for(Todo todo:todos){
            if(todo.getCaption()==caption){
                todo.finish();
            }
        }
    }

    public void finishAllTodos(List<String>todosToFinish){
        for (String todoToFinish:todosToFinish){
            for(Todo todo:todos){
                if(todoToFinish==todo.getCaption()){todo.finish();}
            }
        }




    }
    public List<String> todosToFinish(){
        List<String> result= new ArrayList<>();
        for(Todo todo:todos){
            if(todo.isFinished()==false){
                result.add(todo.getCaption());
            }
        }
        return result;
    }

    public int numberOfFinishedTodos(){
        int result=0;
        for(Todo todo:todos){
            if(todo.isFinished()==true){result++;}
        }
        return result;
    }

    @Override
    public String toString() {
        return "FeladatLista:" +todos;
    }
}
