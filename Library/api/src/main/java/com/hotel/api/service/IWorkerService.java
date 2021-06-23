package com.hotel.api.service;

import com.library.model.Worker;
import com.library.model.dto.WorkerDto;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface IWorkerService {
    Worker addWorker(String lastName,String firstName,String patronymic, LocalDate data);
    WorkerDto getById(Integer workerId);
    List<WorkerDto> getAll();
    void deleteWorker(Integer workerId);
}
