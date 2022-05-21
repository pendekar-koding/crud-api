package com.study.crudrestapi.controller;

import com.study.crudrestapi.common.exception.StudyException;
import com.study.crudrestapi.common.response.CommonResponses;
import com.study.crudrestapi.common.response.CustomReturn;
import com.study.crudrestapi.service.AuthorService;
import com.study.crudrestapi.wrapper.AuthorWrapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/curd-api")
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }


    @GetMapping(value = "/list")
    public CustomReturn<List<AuthorWrapper>> getAll() throws StudyException {
        CommonResponses<List<AuthorWrapper>> commonResponses = new CommonResponses<>();
        List<AuthorWrapper> wrappers = authorService.getAll();
        if (wrappers != null) {
            return commonResponses.commonSuccessResponse(wrappers);
        } else {
            return commonResponses.commonFailedResponse();
        }
    }

    @GetMapping(value = "/getById/{id}")
    public CustomReturn<AuthorWrapper> getById(@PathVariable Long id) throws StudyException {
        CommonResponses<AuthorWrapper> commonResponses = new CommonResponses<>();
        AuthorWrapper wrapper = authorService.getById(id);
        if (wrapper != null) {
            return commonResponses.commonSuccessResponse(wrapper);
        } else {
            return commonResponses.commonFailedResponse();
        }
    }


    @PostMapping(value = "/save")
    public CustomReturn<AuthorWrapper> save(@RequestBody AuthorWrapper wrapper) throws StudyException {
        CommonResponses<AuthorWrapper> commonResponses = new CommonResponses<>();
        wrapper.setDeleted(false);
        wrapper.setVersion(+1);
        AuthorWrapper newData = authorService.save(wrapper);
        if (newData != null) {
            return commonResponses.commonSuccessResponse(newData);
        } else {
            return commonResponses.commonFailedResponse();
        }
    }

    @PostMapping(value = "/update")
    public CustomReturn<AuthorWrapper> update(@RequestBody AuthorWrapper wrapper) throws StudyException {
        CommonResponses<AuthorWrapper> commonResponses = new CommonResponses<>();
        wrapper.setVersion(+1);
        AuthorWrapper newData = authorService.save(wrapper);
        if (newData != null) {
            return commonResponses.commonSuccessResponse(newData);
        } else {
            return commonResponses.commonFailedResponse();
        }
    }

}
