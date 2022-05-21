package com.study.crudrestapi.service.impl;

import com.study.crudrestapi.common.exception.StudyException;
import com.study.crudrestapi.entity.Author;
import com.study.crudrestapi.repository.AuthorRepository;
import com.study.crudrestapi.service.AuthorService;
import com.study.crudrestapi.wrapper.AuthorWrapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    private AuthorWrapper toWrapper(Author model) {
        AuthorWrapper wrapper = new AuthorWrapper();
        wrapper.setId(model.getId());
        wrapper.setDeleted(model.getDeleted());
        wrapper.setVersion(model.getVersion());
        wrapper.setDescription(model.getDescription());

        wrapper.setName(model.getName());
        wrapper.setAddress(model.getAddress());

        return wrapper;
    }

    private Author toEntity(AuthorWrapper wrapper) {
        Author model = new Author();
        if (wrapper.getId() != null) {
            Optional<Author> optional = authorRepository.findById(wrapper.getId());
            if (optional.isPresent()) {
                model = optional.get();
            }
        }
        model.setDeleted(wrapper.getDeleted());
        model.setVersion(wrapper.getVersion());
        model.setDescription(wrapper.getDescription());

        model.setName(wrapper.getName());
        model.setAddress(wrapper.getAddress());

        return model;
    }

    private List<AuthorWrapper> toWrapperList(List<Author> modelList) {
        List<AuthorWrapper> wrappers = new ArrayList<>();
        if (modelList != null && !modelList.isEmpty()) {
            for (Author model : modelList) {
                wrappers.add(toWrapper(model));
            }
        }
        return wrappers;
    }

    @Override
    public Long getNum() {
        return authorRepository.count();
    }

    @Override
    public AuthorWrapper save(AuthorWrapper entity) throws StudyException {
        return toWrapper(authorRepository.save(toEntity(entity)));
    }

    @Override
    public AuthorWrapper getById(Long pk) throws StudyException {
        Optional<Author> optional = authorRepository.findById(pk);
        return optional.map(this::toWrapper).orElse(null);
    }

    @Override
    public Boolean delete(Long pk) throws StudyException {
        return null;
    }

    @Override
    public List<AuthorWrapper> getAll() throws StudyException {
        return toWrapperList((List<Author>) authorRepository.findAllByDeletedIsFalse());
    }

    @Override
    public void deleteAll() throws StudyException {

    }

    @Override
    public Page<AuthorWrapper> getPageableList(String sSearch, int startPage, int pageSize, Sort sort) throws StudyException {
        return null;
    }
}
