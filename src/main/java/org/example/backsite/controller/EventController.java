package org.example.backsite.controller;

import org.example.backsite.model.Event;
import org.example.backsite.service.EventService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/event")
public class EventController {
    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(eventService.getAllEvents());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getById(@PathVariable long id) {
        return ResponseEntity.ok(eventService.getEventById(id));
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestParam String name, @RequestParam String place, @RequestParam String date, @RequestParam Long userId) {
        Event event = new Event(name, place, date);
        return ResponseEntity.ok(eventService.createEvent(event, userId));
    }

    @PostMapping("/edit/{id}")
    public ResponseEntity<?> edit(@PathVariable Long id, @RequestParam String name, @RequestParam String place, @RequestParam String date, @RequestParam Long userId) {
        Event event = eventService.getEventById(id);
        event.setName(name);
        event.setPlace(place);
        event.setDate(date);
        return ResponseEntity.ok(eventService.editEvent(event, userId));
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id, @RequestParam Long userId) {
        return ResponseEntity.ok(eventService.deleteEvent(id, userId));
    }
}
