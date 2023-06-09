package com.kreitek.store.infraestructure.rest;

import com.kreitek.store.domain.entity.Item;
import com.kreitek.store.domain.entity.UserRegister;
import com.kreitek.store.infraestructure.persistence.ItemRepository;
import com.kreitek.store.infraestructure.persistence.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FavoritesController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ItemRepository itemRepository;

    @PostMapping("/{userId}/{itemId}")
    public ResponseEntity<String> newFavorite(@PathVariable Long userId, @PathVariable Long itemId) {
        UserRegister user = userRepository.findById(userId).orElse(null);
        Item item = itemRepository.findById(itemId).orElse(null);

        if (user == null || item == null) {
            return ResponseEntity.badRequest().body("Usuario o ítem no encontrado");
        }

        if (!user.getFavorites().contains(item)) {
            user.getFavorites().add(item);
            userRepository.save(user);
            return ResponseEntity.ok("Ítem agregado a favoritos");
        }

        return ResponseEntity.ok("El ítem ya está en favoritos");
    }

    @DeleteMapping("/{userId}/{itemId}")
    public ResponseEntity<String> deleteFavorite(@PathVariable Long userId, @PathVariable Long itemId) {
        UserRegister user = userRepository.findById(userId).orElse(null);
        Item item = itemRepository.findById(itemId).orElse(null);

        if (user == null || item == null) {
            return ResponseEntity.badRequest().body("Usuario o ítem no encontrado");
        }

        if (user.getFavorites().contains(item)) {
            user.getFavorites().remove(item);
            userRepository.save(user);
            return ResponseEntity.ok("Ítem eliminado de favoritos");
        }

        return ResponseEntity.ok("El ítem no está en favoritos");
    }
}
