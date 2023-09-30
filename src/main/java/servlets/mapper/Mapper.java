package servlets.mapper;

public interface Mapper<F, T> {
    T mapFrom(F object);
}
