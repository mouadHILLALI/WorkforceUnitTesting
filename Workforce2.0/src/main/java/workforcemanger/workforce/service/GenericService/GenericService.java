package workforcemanger.workforce.service.GenericService;

import java.util.List;

public interface GenericService {
    abstract <T> T create(T t);
    abstract <T> T update(T t);
    abstract <T> T delete(T t);
    abstract <T> List<T> findAllById(Class<T> clazz , int id);
    abstract <T> T findById(Class<T> clazz , int id);
}
