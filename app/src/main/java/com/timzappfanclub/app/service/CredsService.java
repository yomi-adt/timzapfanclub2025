package com.timzappfanclub.app.service;

import java.util.List;

import com.timzappfanclub.app.dto.CredsDto;
public interface CredsService {
    CredsDto createCreds(CredsDto credsDto);
    List<CredsDto> getAllCreds();
}
