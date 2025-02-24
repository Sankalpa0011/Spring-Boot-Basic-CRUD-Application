package com.springbootacademy.batch7.pos.controller;

import com.springbootacademy.batch7.pos.dto.paginated.PaginatedResponseItemDTO;
import com.springbootacademy.batch7.pos.dto.request.ItemSaveRequestDTO;
import com.springbootacademy.batch7.pos.dto.response.ItemGetResponseDTO;
import com.springbootacademy.batch7.pos.service.impl.ItemServiceIMPL;
import com.springbootacademy.batch7.pos.util.StandardResponse;
import jakarta.validation.constraints.Max;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
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


    @GetMapping(
            path = "/get-all-items-by-status",
            params = {"activeStatus"}
    )
    public ResponseEntity<StandardResponse> findAllItemsPaginated(@RequestParam(value = "activeStatus") boolean activeStatus) {
        List<ItemGetResponseDTO> itemDTO = itemService.getItemByActiveStatus(activeStatus);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200, "Success", itemDTO),
                HttpStatus.OK
        );
    }


    // Pagination example
    @GetMapping(
            path = "/get-all-items-paginated",
            params = {"page", "size"}
    )
    public ResponseEntity<StandardResponse> findItemByActiveStatus(
            @RequestParam(value = "page") int page,
            @RequestParam(value = "size") @Max(50) int size
    ) {
        PaginatedResponseItemDTO paginatedResponseItemDTO = itemService.getItemsPaginated(page, size);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200, "Success", paginatedResponseItemDTO),
                HttpStatus.OK
        );
    }

    @GetMapping(
            path = "/get-all-items-by-status-paginated",
            params = {"activeStatus", "page", "size"}
    )
    public ResponseEntity<StandardResponse> findItemByActiveStatus(
            @RequestParam(value = "activeStatus") boolean activeStatus,
            @RequestParam(value = "page") int page,
            @RequestParam(value = "size") @Max(50) int size
            ) {
        PaginatedResponseItemDTO paginatedResponseItemDTO = itemService.getItemByActiveStatusPaginated(activeStatus, page, size);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200, "Success", paginatedResponseItemDTO),
                HttpStatus.OK
        );
    }

}
