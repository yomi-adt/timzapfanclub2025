package com.timzappfanclub.app.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.timzappfanclub.app.dto.CredsDto;
import com.timzappfanclub.app.entity.Creds;
import com.timzappfanclub.app.mapper.CredsMapper;
import com.timzappfanclub.app.repository.CredsRepo;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CredsServiceImpl implements CredsService{
    private CredsRepo repo;

    @Override
    public CredsDto createCreds(CredsDto credsDto){
        Creds creds = CredsMapper.mapToCreds(credsDto);
        Creds saved = repo.save(creds);
        return CredsMapper.mapToCredsDto(saved);
    }

    @Override
    public List<CredsDto> getAllCreds(){
        List<Creds> creds = repo.findAll();
        return creds.stream().map((cred) -> CredsMapper.mapToCredsDto(cred)).collect(Collectors.toList());
    }
}
