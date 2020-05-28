package com.pactpharma.poc.controller;

import com.pactpharma.poc.model.Clinical2;
import com.pactpharma.poc.model.Lab2;
import com.pactpharma.poc.repo.ClinicalRepository;
import com.pactpharma.poc.repo.LabRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PactService {
    @Autowired
    private ClinicalRepository clinicalRepository;

    @Autowired
    private LabRepository labRepository;

    @RequestMapping(path = "/labs", method = RequestMethod.GET)
    public List<Lab2> getLabs() {
        return labRepository.findAll();
    }

    @RequestMapping(path = "/clinicals", method = RequestMethod.GET)
    public List<Clinical2> getClinicals() {
        return clinicalRepository.findAll();
    }
}
