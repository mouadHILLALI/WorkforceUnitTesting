package workforcemanger.workforce.repository;

public interface Repository {
     public abstract <T> T create(T t);
     public abstract  boolean delete(int id);
     public abstract <T> T update(T t);
     public abstract <T> T get(T t);
}
