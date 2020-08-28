package yg0r2.examples.backend.web.rest;

import yg0r2.examples.backend.api.model.DummyResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RestController
@RequestMapping(path = "/api/dummy")
public class DummyController {

    private static final List<DummyResponse> DUMMY_RESPONSES = IntStream.range(1, 6)
        .mapToObj(i -> DummyResponse.builder().withId(i).withTitle(UUID.randomUUID().toString()).build())
        .collect(Collectors.toList());

    @GetMapping
    public ResponseEntity<List<DummyResponse>> getAll() {
        return ResponseEntity.ok(DUMMY_RESPONSES);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<DummyResponse> get(@PathVariable("id") long id) {
        return DUMMY_RESPONSES.stream()
            .filter(dummyResponse -> dummyResponse.getId() == id)
            .findFirst()
            .map(ResponseEntity::ok)
            .orElseThrow(() -> new RuntimeException("Entry not found with id: " + id));
    }

}
