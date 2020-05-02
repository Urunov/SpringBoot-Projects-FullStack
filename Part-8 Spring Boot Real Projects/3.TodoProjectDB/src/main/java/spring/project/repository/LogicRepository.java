package spring.project.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import spring.project.entity.ToDo;

import java.util.List;
import java.util.Optional;

/**
 * @Author: apple
 * @created on 02/05/2020
 * @Project is TodoProjectDB
 */
public class LogicRepository implements ToDoRepository{


    @Override
    public List<ToDo> findAll() {
        return null;
    }

    @Override
    public List<ToDo> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<ToDo> findAll(Pageable pageable) {
        return null;
    }


    @Override
    public List<ToDo> findAllById(Iterable<Long> iterable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(ToDo toDo) {

    }

    @Override
    public void deleteAll(Iterable<? extends ToDo> iterable) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends ToDo> S save(S s) {
        return null;
    }

    @Override
    public <S extends ToDo> List<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<ToDo> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends ToDo> S saveAndFlush(S s) {
        return null;
    }

    @Override
    public void deleteInBatch(Iterable<ToDo> iterable) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public ToDo getOne(Long aLong) {
        return null;
    }

    @Override
    public <S extends ToDo> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends ToDo> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends ToDo> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends ToDo> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends ToDo> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends ToDo> boolean exists(Example<S> example) {
        return false;
    }
}
