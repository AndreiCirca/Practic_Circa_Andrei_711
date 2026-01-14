package Service;

import Model.TrafficEvent;
import Repository.TrafficEventRepository;

import java.util.List;

public class TrafficEventService {

    private final TrafficEventRepository TrafficEventRepository;

        public TrafficEventService(TrafficEventRepository TrafficEventRepository) {
        this.TrafficEventRepository = TrafficEventRepository;
    }

    public List<TrafficEvent> getAllTrafficEvents() {
        return TrafficEventRepository.getAllTrafficEvents();
    }
}