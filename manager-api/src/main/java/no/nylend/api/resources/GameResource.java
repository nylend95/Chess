package no.nylend.api.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Basic
 */
@RestController
@RequestMapping(path = "/api")
public class GameResource {

    /**
     * Gets current active game
     * @return
     */
    @GetMapping(path = "/game")
    public ResponseEntity<Game> getGame(){
        //Call service which contains current game
        //Return game

        return null; //return ResponseEntity.ok(game)
    }
}
