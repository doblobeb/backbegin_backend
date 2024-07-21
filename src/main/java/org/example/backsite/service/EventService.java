package org.example.backsite.service;

import org.example.backsite.exception.CustomNotFoundException;
import org.example.backsite.exception.DatabaseException;
import org.example.backsite.model.Event;
import org.example.backsite.model.User;
import org.example.backsite.repo.EventRepo;
import org.example.backsite.repo.UserRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventService {
    private final EventRepo eventRepo;
    private final UserRepo userRepo;

    public EventService(EventRepo eventRepo, UserRepo userRepo) {
        this.eventRepo = eventRepo;
        this.userRepo = userRepo;
    }

    public Event createEvent(Event event, Long userId) {
        Optional<User> user = userRepo.findById(userId);
        if (user.isPresent()) {
            User userObj = user.get();
            userObj.setEventsToList(event);
            return eventRepo.save(event);
        } else
            throw new DatabaseException("User is not registered");
    }

    public List<Event> getAllEvents() {
        return eventRepo.findAll();
    }

    public Event getEventById(Long id) {
        Optional<Event> event = eventRepo.findById(id);
        if (event.isPresent()) {
            return event.get();
        } else
            throw new CustomNotFoundException("Event not found");
    }

    public Event editEvent(Event event1, Long userId) {
        Optional<Event> event = eventRepo.findById(event1.getId());
        if (event.isPresent()) {
            if (userRepo.findById(userId).isPresent()) {
                if (userRepo.findById(userId).get().getEvent().contains(event.get())) {
                    return eventRepo.save(event1);
                } else {
                    throw new CustomNotFoundException("User cannot edit this event");
                }
            } else throw new CustomNotFoundException("User not found");
        } else
            throw new CustomNotFoundException("Event not found");
    }

    public String deleteEvent(Long id, Long userId) {
        Optional<Event> event = eventRepo.findById(id);
        if (event.isPresent()) {
            if (userRepo.findById(userId).isPresent()) {
                if (userRepo.findById(userId).get().getEvent().contains(event.get())) {
                    eventRepo.deleteById(id);
                    return "Event deleted";
                } else {
                    throw new CustomNotFoundException("User cannot delete this event");
                }
            } else throw new CustomNotFoundException("User not found");
        } else
            throw new CustomNotFoundException("Event not found");
    }
}
