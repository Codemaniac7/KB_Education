package org.scoula.todo.service;

import org.scoula.lib.cli.ui.Input;
import org.scoula.todo.context.Context;
import org.scoula.todo.dao.TodoDao;
import org.scoula.todo.dao.TodoDaoImpl;
import org.scoula.todo.domain.Todo;
import org.scoula.todo.domain.TodoVO;
import org.scoula.todo.dto.Page;
import org.scoula.todo.dto.PageRequest;
import org.scoula.todo.exception.NoSuchElementException;

import java.sql.SQLException;
import java.util.List;
import java.util.function.Supplier;

public class TodoService {
    TodoDao dao = new TodoDaoImpl();
    Supplier<String> userId = () -> Context.getContext().getUser().getId();

//    TodoDao dao = TodoListDao.getInstance();

    public void printTodoList() {
        for (Todo todo : dao.getList()) {
            String line = "%2d] %s".formatted(todo.getId(), todo.getTitle());
            System.out.println(line);
        }
        System.out.println();
    }

    public void detaillTodo() {
        int id = Input.getInt("Todo Id: ");
        Todo todo = dao.getTodo(id);
        System.out.println("[Todo 상세보기]---------------------------------");
        System.out.println("ID : " + todo.getId());
        System.out.println("제목 : " + todo.getTitle());
        System.out.println("설명 : " + todo.getDescription());
        System.out.println("완료여부: " + todo.isDone());
        System.out.println("등록일 : " + todo.getRegDate());
        System.out.println("----------------------------------------------");
        System.out.println();
    }

    public void addTodo() {
        System.out.println("[새 Todo 추가]---------------------------------");
        String title = Input.getLine("제목: ");
        String description = Input.getLine("설명: ");
        System.out.println("----------------------------------------------");
        Todo todo = Todo.builder()
                .title(title)
                .description(description)
                .done(false)
                .build();
        dao.add(todo);
        System.out.println();
    }


    public void updateTodo() {
        int id = Input.getInt("수정할 Id: ");
        Todo todo = dao.getTodo(id);
        System.out.println("[Todo 수정하기]---------------------------------");
        System.out.println("ID : " + todo.getId());
        String title = Input.getLine("제목", todo.getTitle());
        String description = Input.getLine("설명", todo.getDescription());
        Boolean done = Input.confirm("완료여부", todo.isDone());
        System.out.println("----------------------------------------------");
        System.out.println();
        Todo updateTodo = (Todo) todo.clone();
        updateTodo.setTitle(title);
        updateTodo.setDescription(description);
        updateTodo.setDone(done);
        dao.update(updateTodo);
    }


    public void deleteTodo() {
        int id = Input.getInt("삭제할 Todo Id: ");
        dao.delete(id);
        System.out.println();
    }

    public void print() {
        try {
            int count = dao.getTotalCount(userId.get());
            List<TodoVO> list = dao.getList(userId.get());
            System.out.println("총 건수: " + count);
            System.out.println("=========================================");
            for (TodoVO todo : list) {
                System.out.printf("%03d] %s%s\n", todo.getId(), todo.getTitle(),
                        todo.getDone() ? "(완료)" : "");
            }
            System.out.println("=========================================");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void search() {
        String keyword = Input.getLine("검색어: ");
        keyword = "%" + keyword + "%";
        try {
            List<TodoVO> list = dao.search(userId.get(), keyword);
            System.out.println("총 건수: " + list.size());
            System.out.println("=========================================");
            for (TodoVO todo : list) {
                System.out.printf("%03d] %s%s\n", todo.getId(), todo.getTitle(),
                        todo.getDone() ? "(완료)" : "");
            }
            System.out.println("=========================================");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void detail() {
        long id = (long) Input.getInt("Todo ID: ");
        try {
            TodoVO todo = dao.get(userId.get(), id).orElseThrow(NoSuchElementException::new);
            System.out.println("=========================================");
            System.out.printf("Todo ID : %s\n", todo.getId());
            System.out.printf("제목 : %s\n", todo.getTitle());
            System.out.printf("설명 : %s\n", todo.getDescription());
            System.out.printf("완료여부 : %s\n", todo.getDone() ? "완료" : "미완료");
            System.out.println("=========================================");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (NoSuchElementException e) {
            throw new RuntimeException(e);
        }
    }

    public void create() {
        String title = Input.getLine("제목: ");
        String description = Input.getLine("설명: ");
        TodoVO todo = TodoVO.builder()
                .title(title)
                .description(description).userId(userId.get())
                .done(false)
                .build();
        try {
            dao.create
                    (todo);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void update() {
        Long id = (long) Input.getInt("수정할 Todo ID: ");
        try {
            TodoVO todo = dao.get(userId.get(), id).orElseThrow(NoSuchElementException::new);
            System.out.println("=========================================");
            String title = Input.getLine("제목", todo.getTitle());
            String description = Input.getLine("설명", todo.getDescription());
            boolean done = Input.confirm("완료", todo.getDone());
            System.out.println("=========================================");
            todo.setTitle(title);
            todo.setDescription(description);
            todo.setDone(done);
            dao.update(userId.get(), todo);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (NoSuchElementException e) {
            throw new RuntimeException(e);
        }
    }

    public void delete() {
        Long id = (long) Input.getInt("삭제할 Todo ID: ");
        boolean answer = Input.confirm("삭제할까요?");
        if (answer) {
            try {
                dao.delete(userId.get(), id);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }


    private Page getPage
            (int pageNum) throws SQLException {
        int count = dao.getTotalCount(userId.get());
        PageRequest request = PageRequest.of(pageNum, 10);
        List<TodoVO> list = dao.getPage(userId.get(), request);
        return Page.of(request, count, list);
    }

    private void printPageData
            (Page page, int pageNum) {
        System.out.println("총 건수: " + page.getTotalCount());
        System.out.println("=========================================");
        for (TodoVO todo : page.getList()) {
            System.out.printf("%03d] %s%s\n", todo.getId(), todo.getTitle(),
                    todo.getDone() ? "(완료)" : "");
        }
        System.out.println("=========================================");
        System.out.printf("페이지(%d/%d): ", pageNum, page.getTotalPage());
        for (int
             i = 1;
             i <= page.getTotalPage();
             i++) {
            System.out.printf("%s ",
                    i == pageNum ? "[" +
                            i + "]" : "" +
                            i);
        }
        System.out.println();
    }

    public void printPage() {
        int pageNum = 1;
        try {
            do {
                Page page = getPage(pageNum);
                printPageData(page, pageNum);
                pageNum = Input.getInt("페이지 번호: ");
            } while (pageNum != -1);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}