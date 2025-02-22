package com.springbootacademy.batch7.pos.controller;

import com.springbootacademy.batch7.pos.dto.request.ItemSaveRequestDTO;
import com.springbootacademy.batch7.pos.dto.response.ItemGetResponseDTO;
import com.springbootacademy.batch7.pos.service.impl.ItemServiceIMPL;
import com.springbootacademy.batch7.pos.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/item")
public class ItemController {

    @Autowired
    private ItemServiceIMPL itemService;

    // Create
//    @PostMapping(path = "/save")
//    public String saveItem(@RequestBody ItemSaveRequestDTO itemSaveRequestDTO) {
//        String message = itemService.saveItem(itemSaveRequestDTO);
//        return message;
//    }

    @PostMapping(path = "/save")
    public ResponseEntity<StandardResponse> saveItem(@RequestBody ItemSaveRequestDTO itemSaveRequestDTO) {
        String message = itemService.saveItem(itemSaveRequestDTO);
//        ResponseEntity<StandardResponse> response = new ResponseEntity<StandardResponse>(
//                new StandardResponse(200, "Success", message), HttpStatus.CREATED
//        );
//        return response;
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(201, "Success", message),
                HttpStatus.CREATED
        );
    }


    @GetMapping(
            path = "/get-by-name",
            params = "name"
    )
//    public List<ItemGetResponseDTO> findItemByNameAndStatus(@RequestParam(value = "name") String itemName) {
//        List<ItemGetResponseDTO> itemDTO = itemService.getItemByNameAndStatus(itemName);
//        return itemDTO;
//    }

    public ResponseEntity<StandardResponse> findItemByNameAndStatus(@RequestParam(value = "name") String itemName) {
        List<ItemGetResponseDTO> itemDTO = itemService.getItemByNameAndStatus(itemName);
        return new ResponseEntity<>(
                new StandardResponse(200, "Success", itemDTO),
                HttpStatus.OK
        );
    }

    @GetMapping(
            path = "/get-by-name-with-mapstruct",
            params = "name"
    )
//    public List<ItemGetResponseDTO> findItemByNameAndStatusByMapstruct(@RequestParam(value = "name") String itemName) {
//        List<ItemGetResponseDTO> itemDTO = itemService.getItemByNameAndStatusByMapstruct(itemName);
//        return itemDTO;
//    }
    public ResponseEntity<StandardResponse> findItemByNameAndStatusByMapstruct(@RequestParam(value = "name") String itemName) {
        List<ItemGetResponseDTO> itemDTO = itemService.getItemByNameAndStatusByMapstruct(itemName);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200, "Success", itemDTO),
                HttpStatus.OK
        );
    }
}
