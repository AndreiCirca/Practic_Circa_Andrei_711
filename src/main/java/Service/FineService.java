package Service;

import Model.Fine;
import Model.Vehicle;
import Repository.FineRepository;
import Model.Fine;


import java.util.Comparator;
import java.util.List;

public class FineService {

    private final FineService FineRepository;


    public FineService(FineService FineRepository, FineService fineRepository) {
        this.FineRepository = fineRepository;
        FineRepository = FineRepository;
    }

    public FineService(FineRepository fineRepository) {
    }

    public List<Fine> getAllFine() {
        return FineRepository.getAllFine();
    }
}